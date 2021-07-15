package com.fedex.weightbalance.batch.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.fedex.weightbalance.batch.repository.WbTripDataRepository;

@Service
public class WbTripDataService implements PurgeService
{
	@Autowired
	private WbTripDataRepository wbTripDataRepository;

	@Value("${trip.purgeThresholdDays}")
	private String purgeThresholdDays;
	
	@Value("${wb.tasks.countProperties.sql}")
	private String sql;
	
	@Value("${wb.tasks.countProperties.emailRecipients}")
	private String emailRecipients;
	
	@Autowired private JdbcTemplate jdbcTemplate;
	
	@Autowired private EmailService email;

	public void purge()
	{
	

//		System.out.println("Starting TripData Service");
//
//		List<WbTripData> deleteTripsList = new ArrayList<>();
//		deleteTripsList.addAll(wbTripDataRepository.tripDatesBefore(tripDeleteDate));
//
//		if (deleteTripsList.isEmpty()) 
//		{
//			System.out.println("No Trips to delete");
//		}
//		else 
//		{
//			System.out.println("Deleting " + deleteTripsList.size() + " Trips");
//			//wbTripDataRepository.deleteAll(deleteTripsList);
//			System.out.println("Finished");
//		}
	}
}
