package com.ats.ckweb.apicontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.IngrediantCategory;
import com.ats.ckweb.model.Tags;
import com.ats.ckweb.services.TagsServices;

@RestController
public class MasterAPIController {

	@Autowired TagsServices tagService;
	
	
	@RequestMapping(value = { "/saveNewTag" }, method = RequestMethod.POST)
	public @ResponseBody Tags saveNewTag(@RequestBody Tags tag){
		System.err.println("tag------------"+tag);
		Tags saveTag = new Tags();
		try {
			saveTag = tagService.saveTag(tag);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return saveTag;		
	}
	
	@RequestMapping(value = { "/getAllTags" }, method = RequestMethod.GET)
	public @ResponseBody List<Tags> getAllTags(){
		
		List<Tags> tagList = new ArrayList<Tags>();
		try {
			tagList = tagService.getAllOfferTags();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tagList;
		
	}
	
	@RequestMapping(value = { "/getAllActiveTags" }, method = RequestMethod.GET)
	public @ResponseBody List<Tags> getAllActiveTags(){
		
		List<Tags> tagList = new ArrayList<Tags>();
		try {
			tagList = tagService.getAllActiveOfferTags();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tagList;
		
	}
	
	@RequestMapping(value = { "/getTagById" }, method = RequestMethod.POST)
	public @ResponseBody Tags getTagById(@RequestParam int tagId){
		
		Tags tag = new Tags();
		try {
			tag = tagService.getTagById(tagId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tag;		
	}
	
	
	@RequestMapping(value = { "/deleteTagById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteTagById(@RequestParam int tagId){
		
		Info info = new Info();
		try {
			int res = tagService.deletTagById(tagId);
			if(res>0) {
				info.setError(false);
				info.setMessage("Tag Deleted Successfully");
			}else {
				info.setError(true);
				info.setMessage("Failed to Delete Tag");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return info;		
	}
	
	@RequestMapping(value = { "/saveNewIngrediantCategory" }, method = RequestMethod.POST)
	public @ResponseBody IngrediantCategory saveNewIngrediantCategory(@RequestBody IngrediantCategory ingerediant){
		System.err.println("ingerediant------------"+ingerediant);
		IngrediantCategory saveingerediant = new IngrediantCategory();
		try {
			saveingerediant = tagService.saveingerediant(ingerediant);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return saveingerediant;		
	}
	
	@RequestMapping(value = { "/getAllIngerediant" }, method = RequestMethod.GET)
	public @ResponseBody List<IngrediantCategory> getAllingerediant(){
		
		List<IngrediantCategory> ingerediantCatList = new ArrayList<IngrediantCategory>();
		try {
			ingerediantCatList = tagService.getAllIngrediantCategory();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ingerediantCatList;
		
	}
	
	@RequestMapping(value = { "/getIngeredianCatById" }, method = RequestMethod.POST)
	public @ResponseBody IngrediantCategory getIngeredianCatById(@RequestParam int ingerediantCatId){
		
		IngrediantCategory tag = new IngrediantCategory();
		try {
			tag = tagService.getIngrediantCatById(ingerediantCatId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tag;		
	}
	
	@RequestMapping(value = { "/deleteIngeredianCatById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteIngeredianCatById(@RequestParam int ingerediantCatId){
		
		Info info = new Info();
		try {
			int res = tagService.deletIngerediantCatIdById(ingerediantCatId);
			if(res>0) {
				info.setError(false);
				info.setMessage("Ingerediant Category Deleted Successfully");
			}else {
				info.setError(true);
				info.setMessage("Failed to Delete Ingerediant Category");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return info;		
	}
}
