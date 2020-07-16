package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IngredientDetailList {

	@Id
	private int ingrediantId;
	private String ingrediantName;
	private int isActive;
	private String ingrediantDesc;
	private String ingrediantCatName;
	private int exInt1;
	private String exVar1;
	
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
	@Override
	public String toString() {
		return "IngredientDetailList [ingrediantId=" + ingrediantId + ", ingrediantName=" + ingrediantName
				+ ", isActive=" + isActive + ", ingrediantDesc=" + ingrediantDesc + ", ingrediantCatName="
				+ ingrediantCatName + ", exInt1=" + exInt1 + ", exVar1=" + exVar1 + "]";
	}
	
}
