package com.ats.ckweb.model;

import java.util.List;

public class GetSubCategoryData {

	private List<SubCategoryData> subCategory;
	private Info info;

	public List<SubCategoryData> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<SubCategoryData> subCategory) {
		this.subCategory = subCategory;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetSubCategoryData [subCategory=" + subCategory + ", info=" + info + "]";
	}

}
