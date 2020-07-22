package com.ats.ckweb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class CategoryData {

	@Id
	private int catId;
	private String catName;

	@Transient
	List<Images> imageList;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public List<Images> getImageList() {
		return imageList;
	}

	public void setImageList(List<Images> imageList) {
		this.imageList = imageList;
	}

	@Override
	public String toString() {
		return "CategoryData [catId=" + catId + ", catName=" + catName + "]";
	}

}
