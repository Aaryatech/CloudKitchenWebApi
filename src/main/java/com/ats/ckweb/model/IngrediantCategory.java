package com.ats.ckweb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mn_ingrediant_category")
public class IngrediantCategory implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="ingrediant_cat_id")
	private int ingrediantCatId;
	
	@Column(name="ingrediant_cat_name")
	private String ingrediantCatName;
	
	@Column(name="ingrediant_cat_desc")
	private String ingrediantCatDesc;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="ingrediant_cat_image")
	private String ingrediantCatImage;
	
	@Column(name="ex_int1")
	private int exInt1;
	
	@Column(name="ex_int2")
	private int exInt2;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_var2")
	private String exVar2;
	
	@Column(name="sequence_number")
	private float sequenceNumber;

	public int getIngrediantCatId() {
		return ingrediantCatId;
	}

	public void setIngrediantCatId(int ingrediantCatId) {
		this.ingrediantCatId = ingrediantCatId;
	}

	public String getIngrediantCatName() {
		return ingrediantCatName;
	}

	public void setIngrediantCatName(String ingrediantCatName) {
		this.ingrediantCatName = ingrediantCatName;
	}

	public String getIngrediantCatDesc() {
		return ingrediantCatDesc;
	}

	public void setIngrediantCatDesc(String ingrediantCatDesc) {
		this.ingrediantCatDesc = ingrediantCatDesc;
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

	public String getIngrediantCatImage() {
		return ingrediantCatImage;
	}

	public void setIngrediantCatImage(String ingrediantCatImage) {
		this.ingrediantCatImage = ingrediantCatImage;
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

	public float getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(float sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	@Override
	public String toString() {
		return "IngrediantCategory [ingrediantCatId=" + ingrediantCatId + ", ingrediantCatName=" + ingrediantCatName
				+ ", ingrediantCatDesc=" + ingrediantCatDesc + ", delStatus=" + delStatus + ", isActive=" + isActive
				+ ", ingrediantCatImage=" + ingrediantCatImage + ", exInt1=" + exInt1 + ", exInt2=" + exInt2
				+ ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", sequenceNumber=" + sequenceNumber + "]";
	}
	
	
}
