package com.ats.ckweb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ckweb.model.SubCategory;
import com.ats.ckweb.repository.SubCategoryRepo;

@Service
public class SubCategoryServiceImpl implements  SubCategoryService{

	@Autowired
	SubCategoryRepo subCategoryRepo;

	@Override
	public List<SubCategory> getAllSubCategory() {

		List<SubCategory> subCatList = null;

		subCatList = subCategoryRepo.findByDelStatus(0);

		if (subCatList == null) {
			subCatList = new ArrayList<>();
		}

		return subCatList;
	}

}
