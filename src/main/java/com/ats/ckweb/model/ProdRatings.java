package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProdRatings {

	@Id
	private int ratingsId;
	private int custId;
	private int itemId;
	private float value;
	private String insertDatetime;
	private int exInt1;
	private int exInt2;
	private String exVar1;
	private String exVar2;
	private float exFloat1;
	private float exFloat2;

	public int getRatingsId() {
		return ratingsId;
	}

	public void setRatingsId(int ratingsId) {
		this.ratingsId = ratingsId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getInsertDatetime() {
		return insertDatetime;
	}

	public void setInsertDatetime(String insertDatetime) {
		this.insertDatetime = insertDatetime;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	public float getExFloat1() {
		return exFloat1;
	}

	public void setExFloat1(float exFloat1) {
		this.exFloat1 = exFloat1;
	}

	public float getExFloat2() {
		return exFloat2;
	}

	public void setExFloat2(float exFloat2) {
		this.exFloat2 = exFloat2;
	}

	@Override
	public String toString() {
		return "ProdRatings [ratingsId=" + ratingsId + ", custId=" + custId + ", itemId=" + itemId + ", value=" + value
				+ ", insertDatetime=" + insertDatetime + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1="
				+ exVar1 + ", exVar2=" + exVar2 + ", exFloat1=" + exFloat1 + ", exFloat2=" + exFloat2 + "]";
	}

}
