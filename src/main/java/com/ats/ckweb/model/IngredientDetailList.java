package com.ats.ckweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IngredientDetailList {

	@Id
	private int ingrediantId;
	private String ingrediantCatName;
	private int ingrediantCatId;
	private String ingrediantName;
	private int delStatus;
	private int isActive;
	private String ingrediantImage;
	private int exInt1;
	private int exInt2;
	private String exVar1;
	private String exVar2;
	private float exFloat1;
	private float exFloat2;
	private String lastOprationDatetime;
	private String ingrediantDesc;

	public int getIngrediantId() {
		return ingrediantId;
	}

	public void setIngrediantId(int ingrediantId) {
		this.ingrediantId = ingrediantId;
	}

	public String getIngrediantName() {
		return ingrediantName;
	}

	public void setIngrediantName(String ingrediantName) {
		this.ingrediantName = ingrediantName;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getIngrediantDesc() {
		return ingrediantDesc;
	}

	public void setIngrediantDesc(String ingrediantDesc) {
		this.ingrediantDesc = ingrediantDesc;
	}

	public String getIngrediantCatName() {
		return ingrediantCatName;
	}

	public void setIngrediantCatName(String ingrediantCatName) {
		this.ingrediantCatName = ingrediantCatName;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public int getIngrediantCatId() {
		return ingrediantCatId;
	}

	public void setIngrediantCatId(int ingrediantCatId) {
		this.ingrediantCatId = ingrediantCatId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getIngrediantImage() {
		return ingrediantImage;
	}

	public void setIngrediantImage(String ingrediantImage) {
		this.ingrediantImage = ingrediantImage;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
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

	public String getLastOprationDatetime() {
		return lastOprationDatetime;
	}

	public void setLastOprationDatetime(String lastOprationDatetime) {
		this.lastOprationDatetime = lastOprationDatetime;
	}

	@Override
	public String toString() {
		return "IngredientDetailList [ingrediantId=" + ingrediantId + ", ingrediantCatName=" + ingrediantCatName
				+ ", ingrediantCatId=" + ingrediantCatId + ", ingrediantName=" + ingrediantName + ", delStatus="
				+ delStatus + ", isActive=" + isActive + ", ingrediantImage=" + ingrediantImage + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exFloat1=" + exFloat1
				+ ", exFloat2=" + exFloat2 + ", lastOprationDatetime=" + lastOprationDatetime + ", ingrediantDesc="
				+ ingrediantDesc + "]";
	}

}
