package com.fedex.weightbalance.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.fedex.weightbalance.batch.service.PurgeService;
import com.fedex.weightbalance.batch.service.SchedulerService;
import com.fedex.weightbalance.batch.service.WbFlightService;
import com.fedex.weightbalance.batch.service.WbTripDataService;
import com.fedex.weightbalance.batch.service.WbULDService;

@SpringBootApplication
@EnableJpaRepositories("com.fedex.weightbalance.batch.repository")

@EntityScan(basePackages = {
		"com.fedex.airops.wb.model"
})
@EnableScheduling
public class WbPurgeProcessApplication 
{
	@Autowired
	private SchedulerService scheduler;
	public static void main(String[] args)
	{
		SpringApplication.run(WbPurgeProcessApplication.class, args);
	}
	
//	@Bean
//    public CommandLineRunner run(WbTripDataService wbTripDataService,WbFlightService wbFlightService, WbULDService wbULDService )
//	{
//        return (String[] args) -> 
//        {
//        	scheduler.runAllTasks();
//        	System.exit(0);
//        };
//	}
}

