package com.ats.ckweb.report.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetGrievanceCntByType {

	@Id
	private String id;
	private int grievCnt;
	private int grevTypeId;
	private int grieveId;
	private int grievenceTypeId;
	private String frName;
	private String caption;
	private int frId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGrievCnt() {
		return grievCnt;
	}
	public void setGrievCnt(int grievCnt) {
		this.grievCnt = grievCnt;
	}
	public int getGrevTypeId() {
		return grevTypeId;
	}
	public void setGrevTypeId(int grevTypeId) {
		this.grevTypeId = grevTypeId;
	}
	public int getGrieveId() {
		return grieveId;
	}
	public void setGrieveId(int grieveId) {
		this.grieveId = grieveId;
	}
	public int getGrievenceTypeId() {
		return grievenceTypeId;
	}
	public void setGrievenceTypeId(int grievenceTypeId) {
		this.grievenceTypeId = grievenceTypeId;
	}
	public String getFrName() {
		return frName;
	}
	public void setFrName(String frName) {
		this.frName = frName;
	}
	public int getFrId() {
		return frId;
	}
	public void setFrId(int frId) {
		this.frId = frId;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	@Override
	public String toString() {
		return "GetGrievanceCntByType [id=" + id + ", grievCnt=" + grievCnt + ", grevTypeId=" + grevTypeId
				+ ", grieveId=" + grieveId + ", grievenceTypeId=" + grievenceTypeId + ", frName=" + frName
				+ ", caption=" + caption + ", frId=" + frId + "]";
	}
	
	
	
}
