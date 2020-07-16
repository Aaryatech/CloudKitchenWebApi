package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.SubCategory;

@Repository
public interface SubCategoryRepo extends JpaRepository<SubCategory, Integer>{

	public List<SubCategory> findByDelStatus(int del);

}
