package com.ats.ckweb.apicontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ats.ckweb.model.AreaData;
import com.ats.ckweb.model.CategoryData;
import com.ats.ckweb.model.CityData;
import com.ats.ckweb.model.FranchiseData;
import com.ats.ckweb.model.GetCategoryData;
import com.ats.ckweb.model.GetFranchiseData;
import com.ats.ckweb.model.GetSubCategoryData;
import com.ats.ckweb.model.Images;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.SubCategoryData;
import com.ats.ckweb.repository.AreaDataRepo;
import com.ats.ckweb.repository.CategoryDataRepo;
import com.ats.ckweb.repository.CityDataRepo;
import com.ats.ckweb.repository.FranchiseDataRepo;
import com.ats.ckweb.repository.SubCategoryDataRepo;
import com.ats.ckweb.services.ImagesService;

@Controller
public class FrontEndController {

	@Autowired
	FranchiseDataRepo franchiseDataRepo;

	@Autowired
	CityDataRepo cityDataRepo;

	@Autowired
	AreaDataRepo areaDataRepo;

	@Autowired
	CategoryDataRepo categoryDataRepo;

	@Autowired
	SubCategoryDataRepo subCategoryDataRepo;

	@Autowired
	ImagesService imagesService;

	// Author-Anmol Shirke Created On-20-07-2020
	// Desc- Returns franchisee,city,area list
	@RequestMapping(value = { "/getFranchiseList" }, method = RequestMethod.GET)
	public @ResponseBody GetFranchiseData getFranchiseList() {

		GetFranchiseData res = new GetFranchiseData();

		List<FranchiseData> frData = null;

		frData = franchiseDataRepo.getAllFranchise();

		Info info = new Info();

		if (frData == null) {
			frData = new ArrayList<FranchiseData>();

			info.setError(true);
			info.setMessage("Failed");
		} else {

//			for (int i = 0; i < frData.size(); i++) {
//
//				List<CityData> cityList = cityDataRepo.getAllCityByFr(frData.get(i).getFrId());
//				if (cityList == null) {
//					cityList = new ArrayList<>();
//				}
//
//				frData.get(i).setCityList(cityList);
//
//				List<AreaData> areaList = areaDataRepo.getAllAreasByFr(frData.get(i).getFrId());
//				if (areaList == null) {
//					areaList = new ArrayList<>();
//				}
//
//				frData.get(i).setAreaList(areaList);
//
//			}

			info.setError(false);
			info.setMessage("Success");
		}

		res.setFranchise(frData);
		res.setInfo(info);

		return res;
	}

	@RequestMapping(value = { "/getFranchiseByFrId" }, method = RequestMethod.GET)
	public @ResponseBody FranchiseData getFranchiseByFrId(@RequestParam("frId") int frId) {

		FranchiseData frData = null;

		frData = franchiseDataRepo.getFranchiseById(frId);

		if (frData == null) {
			frData = new FranchiseData();
		} else {

			List<CityData> cityList = cityDataRepo.getAllCityByFr(frData.getFrId());
			if (cityList == null) {
				cityList = new ArrayList<>();
			}
			frData.setCityList(cityList);

			List<AreaData> areaList = areaDataRepo.getAllAreasByFr(frData.getFrId());
			if (areaList == null) {
				areaList = new ArrayList<>();
			}
			frData.setAreaList(areaList);
		}

		return frData;
	}

	// Author-Anmol Shirke Created On-20-07-2020
	// Desc- Returns Category list with images
	@RequestMapping(value = { "/getCategoryListByFr" }, method = RequestMethod.GET)
	public @ResponseBody GetCategoryData getCategoryListByFr(@RequestParam("frId") int frId) {

		GetCategoryData res = new GetCategoryData();

		List<CategoryData> catData = null;

		catData = categoryDataRepo.getCategoriesByFr(frId);

		Info info = new Info();

		if (catData == null) {
			catData = new ArrayList<CategoryData>();

			info.setError(true);
			info.setMessage("Failed");
		} else {

			for (int i = 0; i < catData.size(); i++) {

				List<Images> imgList = imagesService.getImageListByDocIdAndDocType(catData.get(i).getCatId(), 1);
				if (imgList == null) {
					imgList = new ArrayList<>();
				}

				catData.get(i).setImageList(imgList);

			}

			info.setError(false);
			info.setMessage("Success");
		}

		res.setCategory(catData);
		res.setInfo(info);

		return res;
	}

	// Author-Anmol Shirke Created On-20-07-2020
	// Desc- Returns Category list with images
	@RequestMapping(value = { "/getSubCategoryListByFr" }, method = RequestMethod.GET)
	public @ResponseBody GetSubCategoryData getSubCategoryListByFr(@RequestParam("frId") int frId) {

		GetSubCategoryData res = new GetSubCategoryData();

		List<SubCategoryData> subCatData = null;

		subCatData = subCategoryDataRepo.getSubCategoriesByFr(frId);

		Info info = new Info();

		if (subCatData == null) {
			subCatData = new ArrayList<SubCategoryData>();
			info.setError(true);
			info.setMessage("Failed");
		} else {

			for (int i = 0; i < subCatData.size(); i++) {

				List<Images> imgList = imagesService.getImageListByDocIdAndDocType(subCatData.get(i).getSubCatId(), 2);
				if (imgList == null) {
					imgList = new ArrayList<>();
				}

				subCatData.get(i).setImageList(imgList);

			}

			info.setError(false);
			info.setMessage("Success");
		}

		res.setSubCategory(subCatData);
		res.setInfo(info);

		return res;
	}

}
