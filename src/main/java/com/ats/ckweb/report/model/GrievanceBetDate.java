package com.ats.ckweb.report.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GrievanceBetDate {

	
	@Id
	private String id;
	
	private int orderId;
	private String orderNo;
	private Date deliveryDate;
	private int orderPlatform;
	
	private int frId;
	private int custId;
	private float totalAmt;
	
	private int orderUserId; //based on platform it can be cust  or executive id.
	
	private String custName;
	private String phoneNumber;
	private String whatsappNo;
	
	private int grieveId;
	private String grievencceNo;
	private int grievenceTypeId;

	private int grievenceSubtypeId;
	private int grivStatus;

	private Date grivDate;

	private String type;
	private String subType;
	
	private String frName;
	private String frCode;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public int getOrderPlatform() {
		return orderPlatform;
	}
	public void setOrderPlatform(int orderPlatform) {
		this.orderPlatform = orderPlatform;
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
	public float getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}
	public int getOrderUserId() {
		return orderUserId;
	}
	public void setOrderUserId(int orderUserId) {
		this.orderUserId = orderUserId;
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
	public int getGrieveId() {
		return grieveId;
	}
	public void setGrieveId(int grieveId) {
		this.grieveId = grieveId;
	}
	public String getGrievencceNo() {
		return grievencceNo;
	}
	public void setGrievencceNo(String grievencceNo) {
		this.grievencceNo = grievencceNo;
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
	public int getGrivStatus() {
		return grivStatus;
	}
	public void setGrivStatus(int grivStatus) {
		this.grivStatus = grivStatus;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getGrivDate() {
		return grivDate;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setGrivDate(Date grivDate) {
		this.grivDate = grivDate;
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
		return "GrievanceBetDate [id=" + id + ", orderId=" + orderId + ", orderNo=" + orderNo + ", deliveryDate="
				+ deliveryDate + ", orderPlatform=" + orderPlatform + ", frId=" + frId + ", custId=" + custId
				+ ", totalAmt=" + totalAmt + ", orderUserId=" + orderUserId + ", custName=" + custName
				+ ", phoneNumber=" + phoneNumber + ", whatsappNo=" + whatsappNo + ", grieveId=" + grieveId
				+ ", grievencceNo=" + grievencceNo + ", grievenceTypeId=" + grievenceTypeId + ", grievenceSubtypeId="
				+ grievenceSubtypeId + ", grivStatus=" + grivStatus + ", grivDate=" + grivDate + ", type=" + type
				+ ", subType=" + subType + ", frName=" + frName + ", frCode=" + frCode + "]";
	}
	
}
