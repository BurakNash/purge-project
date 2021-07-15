package com.fedex.weightbalance.batch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fedex.weightbalance.batch.repository.WbULDRepository;
import com.fedex.weightbalance.batch.repository.WbUldSvcCdRepository;

@Service
public class WbULDService implements PurgeService
{
	@Autowired
	private WbULDRepository wbFlightRepository;
	
	@Autowired WbUldSvcCdRepository serviceCodeRepository;

	@Value("${flight.date}")
	private String flightDeleteDate;
	
	private String deleteChildrenQuery = 
			"delete from %s where wb_uld_on_flt_oid in (select wb_uld_on_flt_oid from wb_uld_on_flt where last_update_dt < :lastUpdateDt)";
	
	List<String> ownedEntities = new ArrayList<String>() {{
		add("WB_ULD_SVC_CD");
		add("WB_ULD_LOAD_CD");
		add("WB_ULD_DG");
	}};

	@Override
	public void purge() {
		
//		List<Object[]> deleteList = wbFlightRepository.findOidByLastUpdateDtBefore(daysBeforeNow(365));
	
//		List<Long> deleteList = serviceCodeRepository.findOidByLastUpdateDtBefore(daysBeforeNow(365));
//		
//		for (Long l : deleteList)
//		{
//			System.out.println(l);
//		}
		
		
//		System.out.println(String.format("Deleting %s ULDs from WB_ULD_ON_FLT", deleteList.size()));
		
	}
}