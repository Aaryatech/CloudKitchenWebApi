package com.ats.ckweb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.FrConfig;

public interface FrConfigRepo extends JpaRepository<FrConfig, Integer> {

	FrConfig findBydelStatusAndFrConfigId(int del, int configId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE tn_fr_config SET del_status=0 WHERE fr_config_id=:configId",nativeQuery=true)
	public int deleteConfigurationById(@Param("configId") int configId);
}
