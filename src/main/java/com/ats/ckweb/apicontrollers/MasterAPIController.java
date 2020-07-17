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

import com.ats.ckweb.model.Category;
import com.ats.ckweb.model.GetAllConfiguredItemTag;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.Ingrediant;
import com.ats.ckweb.model.IngrediantCategory;
import com.ats.ckweb.model.IngredientDetailList;
import com.ats.ckweb.model.MCategory;
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
	
	@RequestMapping(value = { "/isTagAssign" }, method = RequestMethod.POST)
	public @ResponseBody Info isTagAssign(@RequestParam int tagId){
		
		Info info = new Info();
		try {
			int res = tagService.getAssignItemDetailsById(tagId);
			if(res>0) {
				info.setError(false);
				info.setMessage("Items Assigned To This Tag. Can't Delete This Record.");
			}else {
				info.setError(true);
				info.setMessage(null);
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
	
	@RequestMapping(value = { "/getAllIngerediantCategory" }, method = RequestMethod.GET)
	public @ResponseBody List<IngrediantCategory> getAllIngerediantCategory(){
		
		List<IngrediantCategory> ingerediantCatList = new ArrayList<IngrediantCategory>();
		try {
			ingerediantCatList = tagService.getAllIngrediantCategory();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ingerediantCatList;
		
	}
	
	@RequestMapping(value = { "/getAllActiveIngerediantCategory" }, method = RequestMethod.GET)
	public @ResponseBody List<IngrediantCategory> getAllActiveIngerediantCategory(){
		
		List<IngrediantCategory> ingerediantCatList = new ArrayList<IngrediantCategory>();
		try {
			ingerediantCatList = tagService.getAllActiveIngrediantCategory();
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
	
	@RequestMapping(value = { "/deleteIngerediantCatById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteIngerediantCatById(@RequestParam int ingerediantCatId){
		
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
	
	@RequestMapping(value = { "/saveNewIngrediant" }, method = RequestMethod.POST)
	public @ResponseBody Ingrediant saveNewIngrediant(@RequestBody Ingrediant ingerediant){
		System.err.println("ingerediant------------"+ingerediant);
		Ingrediant saveIngerediant = new Ingrediant();
		try {
			saveIngerediant = tagService.insertIngrediant(ingerediant);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return saveIngerediant;		
	}
	
	@RequestMapping(value = { "/getAllIngerediants" }, method = RequestMethod.GET)
	public @ResponseBody List<IngredientDetailList> getAllIngerediants(){
		
		List<IngredientDetailList> ingrediantList = new ArrayList<IngredientDetailList>();
		try {
			ingrediantList = tagService.getAllIngrediantDetailList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ingrediantList;
		
	}
	
	@RequestMapping(value = { "/getIngerediantById" }, method = RequestMethod.POST)
	public @ResponseBody Ingrediant getIngerediantById(@RequestParam int ingrediantId){
		
		Ingrediant ingrediant = new Ingrediant();
		try {
			ingrediant = tagService.getIngrediantById(ingrediantId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ingrediant;		
	}
	
	@RequestMapping(value = { "/deleteIngerediantById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteIngerediantById(@RequestParam int ingerediantId){
		
		Info info = new Info();
		try {
			int res = tagService.deleteIngerediantById(ingerediantId);
			if(res>0) {
				info.setError(false);
				info.setMessage("Ingerediant Deleted Successfully");
			}else {
				info.setError(true);
				info.setMessage("Failed to Delete Ingerediant");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return info;		
	}
	
	@RequestMapping(value = { "/isItemTasteAssign" }, method = RequestMethod.POST)
	public @ResponseBody Info isItemTasteAssign(@RequestParam int ingerediantId){
		
		Info info = new Info();
		try {
			int res = tagService.getItemTasteDetails(ingerediantId);
			if(res>0) {
				info.setError(false);
				info.setMessage("Items Assigned To This Ingredient. Can't Delete This Record.");
			}else {
				info.setError(true);
				info.setMessage("Failed to Delete Ingerediant");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return info;		
	}
	
	
	/***********************************************/
	@RequestMapping(value = { "/showAllCategory" }, method = RequestMethod.GET)

	public @ResponseBody List<MCategory> showAllCategory() {

		List<MCategory> categoryList = tagService.findAllCategory();
	
		return categoryList;
	}
	
	
	@RequestMapping(value = { "/getAllConfigTagItemsById" }, method = RequestMethod.POST)
	public @ResponseBody List<GetAllConfiguredItemTag> getAllConfigTagItems(@RequestParam int tagId){
		
		List<GetAllConfiguredItemTag> itemList = new ArrayList<GetAllConfiguredItemTag>();
		try {
			itemList = tagService.getAllTagItemConfigListById(tagId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return itemList;
		
	}
	
}
