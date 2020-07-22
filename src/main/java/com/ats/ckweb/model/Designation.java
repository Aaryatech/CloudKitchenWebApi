package com.ats.ckweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mn_designation")
public class Designation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "designation_id")
	private int designationId;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "is_active")
	private int isActive;

	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "ex_int1")
	private int eInt1;
	
	@Column(name = "ex_int2")
	private int exInt2;
	
	@Column(name = "ex_var1")
	private String exVar1;
	
	@Column(name = "ex_var2")
	private String exVar2;

	public int getDesignationId() {
		return designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int geteInt1() {
		return eInt1;
	}

	public void seteInt1(int eInt1) {
		this.eInt1 = eInt1;
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

	@Override
	public String toString() {
		return "Designation [designationId=" + designationId + ", designation=" + designation + ", isActive=" + isActive
				+ ", delStatus=" + delStatus + ", eInt1=" + eInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1
				+ ", exVar2=" + exVar2 + "]";
	}
	
}
