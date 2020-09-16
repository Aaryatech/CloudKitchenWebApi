package com.ats.ckweb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.NewSetting;


public interface NewSettingRepo extends JpaRepository<NewSetting, Integer>{

	NewSetting findBySettingKeyAndDelStatus(String settingKey, int i);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_setting_new SET setting_value1=:val WHERE setting_id=:settingId",nativeQuery=true)
	int updateSettingsValueById(@Param("settingId") int settingId, @Param("val") String val);

}
