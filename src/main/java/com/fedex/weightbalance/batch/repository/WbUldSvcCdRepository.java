package com.fedex.weightbalance.batch.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fedex.airops.wb.model.WbUldSvcCd;

@Repository
@EntityScan("com.fedex.airops.wb.model")
public interface WbUldSvcCdRepository extends JpaRepository<WbUldSvcCd, Long> 
{
//	@Query(
//			value = "select * from wb_uld_on_flt p where p.last_update_dt > SYSDATE-:uldDeleteDate",
//			nativeQuery = true
//			)
//    List<WbUldOnFlt> uldDatesBefore(@Param("uldDeleteDate") String uldDeleteDate);	
	
//	List<WbUldOnFltOid> findByLastUpdateDtBefore (Timestamp lastUpdateDt);
	
//	@Query("select wbUldSvcCdOid from WbUldSvcCd svc where svc.wbUldOnFltOid in (select uld.wbUldOnFltOid from WbUldOnFlt uld where uld.lastUpdateDt < :lastUpdateDt)")
//	@Query(
//			nativeQuery = true
//			)
//	List<Long> findOidByLastUpdateDtBefore (Timestamp lastUpdateDt);
	
}
