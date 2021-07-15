package com.fedex.weightbalance.batch.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public interface PurgeService {
	
	public default Timestamp daysBeforeNow (int days)
	{
		Instant threshold = Instant.now().minus(days, ChronoUnit.DAYS);
		return Timestamp.from(threshold);
	}
	
	public void purge ();
	
}
