package com.ats.ckweb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.ckweb.model.Category;

@Service
public interface CategoryService {

	List<Category> getAllCategory();
	
}
