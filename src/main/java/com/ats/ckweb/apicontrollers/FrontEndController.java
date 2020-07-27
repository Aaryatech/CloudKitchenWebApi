package com.ats.ckweb.apicontrollers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ats.ckweb.model.Area;
import com.ats.ckweb.model.AreaData;
import com.ats.ckweb.model.CategoryData;
import com.ats.ckweb.model.CityData;
import com.ats.ckweb.model.FranchiseData;
import com.ats.ckweb.model.GetAllDataByFr;
import com.ats.ckweb.model.GetCategoryData;
import com.ats.ckweb.model.GetFranchiseData;
import com.ats.ckweb.model.GetSubCategoryData;
import com.ats.ckweb.model.Images;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.Ingrediant;
import com.ats.ckweb.model.ItemDisplay;
import com.ats.ckweb.model.OfferHeader;
import com.ats.ckweb.model.SubCategoryData;
import com.ats.ckweb.model.Tags;
import com.ats.ckweb.repository.AreaDataRepo;
import com.ats.ckweb.repository.CategoryDataRepo;
import com.ats.ckweb.repository.CityDataRepo;
import com.ats.ckweb.repository.FranchiseDataRepo;
import com.ats.ckweb.repository.ImagesRepo;
import com.ats.ckweb.repository.IngrediantRepo;
import com.ats.ckweb.repository.ItemDisplayRepo;
import com.ats.ckweb.repository.OfferHeaderRepo;
import com.ats.ckweb.repository.SubCategoryDataRepo;
import com.ats.ckweb.repository.TagRepo;
import com.ats.ckweb.services.ImagesService;
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

	@RequestMapping(value = { "/getFranchiseByFrId" }, method = RequestMethod.POST)
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
			@RequestParam("applicableFor") int applicableFor) {

		GetAllDataByFr res = new GetAllDataByFr();

		Info info = new Info();

		List<CategoryData> catData = null;
		List<SubCategoryData> subCatData = null;
		List<OfferHeader> offerData = null;
		List<Tags> tagsData = null;
		List<ItemDisplay> itemData = null;

		try {
			List<Images> imgList = imagesRepo.findAllByDelStatus(0);
			List<Tags> allTagList = tagRepo.findByTagDeleteStatusOrderByTagIdDesc(0);
			List<Ingrediant> allTasteList = ingrediantRepo.findByDelStatusOrderByIngrediantIdDesc(0);

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
			itemData = itemDisplayRepo.getAllItemByFr(frId, type);

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
									itemData.get(t).getCatName(), itemData.get(t).getItemSortId(),
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
									itemData.get(t).getRelItemIds());

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

				}
			}
			res.setItemData(itemData);

			info.setError(false);
			info.setMessage("Success");

			res.setInfo(info);

		} catch (Exception e) {
			e.printStackTrace();
			info.setError(true);
			info.setMessage("Failed");
		}

		res.setInfo(info);

		return res;
	}

}
