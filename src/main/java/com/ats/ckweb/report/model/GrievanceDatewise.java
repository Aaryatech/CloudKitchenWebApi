package com.ats.ckweb.report.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


//Sachin 13-08-2020
	// Desc-Bean for  Griv Report Date wise

@Entity
public class GrievanceDatewise {

	
	@Id
	private String id;
	
	private Date deliveryDate;
	
	private float totalAmt;
	
	private int grivCount;
	
	private String filterName; //ie fr name/grievance type/grievance sub type name
	
	private float ePay; //take it 0 by default. Sumit Sir call
	private float cashPay; //take it 0 by default.Sumit Sir call
	
	
	
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
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public float getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}
	public int getGrivCount() {
		return grivCount;
	}
	public void setGrivCount(int grivCount) {
		this.grivCount = grivCount;
	}
	public String getFilterName() {
		return filterName;
	}
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	public float getePay() {
		return ePay;
	}
	public void setePay(float ePay) {
		this.ePay = ePay;
	}
	public float getCashPay() {
		return cashPay;
	}
	public void setCashPay(float cashPay) {
		this.cashPay = cashPay;
	}

	@Override
	public String toString() {
		return "GrievanceDatewise [id=" + id + ", deliveryDate=" + deliveryDate + ", totalAmt=" + totalAmt
				+ ", grivCount=" + grivCount + ", filterName=" + filterName + ", ePay=" + ePay + ", cashPay=" + cashPay
				+ "]";
	}
	
}
