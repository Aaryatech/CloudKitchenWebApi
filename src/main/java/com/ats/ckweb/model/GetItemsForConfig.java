package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetItemsForConfig {

	@Id
	private int itemId;

	private String itemName;
	private String hsncd;
	private float rate_amt;
	private float mrp_amt;
	private float sp_rate_amt;
	private float tax1;
	private float tax2;
	private float tax3;
	private int status;
	private int checked;
	private int itemConfigId;
	private int itemConfigDetailId;
	private int isActive;

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

	public String getHsncd() {
		return hsncd;
	}

	public void setHsncd(String hsncd) {
		this.hsncd = hsncd;
	}

	public float getRate_amt() {
		return rate_amt;
	}

	public void setRate_amt(float rate_amt) {
		this.rate_amt = rate_amt;
	}

	public float getMrp_amt() {
		return mrp_amt;
	}

	public void setMrp_amt(float mrp_amt) {
		this.mrp_amt = mrp_amt;
	}

	public float getSp_rate_amt() {
		return sp_rate_amt;
	}

	public void setSp_rate_amt(float sp_rate_amt) {
		this.sp_rate_amt = sp_rate_amt;
	}

	public float getTax1() {
		return tax1;
	}

	public void setTax1(float tax1) {
		this.tax1 = tax1;
	}

	public float getTax2() {
		return tax2;
	}

	public void setTax2(float tax2) {
		this.tax2 = tax2;
	}

	public float getTax3() {
		return tax3;
	}

	public void setTax3(float tax3) {
		this.tax3 = tax3;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getChecked() {
		return checked;
	}

	public void setChecked(int checked) {
		this.checked = checked;
	}

	public int getItemConfigId() {
		return itemConfigId;
	}

	public void setItemConfigId(int itemConfigId) {
		this.itemConfigId = itemConfigId;
	}

	public int getItemConfigDetailId() {
		return itemConfigDetailId;
	}

	public void setItemConfigDetailId(int itemConfigDetailId) {
		this.itemConfigDetailId = itemConfigDetailId;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "GetItemsForConfig [itemId=" + itemId + ", itemName=" + itemName + ", hsncd=" + hsncd + ", rate_amt="
				+ rate_amt + ", mrp_amt=" + mrp_amt + ", sp_rate_amt=" + sp_rate_amt + ", tax1=" + tax1 + ", tax2="
				+ tax2 + ", tax3=" + tax3 + ", status=" + status + ", checked=" + checked + ", itemConfigId="
				+ itemConfigId + ", itemConfigDetailId=" + itemConfigDetailId + ", isActive=" + isActive + "]";
	}

}
