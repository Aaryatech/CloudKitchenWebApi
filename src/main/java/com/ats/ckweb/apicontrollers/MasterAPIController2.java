package com.ats.ckweb.apicontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.model.Category;
import com.ats.ckweb.model.SubCategory;
import com.ats.ckweb.services.CategoryService;
import com.ats.ckweb.services.SubCategoryService;

@RestController
public class MasterAPIController2 {

	@Autowired CategoryService categoryService;
	@Autowired SubCategoryService subCategoryService;
	
	@RequestMapping(value = { "/getAllCategory" }, method = RequestMethod.GET)
	public @ResponseBody List<Category> getAllCategory(){
		
		List<Category> catList = new ArrayList<Category>();
		try {
			catList = categoryService.getAllCategory();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return catList;
		
	}
	
	@RequestMapping(value = { "/getAllSubCategory" }, method = RequestMethod.GET)
	public @ResponseBody List<SubCategory> getAllSubCategory(){
		
		List<SubCategory> subCatList = new ArrayList<SubCategory>();
		try {
			subCatList = subCategoryService.getAllSubCategory();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return subCatList;
		
	}
	
}
