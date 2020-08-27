package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FrWiseOrderReportData {

	@Id
	private String id;
	private int orderId;
	private String orderDate;
	private float orderAmt;
	private int frId;
	private String frName;
	private float cash;
	private float online;
	private float frToComp;
	private float compToFr;

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

	public float getCash() {
		return cash;
	}

	public void setCash(float cash) {
		this.cash = cash;
	}

	public float getOnline() {
		return online;
	}

	public void setOnline(float online) {
		this.online = online;
	}


	public float getFrToComp() {
		return frToComp;
	}

	public void setFrToComp(float frToComp) {
		this.frToComp = frToComp;
	}

	public float getCompToFr() {
		return compToFr;
	}

	public void setCompToFr(float compToFr) {
		this.compToFr = compToFr;
	}

	@Override
	public String toString() {
		return "FrWiseOrderReportData [id=" + id + ", orderId=" + orderId + ", orderDate=" + orderDate + ", orderAmt="
				+ orderAmt + ", frId=" + frId + ", frName=" + frName + ", cash=" + cash + ", online=" + online
				+ ", frToComp=" + frToComp + ", compToFr=" + compToFr + "]";
	}

	
}
