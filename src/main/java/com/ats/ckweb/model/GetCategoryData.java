package com.ats.ckweb.model;

import java.util.List;

public class GetCategoryData {

	List<CategoryData> category;
	Info info;

	public List<CategoryData> getCategory() {
		return category;
	}

	public void setCategory(List<CategoryData> category) {
		this.category = category;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetCategoryData [category=" + category + ", info=" + info + "]";
	}

}
