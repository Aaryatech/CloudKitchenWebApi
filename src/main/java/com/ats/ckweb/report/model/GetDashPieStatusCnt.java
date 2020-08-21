package com.ats.ckweb.report.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetDashPieStatusCnt {
	@Id
	private String id;
	private int orderStatusCnt;
	private int orderStatus;
	private int exInt1;
	private int exInt2;
	private String statusName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOrderStatusCnt() {
		return orderStatusCnt;
	}
	public void setOrderStatusCnt(int orderStatusCnt) {
		this.orderStatusCnt = orderStatusCnt;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getExInt1() {
		return exInt1;
	}
	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}
	public int getExInt2() {
		return exInt2;
	}
	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	@Override
	public String toString() {
		return "GetDashPieStatusCnt [id=" + id + ", orderStatusCnt=" + orderStatusCnt + ", orderStatus=" + orderStatus
				+ ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", statusName=" + statusName + "]";
	}
	
}
