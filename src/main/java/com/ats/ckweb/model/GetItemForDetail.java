package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetItemForDetail {

	@Id
	private int itemId;

	private String itemName;
	private int catId;
	private int subCatId;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	@Override
	public String toString() {
		return "GetItemForDetail [itemId=" + itemId + ", itemName=" + itemName + ", catId=" + catId + ", subCatId="
				+ subCatId + "]";
	}

}
