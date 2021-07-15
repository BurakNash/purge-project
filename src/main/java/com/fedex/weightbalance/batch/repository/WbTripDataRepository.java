package com.fedex.weightbalance.batch.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fedex.airops.wb.model.WbTripData;

@Repository
@EntityScan("com.fedex.airops.wb.model")
public interface WbTripDataRepository extends JpaRepository<WbTripData, Long> 
{
	@Query(
			value = "select * from wb_trip_data p where p.truck_route_zdate < :tripdeletedate and p.truck_route_zdate is not null",
			nativeQuery = true
			)
    List<WbTripData> tripDatesBefore(@Param("tripdeletedate") String tripDeleteDate);	
}


