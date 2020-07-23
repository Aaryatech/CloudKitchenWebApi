package com.ats.ckweb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class SubCategoryData {

	@Id
	private int subCatId;
	private int catId;
	private String catName;
	private String subCatName;

	@Transient
	List<Images> imageList;

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public List<Images> getImageList() {
		return imageList;
	}

	public void setImageList(List<Images> imageList) {
		this.imageList = imageList;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	@Override
	public String toString() {
		return "SubCategoryData [subCatId=" + subCatId + ", catId=" + catId + ", catName=" + catName + ", subCatName="
				+ subCatName + ", imageList=" + imageList + "]";
	}

}