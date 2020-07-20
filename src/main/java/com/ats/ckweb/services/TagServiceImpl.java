package com.ats.ckweb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ckweb.model.Area;
import com.ats.ckweb.model.AreaCityList;
import com.ats.ckweb.model.City;
import com.ats.ckweb.model.GetAllConfiguredItemTag;
import com.ats.ckweb.model.Ingrediant;
import com.ats.ckweb.model.IngrediantCategory;
import com.ats.ckweb.model.IngredientDetailList;
import com.ats.ckweb.model.Language;
import com.ats.ckweb.model.MCategory;
import com.ats.ckweb.model.SubCategory;
import com.ats.ckweb.model.SubCategoryRepository;
import com.ats.ckweb.model.Tags;
import com.ats.ckweb.repository.AreaCityListRepo;
import com.ats.ckweb.repository.AreaRepo;
import com.ats.ckweb.repository.CategoryRepository;
import com.ats.ckweb.repository.CityRepo;
import com.ats.ckweb.repository.GetAllConfiguredItemTagRepo;
import com.ats.ckweb.repository.IngrediantCategoryRepo;
import com.ats.ckweb.repository.IngrediantRepo;
import com.ats.ckweb.repository.IngredientDetailListRepo;
import com.ats.ckweb.repository.ItemDetailNewRepo;
import com.ats.ckweb.repository.LanguageRepo;
import com.ats.ckweb.repository.TagRepo;

@Service
public class TagServiceImpl implements TagsServices {

	@Autowired TagRepo tagRepo;
	
	@Autowired IngrediantCategoryRepo ingrediantCatRepo;
	
	@Autowired IngrediantRepo ingrediantRepo;
	
	@Autowired IngredientDetailListRepo ingDetailRepo;
	
	@Autowired GetAllConfiguredItemTagRepo itemTagListRepo;
	
	@Autowired CategoryRepository categoryRepository;
	
	@Autowired SubCategoryRepository subCategoryRepository;
	
	@Autowired ItemDetailNewRepo itemDetailNewRepo;
	
	@Autowired LanguageRepo langRepo;
	
	@Autowired CityRepo cityRepo;
	
	@Autowired AreaRepo areaRepo;
	
	@Autowired AreaCityListRepo areaCityRepo;
	
	@Override
	public List<Tags> getAllOfferTags() {
		
		List<Tags> taglist = tagRepo.findByTagDeleteStatusOrderByTagIdDesc(0);
		
		return taglist;
	}

	@Override
	public Tags getTagById(int tagId) {
		Tags tag = tagRepo.findByTagIdAndTagDeleteStatus(tagId, 0);
		return tag;
	}

	@Override
	public Tags saveTag(Tags tag) {
		Tags saveTag = tagRepo.save(tag);
		return saveTag;
	}

	@Override
	public List<Tags> getAllActiveOfferTags() {
		
		List<Tags> taglist = tagRepo.findByTagDeleteStatusAndTagIsActive(0, 0);		
		return taglist;
	}

	@Override
	public int deletTagById(int tagId) {
		int res = tagRepo.deleteTagById(tagId);
		return res;
	}

	@Override
	public IngrediantCategory saveingerediant(IngrediantCategory ingerediant) {
		IngrediantCategory saveIngrediantCategory = ingrediantCatRepo.save(ingerediant);
		return saveIngrediantCategory;
	}

	@Override
	public List<IngrediantCategory> getAllIngrediantCategory() {
		
		List<IngrediantCategory> catlist = ingrediantCatRepo.findBydelStatusOrderByIngrediantCatIdDesc(0);		
		return  catlist;
	}

	@Override
	public List<IngrediantCategory> getAllActiveIngrediantCategory() {
		List<IngrediantCategory> list = ingrediantCatRepo.findByDelStatusAndIsActiveOrderByIngrediantCatIdDesc(0, 0);
		return list;
	}
	
	@Override
	public IngrediantCategory getIngrediantCatById(int ingerediantCatId) {
		IngrediantCategory cat = ingrediantCatRepo.findByIngrediantCatIdAndDelStatus(ingerediantCatId, 0);
		return cat;
	}

	@Override
	public int deletIngerediantCatIdById(int ingerediantCatId) {
		int res = ingrediantCatRepo.deleteIngrediantCatById(ingerediantCatId);
		return res;
	}
/***************************************************/

	@Override
	public Ingrediant insertIngrediant(Ingrediant ingerediant) {
		Ingrediant saveIngrdnt = ingrediantRepo.save(ingerediant);
		return saveIngrdnt;
	}

