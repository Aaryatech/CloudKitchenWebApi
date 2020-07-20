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

import com.ats.ckweb.model.Area;
import com.ats.ckweb.model.AreaCityList;
import com.ats.ckweb.model.Category;
import com.ats.ckweb.model.City;
import com.ats.ckweb.model.GetAllConfiguredItemTag;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.Ingrediant;
import com.ats.ckweb.model.IngrediantCategory;
import com.ats.ckweb.model.IngredientDetailList;
import com.ats.ckweb.model.Language;
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
	
	/********************************************************/
	@RequestMapping(value = { "/getAllLanguages" }, method = RequestMethod.GET)
	public @ResponseBody List<Language> getAllLanguages(){
		
		List<Language> langList = new ArrayList<Language>();
		try {
			langList = tagService.getAllLanguages();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return langList;
		
	}
	
	@RequestMapping(value = { "/getLanguageById" }, method = RequestMethod.POST)
	public @ResponseBody Language getLanguageById(@RequestParam int langId){
		
		Language lang = new Language();
		try {
			lang = tagService.getLanguageById(langId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lang;
		
	}
	
	@RequestMapping(value = { "/getLanguageByCode" }, method = RequestMethod.POST)
	public @ResponseBody Language getLanguageByCode(@RequestParam String code, @RequestParam int langId){
		
		Language lang = new Language();
		try {
			if(langId==0) {
				
				lang = tagService.getLanguageByCode(code);
			}else {
				
				lang = tagService.getLanguageByCodeInEdit(code, langId);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lang;
		
	}
	
	@RequestMapping(value = { "/deleteLanguageById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteLanguageById(@RequestParam int langId){
		
		Info info = new Info();
		try {
			int res = tagService.deleteLangById(langId);
			if(res>0) {
				info.setError(false);
				info.setMessage("Language Deleted Successfully");
			}else {
				info.setError(true);
				info.setMessage("Failed to Delete Language");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return info;		
	}
	
	@RequestMapping(value = { "/addLanguage" }, method = RequestMethod.POST)
	public @ResponseBody Language addLanguage(@RequestBody Language lang){
		
		Language newLang = new Language();
		try {
			newLang = tagService.insertLanguage(lang);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return newLang;		
	}
	
	/********************************************************/
	@RequestMapping(value = { "/getAllCities" }, method = RequestMethod.GET)
	public @ResponseBody List<City> getAllCities(){
		
		List<City> cityList = new ArrayList<City>();
		try {
			cityList = tagService.getAllCities();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cityList;
		
	}
	
	@RequestMapping(value = { "/getCityById" }, method = RequestMethod.POST)
	public @ResponseBody City getCityById(@RequestParam int cityId){
		
		City city = new City();
		try {
			city = tagService.getCityById(cityId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return city;
		
	}
	
	@RequestMapping(value = { "/getCityByCode" }, method = RequestMethod.POST)
	public @ResponseBody City getCityByCode(@RequestParam String code, @RequestParam int cityId){
		
		City city = new City();
		try {
			if(cityId==0) {
				
				city = tagService.getCityByCode(code);
			}else {
				
				city = tagService.getCityByCodeInEdit(code, cityId);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return city;		
	}
	
	@RequestMapping(value = { "/deleteCityById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteCityById(@RequestParam int cityId){
		
		Info info = new Info();
		try {
			int res = tagService.deleteCityById(cityId);
			if(res>0) {
				info.setError(false);
				info.setMessage("City Deleted Successfully");
			}else {
				info.setError(true);
				info.setMessage("Failed to Delete City");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return info;		
	}
	
	@RequestMapping(value = { "/addCity" }, method = RequestMethod.POST)
	public @ResponseBody City addCity(@RequestBody City city){
		
		City newCity = new City();
		try {
			newCity = tagService.insertCity(city);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return newCity;		
	}
	/**********************************************************/
	@RequestMapping(value = { "/getAllAreas" }, method = RequestMethod.GET)
	public @ResponseBody List<Area> getAllArea(){
		
		List<Area> areaList = new ArrayList<Area>();
		try {
			areaList = tagService.getAllArea();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return areaList;
	}
	
	@RequestMapping(value = { "/getAllAreaCityList" }, method = RequestMethod.POST)
	public @ResponseBody List<AreaCityList> getAllAreaCityList(@RequestParam int compId){
		
		List<AreaCityList> areaList = new ArrayList<AreaCityList>();
		try {
			areaList = tagService.getAllAreaCityList(compId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return areaList;
	}
	
	@RequestMapping(value = { "/getAreaById" }, method = RequestMethod.POST)
	public @ResponseBody Area getAreaById(@RequestParam int areaId){
		
		Area area = new Area();
		try {
			area = tagService.getAreaById(areaId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return area;
	}
	
	@RequestMapping(value = { "/getAreaByCode" }, method = RequestMethod.POST)
	public @ResponseBody Area getAreaByCode(@RequestParam String code, @RequestParam int areaId){
		
		Area area = new Area();
		try {
			if(areaId==0) {
				
				area = tagService.getAreaByCode(code);
			}else {
				
				area = tagService.getAreaByCodeInEdit(code, areaId);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return area;		
	}
	
	@RequestMapping(value = { "/deleteAreaById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteAreaById(@RequestParam int areaId){
		
		Info info = new Info();
		try {
			int res = tagService.deleteAreaById(areaId);
			if(res>0) {
				info.setError(false);
				info.setMessage("Area Deleted Successfully");
			}else {
				info.setError(true);
				info.setMessage("Failed to Delete Area");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return info;		
	}
	
	@RequestMapping(value = { "/addArea" }, method = RequestMethod.POST)
	public @ResponseBody Area addArea(@RequestBody Area area){
		
		Area newArea = new Area();
		try {
			newArea = tagService.insertArea(area);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return newArea;		
	}
}
