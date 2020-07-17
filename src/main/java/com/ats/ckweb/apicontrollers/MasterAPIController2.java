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
import com.ats.ckweb.model.GetItemForDetail;
import com.ats.ckweb.model.Images;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.ItemDetailNew;
import com.ats.ckweb.model.SubCategory;
import com.ats.ckweb.model.Tags;
import com.ats.ckweb.repository.GetItemForDetailRepo;
import com.ats.ckweb.services.CategoryService;
import com.ats.ckweb.services.ImagesService;
import com.ats.ckweb.services.ItemDetailNewService;
import com.ats.ckweb.services.SubCategoryService;

@RestController
public class MasterAPIController2 {

	@Autowired
	CategoryService categoryService;

	@Autowired
	SubCategoryService subCategoryService;

	@Autowired
	ImagesService imagesService;

	@Autowired
	ItemDetailNewService itemDetailNewService;

	@Autowired
	GetItemForDetailRepo getItemForDetailRepo;

	// Author-Anmol Shirke Created On-15-07-2020
	// Desc- Returns all category list by delete status=0.
	@RequestMapping(value = { "/getAllCategory" }, method = RequestMethod.GET)
	public @ResponseBody List<Category> getAllCategory() {

		List<Category> catList = new ArrayList<Category>();
		try {
			catList = categoryService.getAllCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return catList;
	}

	// Author-Anmol Shirke Created On-15-07-2020
	// Desc- Returns all sub category list by delete status=0.
	@RequestMapping(value = { "/getAllSubCategory" }, method = RequestMethod.GET)
	public @ResponseBody List<SubCategory> getAllSubCategory() {

		List<SubCategory> subCatList = new ArrayList<SubCategory>();
		try {
			subCatList = subCategoryService.getAllSubCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subCatList;
	}

	// Author-Anmol Shirke Created On-16-07-2020
	// Desc- Returns Images object - save single image.
	@RequestMapping(value = { "/saveImage" }, method = RequestMethod.POST)
	public @ResponseBody Images saveImage(@RequestBody Images image) {
		Images res = imagesService.saveImage(image);
		return res;
	}

	// Author-Anmol Shirke Created On-16-07-2020
	// Desc- Returns Info object - save multiple image.
	@RequestMapping(value = { "/saveMultipleImage" }, method = RequestMethod.POST)
	public @ResponseBody Info saveMultipleImage(@RequestBody List<Images> imageList) {
		Info info = imagesService.saveMultipleImages(imageList);
		return info;
	}

	// Author-Anmol Shirke Created On-16-07-2020
	// Desc- Returns Images list - get all images by docId and delete status=0.
	@RequestMapping(value = { "/getImagesByDocIdAndDocType" }, method = RequestMethod.POST)
	public @ResponseBody List<Images> getImagesByDocId(@RequestParam int docId, int docType) {
		List<Images> res = imagesService.getImageListByDocIdAndDocType(docId, docType);
		return res;
	}

	// Author-Anmol Shirke Created On-16-07-2020
	// Desc- Returns Info object - delete image by imageId - physical delete.
	@RequestMapping(value = { "/deleteByImageId" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteByImageId(@RequestParam int imageId) {
		Info res = imagesService.deletImageById(imageId);
		return res;
	}

	// Author-Anmol Shirke Created On-16-07-2020
	// Desc- Returns ItemDetailNew object - save item detail.
	@RequestMapping(value = { "/saveItemDetailNew" }, method = RequestMethod.POST)
	public @ResponseBody ItemDetailNew saveImage(@RequestBody ItemDetailNew itemDetailNew) {
		ItemDetailNew res = itemDetailNewService.saveItemDetailNew(itemDetailNew);
		return res;
	}

	// Author-Anmol Shirke Created On-15-07-2020
	// Desc- Returns all sub category list by delete status=0.
	@RequestMapping(value = { "/getItemsToAddDetail" }, method = RequestMethod.GET)
	public @ResponseBody List<GetItemForDetail> getItemsToAddDetail() {

		List<GetItemForDetail> itemList = null;
		try {
			itemList = getItemForDetailRepo.getItemsForDetail();
			if (itemList == null) {
				new ArrayList<GetItemForDetail>();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemList;
	}

}
