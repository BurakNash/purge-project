package com.fedex.weightbalance.batch.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fedex.airops.wb.model.WbFlight;

@Repository
@EntityScan("com.fedex.airops.wb.model")
public interface WbFlightRepository extends JpaRepository<WbFlight, Long> 
{
//	@Query(
//			value = "SELECT * FROM  wb_flight p WHERE p.flt_dt > SYSDATE-:flightdeletedate",
//			nativeQuery = true
//			)
//    List<WbFlight> flightDatesBefore(@Param("flightdeletedate") String flightDeleteDate);	
	
	List<WbFlight> findByLegDtBefore (Timestamp threshold);
}


