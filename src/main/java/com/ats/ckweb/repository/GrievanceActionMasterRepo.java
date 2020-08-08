package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.ckweb.model.GrievanceActionMaster;

public interface GrievanceActionMasterRepo extends JpaRepository<GrievanceActionMaster, Integer> {
	
	List<GrievanceActionMaster> findAllByIsActiveAndDelStatus(int isActive,int delStatus);
	
	GrievanceActionMaster findByGrivActionValue(int grivActionValue);
	
}