package com.ats.ckweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShowItemDetailNewList {

	@Id
	@Column(name = "item_d_id")
	private int itemDId;

	private int itemId;
	private String itemName;
	private int productType;
	private int productCategory;
	private String productStatus;
	private int productShowIn;

	public int getItemDId() {
		return itemDId;
	}

	public void setItemDId(int itemDId) {
		this.itemDId = itemDId;
	}

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

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public int getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public int getProductShowIn() {
		return productShowIn;
	}

	public void setProductShowIn(int productShowIn) {
		this.productShowIn = productShowIn;
	}

	@Override
	public String toString() {
		return "ShowItemDetailNewList [itemDId=" + itemDId + ", itemId=" + itemId + ", itemName=" + itemName
				+ ", productType=" + productType + ", productCategory=" + productCategory + ", productStatus="
				+ productStatus + ", productShowIn=" + productShowIn + "]";
	}

}
