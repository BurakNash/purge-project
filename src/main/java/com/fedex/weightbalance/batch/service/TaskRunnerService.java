package com.fedex.weightbalance.batch.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaskRunnerService {
	
	@Autowired JdbcTemplate jdbc;
	
	public void runTask (String taskName, Map<String, String> taskProperties)
	{
		boolean sqlTask = taskProperties.containsKey("sql");
		boolean requiresEmail = taskProperties.containsKey("emailRecipients");
		
		if (sqlTask)
		{
			String query = taskProperties.get("sql");
			String result = executeSql(query).toString();
			
			System.out.println(result);
		}
		
//		email.sendMessage(null, emailRecipients, sb.toString(), "WB Tasks: Count Properties" );
		
	}
	
	private StringBuilder executeSql (String sql)
	{
		StringBuilder sb = new StringBuilder();
		System.out.println("Executing SQL: " + sql);
		List<Map<String, Object>> map = new ArrayList<>();
		if (sql.contains("delete"))
		{
			int rowcount = jdbc.update(sql);
			Map<String, Object> tempMap = new HashMap<>();
			tempMap.put("ROWCOUNT", rowcount);
			map.add(tempMap);
		}
		else 
		{
			map = jdbc.queryForList(sql);
		}
	
		for (Map<String, Object> row : map)
		{
			for (Map.Entry<String, Object> entry : row.entrySet())
			{
				sb.append(entry.getKey() + ":" + entry.getValue() + '\t');
			}
			sb.append('\n');
		}
		
		return sb;
	}

}
