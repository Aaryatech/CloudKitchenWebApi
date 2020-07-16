package com.ats.ckweb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.ckweb.model.SubCategory;

@Service
public interface SubCategoryService {

	List<SubCategory> getAllSubCategory();
	
}
