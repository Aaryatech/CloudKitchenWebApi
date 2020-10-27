package com.ats.ckweb.apicontrollers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ats.ckweb.model.Agent;
import com.ats.ckweb.model.Area;
import com.ats.ckweb.model.AreaData;
import com.ats.ckweb.model.CategoryData;
import com.ats.ckweb.model.CityData;
import com.ats.ckweb.model.CkDeliveryCharges;
import com.ats.ckweb.model.CustWalletTotal;
import com.ats.ckweb.model.FrCharges;
import com.ats.ckweb.model.FrItemStock;
import com.ats.ckweb.model.FranchiseData;
import com.ats.ckweb.model.Franchisee;
import com.ats.ckweb.model.GetAllDataByFr;
import com.ats.ckweb.model.GetCategoryData;
import com.ats.ckweb.model.GetFranchiseData;
import com.ats.ckweb.model.GetRelatedItemsAndFreqOrderList;
import com.ats.ckweb.model.GetSubCategoryData;
import com.ats.ckweb.model.Images;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.Ingrediant;
import com.ats.ckweb.model.ItemDisplay;
import com.ats.ckweb.model.ItemWiseOfferData;
import com.ats.ckweb.model.ItemWiseOfferDetailDisplay;
import com.ats.ckweb.model.ItemWiseOfferHeaderDisplay;
import com.ats.ckweb.model.NewSetting;
import com.ats.ckweb.model.OfferDetail;
import com.ats.ckweb.model.OfferHeader;
import com.ats.ckweb.model.OrderCheckoutData;
import com.ats.ckweb.model.PostFrItemStockHeader;
import com.ats.ckweb.model.Setting;
import com.ats.ckweb.model.SubCategoryData;
import com.ats.ckweb.model.Tags;
import com.ats.ckweb.report.repo.WalletRepo;
import com.ats.ckweb.repository.AgentRepo;
import com.ats.ckweb.repository.AreaDataRepo;
import com.ats.ckweb.repository.CategoryDataRepo;
import com.ats.ckweb.repository.CityDataRepo;
import com.ats.ckweb.repository.CkDeliveryChargesRepo;
import com.ats.ckweb.repository.CustWalletTotalRepo;
import com.ats.ckweb.repository.FrChargesRepo;
import com.ats.ckweb.repository.FrItemStockRepo;
import com.ats.ckweb.repository.FranchiseDataRepo;
import com.ats.ckweb.repository.FranchiseeRepository;
import com.ats.ckweb.repository.ImagesRepo;
import com.ats.ckweb.repository.IngrediantRepo;
import com.ats.ckweb.repository.ItemDisplayRepo;
import com.ats.ckweb.repository.ItemWiseOfferDataRepo;
import com.ats.ckweb.repository.NewSettingRepo;
import com.ats.ckweb.repository.OfferDetailRepo;
import com.ats.ckweb.repository.OfferHeaderRepo;
import com.ats.ckweb.repository.PostFrItemStockHeaderRepo;
import com.ats.ckweb.repository.SettingRepository;
import com.ats.ckweb.repository.SubCategoryDataRepo;
import com.ats.ckweb.repository.TagRepo;
import com.ats.ckweb.services.ImagesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ats.ckweb.repository.AreaRepo;

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

	@Autowired
	AreaRepo areaRepo;

	@Autowired
	ImagesRepo imagesRepo;

	@Autowired
	OfferHeaderRepo offerHeaderRepo;

	@Autowired
	TagRepo tagRepo;

	@Autowired
	ItemDisplayRepo itemDisplayRepo;

	@Autowired
	IngrediantRepo ingrediantRepo;

	@Autowired
	ItemWiseOfferDataRepo itemWiseOfferDataRepo;

	@Autowired
	FrItemStockRepo frItemStockRepo;

	@Autowired
	PostFrItemStockHeaderRepo postFrItemStockHeaderRepo;

	@Autowired
	FranchiseeRepository franchiseeRepository;

	@Autowired
	SettingRepository settingRepository;

	@Autowired
	WalletRepo walletRepo;

	@Autowired
	NewSettingRepo newSettingRepo;

	@Autowired
	CustWalletTotalRepo custWalletTotalRepo;

	@Autowired
	CkDeliveryChargesRepo ckDeliveryChargesRepo;

	@Autowired
	FrChargesRepo frChargesRepo;

	@Autowired
	OfferDetailRepo offerDetailRepo;

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

	@RequestMapping(value = { "/getShopByCityId" }, method = RequestMethod.POST)
	public @ResponseBody GetFranchiseData getShopByCityId(@RequestParam("cityId") int cityId) {

		GetFranchiseData res = new GetFranchiseData();

		try {

			List<FranchiseData> frData = null;

			frData = franchiseDataRepo.getShopByCityId(cityId);

			Info info = new Info();

			if (frData == null) {
				frData = new ArrayList<FranchiseData>();

				info.setError(true);
				info.setMessage("Failed");
			} else {

				info.setError(false);
				info.setMessage("Success");
			}

			res.setFranchise(frData);
			res.setInfo(info);
		} catch (Exception e) {

		}

		return res;
	}

	@Autowired
	AgentRepo agentRepo;

	@RequestMapping(value = { "/getAgetListByShopId" }, method = RequestMethod.POST)
	public @ResponseBody List<Agent> getAgetListByShopId(@RequestParam("cityId") int cityId,
			@RequestParam("shopId") int shopId) {

		List<Agent> list = new ArrayList<>();

		try {

			list = agentRepo.getAgetListByShopId(cityId, shopId);

		} catch (Exception e) {

		}

		return list;
	}

	@RequestMapping(value = { "/getFranchiseByFrId" }, method = RequestMethod.POST)
	public @ResponseBody FranchiseData getFranchiseByFrId(@RequestParam("frId") int frId) {

		FranchiseData frData = null;

		frData = franchiseDataRepo.getFranchiseById(frId);

		if (frData == null) {
			frData = new FranchiseData();
		} else {

			/*
			 * List<CityData> cityList = cityDataRepo.getAllCityByFr(frData.getFrId()); if
			 * (cityList == null) { cityList = new ArrayList<>(); }
			 * frData.setCityList(cityList);
			 * 
			 * List<AreaData> areaList = areaDataRepo.getAllAreasByFr(frData.getFrId()); if
			 * (areaList == null) { areaList = new ArrayList<>(); }
			 * frData.setAreaList(areaList);
			 */
		}

		return frData;
	}

	// Author-Anmol Shirke Created On-20-07-2020
	// Desc- Returns Category list with images
	@RequestMapping(value = { "/getCategoryListByFr" }, method = RequestMethod.POST)
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
	@RequestMapping(value = { "/getSubCategoryListByFr" }, method = RequestMethod.POST)
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

	@RequestMapping(value = { "/getAreaListByCity" }, method = RequestMethod.POST)
	public @ResponseBody List<Area> getAreaListByCity(@RequestParam("cityId") int cityId) {

		List<Area> arealist = new ArrayList<>();

		try {
			arealist = areaRepo.getarealistbycityid(cityId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arealist;
	}

	// ---------ALL DATA BY FR-----------
	@RequestMapping(value = { "/getAllDataByFr" }, method = RequestMethod.POST)
	public @ResponseBody GetAllDataByFr getAllDataByFr(@RequestParam("frId") int frId, @RequestParam("type") int type,
			@RequestParam("applicableFor") int applicableFor, @RequestParam("compId") int compId) {

		GetAllDataByFr res = new GetAllDataByFr();

		Info info = new Info();

		List<CategoryData> catData = null;
		List<SubCategoryData> subCatData = null;
		List<OfferHeader> offerData = null;
		List<Tags> tagsData = null;
		List<ItemDisplay> itemData = null;

		try {
			List<Images> imgList = imagesRepo.findAllByDelStatus(0);
			List<Tags> allTagList = tagRepo.findByTagDeleteStatusAndExInt1OrderByTagIdDesc(0, compId);
			List<Ingrediant> allTasteList = ingrediantRepo.findByDelStatusOrderByIngrediantIdDesc(0);

			List<ItemWiseOfferHeaderDisplay> offerDisplayList = new ArrayList<>();

			List<ItemWiseOfferData> allOfferList = itemWiseOfferDataRepo.getAllOffersByFr(frId, type, applicableFor);
			if (allOfferList != null) {
				Set<Integer> offerSet = new HashSet<Integer>();
				for (ItemWiseOfferData data : allOfferList) {
					offerSet.add(data.getOfferId());
				}

				List<Integer> offerIdList = new ArrayList<>();
				offerIdList.addAll(offerSet);

				Collections.sort(offerIdList);

				for (int i = 0; i < offerIdList.size(); i++) {
					for (int j = 0; j < allOfferList.size(); j++) {
						if (offerIdList.get(i) == allOfferList.get(j).getOfferId()) {

							ItemWiseOfferHeaderDisplay header = new ItemWiseOfferHeaderDisplay(
									allOfferList.get(j).getOfferId(), allOfferList.get(j).getOfferName(),
									allOfferList.get(j).getOfferDesc(), allOfferList.get(j).getType(),
									allOfferList.get(j).getApplicableFor(), allOfferList.get(j).getOfferType(),
									allOfferList.get(j).getOfferSubType(), allOfferList.get(j).getFrequencyType(),
									allOfferList.get(j).getFrequency(), allOfferList.get(j).getFromDate(),
									allOfferList.get(j).getToDate(), allOfferList.get(j).getFromTime(),
									allOfferList.get(j).getToTime(), allOfferList.get(j).getPrimaryItemId(),
									allOfferList.get(j).getPrimaryItemName(), allOfferList.get(j).getPrimaryQty(),
									allOfferList.get(j).getDiscPer());

							offerDisplayList.add(header);

							break;

						}
					}
				}

				for (int i = 0; i < offerDisplayList.size(); i++) {

					List<ItemWiseOfferDetailDisplay> detailList = new ArrayList<>();

					for (int j = 0; j < allOfferList.size(); j++) {
						ItemWiseOfferDetailDisplay detail = new ItemWiseOfferDetailDisplay(
								allOfferList.get(j).getOfferDetailId(), allOfferList.get(j).getPrimaryItemId(),
								allOfferList.get(j).getSecondaryItemId(), allOfferList.get(j).getSecondaryQty(),
								allOfferList.get(j).getSecondaryItemName());

						detailList.add(detail);

					}
					offerDisplayList.get(i).setOfferDetailList(detailList);
				}

			}

			// -------CATEGORY LIST---------------
			catData = categoryDataRepo.getCategoriesByFrAndType(frId, type);

			if (catData == null) {
				catData = new ArrayList<CategoryData>();
			} else {

				for (int i = 0; i < catData.size(); i++) {

					List<Images> catImgList = new ArrayList<>();

					if (imgList != null) {
						for (Images image : imgList) {
							if (image.getDocId() == catData.get(i).getCatId() && image.getDocType() == 1) {
								catImgList.add(image);
							}
						}
					}
					catData.get(i).setImageList(catImgList);
				}
			}
			res.setCategoryData(catData);

			// --------SUB CATEGORY LIST-------------
			subCatData = subCategoryDataRepo.getSubCategoriesByFrAndType(frId, type);

			if (subCatData == null) {
				subCatData = new ArrayList<SubCategoryData>();
			} else {

				for (int i = 0; i < subCatData.size(); i++) {

					List<Images> subCatImgList = new ArrayList<>();

					if (imgList != null) {
						for (Images image : imgList) {
							if (image.getDocId() == subCatData.get(i).getSubCatId() && image.getDocType() == 2) {
								subCatImgList.add(image);
							}
						}
					}
					subCatData.get(i).setImageList(subCatImgList);

				}
			}
			res.setSubCategoryData(subCatData);

			// ---------OFFER DATA--------------
			offerData = offerHeaderRepo.getOfferHeaderByFr(frId, type, applicableFor);

			if (offerData == null) {
				offerData = new ArrayList<OfferHeader>();
			} else {

				for (int i = 0; i < offerData.size(); i++) {

					List<Images> offerImgList = new ArrayList<>();

					if (imgList != null) {
						for (Images image : imgList) {
							if (image.getDocId() == offerData.get(i).getOfferId() && image.getDocType() == 4) {
								offerImgList.add(image);
							}
						}
					}
					offerData.get(i).setImageList(offerImgList);

				}
			}
			res.setOfferData(offerData);

			// ------------Tag DATA--------------------
			tagsData = tagRepo.getTagListByFr(frId, type);

			if (tagsData == null) {
				tagsData = new ArrayList<Tags>();
			}
			res.setTagsData(tagsData);

			// ------------ITEM DATA----------------

			Franchisee fr = franchiseeRepository.findByFrId(frId);

//			boolean isMonthCloseApplicable = false;
//			String fromDate = "", toDate = "";
//			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			DateFormat yearFormat = new SimpleDateFormat("yyyy");
//
//			List<PostFrItemStockHeader> list = postFrItemStockHeaderRepo.findByFrIdAndIsMonthClosed(frId, 0);
//
//			int month = 0;
//
//			for (PostFrItemStockHeader header : list) {
//				month = header.getMonth();
//			}
//
//			Date todaysDate = new Date();
//
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(todaysDate);
//
//			cal.set(Calendar.DAY_OF_MONTH, 1);
//
//			Date firstDay = cal.getTime();
//
//			DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
//			Date date = new Date();
//			System.out.println(dateFormat1.format(date));
//
//			Calendar cal1 = Calendar.getInstance();
//			cal1.setTime(date);
//
//			int dayOfMonth = cal1.get(Calendar.DATE);
//
//			int calCurrentMonth = cal1.get(Calendar.MONTH) + 1;
//
//			if (month < calCurrentMonth) {
//
//				isMonthCloseApplicable = true;
//
//			} else if (month == 12 && calCurrentMonth == 1) {
//				isMonthCloseApplicable = true;
//			}
//
//			if (isMonthCloseApplicable) {
//				String strDate;
//				int year;
//				if (month == 12) {
//					year = (Calendar.getInstance().getWeekYear() - 1);
//				} else {
//					year = Calendar.getInstance().getWeekYear();
//				}
//
//				if (month < 10) {
//					strDate = year + "-0" + month + "-01";
//				} else {
//					strDate = year + "-" + month + "-01";
//				}
//				fromDate = strDate;
//
//			} else {
//				fromDate = dateFormat.format(firstDay);
//			}
//
//			int stockType = 1;
//			if (fr != null) {
//				stockType = fr.getStockType();
//			}
//
//			int year = Integer.parseInt(yearFormat.format(todaysDate));

			// List<FrItemStock> frStock = frItemStockRepo.getFrCurrStock(frId, fromDate,
			// toDate, month, year, stockType, type);

			List<ItemDisplay> tempItemData = itemDisplayRepo.getAllItemByFr(frId, type, applicableFor);
			itemData = tempItemData;

//			if (tempItemData != null) {
//				if (frStock != null) {
//					
//					itemData=new ArrayList<ItemDisplay>();
//
//					for (ItemDisplay item : tempItemData) {
//						for (FrItemStock stock : frStock) {
//							if (item.getItemId() == stock.getId()) {
//								if (stock.getCurrentStock() > stock.getReorder()) {
//									item.setIsAvailable(0);
//									//itemData.add(item);
//									
//								} else {
//									item.setIsAvailable(1);
//								}
//								break;
//							}
//						}
//					}
//
//					itemData = tempItemData;
//
//				}
//			}

			if (itemData == null) {
				itemData = new ArrayList<ItemDisplay>();
			} else {

				for (int i = 0; i < itemData.size(); i++) {

					// ----------ITEM IMAGES------------
					List<Images> itemImgList = new ArrayList<>();

					if (imgList != null) {
						for (Images image : imgList) {
							if (image.getDocId() == itemData.get(i).getItemId() && image.getDocType() == 3) {
								itemImgList.add(image);
							}
						}
					}
					itemData.get(i).setImageList(itemImgList);

					// -----------RELATED PRODUCTS---------------
					List<ItemDisplay> relItemData = new ArrayList<>();
					List<Integer> relItemIdsList = new ArrayList<>();
					try {
						relItemIdsList = Stream.of(itemData.get(i).getRelItemIds().split(",")).map(Integer::parseInt)
								.collect(Collectors.toList());
					} catch (Exception e) {
					}

					for (int t = 0; t < itemData.size(); t++) {
						if (relItemIdsList.contains(itemData.get(t).getItemId())) {

							ItemDisplay relItem = new ItemDisplay(itemData.get(t).getItemId(),
									itemData.get(t).getItemName(), itemData.get(t).getCatId(),
									itemData.get(t).getCatName(), itemData.get(t).getSubCatId(),
									itemData.get(t).getSubCatName(), itemData.get(t).getItemSortId(),
									itemData.get(t).getIsDecimal(), itemData.get(t).getItemUom(),
									itemData.get(t).getUomId(), itemData.get(t).getItemDesc(),
									itemData.get(t).getProductType(), itemData.get(t).getProductStatus(),
									itemData.get(t).getProductCategory(), itemData.get(t).getProductCategoryName(),
									itemData.get(t).getPreperationTime(), itemData.get(t).getShowInOrder(),
									itemData.get(t).getRating(), itemData.get(t).getTagIds(),
									itemData.get(t).getTasteTypeIds(), itemData.get(t).getTagName(),
									itemData.get(t).getTasteName(), itemData.get(t).getRateAmt(),
									itemData.get(t).getMrpAmt(), itemData.get(t).getSpRateAmt(),
									itemData.get(t).getCgstPer(), itemData.get(t).getSgstPer(),
									itemData.get(t).getIgstPer(), itemData.get(t).getHsncd(),
									itemData.get(t).getRelItemIds(), itemData.get(t).getDiscPer(),
									itemData.get(t).getMrpDiscAmt(), itemData.get(t).getSpDiscAmt(),
									itemData.get(t).getOfferIds(), itemData.get(t).getFreqOrderedQty(),
									itemData.get(t).getIsAvailable());

							// ----Related Item Images-----
							List<Images> relItemImgList = new ArrayList<>();

							if (imgList != null) {
								for (Images image : imgList) {
									if (image.getDocId() == relItem.getItemId() && image.getDocType() == 3) {
										relItemImgList.add(image);
									}
								}
							}
							relItem.setImageList(relItemImgList);

							relItemData.add(relItem);
						}
					}
					itemData.get(i).setRelItemList(relItemData);

					// ----------ITEM TAGS------------
					List<Tags> tagList = new ArrayList<>();

					if (allTagList != null) {

						List<Integer> tagIdsList = new ArrayList<>();
						try {
							tagIdsList = Stream.of(itemData.get(i).getTagIds().split(",")).map(Integer::parseInt)
									.collect(Collectors.toList());
						} catch (Exception e) {
						}

						for (int t = 0; t < allTagList.size(); t++) {
							if (tagIdsList.contains(allTagList.get(t).getTagId())) {
								tagList.add(allTagList.get(t));
							}
						}

					}
					itemData.get(i).setTagList(tagList);

					// ----------ITEM TASTES------------
					List<Ingrediant> taseList = new ArrayList<>();

					if (allTasteList != null) {

						List<Integer> tasteIdsList = new ArrayList<>();
						try {
							tasteIdsList = Stream.of(itemData.get(i).getTasteTypeIds().split(","))
									.map(Integer::parseInt).collect(Collectors.toList());
						} catch (Exception e) {
						}

						for (int t = 0; t < allTasteList.size(); t++) {
							if (tasteIdsList.contains(allTasteList.get(t).getIngrediantId())) {
								taseList.add(allTasteList.get(t));
							}
						}

					}
					itemData.get(i).setTasteList(taseList);

					// ------------JSON STRING------------------------------
					ObjectMapper Obj = new ObjectMapper();

					try {
						String jsonStr = Obj.writeValueAsString(itemData.get(i));
						itemData.get(i).setJsonStr(jsonStr);
					} catch (IOException e) {
					}

					// --------------------OFFER LIST--------------------------

					List<ItemWiseOfferHeaderDisplay> itemOfferList = new ArrayList<>();

					if (offerDisplayList != null) {
						List<Integer> offerIdsList = new ArrayList<>();
						try {
							offerIdsList = Stream.of(itemData.get(i).getOfferIds().split(",")).map(Integer::parseInt)
									.collect(Collectors.toList());
						} catch (Exception e) {
						}

						for (int t = 0; t < offerDisplayList.size(); t++) {
							if (offerIdsList.contains(offerDisplayList.get(t).getOfferId())) {
								itemOfferList.add(offerDisplayList.get(t));
							}
						}
					}
					itemData.get(i).setOfferList(itemOfferList);

				}
			}
			res.setItemData(itemData);

			try {

				if (subCatData != null) {
					if (subCatData.size() > 0) {
						for (int i = 0; i < subCatData.size(); i++) {

							int count = 0;

							if (itemData != null) {
								if (itemData.size() > 0) {

									for (int j = 0; j < itemData.size(); j++) {

										if (subCatData.get(i).getSubCatId() == itemData.get(j).getSubCatId()) {
											count = count + 1;
										}

									}

								}
							}

							subCatData.get(i).setProdCount(count);

						}

						res.setSubCategoryData(subCatData);
					}
				}

			} catch (Exception e) {
			}

			info.setError(false);
			info.setMessage("Success");

			res.setInfo(info);

		} catch (Exception e) {
			e.printStackTrace();
			info.setError(true);
			info.setMessage("Failed");
		}

		res.setInfo(info);

		publishData(res, frId);

		return res;
	}

	@RequestMapping(value = { "/getAllItemListByFr" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemDisplay> getAllItemListByFr(@RequestParam("frId") int frId,
			@RequestParam("type") int type, @RequestParam("applicableFor") int applicableFor) {

		List<ItemDisplay> itemData = null;

		try {

			Franchisee fr = franchiseeRepository.findByFrId(frId);

			boolean isMonthCloseApplicable = false;
			String fromDate = "", toDate = "";
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat yearFormat = new SimpleDateFormat("yyyy");

			List<PostFrItemStockHeader> list = postFrItemStockHeaderRepo.findByFrIdAndIsMonthClosed(frId, 0);

			int month = 0;

			for (PostFrItemStockHeader header : list) {
				month = header.getMonth();
				break;
			}

			Date todaysDate = new Date();

			Calendar cal = Calendar.getInstance();
			cal.setTime(todaysDate);

			cal.set(Calendar.DAY_OF_MONTH, 1);

			Date firstDay = cal.getTime();

			DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			System.out.println(dateFormat1.format(date));

			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(date);

			int dayOfMonth = cal1.get(Calendar.DATE);

			int calCurrentMonth = cal1.get(Calendar.MONTH) + 1;

			if (month < calCurrentMonth) {

				isMonthCloseApplicable = true;
				System.out.println("Day Of Month End ......");

			} else if (month == 12 && calCurrentMonth == 1) {
				isMonthCloseApplicable = true;
			}

			if (isMonthCloseApplicable) {
				System.err.println("Inside iMonthclose app");
				String strDate;
				int year;
				if (month == 12) {
					System.err.println("running month =12");
					year = (Calendar.getInstance().getWeekYear() - 1);
					System.err.println("year value " + year);
				} else {
					System.err.println("running month not eq 12");
					year = Calendar.getInstance().getWeekYear();
					System.err.println("year value " + year);
				}

				if (month < 10) {
					strDate = year + "-0" + month + "-01";
				} else {
					strDate = year + "-" + month + "-01";
				}
				fromDate = strDate;

			} else {
				fromDate = dateFormat.format(firstDay);
			}

			int stockType = 1;
			if (fr != null) {
				stockType = fr.getStockType();
			}

			int year = Integer.parseInt(yearFormat.format(todaysDate));

			List<FrItemStock> frStock = frItemStockRepo.getFrCurrStock(frId, fromDate, toDate, month, year, stockType,
					type);

			System.err.println("FR STOCk = " + frStock);

			List<ItemDisplay> tempItemData = itemDisplayRepo.getAllItemByFr(frId, type, applicableFor);

			if (tempItemData != null) {
				if (frStock != null) {

					for (ItemDisplay item : tempItemData) {
						for (FrItemStock stock : frStock) {
							if (item.getItemId() == stock.getId()) {
								if (stock.getCurrentStock() > stock.getReorder()) {
									item.setIsAvailable(0);
								} else {
									item.setIsAvailable(1);
								}
								break;
							}
						}
					}

					itemData = tempItemData;

				}
			}

			if (itemData == null) {
				itemData = new ArrayList<>();
			}

		} catch (Exception e) {
			System.err.println("EXCEPTION IN getAllItemListByFr -> " + e.getMessage());
			e.printStackTrace();
		}

		return itemData;
	}

	@RequestMapping(value = { "/getFrequentlyOrderedItemListByCust" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemDisplay> getFrequentlyOrderedItemListByCust(@RequestParam("frId") int frId,
			@RequestParam("type") int type, @RequestParam("applicableFor") int applicableFor,
			@RequestParam("custId") int custId) {

		List<ItemDisplay> itemData = null;

		try {

			List<Images> imgList = imagesRepo.findAllByDelStatus(0);
			List<Ingrediant> allTasteList = ingrediantRepo.findByDelStatusOrderByIngrediantIdDesc(0);

			// ------------ALL OFFER--------------------
			List<ItemWiseOfferHeaderDisplay> offerDisplayList = new ArrayList<>();

			List<ItemWiseOfferData> allOfferList = itemWiseOfferDataRepo.getAllOffersByFr(frId, type, applicableFor);
			if (allOfferList != null) {
				Set<Integer> offerSet = new HashSet<Integer>();
				for (ItemWiseOfferData data : allOfferList) {
					offerSet.add(data.getOfferId());
				}

				List<Integer> offerIdList = new ArrayList<>();
				offerIdList.addAll(offerSet);

				Collections.sort(offerIdList);

				for (int i = 0; i < offerIdList.size(); i++) {
					for (int j = 0; j < allOfferList.size(); j++) {
						if (offerIdList.get(i) == allOfferList.get(j).getOfferId()) {

							ItemWiseOfferHeaderDisplay header = new ItemWiseOfferHeaderDisplay(
									allOfferList.get(j).getOfferId(), allOfferList.get(j).getOfferName(),
									allOfferList.get(j).getOfferDesc(), allOfferList.get(j).getType(),
									allOfferList.get(j).getApplicableFor(), allOfferList.get(j).getOfferType(),
									allOfferList.get(j).getOfferSubType(), allOfferList.get(j).getFrequencyType(),
									allOfferList.get(j).getFrequency(), allOfferList.get(j).getFromDate(),
									allOfferList.get(j).getToDate(), allOfferList.get(j).getFromTime(),
									allOfferList.get(j).getToTime(), allOfferList.get(j).getPrimaryItemId(),
									allOfferList.get(j).getPrimaryItemName(), allOfferList.get(j).getPrimaryQty(),
									allOfferList.get(j).getDiscPer());

							offerDisplayList.add(header);

							break;

						}
					}
				}

				for (int i = 0; i < offerDisplayList.size(); i++) {

					List<ItemWiseOfferDetailDisplay> detailList = new ArrayList<>();

					for (int j = 0; j < allOfferList.size(); j++) {
						ItemWiseOfferDetailDisplay detail = new ItemWiseOfferDetailDisplay(
								allOfferList.get(j).getOfferDetailId(), allOfferList.get(j).getPrimaryItemId(),
								allOfferList.get(j).getSecondaryItemId(), allOfferList.get(j).getSecondaryQty(),
								allOfferList.get(j).getSecondaryItemName());

						detailList.add(detail);

					}
					offerDisplayList.get(i).setOfferDetailList(detailList);
				}

			}

			Franchisee fr = franchiseeRepository.findByFrId(frId);

			boolean isMonthCloseApplicable = false;
			String fromDate = "", toDate = "";
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat yearFormat = new SimpleDateFormat("yyyy");

			List<PostFrItemStockHeader> list = postFrItemStockHeaderRepo.findByFrIdAndIsMonthClosed(frId, 0);

			int month = 0;

			for (PostFrItemStockHeader header : list) {
				month = header.getMonth();
				break;
			}

			Date todaysDate = new Date();

			Calendar cal = Calendar.getInstance();
			cal.setTime(todaysDate);

			cal.set(Calendar.DAY_OF_MONTH, 1);

			Date firstDay = cal.getTime();

			DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			System.out.println(dateFormat1.format(date));

			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(date);

			int dayOfMonth = cal1.get(Calendar.DATE);

			int calCurrentMonth = cal1.get(Calendar.MONTH) + 1;

			if (month < calCurrentMonth) {

				isMonthCloseApplicable = true;
				System.out.println("Day Of Month End ......");

			} else if (month == 12 && calCurrentMonth == 1) {
				isMonthCloseApplicable = true;
			}

			if (isMonthCloseApplicable) {
				System.err.println("Inside iMonthclose app");
				String strDate;
				int year;
				if (month == 12) {
					System.err.println("running month =12");
					year = (Calendar.getInstance().getWeekYear() - 1);
					System.err.println("year value " + year);
				} else {
					System.err.println("running month not eq 12");
					year = Calendar.getInstance().getWeekYear();
					System.err.println("year value " + year);
				}

				if (month < 10) {
					strDate = year + "-0" + month + "-01";
				} else {
					strDate = year + "-" + month + "-01";
				}
				fromDate = strDate;

			} else {
				fromDate = dateFormat.format(firstDay);
			}

			int stockType = 1;
			if (fr != null) {
				stockType = fr.getStockType();
			}

			int year = Integer.parseInt(yearFormat.format(todaysDate));

			List<FrItemStock> frStock = frItemStockRepo.getFrCurrStock(frId, fromDate, toDate, month, year, stockType,
					type);

			System.err.println("FR STOCk = " + frStock);

			List<ItemDisplay> tempItemData = itemDisplayRepo.getFrequentlyOrderedItemListByCust(frId, type,
					applicableFor, custId);

			if (tempItemData != null) {
				if (frStock != null) {

					for (ItemDisplay item : tempItemData) {
						for (FrItemStock stock : frStock) {
							if (item.getItemId() == stock.getId()) {
								if (stock.getCurrentStock() > stock.getReorder()) {
									item.setIsAvailable(0);
								} else {
									item.setIsAvailable(1);
								}
								break;
							}
						}
					}

					itemData = tempItemData;

				}
			}

			if (itemData == null) {
				itemData = new ArrayList<ItemDisplay>();
			} else {

				for (int i = 0; i < itemData.size(); i++) {

					// ----------ITEM IMAGES------------
					List<Images> itemImgList = new ArrayList<>();

					if (imgList != null) {
						for (Images image : imgList) {
							if (image.getDocId() == itemData.get(i).getItemId() && image.getDocType() == 3) {
								itemImgList.add(image);
							}
						}
					}
					itemData.get(i).setImageList(itemImgList);

					// ----------ITEM TASTES------------
					List<Ingrediant> taseList = new ArrayList<>();

					if (allTasteList != null) {

						List<Integer> tasteIdsList = new ArrayList<>();
						try {
							tasteIdsList = Stream.of(itemData.get(i).getTasteTypeIds().split(","))
									.map(Integer::parseInt).collect(Collectors.toList());
						} catch (Exception e) {
						}

						for (int t = 0; t < allTasteList.size(); t++) {
							if (tasteIdsList.contains(allTasteList.get(t).getIngrediantId())) {
								taseList.add(allTasteList.get(t));
							}
						}

					}
					itemData.get(i).setTasteList(taseList);

					// --------------------OFFER LIST--------------------------

					List<ItemWiseOfferHeaderDisplay> itemOfferList = new ArrayList<>();

					if (offerDisplayList != null) {
						List<Integer> offerIdsList = new ArrayList<>();
						try {
							offerIdsList = Stream.of(itemData.get(i).getOfferIds().split(",")).map(Integer::parseInt)
									.collect(Collectors.toList());
						} catch (Exception e) {
						}

						for (int t = 0; t < offerDisplayList.size(); t++) {
							if (offerIdsList.contains(offerDisplayList.get(t).getOfferId())) {
								itemOfferList.add(offerDisplayList.get(t));
							}
						}
					}
					itemData.get(i).setOfferList(itemOfferList);

				}
			}

		} catch (Exception e) {
			System.err.println("EXCEPTION IN getAllItemListByFr -> " + e.getMessage());
			e.printStackTrace();
		}

		return itemData;
	}

	@RequestMapping(value = { "/getRelatedItemListByItemIds" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemDisplay> getRelatedItemListByItemIds(@RequestParam("frId") int frId,
			@RequestParam("type") int type, @RequestParam("applicableFor") int applicableFor,
			@RequestParam("itemIds") List<Integer> itemIds) {

		List<ItemDisplay> itemData = null;

		try {

			List<Images> imgList = imagesRepo.findAllByDelStatus(0);
			List<Ingrediant> allTasteList = ingrediantRepo.findByDelStatusOrderByIngrediantIdDesc(0);

			// ------------ALL OFFER--------------------
			List<ItemWiseOfferHeaderDisplay> offerDisplayList = new ArrayList<>();

			List<ItemWiseOfferData> allOfferList = itemWiseOfferDataRepo.getAllOffersByFr(frId, type, applicableFor);
			if (allOfferList != null) {
				Set<Integer> offerSet = new HashSet<Integer>();
				for (ItemWiseOfferData data : allOfferList) {
					offerSet.add(data.getOfferId());
				}

				List<Integer> offerIdList = new ArrayList<>();
				offerIdList.addAll(offerSet);

				Collections.sort(offerIdList);

				for (int i = 0; i < offerIdList.size(); i++) {
					for (int j = 0; j < allOfferList.size(); j++) {
						if (offerIdList.get(i) == allOfferList.get(j).getOfferId()) {

							ItemWiseOfferHeaderDisplay header = new ItemWiseOfferHeaderDisplay(
									allOfferList.get(j).getOfferId(), allOfferList.get(j).getOfferName(),
									allOfferList.get(j).getOfferDesc(), allOfferList.get(j).getType(),
									allOfferList.get(j).getApplicableFor(), allOfferList.get(j).getOfferType(),
									allOfferList.get(j).getOfferSubType(), allOfferList.get(j).getFrequencyType(),
									allOfferList.get(j).getFrequency(), allOfferList.get(j).getFromDate(),
									allOfferList.get(j).getToDate(), allOfferList.get(j).getFromTime(),
									allOfferList.get(j).getToTime(), allOfferList.get(j).getPrimaryItemId(),
									allOfferList.get(j).getPrimaryItemName(), allOfferList.get(j).getPrimaryQty(),
									allOfferList.get(j).getDiscPer());

							offerDisplayList.add(header);

							break;

						}
					}
				}

				for (int i = 0; i < offerDisplayList.size(); i++) {

					List<ItemWiseOfferDetailDisplay> detailList = new ArrayList<>();

					for (int j = 0; j < allOfferList.size(); j++) {
						ItemWiseOfferDetailDisplay detail = new ItemWiseOfferDetailDisplay(
								allOfferList.get(j).getOfferDetailId(), allOfferList.get(j).getPrimaryItemId(),
								allOfferList.get(j).getSecondaryItemId(), allOfferList.get(j).getSecondaryQty(),
								allOfferList.get(j).getSecondaryItemName());

						detailList.add(detail);

					}
					offerDisplayList.get(i).setOfferDetailList(detailList);
				}

			}

			Franchisee fr = franchiseeRepository.findByFrId(frId);

			boolean isMonthCloseApplicable = false;
			String fromDate = "", toDate = "";
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat yearFormat = new SimpleDateFormat("yyyy");

			List<PostFrItemStockHeader> list = postFrItemStockHeaderRepo.findByFrIdAndIsMonthClosed(frId, 0);

			int month = 0;

			for (PostFrItemStockHeader header : list) {
				month = header.getMonth();
				break;
			}

			Date todaysDate = new Date();

			Calendar cal = Calendar.getInstance();
			cal.setTime(todaysDate);

			cal.set(Calendar.DAY_OF_MONTH, 1);

			Date firstDay = cal.getTime();

			DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			System.out.println(dateFormat1.format(date));

			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(date);

			int dayOfMonth = cal1.get(Calendar.DATE);

			int calCurrentMonth = cal1.get(Calendar.MONTH) + 1;

			if (month < calCurrentMonth) {

				isMonthCloseApplicable = true;
				System.out.println("Day Of Month End ......");

			} else if (month == 12 && calCurrentMonth == 1) {
				isMonthCloseApplicable = true;
			}

			if (isMonthCloseApplicable) {
				System.err.println("Inside iMonthclose app");
				String strDate;
				int year;
				if (month == 12) {
					System.err.println("running month =12");
					year = (Calendar.getInstance().getWeekYear() - 1);
					System.err.println("year value " + year);
				} else {
					System.err.println("running month not eq 12");
					year = Calendar.getInstance().getWeekYear();
					System.err.println("year value " + year);
				}

				if (month < 10) {
					strDate = year + "-0" + month + "-01";
				} else {
					strDate = year + "-" + month + "-01";
				}
				fromDate = strDate;

			} else {
				fromDate = dateFormat.format(firstDay);
			}

			int stockType = 1;
			if (fr != null) {
				stockType = fr.getStockType();
			}

			int year = Integer.parseInt(yearFormat.format(todaysDate));

			List<FrItemStock> frStock = frItemStockRepo.getFrCurrStock(frId, fromDate, toDate, month, year, stockType,
					type);

			System.err.println("FR STOCk = " + frStock);

			List<ItemDisplay> allItemData = itemDisplayRepo.getAllItemByFr(frId, type, applicableFor);

			if (allItemData != null) {

				Set<Integer> idSet = new HashSet<Integer>();

				if (itemIds != null) {
					for (ItemDisplay item : allItemData) {
						if (itemIds.contains(item.getItemId())) {

							if (!item.getRelItemIds().isEmpty()) {
								List<Integer> relIdList = Stream.of(item.getRelItemIds().split(","))
										.map(Integer::parseInt).collect(Collectors.toList());
								idSet.addAll(relIdList);
							}

						}
					}
				}

				List<Integer> relItemIds = new ArrayList<>();
				relItemIds.addAll(idSet);

				List<ItemDisplay> tempItemData = new ArrayList<>();

				for (ItemDisplay item : allItemData) {
					if (relItemIds.contains(item.getItemId())) {

						tempItemData.add(item);

					}
				}

				if (frStock != null) {

					for (ItemDisplay item : tempItemData) {
						for (FrItemStock stock : frStock) {
							if (item.getItemId() == stock.getId()) {
								if (stock.getCurrentStock() > stock.getReorder()) {
									item.setIsAvailable(0);
								} else {
									item.setIsAvailable(1);
								}
								break;
							}
						}
					}

					itemData = tempItemData;

				}
			}

			if (itemData == null) {
				itemData = new ArrayList<ItemDisplay>();
			} else {

				for (int i = 0; i < itemData.size(); i++) {

					// ----------ITEM IMAGES------------
					List<Images> itemImgList = new ArrayList<>();

					if (imgList != null) {
						for (Images image : imgList) {
							if (image.getDocId() == itemData.get(i).getItemId() && image.getDocType() == 3) {
								itemImgList.add(image);
							}
						}
					}
					itemData.get(i).setImageList(itemImgList);

					// ----------ITEM TASTES------------
					List<Ingrediant> taseList = new ArrayList<>();

					if (allTasteList != null) {

						List<Integer> tasteIdsList = new ArrayList<>();
						try {
							tasteIdsList = Stream.of(itemData.get(i).getTasteTypeIds().split(","))
									.map(Integer::parseInt).collect(Collectors.toList());
						} catch (Exception e) {
						}

						for (int t = 0; t < allTasteList.size(); t++) {
							if (tasteIdsList.contains(allTasteList.get(t).getIngrediantId())) {
								taseList.add(allTasteList.get(t));
							}
						}

					}
					itemData.get(i).setTasteList(taseList);

					// --------------------OFFER LIST--------------------------

					List<ItemWiseOfferHeaderDisplay> itemOfferList = new ArrayList<>();

					if (offerDisplayList != null) {
						List<Integer> offerIdsList = new ArrayList<>();
						try {
							offerIdsList = Stream.of(itemData.get(i).getOfferIds().split(",")).map(Integer::parseInt)
									.collect(Collectors.toList());
						} catch (Exception e) {
						}

						for (int t = 0; t < offerDisplayList.size(); t++) {
							if (offerIdsList.contains(offerDisplayList.get(t).getOfferId())) {
								itemOfferList.add(offerDisplayList.get(t));
							}
						}
					}
					itemData.get(i).setOfferList(itemOfferList);

				}
			}

		} catch (Exception e) {
			System.err.println("EXCEPTION IN getAllItemListByFr -> " + e.getMessage());
			e.printStackTrace();
		}

		return itemData;
	}

	// GET RELATED ITEMS AND FREQUENTLY ORDER ITEM LIST-------------------

	@RequestMapping(value = { "/getRelAndFreqOrderItemList" }, method = RequestMethod.POST)
	public @ResponseBody GetRelatedItemsAndFreqOrderList getRelAndFreqOrderItemList(@RequestParam("frId") int frId,
			@RequestParam("type") int type, @RequestParam("applicableFor") int applicableFor,
			@RequestParam("itemIds") List<Integer> itemIds, @RequestParam("custId") int custId) {

		GetRelatedItemsAndFreqOrderList itemListRes = new GetRelatedItemsAndFreqOrderList();

		List<Images> imgList = imagesRepo.findAllByDelStatus(0);
		List<Ingrediant> allTasteList = ingrediantRepo.findByDelStatusOrderByIngrediantIdDesc(0);

		// ------------ALL OFFER--------------------
		List<ItemWiseOfferHeaderDisplay> offerDisplayList = new ArrayList<>();

		List<ItemWiseOfferData> allOfferList = itemWiseOfferDataRepo.getAllOffersByFr(frId, type, applicableFor);
		if (allOfferList != null) {
			Set<Integer> offerSet = new HashSet<Integer>();
			for (ItemWiseOfferData data : allOfferList) {
				offerSet.add(data.getOfferId());
			}

			List<Integer> offerIdList = new ArrayList<>();
			offerIdList.addAll(offerSet);

			Collections.sort(offerIdList);

			for (int i = 0; i < offerIdList.size(); i++) {
				for (int j = 0; j < allOfferList.size(); j++) {
					if (offerIdList.get(i) == allOfferList.get(j).getOfferId()) {

						ItemWiseOfferHeaderDisplay header = new ItemWiseOfferHeaderDisplay(
								allOfferList.get(j).getOfferId(), allOfferList.get(j).getOfferName(),
								allOfferList.get(j).getOfferDesc(), allOfferList.get(j).getType(),
								allOfferList.get(j).getApplicableFor(), allOfferList.get(j).getOfferType(),
								allOfferList.get(j).getOfferSubType(), allOfferList.get(j).getFrequencyType(),
								allOfferList.get(j).getFrequency(), allOfferList.get(j).getFromDate(),
								allOfferList.get(j).getToDate(), allOfferList.get(j).getFromTime(),
								allOfferList.get(j).getToTime(), allOfferList.get(j).getPrimaryItemId(),
								allOfferList.get(j).getPrimaryItemName(), allOfferList.get(j).getPrimaryQty(),
								allOfferList.get(j).getDiscPer());

						offerDisplayList.add(header);

						break;

					}
				}
			}

			for (int i = 0; i < offerDisplayList.size(); i++) {

				List<ItemWiseOfferDetailDisplay> detailList = new ArrayList<>();

				for (int j = 0; j < allOfferList.size(); j++) {
					ItemWiseOfferDetailDisplay detail = new ItemWiseOfferDetailDisplay(
							allOfferList.get(j).getOfferDetailId(), allOfferList.get(j).getPrimaryItemId(),
							allOfferList.get(j).getSecondaryItemId(), allOfferList.get(j).getSecondaryQty(),
							allOfferList.get(j).getSecondaryItemName());

					detailList.add(detail);

				}
				offerDisplayList.get(i).setOfferDetailList(detailList);
			}

		}

		// --------------------OFFER
		// END------------------------------------------------------

		// ---------------------FR
		// STOCK-------------------------------------------------------

		Franchisee fr = franchiseeRepository.findByFrId(frId);

		boolean isMonthCloseApplicable = false;
		String fromDate = "", toDate = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat yearFormat = new SimpleDateFormat("yyyy");

		List<PostFrItemStockHeader> list = postFrItemStockHeaderRepo.findByFrIdAndIsMonthClosed(frId, 0);

		int month = 0;

		for (PostFrItemStockHeader header : list) {
			month = header.getMonth();
			break;
		}

		Date todaysDate = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(todaysDate);

		cal.set(Calendar.DAY_OF_MONTH, 1);

		Date firstDay = cal.getTime();

		DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		System.out.println(dateFormat1.format(date));

		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date);

		int dayOfMonth = cal1.get(Calendar.DATE);

		int calCurrentMonth = cal1.get(Calendar.MONTH) + 1;

		if (month < calCurrentMonth) {

			isMonthCloseApplicable = true;
			System.out.println("Day Of Month End ......");

		} else if (month == 12 && calCurrentMonth == 1) {
			isMonthCloseApplicable = true;
		}

		if (isMonthCloseApplicable) {
			System.err.println("Inside iMonthclose app");
			String strDate;
			int year;
			if (month == 12) {
				System.err.println("running month =12");
				year = (Calendar.getInstance().getWeekYear() - 1);
				System.err.println("year value " + year);
			} else {
				System.err.println("running month not eq 12");
				year = Calendar.getInstance().getWeekYear();
				System.err.println("year value " + year);
			}

			if (month < 10) {
				strDate = year + "-0" + month + "-01";
			} else {
				strDate = year + "-" + month + "-01";
			}
			fromDate = strDate;

		} else {
			fromDate = dateFormat.format(firstDay);
		}

		int stockType = 1;
		if (fr != null) {
			stockType = fr.getStockType();
		}

		int year = Integer.parseInt(yearFormat.format(todaysDate));

		List<FrItemStock> frStock = frItemStockRepo.getFrCurrStock(frId, fromDate, toDate, month, year, stockType,
				type);

		System.err.println("FR STOCk = " + frStock);

		// ----------------------FR STOCK
		// END--------------------------------------------------

		// ----------ALL ITEM LIST------------------------------
		List<ItemDisplay> allItemData = itemDisplayRepo.getAllItemByFr(frId, type, applicableFor);

		List<ItemDisplay> itemData = null;

		try {

			if (allItemData != null) {

				Set<Integer> idSet = new HashSet<Integer>();

				if (itemIds != null) {
					for (ItemDisplay item : allItemData) {
						if (itemIds.contains(item.getItemId())) {

							if (!item.getRelItemIds().isEmpty()) {
								List<Integer> relIdList = Stream.of(item.getRelItemIds().split(","))
										.map(Integer::parseInt).collect(Collectors.toList());
								idSet.addAll(relIdList);
							}

						}
					}
				}

				List<Integer> relItemIds = new ArrayList<>();
				relItemIds.addAll(idSet);

				List<ItemDisplay> tempItemData = new ArrayList<>();

				for (ItemDisplay item : allItemData) {
					if (relItemIds.contains(item.getItemId())) {

						tempItemData.add(item);

					}
				}

				if (frStock != null) {

					for (ItemDisplay item : tempItemData) {
						for (FrItemStock stock : frStock) {
							if (item.getItemId() == stock.getId()) {
								if (stock.getCurrentStock() > stock.getReorder()) {
									item.setIsAvailable(0);
								} else {
									item.setIsAvailable(1);
								}
								break;
							}
						}
					}

					itemData = tempItemData;

				}
			}

			if (itemData == null) {
				itemData = new ArrayList<ItemDisplay>();
			} else {

				for (int i = 0; i < itemData.size(); i++) {

					// ----------ITEM IMAGES------------
					List<Images> itemImgList = new ArrayList<>();

					if (imgList != null) {
						for (Images image : imgList) {
							if (image.getDocId() == itemData.get(i).getItemId() && image.getDocType() == 3) {
								itemImgList.add(image);
							}
						}
					}
					itemData.get(i).setImageList(itemImgList);

					// ----------ITEM TASTES------------
					List<Ingrediant> taseList = new ArrayList<>();

					if (allTasteList != null) {

						List<Integer> tasteIdsList = new ArrayList<>();
						try {
							tasteIdsList = Stream.of(itemData.get(i).getTasteTypeIds().split(","))
									.map(Integer::parseInt).collect(Collectors.toList());
						} catch (Exception e) {
						}

						for (int t = 0; t < allTasteList.size(); t++) {
							if (tasteIdsList.contains(allTasteList.get(t).getIngrediantId())) {
								taseList.add(allTasteList.get(t));
							}
						}

					}
					itemData.get(i).setTasteList(taseList);

					// --------------------OFFER LIST--------------------------

					List<ItemWiseOfferHeaderDisplay> itemOfferList = new ArrayList<>();

					if (offerDisplayList != null) {
						List<Integer> offerIdsList = new ArrayList<>();
						try {
							offerIdsList = Stream.of(itemData.get(i).getOfferIds().split(",")).map(Integer::parseInt)
									.collect(Collectors.toList());
						} catch (Exception e) {
						}

						for (int t = 0; t < offerDisplayList.size(); t++) {
							if (offerIdsList.contains(offerDisplayList.get(t).getOfferId())) {
								itemOfferList.add(offerDisplayList.get(t));
							}
						}
					}
					itemData.get(i).setOfferList(itemOfferList);

				}
			}

		} catch (Exception e) {
			System.err.println("EXCEPTION IN getAllRelatedItems -> " + e.getMessage());
			e.printStackTrace();
		}

		itemListRes.setRelatedItemList(itemData);

		// ====================FREQUENTLY ORDERED ITEM
		// LIST========================================

		List<ItemDisplay> freqItemData = null;

		try {

			List<ItemDisplay> tempItemData = itemDisplayRepo.getFrequentlyOrderedItemListByCust(frId, type,
					applicableFor, custId);

			if (tempItemData != null) {
				if (frStock != null) {

					for (ItemDisplay item : tempItemData) {
						for (FrItemStock stock : frStock) {
							if (item.getItemId() == stock.getId()) {
								if (stock.getCurrentStock() > stock.getReorder()) {
									item.setIsAvailable(0);
								} else {
									item.setIsAvailable(1);
								}
								break;
							}
						}
					}

					freqItemData = tempItemData;

				}
			}

			if (freqItemData == null) {
				freqItemData = new ArrayList<ItemDisplay>();
			} else {

				for (int i = 0; i < freqItemData.size(); i++) {

					// ----------ITEM IMAGES------------
					List<Images> itemImgList = new ArrayList<>();

					if (imgList != null) {
						for (Images image : imgList) {
							if (image.getDocId() == freqItemData.get(i).getItemId() && image.getDocType() == 3) {
								itemImgList.add(image);
							}
						}
					}
					freqItemData.get(i).setImageList(itemImgList);

					// ----------ITEM TASTES------------
					List<Ingrediant> taseList = new ArrayList<>();

					if (allTasteList != null) {

						List<Integer> tasteIdsList = new ArrayList<>();
						try {
							tasteIdsList = Stream.of(freqItemData.get(i).getTasteTypeIds().split(","))
									.map(Integer::parseInt).collect(Collectors.toList());
						} catch (Exception e) {
						}

						for (int t = 0; t < allTasteList.size(); t++) {
							if (tasteIdsList.contains(allTasteList.get(t).getIngrediantId())) {
								taseList.add(allTasteList.get(t));
							}
						}

					}
					freqItemData.get(i).setTasteList(taseList);

					// --------------------OFFER LIST--------------------------

					List<ItemWiseOfferHeaderDisplay> itemOfferList = new ArrayList<>();

					if (offerDisplayList != null) {
						List<Integer> offerIdsList = new ArrayList<>();
						try {
							offerIdsList = Stream.of(freqItemData.get(i).getOfferIds().split(","))
									.map(Integer::parseInt).collect(Collectors.toList());
						} catch (Exception e) {
						}

						for (int t = 0; t < offerDisplayList.size(); t++) {
							if (offerIdsList.contains(offerDisplayList.get(t).getOfferId())) {
								itemOfferList.add(offerDisplayList.get(t));
							}
						}
					}
					freqItemData.get(i).setOfferList(itemOfferList);

				}
			}

		} catch (Exception e) {
			System.err.println("EXCEPTION IN getFreqOrderItemList -> " + e.getMessage());
			e.printStackTrace();
		}

		itemListRes.setFreqOrderItemList(freqItemData);

		return itemListRes;

	}

	@RequestMapping(value = { "/getAllTokenListByFr" }, method = RequestMethod.POST)
	public @ResponseBody List<String> getAllTokenListByFr(@RequestParam("frId") int frId) {

		List<String> list = new ArrayList<>();

		try {

			list = franchiseDataRepo.getAllTokenListByFr(frId);

		} catch (Exception e) {

		}

		return list;
	}

	@RequestMapping(value = { "/updateSettingValueByKey" }, method = RequestMethod.POST)
	public @ResponseBody Info updateSettingValueByKey(@RequestParam("key") String key,
			@RequestParam("value") int value) {

		Info info = new Info();

		try {

			int res = settingRepository.udateKeyAndValue(key, value);
			if (res > 0) {
				info.setError(false);
			} else {
				info.setError(true);
			}

		} catch (Exception e) {
			info.setError(true);
		}

		return info;
	}

	@RequestMapping(value = { "/getSettingByKey" }, method = RequestMethod.POST)
	public @ResponseBody Setting getSettingByKey(@RequestParam("key") String key) {

		Setting setting = new Setting();

		try {

			setting = settingRepository.findBySettingKey(key);

		} catch (Exception e) {
		}

		return setting;
	}

	@RequestMapping(value = { "/getNewSettingByKey" }, method = RequestMethod.POST)
	public @ResponseBody NewSetting getNewSettingByKey(@RequestParam("key") String key) {

		NewSetting setting = new NewSetting();

		try {
			setting = newSettingRepo.findBySettingKeyAndDelStatus(key, 0);
		} catch (Exception e) {
		}

		return setting;
	}

	@RequestMapping(value = { "/getCustomerWalletAmt" }, method = RequestMethod.POST)
	public @ResponseBody CustWalletTotal getCustomerWalletAmt(@RequestParam("custId") int custId) {

		CustWalletTotal wallet = new CustWalletTotal();

		try {
			wallet = custWalletTotalRepo.getCustTotalWalletAmt(custId);
			if (wallet == null) {
				wallet = new CustWalletTotal();
			}

			NewSetting applyLimit = newSettingRepo.findBySettingKeyAndDelStatus("wallet_apply_on_rs", 0);
			NewSetting walletPer = newSettingRepo.findBySettingKeyAndDelStatus("wallet_apply_percent", 0);
			NewSetting walletRs = newSettingRepo.findBySettingKeyAndDelStatus("wallet_apply_rs", 0);

			if (applyLimit != null) {
				wallet.setWalletLimitRs(Float.parseFloat(applyLimit.getSettingValue1()));
			} else {
				wallet.setWalletLimitRs(0);
			}

			if (walletPer != null) {
				wallet.setWalletPercent(Float.parseFloat(walletPer.getSettingValue1()));
			} else {
				wallet.setWalletPercent(0);
			}

			if (walletRs != null) {
				wallet.setWalletMinAmt(Float.parseFloat(walletRs.getSettingValue1()));
			} else {
				wallet.setWalletMinAmt(0);
			}

		} catch (Exception e) {
		}

		return wallet;
	}

	public void publishData(GetAllDataByFr allData, int frId) {

		final String JSON_SAVE_URL = "C:/Users/MAXADMIN/Desktop/Report/";

		// final String JSON_SAVE_URL =
		// "/opt/apache-tomcat-8.5.49/webapps/uploads/ckjson/";
		// final String TALLY_VIEW =
		// "http://107.180.91.43:8080/uploads/ckuploads/ckjson/";

		ObjectMapper Obj = new ObjectMapper();
		String json = "";
		try {
			json = Obj.writeValueAsString(allData);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (json != null) {

			try {
				Writer output = null;
				File file = new File(JSON_SAVE_URL + frId + ".json");
				output = new BufferedWriter(new FileWriter(file));
				output.write(json.toString());
				output.close();

				String fileName = JSON_SAVE_URL + frId + ".zip";
				String sourceFile = JSON_SAVE_URL + frId + ".json";

				FileOutputStream fos = new FileOutputStream(fileName);
				ZipOutputStream zipOut = new ZipOutputStream(fos);
				File fileToZip = new File(sourceFile);
				FileInputStream fis = new FileInputStream(fileToZip);
				ZipEntry zipEntry = new ZipEntry(fileToZip.getName());

				zipOut.putNextEntry(zipEntry);
				byte[] bytes = new byte[1024];
				int length;
				while ((length = fis.read(bytes)) >= 0) {
					zipOut.write(bytes, 0, length);
				}
				zipOut.close();
				fis.close();
				fos.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@RequestMapping(value = { "/publishAllFrData" }, method = RequestMethod.GET)
	public @ResponseBody Info publishAllFrData() {

		Info info = new Info();

		try {

			List<Franchisee> frList = franchiseeRepository.findAllByDelStatus(0);

			for (int i = 0; i < frList.size(); i++) {

				getAllDataByFr(frList.get(i).getFrId(), 2, 1, 1);

			}

			info.setError(false);

		} catch (Exception e) {
			info.setError(true);
		}

		return info;
	}

	@RequestMapping(value = { "/getDeliveryCharges" }, method = RequestMethod.POST)
	public @ResponseBody CkDeliveryCharges getDeliveryCharges(@RequestParam("km") float km) {

		CkDeliveryCharges res = new CkDeliveryCharges();

		try {
			// Delivery Charges
			res = ckDeliveryChargesRepo.getDeliveryCharges(km);
			if (res == null) {
				res = new CkDeliveryCharges();
			}

		} catch (Exception e) {
		}
		return res;
	}

	@RequestMapping(value = { "/getOrderCheckoutData" }, method = RequestMethod.POST)
	public @ResponseBody OrderCheckoutData getOrderCheckoutData(@RequestParam("km") float km,
			@RequestParam("frId") int frId) {

		System.err.println("KM = " + km + "           FR ID = " + frId + "------------------------------");

		OrderCheckoutData res = new OrderCheckoutData();

		try {
			// Delivery Charges

			try {
				CkDeliveryCharges delCh = ckDeliveryChargesRepo.getDeliveryCharges(km);
				if (delCh == null) {
					delCh = new CkDeliveryCharges();
				}
				res.setDeliveryCharges(delCh);
				System.err.println("delCh ------------------------------------------------------------- " + delCh);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				// Additional Charges By Franchise
				FrCharges addCh = frChargesRepo.findByfrId(frId);
				if (addCh == null) {
					addCh = new FrCharges();
				}
				res.setAdditionalCharges(addCh);
				System.err.println("addCh ------------------------------------------------------------- " + addCh);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				// Offers By Franchisee FOR Executive - bill offers
				List<OfferHeader> offerHeaderList = offerHeaderRepo.getBillOfferHeaderByFr(frId, 2, 1, 1);

				List<OfferDetail> offerDetailList = offerDetailRepo.getOfferDetailByFr(frId);

				System.err.println("offerHeaderList ------------------------------------------------------------- "
						+ offerHeaderList);

				if (offerHeaderList != null) {
					if (offerHeaderList.size() > 0) {

						for (OfferHeader header : offerHeaderList) {

							List<OfferDetail> detailList = new ArrayList<>();
							if (offerDetailList != null) {

								for (OfferDetail detail : offerDetailList) {
									if (header.getOfferId() == detail.getOfferId()) {
										detailList.add(detail);
									}
								}

							}
							header.setOfferDetailList(detailList);
						}
					}
				}
				res.setOfferList(offerHeaderList);
				res.setOfferDetailList(offerDetailList);

				System.err.println("offerDetailList ------------------------------------------------------------- "
						+ offerDetailList);

			} catch (Exception e) {
				e.printStackTrace();
			}

			System.err.println("Res ------------------------------------------------------------- " + res);

		} catch (Exception e) {
			System.err.println("in e");
			e.printStackTrace();
		}
		return res;
	}

	@RequestMapping(value = { "/checkIsValidOffer" }, method = RequestMethod.POST)
	public @ResponseBody Info checkIsValidOffer(@RequestParam("offerId") int offerId,
			@RequestParam("coupon") String coupon, @RequestParam("custId") int custId) {

		Info info = new Info();
		try {
			int res = offerHeaderRepo.checkIsValidOffer(offerId, coupon, custId);
			if (res == 1) {
				info.setError(false);
			} else {
				info.setError(true);
			}
		} catch (Exception e) {
			info.setError(true);
		}

		return info;

	}

	// GET COUPON WISE OFFERS
	@RequestMapping(value = { "/getCouponWiseBillOffers" }, method = RequestMethod.POST)
	public @ResponseBody List<OfferHeader> getCouponWiseOffers(@RequestParam("frId") int frId) {

		List<OfferHeader> offerHeaderList = new ArrayList<>();

		try {
			offerHeaderList = offerHeaderRepo.getBillOfferHeaderByFrCouponWise(frId, 2, 1, 1);
		} catch (Exception e) {
		}

		return offerHeaderList;

	}

	// GET CUSTOMER WISE OFFERS
	@RequestMapping(value = { "/getCustomerWiseBillOffers" }, method = RequestMethod.POST)
	public @ResponseBody List<OfferHeader> getCustomerWiseBillOffers(@RequestParam("frId") int frId,
			@RequestParam("custId") int custId) {

		List<OfferHeader> offerHeaderList = new ArrayList<>();

		System.err.println("frId - " + frId + "    Cust - " + custId);

		try {
			offerHeaderList = offerHeaderRepo.getBillOfferHeaderByFrCustomerWise(frId, 2, 1, 1, custId);
		} catch (Exception e) {
		}

		return offerHeaderList;

	}

}
