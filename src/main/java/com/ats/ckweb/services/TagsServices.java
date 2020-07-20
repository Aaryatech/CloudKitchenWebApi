package com.ats.ckweb.services;

import java.util.List;

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
import com.ats.ckweb.model.Tags;
@Service
public interface TagsServices {

	
	List<Tags> getAllOfferTags();

	Tags getTagById(int tagId);

	Tags saveTag(Tags tag);

	List<Tags> getAllActiveOfferTags();

	int deletTagById(int tagId);

	IngrediantCategory saveingerediant(IngrediantCategory ingerediant);

	List<IngrediantCategory> getAllIngrediantCategory();
	
	List<IngrediantCategory> getAllActiveIngrediantCategory();

	IngrediantCategory getIngrediantCatById(int ingerediantCatId);

	int deletIngerediantCatIdById(int ingerediantCatId);

	Ingrediant insertIngrediant(Ingrediant ingerediant);

	List<Ingrediant> getAllIngrediant();

	Ingrediant getIngrediantById(int ingrediantId);

	int deleteIngerediantById(int ingerediantId);

	List<IngredientDetailList> getAllIngrediantDetailList();

	List<GetAllConfiguredItemTag> getAllTagItemConfigListById(int tagId);
	
	public List<MCategory> findAllCategory();

	int getAssignItemDetailsById(int tagId);

	int getItemTasteDetails(int ingerediantId);

	List<Language> getAllLanguages();

	Language insertLanguage(Language lang);

	Language getLanguageById(int langId);

	int deleteLangById(int langId);

	Language getLanguageByCode(String code);

	Language getLanguageByCodeInEdit(String code, int langId);

	List<City> getAllCities();

	City getCityById(int cityId);

	City getCityByCodeInEdit(String code, int cityId);

	City getCityByCode(String code);

	int deleteCityById(int cityId);

	City insertCity(City city);

	List<Area> getAllArea();

	Area getAreaById(int areaId);

	Area getAreaByCode(String code);

	Area getAreaByCodeInEdit(String code, int areaId);

	int deleteAreaById(int areaId);

	Area insertArea(Area area);

	List<AreaCityList> getAllAreaCityList(int compId);
	

	
}
