package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FrWiseGrievenceReportData {

	@Id
	private String id;
	private int grieveId;
	private String grieveDate;
	private float frAffectAmt;
	private int frId;
	private String frName;
	private float dr;
	private float cr;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getGrieveId() {
		return grieveId;
	}

	public void setGrieveId(int grieveId) {
		this.grieveId = grieveId;
	}

	public String getGrieveDate() {
		return grieveDate;
	}

	public void setGrieveDate(String grieveDate) {
		this.grieveDate = grieveDate;
	}

	public float getFrAffectAmt() {
		return frAffectAmt;
	}

	public void setFrAffectAmt(float frAffectAmt) {
		this.frAffectAmt = frAffectAmt;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public float getDr() {
		return dr;
	}

	public void setDr(float dr) {
		this.dr = dr;
	}

	public float getCr() {
		return cr;
	}

	public void setCr(float cr) {
		this.cr = cr;
	}

	@Override
	public String toString() {
		return "FrWiseGrievenceReportData [id=" + id + ", grieveId=" + grieveId + ", grieveDate=" + grieveDate
				+ ", frAffectAmt=" + frAffectAmt + ", frId=" + frId + ", frName=" + frName + ", dr=" + dr + ", cr=" + cr
				+ "]";
	}

}
