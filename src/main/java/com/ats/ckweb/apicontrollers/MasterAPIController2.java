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
import com.ats.ckweb.model.Franchisee;
import com.ats.ckweb.model.GetItemForDetail;
import com.ats.ckweb.model.GetItemsForConfig;
import com.ats.ckweb.model.Images;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.ItemConfigDetail;
import com.ats.ckweb.model.ItemConfigHeader;
import com.ats.ckweb.model.ItemDetailNew;
import com.ats.ckweb.model.OfferDetail;
import com.ats.ckweb.model.OfferHeader;
import com.ats.ckweb.model.ShowItemDetailNewList;
import com.ats.ckweb.model.SubCategory;
import com.ats.ckweb.repository.FranchiseeRepository;
import com.ats.ckweb.repository.GetItemForDetailRepo;
import com.ats.ckweb.repository.GetItemsForConfigRepo;
import com.ats.ckweb.repository.ItemConfigDetailRepo;
import com.ats.ckweb.repository.ItemDetailNewRepo;
import com.ats.ckweb.repository.OfferDetailRepo;
import com.ats.ckweb.repository.OfferHeaderRepo;
import com.ats.ckweb.repository.ShowItemDetailNewListRepo;
import com.ats.ckweb.services.CategoryService;
import com.ats.ckweb.services.ImagesService;
import com.ats.ckweb.services.ItemConfigHeaderService;
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

	@Autowired
	ItemConfigHeaderService itemConfigHeaderService;

	@Autowired
	GetItemsForConfigRepo getItemsForConfigRepo;

	@Autowired
	FranchiseeRepository franchiseeRepository;

	@Autowired
	ItemConfigDetailRepo itemConfigDetailRepo;

	@Autowired
	ItemDetailNewRepo itemDetailNewRepo;

	@Autowired
	ShowItemDetailNewListRepo showItemDetailNewListRepo;

	@Autowired
	OfferHeaderRepo offerHeaderRepo;

	@Autowired
	OfferDetailRepo offerDetailRepo;

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

	// Author-Anmol Shirke Created On-15-07-2020
	// Desc- Returns all sub category list by delete status=0.
	@RequestMapping(value = { "/getAllItemsToAddDetail" }, method = RequestMethod.GET)
	public @ResponseBody List<GetItemForDetail> getAllItemsToAddDetail() {

		List<GetItemForDetail> itemList = null;
		try {
			itemList = getItemForDetailRepo.getAllItemsForDetail();
			if (itemList == null) {
				new ArrayList<GetItemForDetail>();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemList;
	}

	// Author-Anmol Shirke Created On-20-07-2020
	// Desc- Returns ItemConfigHeader object - save item config.
	@RequestMapping(value = { "/saveItemConfiguration" }, method = RequestMethod.POST)
	public @ResponseBody ItemConfigHeader saveItemConfiguration(@RequestBody ItemConfigHeader itemConfigHeader) {
		ItemConfigHeader res = itemConfigHeaderService.saveItemConfigHeaderAndDetail(itemConfigHeader);
		return res;
	}

	// Author-Anmol Shirke Created On-20-07-2020
	// Desc- Returns ItemConfigDetail object - save item config.
	@RequestMapping(value = { "/saveItemConfigurationDetails" }, method = RequestMethod.POST)
	public @ResponseBody Info saveItemConfigurationDetails(@RequestBody List<ItemConfigDetail> itemConfigDetailList) {

		Info info = new Info();

		List<ItemConfigDetail> detailList = itemConfigDetailRepo.saveAll(itemConfigDetailList);
		if (detailList != null) {
			info.setError(false);
			info.setMessage("Success");
		} else {
			info.setError(true);
			info.setMessage("Failed");
		}

		return info;
	}

	// Author-Anmol Shirke Created On-20-07-2020
	// Desc- Returns all item list for configuration
	@RequestMapping(value = { "/getItemsForConfigByFrId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetItemsForConfig> getItemsForConfigByFrId(@RequestParam("frId") int frId,
			@RequestParam("configType") int configType, @RequestParam("compId") int compId) {

		List<GetItemsForConfig> itemList = null;
		try {
			itemList = getItemsForConfigRepo.getItemsForConfigByFrId(frId, configType, compId);
			if (itemList == null) {
				new ArrayList<GetItemsForConfig>();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemList;
	}

	// Author-Anmol Shirke Created On-20-07-2020
	// Desc- Returns all franchisee
	@RequestMapping(value = { "/getAllFranchise" }, method = RequestMethod.GET)
	public @ResponseBody List<Franchisee> getAllFranchise() {

		List<Franchisee> franchisee = null;

		franchisee = franchiseeRepository.findAllFranchisee();

		if (franchisee == null) {
			franchisee = new ArrayList<Franchisee>();
		}
		return franchisee;
	}

	// Author-Anmol Shirke Created On-22-07-2020
	// Desc- Returns Info object - delete item config details.
	@RequestMapping(value = { "/deleteItemConfigDetails" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteItemConfigDetails(@RequestParam("configDetailIds") List<Integer> configDetailIds) {

		Info info = new Info();

		System.err.println("DELETE IDS = " + configDetailIds);

		int res = itemConfigDetailRepo.deleteItemConfigDetail(configDetailIds);
		if (res > 0) {
			info.setError(false);
			info.setMessage("Success");
		} else {
			info.setError(true);
			info.setMessage("Failed");
		}

		return info;
	}

	// Author-Anmol Shirke Created On-22-07-2020
	// Desc- Returns Info object - update tagids from item details.
	@RequestMapping(value = { "/updateItemTagIds" }, method = RequestMethod.POST)
	public @ResponseBody Info updateItemTagIds(@RequestParam("itemDIds") List<Integer> itemDIds,
			@RequestParam("tagId") int tagId) {

		Info info = new Info();

		int res = itemDetailNewRepo.updateTagIdsByItemDId(itemDIds, tagId);
		if (res > 0) {
			info.setError(false);
			info.setMessage("Success");
		} else {
			info.setError(true);
			info.setMessage("Failed");
		}

		return info;
	}

	// Author-Anmol Shirke Created On-22-07-2020
	// Desc- Returns Info object - update tagids from item details.
	@RequestMapping(value = { "/removeItemTagIds" }, method = RequestMethod.POST)
	public @ResponseBody Info removeItemTagIds(@RequestParam("itemDIds") List<Integer> itemDIds,
			@RequestParam("tagId") int tagId) {

		Info info = new Info();

		int res = itemDetailNewRepo.removeTagIdsByItemDId(itemDIds, tagId);
		if (res > 0) {
			info.setError(false);
			info.setMessage("Success");
		} else {
			info.setError(true);
			info.setMessage("Failed");
		}

		return info;
	}

	// Author-Anmol Shirke Created On-22-07-2020
	// Desc- Returns ItemDetailNew object - get Data by itemDId.
	@RequestMapping(value = { "/getItemDetailNewDataById" }, method = RequestMethod.POST)
	public @ResponseBody ItemDetailNew getItemDetailNewDataById(@RequestParam("itemDId") int itemDId) {

		ItemDetailNew data = new ItemDetailNew();

		data = itemDetailNewRepo.findByItemDId(itemDId);
		if (data == null) {
			data = new ItemDetailNew();
		}

		return data;
	}

	// Author-Anmol Shirke Created On-22-07-2020
	// Desc- Returns all ItemDetail List
	@RequestMapping(value = { "/getAllItemDetailListByCompId" }, method = RequestMethod.POST)
	public @ResponseBody List<ShowItemDetailNewList> getAllItemDetailListByCompId(@RequestParam("compId") int compId) {

		List<ShowItemDetailNewList> res = null;

		res = showItemDetailNewListRepo.getItemDetailNewList(compId);

		if (res == null) {
			res = new ArrayList<ShowItemDetailNewList>();
		}
		return res;
	}

	// Author-Anmol Shirke Created On-22-07-2020
	// Desc- Returns OfferHeader object - save OfferHeader.
	@RequestMapping(value = { "/saveOfferHeader" }, method = RequestMethod.POST)
	public @ResponseBody OfferHeader saveOfferHeader(@RequestBody OfferHeader offerHeader) {

		OfferHeader res = offerHeaderRepo.save(offerHeader);

		if (res == null) {
			res = new OfferHeader();
		}

		return res;
	}

	// Author-Anmol Shirke Created On-22-07-2020
	// Desc- Returns OfferHeader object - save OfferHeader.
	@RequestMapping(value = { "/saveOfferDetailList" }, method = RequestMethod.POST)
	public @ResponseBody Info saveOfferDetailList(@RequestParam("offerDetailList") List<OfferDetail> offerDetailList) {

		Info info = new Info();

		List<OfferDetail> res = offerDetailRepo.saveAll(offerDetailList);
		if (res != null) {
			info.setError(false);
			info.setMessage("Success");
		} else {
			info.setError(true);
			info.setMessage("Failed");
		}

		return info;
	}

}
