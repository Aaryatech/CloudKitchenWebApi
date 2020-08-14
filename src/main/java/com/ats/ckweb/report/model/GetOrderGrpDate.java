package com.ats.ckweb.report.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetOrderGrpDate {
	
	@Id
	private String id;
	private Date deliveryDate;
	private float totalAmt;
	private int orderCnt;
	private String monthName;
	private int monthNo;
	private int yearVal;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public float getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}
	public int getOrderCnt() {
		return orderCnt;
	}
	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	public int getMonthNo() {
		return monthNo;
	}
	public void setMonthNo(int monthNo) {
		this.monthNo = monthNo;
	}
	public int getYearVal() {
		return yearVal;
	}
	public void setYearVal(int yearVal) {
		this.yearVal = yearVal;
	}
	@Override
	public String toString() {
		return "GetOrderGrpDate [id=" + id + ", deliveryDate=" + deliveryDate + ", totalAmt=" + totalAmt + ", orderCnt="
				+ orderCnt + ", monthName=" + monthName + ", monthNo=" + monthNo + ", yearVal=" + yearVal + "]";
	}
	

	
}
