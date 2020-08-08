package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.ckweb.model.Designation;

public interface DesignationRepo extends JpaRepository<Designation, Integer> {
	
  List<Designation> findByDelStatusOrderByDesignationIdDesc(int del);

List<Designation> findByDelStatusAndExInt1OrderByDesignationIdDesc(int i, int compId);
  
  
}
