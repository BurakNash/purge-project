package com.fedex.weightbalance.batch.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

	@Autowired private TaskRunnerService taskRunner;
	
	public static final String namespace = "wb.tasks.";
	private static final Properties props = new Properties();
	private static final Map<String, Map<String, String>> allTaskProperties = new HashMap<>();
	
	public Timestamp nextRuntime (String cronExpression)
	{
        CronSequenceGenerator generator = new CronSequenceGenerator(cronExpression);
        Date next = generator.next(new Date());
        return new Timestamp(next.getTime());
	}

	@Scheduled(fixedDelay = 15000)
	public void runAllTasks ()
	{
		System.out.println("Running all tasks");
		try {
			props.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		for (Map.Entry<Object, Object> entry : props.entrySet())
		{
			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			
			
			if (key.startsWith(namespace))
			{
				String[] propertyNames = key.split("\\.");
				String taskName = propertyNames[2];
				Map<String, String> taskProperties = allTaskProperties.computeIfAbsent(taskName,
						k -> new HashMap<>());
			
				String taskPropertyName = propertyNames[3];
				taskProperties.put(taskPropertyName, value);
				
//				System.out.println(taskName + "." + taskPropertyName + ":" + value);
			}
		}
	
		System.out.println(allTaskProperties.size());
		for (Map.Entry<String, Map<String, String>> entry : allTaskProperties.entrySet())
		{
			Map<String, String> taskProperties = entry.getValue();
			if (taskProperties.containsKey("nextRuntime"))
			{
				String nextRunString = taskProperties.get("nextRuntime");
				Timestamp nextRuntime = Timestamp.valueOf(nextRunString);
				Timestamp now = new Timestamp(System.currentTimeMillis());
				if (now.after(nextRuntime))
				{
					taskRunner.runTask(entry.getKey(), entry.getValue());
					String futureRuntime = nextRuntime(taskProperties.get("cron")).toString();
					System.out.println("Computing nextRuntime for " + entry.getKey() + " to be " + futureRuntime);
					taskProperties.put("nextRuntime", futureRuntime);
				}
			}
			else 
			{
				String futureRuntime = nextRuntime(taskProperties.get("cron")).toString();
				System.out.println("Computing nextRuntime for " + entry.getKey() + " to be " + futureRuntime);
				taskProperties.put("nextRuntime", futureRuntime);
			}
		}
	}
	
}
