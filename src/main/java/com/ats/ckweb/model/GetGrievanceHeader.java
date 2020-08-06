package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;


//Sachin 2020-08-06
//Desc- To Show Grievance List at Admin end.

@Entity
public class GetGrievanceHeader {

	@Id
	private int grieveId;

	private int orderId;
	
	private int grievenceTypeId;

	private int grievenceSubtypeId;

	private String remark;

	private int currentStatus;

	private String insertDateTime;

	private String insertUserName;
	

	private String date;

	private String extraVar1;

	private String extraVar2;
	
	private int platform;
	
	private String grievencceNo;
	
	private String orderNo;
	private String orderDate;
	private int frId;
	private int custId;
	
	private String custName;
	private String phoneNumber;
	private String whatsappNo;
	
	private String type;
	private String subType;
	
	private String frName;
	private String frCode;
	
	
	
	public int getGrieveId() {
		return grieveId;
	}
	public void setGrieveId(int grieveId) {
		this.grieveId = grieveId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getGrievenceTypeId() {
		return grievenceTypeId;
	}
	public void setGrievenceTypeId(int grievenceTypeId) {
		this.grievenceTypeId = grievenceTypeId;
	}
	public int getGrievenceSubtypeId() {
		return grievenceSubtypeId;
	}
	public void setGrievenceSubtypeId(int grievenceSubtypeId) {
		this.grievenceSubtypeId = grievenceSubtypeId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(int currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getInsertDateTime() {
		return insertDateTime;
	}
	public void setInsertDateTime(String insertDateTime) {
		this.insertDateTime = insertDateTime;
	}
	public String getInsertUserName() {
		return insertUserName;
	}
	public void setInsertUserName(String insertUserName) {
		this.insertUserName = insertUserName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public int getPlatform() {
		return platform;
	}
	public void setPlatform(int platform) {
		this.platform = platform;
	}
	public String getGrievencceNo() {
		return grievencceNo;
	}
	public void setGrievencceNo(String grievencceNo) {
		this.grievencceNo = grievencceNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getFrId() {
		return frId;
	}
	public void setFrId(int frId) {
		this.frId = frId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getWhatsappNo() {
		return whatsappNo;
	}
	public void setWhatsappNo(String whatsappNo) {
		this.whatsappNo = whatsappNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public String getFrName() {
		return frName;
	}
	public void setFrName(String frName) {
		this.frName = frName;
	}
	public String getFrCode() {
		return frCode;
	}
	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}
	
	@Override
	public String toString() {
		return "GetGrievanceHeader [grieveId=" + grieveId + ", orderId=" + orderId + ", grievenceTypeId="
				+ grievenceTypeId + ", grievenceSubtypeId=" + grievenceSubtypeId + ", remark=" + remark
				+ ", currentStatus=" + currentStatus + ", insertDateTime=" + insertDateTime + ", insertUserName="
				+ insertUserName + ", date=" + date + ", extraVar1=" + extraVar1 + ", extraVar2=" + extraVar2
				+ ", platform=" + platform + ", grievencceNo=" + grievencceNo + ", orderNo=" + orderNo + ", orderDate="
				+ orderDate + ", frId=" + frId + ", custId=" + custId + ", custName=" + custName + ", phoneNumber="
				+ phoneNumber + ", whatsappNo=" + whatsappNo + ", type=" + type + ", subType=" + subType + ", frName="
				+ frName + ", frCode=" + frCode + "]";
	}
	
}
