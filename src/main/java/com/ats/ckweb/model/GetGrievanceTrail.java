package com.ats.ckweb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

//Sachin 2020-08-07
//Desc- To Show Grievance Trail  List at Admin end.

@Entity
public class GetGrievanceTrail {

	@Id
	private int trailId;

	private int grievencesId;
	private String remark;
	private int status;

	private int actionByUserId;
	private Date actionDateTime;
 

	private String extraVar1;
	private String extraVar2;
	
	private String identifiedRootCause;
	private int grievenceResType;
	private String resolutionDetail;
	private float repayAmt;
	private String repayDetails;
	private String actionByUserName;
	
	private String grivActionText;
	private int grivActionValue;
	public int getTrailId() {
		return trailId;
	}
	public void setTrailId(int trailId) {
		this.trailId = trailId;
	}
	public int getGrievencesId() {
		return grievencesId;
	}
	public void setGrievencesId(int grievencesId) {
		this.grievencesId = grievencesId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getActionByUserId() {
		return actionByUserId;
	}
	public void setActionByUserId(int actionByUserId) {
		this.actionByUserId = actionByUserId;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy HH:mm:ss")
	public Date getActionDateTime() {
		return actionDateTime;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy HH:mm:ss")
	public void setActionDateTime(Date actionDateTime) {
		this.actionDateTime = actionDateTime;
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
	public String getIdentifiedRootCause() {
		return identifiedRootCause;
	}
	public void setIdentifiedRootCause(String identifiedRootCause) {
		this.identifiedRootCause = identifiedRootCause;
	}
	public int getGrievenceResType() {
		return grievenceResType;
	}
	public void setGrievenceResType(int grievenceResType) {
		this.grievenceResType = grievenceResType;
	}
	public String getResolutionDetail() {
		return resolutionDetail;
	}
	public void setResolutionDetail(String resolutionDetail) {
		this.resolutionDetail = resolutionDetail;
	}
	public float getRepayAmt() {
		return repayAmt;
	}
	public void setRepayAmt(float repayAmt) {
		this.repayAmt = repayAmt;
	}
	public String getRepayDetails() {
		return repayDetails;
	}
	public void setRepayDetails(String repayDetails) {
		this.repayDetails = repayDetails;
	}
	public String getActionByUserName() {
		return actionByUserName;
	}
	public void setActionByUserName(String actionByUserName) {
		this.actionByUserName = actionByUserName;
	}
	public String getGrivActionText() {
		return grivActionText;
	}
	public void setGrivActionText(String grivActionText) {
		this.grivActionText = grivActionText;
	}
	public int getGrivActionValue() {
		return grivActionValue;
	}
	public void setGrivActionValue(int grivActionValue) {
		this.grivActionValue = grivActionValue;
	}
	@Override
	public String toString() {
		return "GetGrievanceTrail [trailId=" + trailId + ", grievencesId=" + grievencesId + ", remark=" + remark
				+ ", status=" + status + ", actionByUserId=" + actionByUserId + ", actionDateTime=" + actionDateTime
				+ ", extraVar1=" + extraVar1 + ", extraVar2=" + extraVar2 + ", identifiedRootCause="
				+ identifiedRootCause + ", grievenceResType=" + grievenceResType + ", resolutionDetail="
				+ resolutionDetail + ", repayAmt=" + repayAmt + ", repayDetails=" + repayDetails + ", actionByUserName="
				+ actionByUserName + ", grivActionText=" + grivActionText + ", grivActionValue=" + grivActionValue
				+ "]";
	}
	
	
	
	
}
