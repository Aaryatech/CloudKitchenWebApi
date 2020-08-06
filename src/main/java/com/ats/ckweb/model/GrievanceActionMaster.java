package com.ats.ckweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mn_griv_action_suggest")
public class GrievanceActionMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int grivActionId;

	private int grivActionValue;
	private String grivActionText;

	private int extraInt1;
	private int extraInt2;
	private String extraVar1;
	private String extraVar2;

	private int delStatus;
	private int isActive;
	
	public int getGrivActionId() {
		return grivActionId;
	}
	public void setGrivActionId(int grivActionId) {
		this.grivActionId = grivActionId;
	}
	public int getGrivActionValue() {
		return grivActionValue;
	}
	public void setGrivActionValue(int grivActionValue) {
		this.grivActionValue = grivActionValue;
	}
	public String getGrivActionText() {
		return grivActionText;
	}
	public void setGrivActionText(String grivActionText) {
		this.grivActionText = grivActionText;
	}
	public int getExtraInt1() {
		return extraInt1;
	}
	public void setExtraInt1(int extraInt1) {
		this.extraInt1 = extraInt1;
	}
	public int getExtraInt2() {
		return extraInt2;
	}
	public void setExtraInt2(int extraInt2) {
		this.extraInt2 = extraInt2;
	}
	public String getExtraVar1() {
		return extraVar1;
	}
	public void setExtraVar1(String extraVar1) {
		this.extraVar1 = extraVar1;
	}
	public String getExtraVar2() {
		return extraVar2;
	}
	public void setExtraVar2(String extraVar2) {
		this.extraVar2 = extraVar2;
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
	
	@Override
	public String toString() {
		return "GrievanceActionMaster [grivActionId=" + grivActionId + ", grivActionValue=" + grivActionValue
				+ ", grivActionText=" + grivActionText + ", extraInt1=" + extraInt1 + ", extraInt2=" + extraInt2
				+ ", extraVar1=" + extraVar1 + ", extraVar2=" + extraVar2 + ", delStatus=" + delStatus + ", isActive="
				+ isActive + "]";
	}
	
	
	
	

}
