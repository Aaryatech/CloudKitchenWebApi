package com.ats.ckweb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ckweb.model.Category;
import com.ats.ckweb.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo categoryRepo;

	@Override
	public List<Category> getAllCategory() {

		List<Category> catList = null;

		catList = categoryRepo.findByDelStatus(0);

		if (catList == null) {
			catList = new ArrayList<>();
		}

		return catList;
	}

}
