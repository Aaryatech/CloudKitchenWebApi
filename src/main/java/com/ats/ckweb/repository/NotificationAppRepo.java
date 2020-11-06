package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.ckweb.model.NotificationApp;

public interface NotificationAppRepo extends JpaRepository<NotificationApp, Integer>{
	
	public List<NotificationApp> findBydelStatus(int del);

	
	
}
