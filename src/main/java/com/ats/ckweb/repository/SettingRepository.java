package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.ckweb.model.Setting;


public interface SettingRepository extends JpaRepository<Setting, Integer> {

	List<Setting> findBySettingValue(int i);

	Setting findBySettingId(int i);

	@Transactional
	@Modifying
	@Query(" UPDATE Setting SET setting_value=:value WHERE setting_key=:key")
	int udateKeyAndValue(@Param("key") String key, @Param("value") int value);
	
	Setting findBySettingKey(String key);
	
}
