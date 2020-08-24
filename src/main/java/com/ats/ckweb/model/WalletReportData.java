package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WalletReportData {
	
	@Id
	private int orderId;
	private String orderNo;
	private String orderDate;
	private float orderAmt;
	private float drAmt;
	private float crAmt;
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
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public float getOrderAmt() {
		return orderAmt;
	}
	public void setOrderAmt(float orderAmt) {
		this.orderAmt = orderAmt;
	}
	public float getDrAmt() {
		return drAmt;
	}
	public void setDrAmt(float drAmt) {
		this.drAmt = drAmt;
	}
	public float getCrAmt() {
		return crAmt;
	}
	public void setCrAmt(float crAmt) {
		this.crAmt = crAmt;
	}
	@Override
	public String toString() {
		return "WalletReportData [orderId=" + orderId + ", orderNo=" + orderNo + ", orderDate=" + orderDate
				+ ", orderAmt=" + orderAmt + ", drAmt=" + drAmt + ", crAmt=" + crAmt + "]";
	}

	
	

}
