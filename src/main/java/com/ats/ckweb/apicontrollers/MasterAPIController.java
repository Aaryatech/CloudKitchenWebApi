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
import com.ats.ckweb.model.Company;
import com.ats.ckweb.model.ConfigRelatedProduct;
import com.ats.ckweb.model.DeliveryInstruction;
import com.ats.ckweb.model.Designation;
import com.ats.ckweb.model.Franchisee;
import com.ats.ckweb.model.GetAllConfiguredItemTag;
import com.ats.ckweb.model.GetConfigureOfferList;
import com.ats.ckweb.model.GetFrConfigList;
import com.ats.ckweb.model.GetOfferFrConfiguredList;
import com.ats.ckweb.model.GetProductRelatedList;
import com.ats.ckweb.model.GrievencesInstruction;
import com.ats.ckweb.model.GrievencesTypeInstructn;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.Ingrediant;
import com.ats.ckweb.model.IngrediantCategory;
import com.ats.ckweb.model.IngredientDetailList;
import com.ats.ckweb.model.Item;
import com.ats.ckweb.model.Language;
import com.ats.ckweb.model.MCategory;
import com.ats.ckweb.model.MnUser;
import com.ats.ckweb.model.OfferConfig;
import com.ats.ckweb.model.OfferHeader;
import com.ats.ckweb.model.Tags;
import com.ats.ckweb.model.UserType;
import com.ats.ckweb.repository.IngredientDetailListRepo;
import com.ats.ckweb.services.CompanyServices;
import com.ats.ckweb.services.TagsServices;

@RestController
public class MasterAPIController {

	@Autowired
	TagsServices tagService;

	@Autowired
	CompanyServices companyService;

