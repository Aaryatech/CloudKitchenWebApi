package com.ats.ckweb.report.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GrievanceDetailDash {
	@Id
	private String id;
	private int orderId;
	private String grievencceNo;
	private Date date;
	private String custName;
	private String orderNo;
	private float orderAmt;
	private int isSet;
	private int currentStatus;
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
	public String getGrievencceNo() {
		return grievencceNo;
	}
	public void setGrievencceNo(String grievencceNo) {
		this.grievencceNo = grievencceNo;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public float getOrderAmt() {
		return orderAmt;
	}
	public void setOrderAmt(float orderAmt) {
		this.orderAmt = orderAmt;
	}
	
	
	public int getIsSet() {
		return isSet;
	}
	public void setIsSet(int isSet) {
		this.isSet = isSet;
	}
	public int getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(int currentStatus) {
		this.currentStatus = currentStatus;
	}
	@Override
	public String toString() {
		return "GrievanceDetailDash [id=" + id + ", orderId=" + orderId + ", grievencceNo=" + grievencceNo + ", date="
				+ date + ", custName=" + custName + ", orderNo=" + orderNo + ", orderAmt=" + orderAmt + ", isSet="
				+ isSet + ", currentStatus=" + currentStatus + "]";
	}
	
	
}
