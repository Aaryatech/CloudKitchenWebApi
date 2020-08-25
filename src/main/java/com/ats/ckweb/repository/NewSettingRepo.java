package com.ats.ckweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.ckweb.model.NewSetting;


public interface NewSettingRepo extends JpaRepository<NewSetting, Integer>{

	NewSetting findBySettingKeyAndDelStatus(String settingKey, int i);

}