	@RequestMapping(value = { "/getDesignations" }, method = RequestMethod.GET)
	public @ResponseBody List<Designation> getDesignations() {

		List<Designation> list = new ArrayList<Designation>();
		try {
			list = tagService.getAllDesignations();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	/********************************************************************************/

	@RequestMapping(value = { "/getAllUserTypes" }, method = RequestMethod.GET)
	public @ResponseBody List<UserType> getAllUserTypes() {

		List<UserType> list = new ArrayList<UserType>();
		try {
			list = tagService.getAllUserTypes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	/********************************************************************************/
	@RequestMapping(value = { "/saveNewTag" }, method = RequestMethod.POST)
	public @ResponseBody Tags saveNewTag(@RequestBody Tags tag) {
		System.err.println("tag------------" + tag);
		Tags saveTag = new Tags();
		try {
			saveTag = tagService.saveTag(tag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveTag;
	}

	@RequestMapping(value = { "/getAllTags" }, method = RequestMethod.GET)
	public @ResponseBody List<Tags> getAllTags() {

		List<Tags> tagList = new ArrayList<Tags>();
		try {
			tagList = tagService.getAllOfferTags();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tagList;

	}

	@RequestMapping(value = { "/getAllActiveTags" }, method = RequestMethod.GET)
	public @ResponseBody List<Tags> getAllActiveTags() {

		List<Tags> tagList = new ArrayList<Tags>();
		try {
			tagList = tagService.getAllActiveOfferTags();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tagList;

	}

	@RequestMapping(value = { "/getTagById" }, method = RequestMethod.POST)
	public @ResponseBody Tags getTagById(@RequestParam int tagId) {

		Tags tag = new Tags();
		try {
			tag = tagService.getTagById(tagId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tag;
	}

	@RequestMapping(value = { "/deleteTagById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteTagById(@RequestParam int tagId) {

		Info info = new Info();
		try {
			int res = tagService.deletTagById(tagId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Tag Deleted Successfully");
			} else {
				info.setError(true);
				info.setMessage("Failed to Delete Tag");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/isTagAssign" }, method = RequestMethod.POST)
	public @ResponseBody Info isTagAssign(@RequestParam int tagId) {

		Info info = new Info();
		try {
			int res = tagService.getAssignItemDetailsById(tagId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Items Assigned To This Tag. Can't Delete This Record.");
			} else {
				info.setError(true);
				info.setMessage(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/saveNewIngrediantCategory" }, method = RequestMethod.POST)
	public @ResponseBody IngrediantCategory saveNewIngrediantCategory(@RequestBody IngrediantCategory ingerediant) {
		System.err.println("ingerediant------------" + ingerediant);
		IngrediantCategory saveingerediant = new IngrediantCategory();
		try {
			saveingerediant = tagService.saveingerediant(ingerediant);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveingerediant;
	}

	@RequestMapping(value = { "/getAllIngerediantCategory" }, method = RequestMethod.GET)
	public @ResponseBody List<IngrediantCategory> getAllIngerediantCategory() {

		List<IngrediantCategory> ingerediantCatList = new ArrayList<IngrediantCategory>();
		try {
			ingerediantCatList = tagService.getAllIngrediantCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ingerediantCatList;

	}

	@RequestMapping(value = { "/getAllActiveIngerediantCategory" }, method = RequestMethod.GET)
	public @ResponseBody List<IngrediantCategory> getAllActiveIngerediantCategory() {

		List<IngrediantCategory> ingerediantCatList = new ArrayList<IngrediantCategory>();
		try {
			ingerediantCatList = tagService.getAllActiveIngrediantCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ingerediantCatList;

	}

	@RequestMapping(value = { "/getIngeredianCatById" }, method = RequestMethod.POST)
	public @ResponseBody IngrediantCategory getIngeredianCatById(@RequestParam int ingerediantCatId) {

		IngrediantCategory tag = new IngrediantCategory();
		try {
			tag = tagService.getIngrediantCatById(ingerediantCatId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tag;
	}

	@RequestMapping(value = { "/deleteIngerediantCatById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteIngerediantCatById(@RequestParam int ingerediantCatId) {

		Info info = new Info();
		try {
			int res = tagService.deletIngerediantCatIdById(ingerediantCatId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Ingerediant Category Deleted Successfully");
			} else {
				info.setError(true);
				info.setMessage("Failed to Delete Ingerediant Category");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}
	
	@RequestMapping(value = { "/isTasteCatAssign" }, method = RequestMethod.POST)
	public @ResponseBody Info isTasteCatAssign(@RequestParam int ingerediantCatId) {

		Info info = new Info();
		try {
			int res = tagService.getIngredientCnt(ingerediantCatId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Taste Assigned To This Category. Can't Delete This Record");
			} else {
				info.setError(true);
				info.setMessage(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/saveNewIngrediant" }, method = RequestMethod.POST)
	public @ResponseBody Ingrediant saveNewIngrediant(@RequestBody Ingrediant ingerediant) {
		System.err.println("ingerediant------------" + ingerediant);
		Ingrediant saveIngerediant = new Ingrediant();
		try {
			saveIngerediant = tagService.insertIngrediant(ingerediant);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveIngerediant;
	}

	@RequestMapping(value = { "/getAllIngerediants" }, method = RequestMethod.GET)
	public @ResponseBody List<IngredientDetailList> getAllIngerediants() {

		List<IngredientDetailList> ingrediantList = new ArrayList<IngredientDetailList>();
		try {
			ingrediantList = tagService.getAllIngrediantDetailList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ingrediantList;

	}

	@RequestMapping(value = { "/getIngerediantById" }, method = RequestMethod.POST)
	public @ResponseBody Ingrediant getIngerediantById(@RequestParam int ingrediantId) {

		Ingrediant ingrediant = new Ingrediant();
		try {
			ingrediant = tagService.getIngrediantById(ingrediantId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ingrediant;
	}

	@RequestMapping(value = { "/deleteIngerediantById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteIngerediantById(@RequestParam int ingerediantId) {

		Info info = new Info();
		try {
			int res = tagService.deleteIngerediantById(ingerediantId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Ingerediant Deleted Successfully");
			} else {
				info.setError(true);
				info.setMessage("Failed to Delete Ingerediant");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/isItemTasteAssign" }, method = RequestMethod.POST)
	public @ResponseBody Info isItemTasteAssign(@RequestParam int ingerediantId) {

		Info info = new Info();
		try {
			int res = tagService.getItemTasteDetails(ingerediantId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Items Assigned To This Ingredient. Can't Delete This Record.");
			} else {
				info.setError(true);
				info.setMessage("Failed to Delete Ingerediant");
			}
		} catch (Exception e) {
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
	public @ResponseBody List<GetAllConfiguredItemTag> getAllConfigTagItems(@RequestParam int tagId) {

		List<GetAllConfiguredItemTag> itemList = new ArrayList<GetAllConfiguredItemTag>();
		try {
			itemList = tagService.getAllTagItemConfigListById(tagId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemList;

	}

	/********************************************************/
	@RequestMapping(value = { "/getAllLanguages" }, method = RequestMethod.POST)
	public @ResponseBody List<Language> getAllLanguages(@RequestParam int compId) {

		List<Language> langList = new ArrayList<Language>();
		try {
			langList = tagService.getAllLanguages(compId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return langList;

	}

	@RequestMapping(value = { "/getLanguageById" }, method = RequestMethod.POST)
	public @ResponseBody Language getLanguageById(@RequestParam int langId, @RequestParam int compId) {

		Language lang = new Language();
		try {
			lang = tagService.getLanguageById(langId, compId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lang;

	}

	@RequestMapping(value = { "/getLanguageByCode" }, method = RequestMethod.POST)
	public @ResponseBody Language getLanguageByCode(@RequestParam String code, @RequestParam int langId,
			@RequestParam int compId) {

		Language lang = new Language();
		try {
			if (langId == 0) {

				lang = tagService.getLanguageByCode(code, compId);
			} else {

				lang = tagService.getLanguageByCodeInEdit(code, langId, compId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lang;

	}

	@RequestMapping(value = { "/deleteLanguageById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteLanguageById(@RequestParam int langId) {

		Info info = new Info();
		try {
			int res = tagService.deleteLangById(langId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Language Deleted Successfully");
			} else {
				info.setError(true);
				info.setMessage("Failed to Delete Language");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/addLanguage" }, method = RequestMethod.POST)
	public @ResponseBody Language addLanguage(@RequestBody Language lang) {

		Language newLang = new Language();
		try {
			newLang = tagService.insertLanguage(lang);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newLang;
	}

	/********************************************************/
	@RequestMapping(value = { "/getAllCities" }, method = RequestMethod.GET)
	public @ResponseBody List<City> getAllCities() {

		List<City> cityList = new ArrayList<City>();
		try {
			cityList = tagService.getAllCities();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cityList;

	}

	@RequestMapping(value = { "/getCityById" }, method = RequestMethod.POST)
	public @ResponseBody City getCityById(@RequestParam int cityId) {

		City city = new City();
		try {
			city = tagService.getCityById(cityId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return city;

	}

	@RequestMapping(value = { "/getCityByCode" }, method = RequestMethod.POST)
	public @ResponseBody City getCityByCode(@RequestParam String code, @RequestParam int cityId) {

		City city = new City();
		try {
			if (cityId == 0) {

				city = tagService.getCityByCode(code);
			} else {

				city = tagService.getCityByCodeInEdit(code, cityId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return city;
	}

	@RequestMapping(value = { "/deleteCityById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteCityById(@RequestParam int cityId) {

		Info info = new Info();
		try {
			int res = tagService.deleteCityById(cityId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("City Deleted Successfully");
			} else {
				info.setError(true);
				info.setMessage("Failed to Delete City");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/addCity" }, method = RequestMethod.POST)
	public @ResponseBody City addCity(@RequestBody City city) {

		City newCity = new City();
		try {
			newCity = tagService.insertCity(city);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newCity;
	}

	/**********************************************************/
	@RequestMapping(value = { "/getAllAreas" }, method = RequestMethod.POST)
	public @ResponseBody List<Area> getAllArea(@RequestParam int compId) {

		List<Area> areaList = new ArrayList<Area>();
		try {
			areaList = tagService.getAllArea(compId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return areaList;
	}

	@RequestMapping(value = { "/getAllAreaCityList" }, method = RequestMethod.POST)
	public @ResponseBody List<AreaCityList> getAllAreaCityList(@RequestParam int compId) {

		List<AreaCityList> areaList = new ArrayList<AreaCityList>();
		try {
			areaList = tagService.getAllAreaCityList(compId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return areaList;
	}

	@RequestMapping(value = { "/getAreaById" }, method = RequestMethod.POST)
	public @ResponseBody Area getAreaById(@RequestParam int areaId, @RequestParam int compId) {

		Area area = new Area();
		try {
			area = tagService.getAreaById(areaId, compId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return area;
	}

	@RequestMapping(value = { "/getAreaByCode" }, method = RequestMethod.POST)
	public @ResponseBody Area getAreaByCode(@RequestParam String code, @RequestParam int areaId,
			@RequestParam int compId) {

		Area area = new Area();
		try {
			if (areaId == 0) {

				area = tagService.getAreaByCode(code, compId);
			} else {

				area = tagService.getAreaByCodeInEdit(code, areaId, compId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return area;
	}

	@RequestMapping(value = { "/deleteAreaById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteAreaById(@RequestParam int areaId) {

		Info info = new Info();
		try {
			int res = tagService.deleteAreaById(areaId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Area Deleted Successfully");
			} else {
				info.setError(true);
				info.setMessage("Failed to Delete Area");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/addArea" }, method = RequestMethod.POST)
	public @ResponseBody Area addArea(@RequestBody Area area) {

		Area newArea = new Area();
		try {
			newArea = tagService.insertArea(area);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newArea;
	}

	@RequestMapping(value = { "/getAreaByCityId" }, method = RequestMethod.POST)
	public @ResponseBody int getAreaByCityId(@RequestParam int cityId) {

		int res = 0;
		try {
			res = tagService.getAreaCityById(cityId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@RequestMapping(value = { "/getAreaByCityAndCompId" }, method = RequestMethod.POST)
	public @ResponseBody List<Area> getAreaByCityIdAndCopmId(@RequestParam int cityId, @RequestParam int compId) {

		List<Area> list = new ArrayList<Area>();

		try {
			list = tagService.getAreaCityAndCompById(cityId, compId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/*****************************************************************/

	@RequestMapping(value = { "/getAllDeliveryInstructions" }, method = RequestMethod.POST)
	public @ResponseBody List<DeliveryInstruction> getAllDeliveryInstructions(@RequestParam int compId) {

		List<DeliveryInstruction> instructnList = new ArrayList<DeliveryInstruction>();
		try {
			instructnList = tagService.getAllDelvryInstructn(compId, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instructnList;
	}

	@RequestMapping(value = { "/getDeliveryInstructionById" }, method = RequestMethod.POST)
	public @ResponseBody DeliveryInstruction getDeliveryInstructionById(@RequestParam int instructId) {

		DeliveryInstruction del = new DeliveryInstruction();
		try {
			del = tagService.getDeliveryInstructionById(instructId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return del;
	}

	@RequestMapping(value = { "/getDeliveryInstructionByCaptn" }, method = RequestMethod.POST)
	public @ResponseBody DeliveryInstruction getDeliveryInstructionByCaptn(@RequestParam String caption,
			@RequestParam int compId, @RequestParam int instructId) {

		DeliveryInstruction instruct = new DeliveryInstruction();
		try {
			if (instructId == 0) {

				instruct = tagService.getDeliveryInstructionByCaptn(caption, compId);
			} else {

				instruct = tagService.getDeliveryInstructionByCaptnAndId(caption, compId, instructId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return instruct;
	}

	@RequestMapping(value = { "/deleteDeliveryInstructnById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteDeliveryInstructnById(@RequestParam int instructId) {

		Info info = new Info();
		try {
			int res = tagService.deleteDelInstructnById(instructId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Delivery Instruction Deleted Successfully");
			} else {
				info.setError(true);
				info.setMessage("Failed to Delete Delivery Instruction");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/addDeliveryInstrunctn" }, method = RequestMethod.POST)
	public @ResponseBody DeliveryInstruction addDeliveryInstrunctn(@RequestBody DeliveryInstruction instructn) {

		DeliveryInstruction newinstructn = new DeliveryInstruction();
		try {
			newinstructn = tagService.insertDeliveryInstrunctn(instructn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newinstructn;
	}

	/***********************************************************************************/
	@RequestMapping(value = { "/getAllGrievTypeInstruct" }, method = RequestMethod.POST)
	public @ResponseBody List<GrievencesTypeInstructn> getAllGrievTypeInstruct(@RequestParam int compId) {

		List<GrievencesTypeInstructn> grievTypeList = new ArrayList<GrievencesTypeInstructn>();
		try {
			grievTypeList = tagService.getAllGrievTypeList(compId, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grievTypeList;
	}

	@RequestMapping(value = { "/getGrievTypeInstructById" }, method = RequestMethod.POST)
	public @ResponseBody GrievencesTypeInstructn getGrievTypeInstructById(@RequestParam int grievTypeId,
			@RequestParam int compId) {

		GrievencesTypeInstructn griev = new GrievencesTypeInstructn();
		try {
			griev = tagService.getGrievTypeInstructById(grievTypeId, compId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return griev;
	}

	@RequestMapping(value = { "/getGrievTypeInstructByCaptn" }, method = RequestMethod.POST)
	public @ResponseBody GrievencesTypeInstructn getGrievTypeInstructByCaptn(@RequestParam String caption,
			@RequestParam int compId, @RequestParam int grievTypeId) {

		GrievencesTypeInstructn griev = new GrievencesTypeInstructn();
		try {
			if (grievTypeId == 0) {

				griev = tagService.getGrievTypeInstructByCaptn(caption, compId);
			} else {

				griev = tagService.getGrievTypeInstructByCaptnAndId(caption, compId, grievTypeId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return griev;
	}

	@RequestMapping(value = { "/deleteGrievTypeInstructById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteGrievTypeInstructById(@RequestParam int grievTypeId) {

		Info info = new Info();
		try {
			int res = tagService.deleteGrievTypeInstructById(grievTypeId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Delivery Type Instruction Deleted Successfully");
			} else {
				info.setError(true);
				info.setMessage("Failed to Delete Delivery Type Instruction");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/addGrievTypeInstruct" }, method = RequestMethod.POST)
	public @ResponseBody GrievencesTypeInstructn addGrievTypeInstruct(@RequestBody GrievencesTypeInstructn griev) {

		GrievencesTypeInstructn newGriev = new GrievencesTypeInstructn();
		try {
			newGriev = tagService.insertGrievTypeInstruct(griev);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newGriev;
	}

	/***************************************************************************************/

	@RequestMapping(value = { "/getAllGrievancesInstructns" }, method = RequestMethod.POST)
	public @ResponseBody List<GrievencesInstruction> getAllGrievanceInstructn(@RequestParam int compId) {

		List<GrievencesInstruction> grievList = new ArrayList<GrievencesInstruction>();
		try {
			grievList = tagService.getAllGrievanceList(compId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grievList;
	}

	@RequestMapping(value = { "/getGrievanceInstructnById" }, method = RequestMethod.POST)
	public @ResponseBody GrievencesInstruction getGrievanceInstructnById(@RequestParam int grievanceId,
			@RequestParam int compId) {

		GrievencesInstruction grievance = new GrievencesInstruction();
		try {
			grievance = tagService.getGrievanceInstructById(grievanceId, compId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grievance;
	}

	@RequestMapping(value = { "/getGrievancenstructnByCaptn" }, method = RequestMethod.POST)
	public @ResponseBody GrievencesInstruction getGrievancenstructnByCaptn(@RequestParam String caption,
			@RequestParam int compId, @RequestParam int grievanceId) {

		GrievencesInstruction grievance = new GrievencesInstruction();
		try {
			if (grievanceId == 0) {

				grievance = tagService.getGrievanceInstructnByCaptn(caption, compId);
			} else {

				grievance = tagService.getGrievanceInstructnByCaptnAndId(caption, compId, grievanceId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return grievance;
	}

	@RequestMapping(value = { "/deleteGrievanceInstructnById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteGrievanceInstructnById(@RequestParam int grievanceId) {

		Info info = new Info();
		try {
			int res = tagService.deleteGrievanceInstructnById(grievanceId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Grievance Instruction Deleted Successfully");
			} else {
				info.setError(true);
				info.setMessage("Failed to Delete Grievance Instruction");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/addGrievance" }, method = RequestMethod.POST)
	public @ResponseBody GrievencesInstruction addGrievanceInstructn(@RequestBody GrievencesInstruction grievance) {

		GrievencesInstruction newGrievance = new GrievencesInstruction();
		try {
			newGrievance = tagService.insertGrievanceInstructn(grievance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newGrievance;
	}

	/***************************************************************************************/

	@RequestMapping(value = { "/getAllMnUsers" }, method = RequestMethod.POST)
	public @ResponseBody List<MnUser> getAllMnUsers(@RequestParam int compId) {

		List<MnUser> userList = new ArrayList<MnUser>();
		try {
			userList = tagService.getAllMnUserList(compId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	@RequestMapping(value = { "/getMnUserById" }, method = RequestMethod.POST)
	public @ResponseBody MnUser getMnUserById(@RequestParam int userId, @RequestParam int compId) {

		MnUser mnUser = new MnUser();
		try {
			mnUser = tagService.getMnUserById(userId, compId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mnUser;
	}

	@RequestMapping(value = { "/getMnUserByMobNo" }, method = RequestMethod.POST)
	public @ResponseBody MnUser getMnUserByMobNo(@RequestParam String mobNo, @RequestParam int userId) {

		MnUser user = new MnUser();
		try {
			if (userId == 0) {

				user = tagService.getMnUserByMobNo(mobNo);
			} else {

				user = tagService.getMnUserByMobNoAndUserId(mobNo, userId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@RequestMapping(value = { "/deleteMnUserById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMnUserById(@RequestParam int userId) {

		Info info = new Info();
		try {
			int res = tagService.deleteMnUserById(userId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("User Deleted Successfully");
			} else {
				info.setError(true);
				info.setMessage("Failed to Delete User");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/addMnUser" }, method = RequestMethod.POST)
	public @ResponseBody MnUser addMnUser(@RequestBody MnUser user) {

		MnUser mnUser = new MnUser();
		try {
			mnUser = tagService.insertMnUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mnUser;
	}

	/************************************************************************/

	@RequestMapping(value = { "/getAllActiveCompany" }, method = RequestMethod.GET)
	public @ResponseBody List<Company> getAllActiveCompany() {

		List<Company> compList = new ArrayList<Company>();
		try {
			compList = companyService.getAllActiveCompanyList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return compList;
	}

	@RequestMapping(value = { "/getAllMnCompanies" }, method = RequestMethod.GET)
	public @ResponseBody List<Company> getAllMnCompany() {

		List<Company> compList = new ArrayList<Company>();
		try {
			compList = companyService.getAllMnCompanyDetaisList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return compList;
	}

	@RequestMapping(value = { "/getMnCompanyById" }, method = RequestMethod.POST)
	public @ResponseBody Company getMnCompanyById(@RequestParam int compId) {

		Company company = new Company();
		try {
			company = companyService.getMnCompanyById(compId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return company;
	}

	@RequestMapping(value = { "/deleteMnCompanyById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMnCompanyById(@RequestParam int compId) {

		Info info = new Info();
		try {
			int res = companyService.deleteMnCompanyById(compId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Company Deleted Successfully");
			} else {
				info.setError(true);
				info.setMessage("Failed to Delete Company");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/saveMnCompany" }, method = RequestMethod.POST)
	public @ResponseBody Company getMnCompanyById(@RequestBody Company company) {

		Company comp = new Company();
		try {
			comp = companyService.insertNewCompany(company);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comp;
	}

	/************************************************************************/

	@RequestMapping(value = { "/getAllOfferHeads" }, method = RequestMethod.POST)
	public @ResponseBody List<OfferHeader> getAllFranchise(@RequestParam int compId) {

		List<OfferHeader> frOfferList = new ArrayList<OfferHeader>();
		try {
			frOfferList = companyService.getFrOfferConfigList(compId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return frOfferList;
	}

	/************************** Fr Offer Config ********************************/
	@RequestMapping(value = { "/getConfigureOfferList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetConfigureOfferList> getConfigureOfferList(@RequestParam int offerId) {

		List<GetConfigureOfferList> frOfferList = new ArrayList<GetConfigureOfferList>();
		try {
			frOfferList = companyService.getConfigureOfferListById(offerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return frOfferList;
	}

	@RequestMapping(value = { "/getOfferInfoByOfferId" }, method = RequestMethod.POST)
	public @ResponseBody OfferConfig getOfferInfoByOfferId(@RequestParam int offerId) {

		OfferConfig offer = new OfferConfig();
		try {
			offer = companyService.getConfigureFrOfferDetailById(offerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return offer;
	}

	@RequestMapping(value = { "/addFrOfferConfiguration" }, method = RequestMethod.POST)
	public @ResponseBody OfferConfig addFrOfferConfiguration(@RequestBody OfferConfig offer) {

		OfferConfig saveOffer = new OfferConfig();
		try {
			saveOffer = companyService.insertFrOfferConfig(offer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveOffer;
	}

	@RequestMapping(value = { "/updateFrOfferConfig" }, method = RequestMethod.POST)
	public @ResponseBody Info updateFrOfferConfig(@RequestParam String frIdStr, @RequestParam int offerId,
			@RequestParam String updtTime, @RequestParam int userId) {

		Info info = new Info();
		try {
			int res = companyService.udateFrOfferConfig(frIdStr, offerId, updtTime, userId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Update Franchisee Offer Configuration Successfully");
			} else {
				info.setError(true);
				info.setMessage("Failed Update Franchisee Offer Configuration");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/deleteFrOfferConfigById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteFrOfferConfigById(@RequestParam int frOfferConfigId) {

		Info info = new Info();
		try {
			int res = companyService.deleteFrOfferConfig(frOfferConfigId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Delete Franchisee Offer Configuration Successfully");
			} else {
				info.setError(true);
				info.setMessage("Failed To Delete Franchisee Offer Configuration");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/getAllOfferFrConfiguredList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetOfferFrConfiguredList> getAllOfferFrConfiguredList() {

		List<GetOfferFrConfiguredList> offerList = new ArrayList<GetOfferFrConfiguredList>();
		try {
			offerList = companyService.getOfferFrConfiguredList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return offerList;
	}

	/****************************************************************************/

	@RequestMapping(value = { "/getAllItems" }, method = RequestMethod.GET)
	public @ResponseBody List<Item> getAllItems() {

		List<Item> itemList = new ArrayList<Item>();
		try {
			itemList = companyService.getAllProductItems();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemList;
	}

	@RequestMapping(value = { "/getAllItemsByitemId" }, method = RequestMethod.POST)
	public @ResponseBody List<Item> getAllItemsByitemId(@RequestParam int itemId) {

		List<Item> itemList = new ArrayList<Item>();
		try {
			itemList = companyService.getAllProductItemsById(itemId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemList;
	}

	@RequestMapping(value = { "/getProductInfoById" }, method = RequestMethod.POST)
	public @ResponseBody ConfigRelatedProduct getProductInfoById(@RequestParam int itemId) {

		ConfigRelatedProduct item = new ConfigRelatedProduct();
		try {
			item = companyService.getProductById(itemId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	@RequestMapping(value = { "/addRelatedProductConfig" }, method = RequestMethod.POST)
	public @ResponseBody ConfigRelatedProduct addRelatedProductConfig(@RequestBody ConfigRelatedProduct product) {

		ConfigRelatedProduct saveRelatedProduct = new ConfigRelatedProduct();
		try {
			saveRelatedProduct = companyService.insertRelatedProductConfig(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveRelatedProduct;
	}

	@RequestMapping(value = { "/updateRelatedProductConfig" }, method = RequestMethod.POST)
	public @ResponseBody Info updateRelatedProductConfig(@RequestParam String relatedItemIds,
			@RequestParam int productId, @RequestParam String updateDatTime, @RequestParam int userId) {

		Info info = new Info();
		try {
			int res = companyService.udateRelatedProductConfig(relatedItemIds, productId, updateDatTime, userId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Update Related Product Configuration Successfully");
			} else {
				info.setError(true);
				info.setMessage("Failed Update Related Product Configuration");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/deleteRelatedProductById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteRelatedProductById(@RequestParam int relatedProductId) {

		Info info = new Info();
		try {
			int res = companyService.deleteRelProductConfig(relatedProductId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Delete Related Product Configuration Successfully");
			} else {
				info.setError(true);
				info.setMessage("Failed To Delete  Related Product Configuration");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/getAllRelatedProducts" }, method = RequestMethod.POST)
	public @ResponseBody List<GetProductRelatedList> getAllRelatedProducts(@RequestParam int compId) {

		List<GetProductRelatedList> productList = new ArrayList<GetProductRelatedList>();
		try {
			productList = companyService.getAllRelatedProductsByCompId(compId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	@Autowired
	IngredientDetailListRepo ingDetailRepo;

	@RequestMapping(value = { "/getTasteListForAddItemDetail" }, method = RequestMethod.GET)
	public @ResponseBody List<IngredientDetailList> getTasteListForAddItemDetail() {

		List<IngredientDetailList> ingrediantList = new ArrayList<IngredientDetailList>();
		try {
			ingrediantList = ingDetailRepo.getTasteListForAddItemDetail();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ingrediantList;

	}
}
