package com.fedex.weightbalance.batch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fedex.airops.wb.model.WbFlight;
import com.fedex.weightbalance.batch.repository.WbFlightRepository;

@Service
public class WbFlightService implements PurgeService
{
	@Autowired
	private WbFlightRepository wbFlightRepository;

	@Value("${flight.date}")
	private String flightDeleteDate;

	@Override
	public void purge() {
		
//		List<WbFlight> deleteList = wbFlightRepository.findByLegDtBefore(daysBeforeNow(30));
//		
//		System.out.println(String.format("Deleting %s flights from WB_FLIGHT", deleteList.size()));
		
	}
}
