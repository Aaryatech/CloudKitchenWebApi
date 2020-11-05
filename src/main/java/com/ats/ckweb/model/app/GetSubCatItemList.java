package com.ats.ckweb.model.app;

import java.util.List;

import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.SubCategoryData;

public class GetSubCatItemList {

	List<SubCategoryData> subCategoryData;
	Info info;

	public List<SubCategoryData> getSubCategoryData() {
		return subCategoryData;
	}

	public void setSubCategoryData(List<SubCategoryData> subCategoryData) {
		this.subCategoryData = subCategoryData;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetSubCatItemList [subCategoryData=" + subCategoryData + ", info=" + info + "]";
	}

}