	@Override
	public List<Ingrediant> getAllIngrediant() {
		List<Ingrediant> list = ingrediantRepo.findByDelStatusOrderByIngrediantIdDesc(0);
		return list;
	}

	@Override
	public Ingrediant getIngrediantById(int ingrediantId) {
		Ingrediant ingrediant = ingrediantRepo.findByDelStatusAndIngrediantId(0, ingrediantId);
		return ingrediant;
	}

	@Override
	public int deleteIngerediantById(int ingerediantId) {
		int res = ingrediantRepo.deleteIngerediantById(ingerediantId);
		return res;
	}

	@Override
	public List<IngredientDetailList> getAllIngrediantDetailList() {
		List<IngredientDetailList> list = ingDetailRepo.getIngredientDetail();
		return list;
	}

	

	@Override
	public List<GetAllConfiguredItemTag> getAllTagItemConfigListById(int tagId) {
		List<GetAllConfiguredItemTag> list = itemTagListRepo.getAllItemTagsById(tagId);
		return list;
	}
	
	@Override
	public List<MCategory> findAllCategory() {
		List<MCategory> mCategoryList=categoryRepository.findByDelStatusOrderBySeqNoAsc(0);
		return mCategoryList;
	}

	@Override
	public int getAssignItemDetailsById(int tagId) {
		int dtl = itemDetailNewRepo.getItemDetailByTagId(tagId);
		return dtl;
	}

	@Override
	public int getItemTasteDetails(int ingerediantId) {
		int res = itemDetailNewRepo.getItemTasteByid(ingerediantId);
		return res;
	}

	@Override
	public List<Language> getAllLanguages() {
		 List<Language> lang=langRepo.findByDelStatusOrderByLangIdDesc(0);
		return lang;
	}

	@Override
	public Language insertLanguage(Language lang) {
		Language newLang = langRepo.save(lang);
		return newLang;
	}

	@Override
	public Language getLanguageById(int langId) {
		Language lang = langRepo.findByLangIdAndDelStatus(langId, 0);
		return lang;
	}

	@Override
	public int deleteLangById(int langId) {
		int lang = langRepo.deleteLanguage(langId);
		return lang;
	}

	@Override
	public Language getLanguageByCode(String code) {
		Language lang = langRepo.findByLangCodeIgnoreCase(code);
		return lang;
	}

	@Override
	public Language getLanguageByCodeInEdit(String code, int langId) {
		Language lang = langRepo.findByLangCodeIgnoreCaseAndLangIdNot(code, langId);
		return lang;
	}
/**********************************************************************/

	@Override
	public List<City> getAllCities() {
		List<City> cityList = cityRepo.findByDelStatusOrderByCityIdDesc(0);
		return cityList;
	}

	@Override
	public City getCityById(int cityId) {
		City city = cityRepo.findByCityId(cityId);
		return city;
	}

	@Override
	public City getCityByCodeInEdit(String code, int cityId) {
		City city = cityRepo.findByCityCodeIgnoreCaseAndCityIdNot(code, cityId);
		return city;
	}

	@Override
	public City getCityByCode(String code) {
		City city = cityRepo.findByCityCodeIgnoreCase(code);
		return city;
	}

	@Override
	public int deleteCityById(int cityId) {
		int delCity = cityRepo.deleteCity(cityId);
		return delCity;
	}

	@Override
	public City insertCity(City city) {
		City newCity = cityRepo.save(city); 
		return newCity;
	}
/******************************************/
	@Override
	public List<Area> getAllArea() {
		List<Area> areaList = areaRepo.findBydelStatusOrderByAreaIdDesc(0);
		return areaList;
	}

	@Override
	public Area getAreaById(int areaId) {
		Area area = areaRepo.findByAreaIdAndDelStatus(areaId, 0);
		return area;
	}

	@Override
	public Area getAreaByCode(String code) {
		Area area = areaRepo.findByAreaCodeIgnoreCase(code);
		return area;
	}

	@Override
	public Area getAreaByCodeInEdit(String code, int areaId) {
		Area area = areaRepo.findByAreaCodeIgnoreCaseAndAreaIdNot(code, areaId);
		return area;
	}

	@Override
	public int deleteAreaById(int areaId) {
		int areaDel = areaRepo.deleteArea(areaId);
		return areaDel;
	}

	@Override
	public Area insertArea(Area area) {
		Area newArea = areaRepo.save(area);
		return newArea;
	}

	@Override
	public List<AreaCityList> getAllAreaCityList(int compId) {
		List<AreaCityList> list = areaCityRepo.getAllAreaByCompId(1);
		return list;
	}

	
	/************************************************/
}
