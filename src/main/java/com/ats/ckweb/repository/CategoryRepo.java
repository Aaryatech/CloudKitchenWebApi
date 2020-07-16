package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

	public List<Category> findByDelStatus(int del);
	
}
