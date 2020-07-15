package com.ats.ckweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mn_ingrediant")
public class Ingrediant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="ingrediant_id")
	private int ingrediantId;
	
	@Column(name="ingrediant_cat_id")
	private int ingrediantCatId;
	
	@Column(name="ingrediant_name")
	private String ingrediantName;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="ingrediant_image")
	private String ingrediantImage;
	
	@Column(name="ex_int1")
	private int exInt1;
	
	@Column(name="ex_int2")
	private int exInt2;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_var2")
	private String exVar2;
	
	@Column(name="ex_float1")
	private float exFloat1;
	
	@Column(name="ex_float2")
	private float exFloat2;
	
	@Column(name="last_opration_datetime")
	private String lastOprationDatetime;
	
	@Column(name="ingrediant_desc")
	private String ingrediantDesc;

	public int getIngrediantId() {
		return ingrediantId;
	}

	public void setIngrediantId(int ingrediantId) {
		this.ingrediantId = ingrediantId;
	}

	public int getIngrediantCatId() {
		return ingrediantCatId;
	}

	public void setIngrediantCatId(int ingrediantCatId) {
		this.ingrediantCatId = ingrediantCatId;
	}

	public String getIngrediantName() {
		return ingrediantName;
	}

	public void setIngrediantName(String ingrediantName) {
		this.ingrediantName = ingrediantName;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getIngrediantImage() {
		return ingrediantImage;
	}

	public void setIngrediantImage(String ingrediantImage) {
		this.ingrediantImage = ingrediantImage;
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

	public String getLastOprationDatetime() {
		return lastOprationDatetime;
	}

	public void setLastOprationDatetime(String lastOprationDatetime) {
		this.lastOprationDatetime = lastOprationDatetime;
	}

	public String getIngrediantDesc() {
		return ingrediantDesc;
	}

	public void setIngrediantDesc(String ingrediantDesc) {
		this.ingrediantDesc = ingrediantDesc;
	}

	@Override
	public String toString() {
		return "Ingrediant [ingrediantId=" + ingrediantId + ", ingrediantCatId=" + ingrediantCatId + ", ingrediantName="
				+ ingrediantName + ", delStatus=" + delStatus + ", isActive=" + isActive + ", ingrediantImage="
				+ ingrediantImage + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2="
				+ exVar2 + ", exFloat1=" + exFloat1 + ", exFloat2=" + exFloat2 + ", lastOprationDatetime="
				+ lastOprationDatetime + ", ingrediantDesc=" + ingrediantDesc + "]";
	}

	
}
