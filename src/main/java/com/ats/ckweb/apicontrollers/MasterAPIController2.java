package com.ats.ckweb.apicontrollers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.commons.SMSUtility;
import com.ats.ckweb.model.Category;
import com.ats.ckweb.model.Customer;
import com.ats.ckweb.model.CustomerAddress;
import com.ats.ckweb.model.CustomerAddressDisplay;
import com.ats.ckweb.model.CustomerDisplay;
import com.ats.ckweb.model.Franchisee;
import com.ats.ckweb.model.GetItemForDetail;
import com.ats.ckweb.model.GetItemsForConfig;
import com.ats.ckweb.model.Images;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.ItemBuyGetFreeOffer;
import com.ats.ckweb.model.ItemConfigDetail;
import com.ats.ckweb.model.ItemConfigDisplay;
import com.ats.ckweb.model.ItemConfigHeader;
import com.ats.ckweb.model.ItemDetailNew;
import com.ats.ckweb.model.ItemListForOfferDetail;
import com.ats.ckweb.model.Language;
import com.ats.ckweb.model.NewSetting;
import com.ats.ckweb.model.OfferDetail;
import com.ats.ckweb.model.OfferHeader;
import com.ats.ckweb.model.OrderRemark;
import com.ats.ckweb.model.OrderTrail;
import com.ats.ckweb.model.ProdRatings;
import com.ats.ckweb.model.SettingsUpdateModel;
import com.ats.ckweb.model.ShowItemDetailNewList;
import com.ats.ckweb.model.SubCategory;
import com.ats.ckweb.repository.CustomerAddressDisplayRepo;
import com.ats.ckweb.repository.CustomerAddressRepo;
import com.ats.ckweb.repository.CustomerDisplayRepo;
import com.ats.ckweb.repository.CustomerRepo;
import com.ats.ckweb.repository.FranchiseeRepository;
import com.ats.ckweb.repository.GetItemForDetailRepo;
import com.ats.ckweb.repository.GetItemsForConfigRepo;
import com.ats.ckweb.repository.ItemBuyGetFreeOfferRepo;
import com.ats.ckweb.repository.ItemConfigDetailRepo;
import com.ats.ckweb.repository.ItemConfigDisplayRepo;
import com.ats.ckweb.repository.ItemConfigHeaderRepo;
import com.ats.ckweb.repository.ItemDetailNewRepo;
import com.ats.ckweb.repository.ItemListForOfferDetailRepo;
import com.ats.ckweb.repository.LanguageRepo;
import com.ats.ckweb.repository.NewSettingRepo;
import com.ats.ckweb.repository.OfferDetailRepo;
import com.ats.ckweb.repository.OfferHeaderRepo;
import com.ats.ckweb.repository.OrderHeaderRepository;
import com.ats.ckweb.repository.OrderRemarkRepo;
import com.ats.ckweb.repository.OrderTrailRepository;
import com.ats.ckweb.repository.ProdRatingsRepo;
import com.ats.ckweb.repository.SettingsUpdateModelRepo;
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

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	CustomerAddressRepo customerAddressRepo;

	@Autowired
	CustomerDisplayRepo customerDisplayRepo;

	@Autowired
	CustomerAddressDisplayRepo customerAddressDisplayRepo;

	@Autowired
	ItemListForOfferDetailRepo itemListForOfferDetailRepo;

	@Autowired
	LanguageRepo langRepo;

	@Autowired
	ItemBuyGetFreeOfferRepo itemBuyGetFreeOfferRepo;

	@Autowired
	ItemConfigDisplayRepo itemConfigDisplayRepo;

	@Autowired
	OrderHeaderRepository orderHeaderRepository;

	@Autowired
	OrderTrailRepository orderTrailRepository;

	@Autowired
	NewSettingRepo newSettingRepo;

	@Autowired
	OrderRemarkRepo orderRemarkRepo;

	@Autowired
	SettingsUpdateModelRepo settingsUpdateModelRepo;
	
	@Autowired
	ProdRatingsRepo prodRatingsRepo;

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

	@RequestMapping(value = { "/getAllNotConfiguredFranchisee" }, method = RequestMethod.GET)
	public @ResponseBody List<Franchisee> getAllNotConfiguredFranchisee() {

		List<Franchisee> franchisee = null;

		franchisee = franchiseeRepository.getAllNotConfiguredFranchisee();

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
	@RequestMapping(value = { "/saveOfferDetailList" }, method = RequestMethod.POST)
	public @ResponseBody Info saveOfferDetailList(@RequestBody List<OfferDetail> offerDetailList) {

		Info info = new Info();

//		int offerId = 0, type = 0;
//		if (offerDetailList != null) {
//			if (offerDetailList.size() > 0) {
//				offerId = offerDetailList.get(0).getOfferId();
//				type = offerDetailList.get(0).getExInt4();
//			}
//		}
//
//		if (type == 1) {
//
//			List<OfferDetail> detail = offerDetailRepo.findAllByOfferId(offerId);
//			if (detail != null) {
//				if (detail.size() > 0) {
//
//					if (offerDetailList != null) {
//						if (offerDetailList.size() > 0) {
//							for (int i = 0; i < offerDetailList.size(); i++) {
//								offerDetailList.get(i).setOfferDetailId(detail.get(0).getOfferDetailId());
//							}
//						}
//					}
//
//				}
//			}
//		}

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

	// Author-Anmol Shirke Created On-22-07-2020
	// Desc- Returns OfferHeader object - save OfferHeader.
	@RequestMapping(value = { "/getOfferHeaderById" }, method = RequestMethod.POST)
	public @ResponseBody OfferHeader getOfferHeaderById(@RequestParam("offerId") int offerId) {

		OfferHeader res = offerHeaderRepo.findByOfferId(offerId);

		if (res == null) {
			res = new OfferHeader();
		}

		return res;
	}

	@RequestMapping(value = { "/deleteOfferHeaderById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteOfferHeaderById(@RequestParam("offerId") int offerId,
			@RequestParam("status") int status) {

		Info info = new Info();

		int res = offerHeaderRepo.deleteOfferHeader(offerId, status);
		if (res > 0) {
			info.setError(false);
			info.setMessage("Success");
		} else {
			info.setError(true);
			info.setMessage("Failed");
		}

		return info;
	}

	// Author-Anmol Shirke Created On-24-07-2020
	@RequestMapping(value = { "/getAllOfferHeaderListByCompId" }, method = RequestMethod.POST)
	public @ResponseBody List<OfferHeader> getAllOfferHeaderListByCompId(@RequestParam("compId") int compId) {

		List<OfferHeader> res = offerHeaderRepo.findByCompIdAndDelStatusAndIsActive(compId, 0, 0);

		if (res == null) {
			res = new ArrayList<>();
		}

		return res;
	}

	// Author-Anmol Shirke Created On-22-07-2020
	@RequestMapping(value = { "/getOfferDetailListByOfferId" }, method = RequestMethod.POST)
	public @ResponseBody List<OfferDetail> getOfferDetailListByOfferId(@RequestParam("offerId") int offerId) {

		List<OfferDetail> res = offerDetailRepo.findAllByOfferIdAndIsActiveAndDelStatus(offerId, 0, 0);

		if (res == null) {
			res = new ArrayList<>();
		}

		return res;
	}

	@RequestMapping(value = { "/updateOfferType" }, method = RequestMethod.POST)
	public @ResponseBody Info updateOfferType(@RequestParam("offerId") int offerId, @RequestParam("type") int type) {

		Info info = new Info();

		int res = offerHeaderRepo.updateOfferType(offerId, type);
		if (res > 0) {
			info.setError(false);
			info.setMessage("Success");
		} else {
			info.setError(true);
			info.setMessage("Failed");
		}

		return info;
	}

	@RequestMapping(value = { "/updateBillWiseOfferType" }, method = RequestMethod.POST)
	public @ResponseBody Info updateOfferType(@RequestParam("offerId") int offerId, @RequestParam("type") int type,
			@RequestParam("billType") int billType) {

		Info info = new Info();
		
		int res = offerHeaderRepo.updateBillWiseOfferType(offerId, type, billType);
		if (res > 0) {
			info.setError(false);
			info.setMessage("Success");
		} else {
			info.setError(true);
			info.setMessage("Failed");
		}

		return info;
	}

	@RequestMapping(value = { "/removeOfferDetailIds" }, method = RequestMethod.POST)
	public @ResponseBody Info removeOfferDetailIds(@RequestParam("offerDetailIds") List<Integer> offerDetailIds) {

		Info info = new Info();

		int res = offerDetailRepo.deleteOfferDetails(offerDetailIds);
		if (res > 0) {
			info.setError(false);
			info.setMessage("Success");
		} else {
			info.setError(true);
			info.setMessage("Failed");
		}

		return info;
	}

	@RequestMapping(value = { "/getItemListForOfferDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemListForOfferDetail> getItemListForOfferDetail(@RequestParam("offerId") int offerId) {

		List<ItemListForOfferDetail> res = null;

		res = itemListForOfferDetailRepo.getAllItemList(offerId);

		if (res == null) {
			res = new ArrayList<ItemListForOfferDetail>();
		}
		return res;
	}

	@RequestMapping(value = { "/getItemListForOfferDetailByCompId" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemListForOfferDetail> getItemListForOfferDetailByCompId(
			@RequestParam("compId") int compId) {

		List<ItemListForOfferDetail> res = null;

		res = itemListForOfferDetailRepo.getAllItemListByCompId(compId);

		if (res == null) {
			res = new ArrayList<ItemListForOfferDetail>();
		}
		return res;
	}

	@RequestMapping(value = { "/getBuyGetFreeOfferList" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemBuyGetFreeOffer> getBuyGetFreeOfferList(@RequestParam("offerId") int offerId) {

		List<ItemBuyGetFreeOffer> res = null;

		res = itemBuyGetFreeOfferRepo.getOfferDetailListForBuyGetFree(offerId);

		if (res == null) {
			res = new ArrayList<ItemBuyGetFreeOffer>();
		}
		return res;
	}

	// -----------------------CUSTOMER---------------------

	// Author-Anmol Shirke Created On-23-07-2020
	// Desc- Returns Customer object - save Customer.
	@RequestMapping(value = { "/saveCustomer" }, method = RequestMethod.POST)
	public @ResponseBody Customer saveCustomer(@RequestBody Customer customer) {

		Customer res = new Customer();

		res = customerRepo.save(customer);
		if (res == null) {
			res = new Customer();
			res.setError(true);
			res.setMessage("Failed");
			res.setLangName("");

		} else {
			res.setError(false);
			res.setMessage("Success");

			try {
				Language lang = langRepo.findByLangIdAndDelStatusAndCompanyId(res.getLangId(), 0, res.getCompId());
				res.setLangName(lang.getLangName());
			} catch (Exception e) {
			}

			try {
				NewSetting val = newSettingRepo.findBySettingKeyAndDelStatus("msg_new_cust", 0);
				SMSUtility.sendSMS(res.getPhoneNumber(), val.getSettingValue1(),"MADHVI");
			} catch (Exception e) {
			}

		}

		return res;
	}

	// Author-Anmol Shirke Created On-23-07-2020
	// Desc- Returns Customer object - save Customer.
	@RequestMapping(value = { "/saveCustomerAddressList" }, method = RequestMethod.POST)
	public @ResponseBody Info saveCustomerAddressList(@RequestBody List<CustomerAddress> custAddressList) {

		Info info = new Info();

		List<CustomerAddress> res = customerAddressRepo.saveAll(custAddressList);
		if (res != null) {
			info.setError(false);
			info.setMessage(String.valueOf(res.get(0).getCustAddressId()));
		} else {
			info.setError(true);
			info.setMessage("Failed");
		}

		return info;
	}

	// Author-Anmol Shirke Created On-22-07-2020
	// Desc- Returns all Customer List
	@RequestMapping(value = { "/getAllCustomer" }, method = RequestMethod.GET)
	public @ResponseBody List<CustomerDisplay> getAllCustomer() {

		List<CustomerDisplay> res = null;

		res = customerDisplayRepo.getAllCustomer();

		if (res == null) {
			res = new ArrayList<CustomerDisplay>();
		}
		return res;
	}

	// Author-Sachin Handge Created On-10-08-2020
	// Desc- Returns all Customer List
	@RequestMapping(value = { "/getAllCustomerList" }, method = RequestMethod.GET)
	public @ResponseBody List<CustomerDisplay> getAllCustomerList() {

		List<CustomerDisplay> res = null;
		try {
			res = customerDisplayRepo.getAllCustomerList();

			if (res == null) {
				res = new ArrayList<CustomerDisplay>();
			}
		} catch (Exception e) {
			res = new ArrayList<CustomerDisplay>();
			e.printStackTrace();
		}
		return res;
	}

	// Author-Anmol Shirke Created On-22-07-2020
	// Desc- Returns Customer Object by cust id
	@RequestMapping(value = { "/getCustomerById" }, method = RequestMethod.POST)
	public @ResponseBody CustomerDisplay getCustomerById(@RequestParam("custId") int custId) {

		CustomerDisplay res = null;

		res = customerDisplayRepo.getCustomerById(custId);

		if (res == null) {
			res = new CustomerDisplay();
		}
		return res;
	}

	// Author-Anmol Shirke Created On-22-07-2020
	// Desc- Returns all customer address List by cust Id
	@RequestMapping(value = { "/getCustomerAddressList" }, method = RequestMethod.POST)
	public @ResponseBody List<CustomerAddressDisplay> getCustomerAddressList(@RequestParam("custId") int custId) {

		List<CustomerAddressDisplay> res = null;

		res = customerAddressDisplayRepo.getCustomerAddressList(custId);

		if (res == null) {
			res = new ArrayList<CustomerAddressDisplay>();
		}
		return res;
	}

	@RequestMapping(value = { "/getCustomerAddressListById" }, method = RequestMethod.POST)
	public @ResponseBody CustomerAddressDisplay getCustomerAddressById(
			@RequestParam("custAddressId") int custAddressId) {

		CustomerAddressDisplay res = null;

		res = customerAddressDisplayRepo.getCustomerAddressById(custAddressId);

		if (res == null) {
			res = new CustomerAddressDisplay();
		}
		return res;
	}

	@RequestMapping(value = { "/deleteCustAddress" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteCustAddress(@RequestParam("custAddressId") int custAddressId,
			@RequestParam("status") int status) {

		Info info = new Info();

		int res = customerAddressRepo.deleteCustAddress(custAddressId, status);
		if (res > 0) {
			info.setError(false);
			info.setMessage("Success");
		} else {
			info.setError(true);
			info.setMessage("Failed");
		}

		return info;
	}

	@RequestMapping(value = { "/getAllItemConfigListByComp" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemConfigDisplay> getAllItemConfigListByComp(@RequestParam("compId") int compId) {

		List<ItemConfigDisplay> res = null;

		res = itemConfigDisplayRepo.getAllConfigByComp(compId);

		if (res == null) {
			res = new ArrayList<ItemConfigDisplay>();
		}
		return res;
	}

	@RequestMapping(value = { "/getFranchiseById" }, method = RequestMethod.POST)
	public @ResponseBody Franchisee getFranchiseById(@RequestParam("frId") int frId) {

		Franchisee franchisee = new Franchisee();

		franchisee = franchiseeRepository.findByFrId(frId);

		if (franchisee == null) {
			franchisee = new Franchisee();
		}

		return franchisee;
	}

	// ACCEPT AND PROCESS ORDER-------------------
	@RequestMapping(value = { "/acceptAndProcessOrderOPS" }, method = RequestMethod.POST)
	public @ResponseBody Info acceptAndProcessOrderOPS(@RequestParam("orderId") int orderId,
			@RequestParam("status") int status, @RequestParam("userId") int userId,
			@RequestParam("remark") String remark, @RequestParam("type") int type) {

		Info info = new Info();

		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dt = new Date();

			System.err.println("Status = " + status + " ORder id = " + orderId);
			int update = orderHeaderRepository.updateStatus(status, orderId);
			System.err.println("update res = " + update);
			if (update > 0) {

				OrderTrail orderTrail1 = new OrderTrail();
				orderTrail1.setOrderId(orderId);
				orderTrail1.setActionByUserId(userId);
				orderTrail1.setActionDateTime(sf.format(dt));
				orderTrail1.setStatus(2);
				orderTrail1.setExVar1(remark);
				orderTrail1.setExInt1(type);
				OrderTrail orderRes1 = orderTrailRepository.save(orderTrail1);

				OrderTrail orderTrail2 = new OrderTrail();
				orderTrail2.setOrderId(orderId);
				orderTrail2.setActionByUserId(userId);
				orderTrail2.setActionDateTime(sf.format(dt));
				orderTrail2.setStatus(status);
				orderTrail2.setExVar1(remark);
				orderTrail2.setExInt1(type);
				OrderTrail orderRes2 = orderTrailRepository.save(orderTrail2);

				info.setError(false);
				info.setMessage("updated");

				try {

					NewSetting val = newSettingRepo.findBySettingKeyAndDelStatus("msg_process_order", 0);

					Customer cust = customerRepo.getCustomerByOrderId(orderId);

					SMSUtility.sendSMS(cust.getPhoneNumber(), val.getSettingValue1(),"MDVDRY");

				} catch (Exception e) {
				}

			} else {
				info.setError(true);
			}

		} catch (Exception e) {
			info.setError(true);
			e.printStackTrace();
		}
		return info;
	}

	// -----------UPDATE DELIVERY BOY----------------
	@RequestMapping(value = { "/updateDeliveryBoy" }, method = RequestMethod.POST)
	public @ResponseBody Info updateDeliveryBoy(@RequestParam("orderId") int orderId,
			@RequestParam("delBoyId") int delBoyId) {

		Info info = new Info();
		try {

			int res = orderHeaderRepository.updateDeliveryBoy(orderId, delBoyId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("Failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
			info.setError(true);
			info.setMessage("Failed");
		}
		return info;
	}

	@RequestMapping(value = { "/getAllRemarksByType" }, method = RequestMethod.POST)
	public @ResponseBody List<OrderRemark> getAllRemarksByType(@RequestParam("type") int type) {

		List<OrderRemark> res = null;

		res = orderRemarkRepo.findAllByRkTypeAndDelStatus(type, 0);

		if (res == null) {
			res = new ArrayList<OrderRemark>();
		}
		return res;
	}

	@RequestMapping(value = { "/getNewSettingsValueByKey" }, method = RequestMethod.POST)
	public @ResponseBody NewSetting getNewSettingsValueByKey(@RequestParam("orderId") int orderId,
			@RequestParam("key") String key) {

		NewSetting settings = new NewSetting();
		try {

			settings = newSettingRepo.findBySettingKeyAndDelStatus(key, 0);
			Customer cust = customerRepo.getCustomerByOrderId(orderId);
			settings.setSettingValue2(cust.getPhoneNumber());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return settings;
	}

	@RequestMapping(value = { "/getSettingsListForUpdate" }, method = RequestMethod.GET)
	public @ResponseBody List<SettingsUpdateModel> getSettingsListForUpdate() {

		List<SettingsUpdateModel> res = null;

		res = settingsUpdateModelRepo.settingsList();

		if (res == null) {
			res = new ArrayList<SettingsUpdateModel>();
		}
		return res;
	}

	@RequestMapping(value = { "/updateSettingsValById" }, method = RequestMethod.POST)
	public @ResponseBody Info updateSettingsValById(@RequestParam("settingId") int settingId,
			@RequestParam("val") String val) {

		Info info = new Info();
		try {

			int res = newSettingRepo.updateSettingsValueById(settingId, val);
			if (res > 0) {
				info.setError(false);
			} else {
				info.setError(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			info.setError(true);
		}
		return info;
	}
	
	
	//Product Ratings
	@RequestMapping(value = { "/saveProdRatings" }, method = RequestMethod.POST)
	public @ResponseBody ProdRatings saveProdRatings(@RequestBody ProdRatings ProdRatings) {

		ProdRatings res = new ProdRatings();
		try {

			res = prodRatingsRepo.saveAndFlush(ProdRatings);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	

}
