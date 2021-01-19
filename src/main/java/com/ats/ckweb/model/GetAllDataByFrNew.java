package com.ats.ckweb.model;

import java.util.List;

public class GetAllDataByFrNew {

	private Info info;
	private List<CategoryData> categoryData;
	private List<SubCategoryData> subCategoryData;
	private List<OfferHeader> offerData;
	private List<Tags> tagsData;
	private List<ItemDisplay> itemData;
	private FranchiseDataNew franchise;

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public List<CategoryData> getCategoryData() {
		return categoryData;
	}

	public void setCategoryData(List<CategoryData> categoryData) {
		this.categoryData = categoryData;
	}

	public List<SubCategoryData> getSubCategoryData() {
		return subCategoryData;
	}

	public void setSubCategoryData(List<SubCategoryData> subCategoryData) {
		this.subCategoryData = subCategoryData;
	}

	public List<OfferHeader> getOfferData() {
		return offerData;
	}

	public void setOfferData(List<OfferHeader> offerData) {
		this.offerData = offerData;
	}

	public List<Tags> getTagsData() {
		return tagsData;
	}

	public void setTagsData(List<Tags> tagsData) {
		this.tagsData = tagsData;
	}

	public List<ItemDisplay> getItemData() {
		return itemData;
	}

	public void setItemData(List<ItemDisplay> itemData) {
		this.itemData = itemData;
	}

	public FranchiseDataNew getFranchise() {
		return franchise;
	}

	public void setFranchise(FranchiseDataNew franchise) {
		this.franchise = franchise;
	}

	@Override
	public String toString() {
		return "GetAllDataByFrNew [info=" + info + ", categoryData=" + categoryData + ", subCategoryData="
				+ subCategoryData + ", offerData=" + offerData + ", tagsData=" + tagsData + ", itemData=" + itemData
				+ ", franchise=" + franchise + "]";
	}

}
