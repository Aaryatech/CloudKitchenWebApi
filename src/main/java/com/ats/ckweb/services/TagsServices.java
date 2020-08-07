package com.ats.ckweb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.ckweb.model.Area;
import com.ats.ckweb.model.AreaCityList;
import com.ats.ckweb.model.City;
import com.ats.ckweb.model.DeliveryInstruction;
import com.ats.ckweb.model.Designation;
import com.ats.ckweb.model.GetAllConfiguredItemTag;
import com.ats.ckweb.model.GetItemTagDetails;
import com.ats.ckweb.model.GrievencesInstruction;
import com.ats.ckweb.model.GrievencesTypeInstructn;
import com.ats.ckweb.model.Ingrediant;
import com.ats.ckweb.model.IngrediantCategory;
import com.ats.ckweb.model.IngredientDetailList;
import com.ats.ckweb.model.Language;
import com.ats.ckweb.model.MCategory;
import com.ats.ckweb.model.MnUser;
import com.ats.ckweb.model.Tags;
import com.ats.ckweb.model.UserType;
@Service
public interface TagsServices {

	
	List<Tags> getAllOfferTags(int compId);

	Tags getTagById(int tagId);

	Tags saveTag(Tags tag);

	List<Tags> getAllActiveOfferTags(int compId);

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

	List<Language> getAllLanguages(int compId);

	Language insertLanguage(Language lang);

	Language getLanguageById(int langId, int compId);

	int deleteLangById(int langId);

	Language getLanguageByCode(String code, int compId);

	Language getLanguageByCodeInEdit(String code, int langId, int compId);

	List<City> getAllCities();

	City getCityById(int cityId);

	City getCityByCodeInEdit(String code, int cityId);

	City getCityByCode(String code);

	int deleteCityById(int cityId);

	City insertCity(City city);

	List<Area> getAllArea(int compId);

	Area getAreaById(int areaId, int compId);

	Area getAreaByCode(String code, int compId);

	Area getAreaByCodeInEdit(String code, int areaId, int compId);

	int deleteAreaById(int areaId);

	Area insertArea(Area area);

	List<AreaCityList> getAllAreaCityList(int compId);

	List<DeliveryInstruction> getAllDelvryInstructn(int compId, int i);

	DeliveryInstruction getDeliveryInstructionById(int instructId);

	DeliveryInstruction getDeliveryInstructionByCaptn(String caption, int compId);

	DeliveryInstruction getDeliveryInstructionByCaptnAndId(String caption, int compId, int instructId);

	int deleteDelInstructnById(int instructId);

	DeliveryInstruction insertDeliveryInstrunctn(DeliveryInstruction instructn);

	int getAreaCityById(int cityId);

	List<GrievencesTypeInstructn> getAllGrievTypeList(int compId, int i);

	GrievencesTypeInstructn getGrievTypeInstructById(int grievTypeId, int compId);

	GrievencesTypeInstructn getGrievTypeInstructByCaptn(String caption, int compId);

	GrievencesTypeInstructn getGrievTypeInstructByCaptnAndId(String caption, int compId, int grievTypeId);

	int deleteGrievTypeInstructById(int grievTypeId);

	GrievencesTypeInstructn insertGrievTypeInstruct(GrievencesTypeInstructn griev);

	List<GrievencesInstruction> getAllGrievanceList(int compId);

	GrievencesInstruction getGrievanceInstructById(int grievanceId, int compId);

	GrievencesInstruction getGrievanceInstructnByCaptn(String caption, int compId);

	GrievencesInstruction getGrievanceInstructnByCaptnAndId(String caption, int compId, int grievanceId);

	int deleteGrievanceInstructnById(int grievanceId);

	GrievencesInstruction insertGrievanceInstructn(GrievencesInstruction grievance);

	List<MnUser> getAllMnUserList(int compId);

	MnUser getMnUserById(int userId, int compId);

	MnUser getMnUserByMobNo(String mobNo);

	MnUser getMnUserByMobNoAndUserId(String mobNo, int userId);

	int deleteMnUserById(int userId);

	MnUser insertMnUser(MnUser user);

	List<Designation> getAllDesignations();

	List<UserType> getAllUserTypes();

	MnUser getMnUserDetailById(int userId, int i);

	int updatePassword(int userId, String newPass);

	List<Area> getAreaCityAndCompById(int cityId, int compId);

	int getIngredientCnt(int ingerediantCatId);

	List<GetItemTagDetails> getItemTagDtl(int tagId, int compId);

	List<Designation> getAllDesignationsBtCompId(int compId);
	

	
}
