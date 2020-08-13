package com.ats.ckweb.report.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetGroupByReportData {

	@Id
	private String uId;

	private int frId;
	private String frName;
	private int custId;
	private String custName;
	private int orderComingFromId;
	private String orderComingFromName;
	private int payModeId;
	private String payModeName;
	private String deliveryDate;
	private String deliveryDateDisp;
	private int deliveryMonth;
	private int deliveryYear;
	private String monthName;
	private float totalAmt;
	private String statusList;
	private int orderCount;

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
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

	public int getOrderComingFromId() {
		return orderComingFromId;
	}

	public void setOrderComingFromId(int orderComingFromId) {
		this.orderComingFromId = orderComingFromId;
	}

	public String getOrderComingFromName() {
		return orderComingFromName;
	}

	public void setOrderComingFromName(String orderComingFromName) {
		this.orderComingFromName = orderComingFromName;
	}

	public int getPayModeId() {
		return payModeId;
	}

	public void setPayModeId(int payModeId) {
		this.payModeId = payModeId;
	}

	public String getPayModeName() {
		return payModeName;
	}

	public void setPayModeName(String payModeName) {
		this.payModeName = payModeName;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryDateDisp() {
		return deliveryDateDisp;
	}

	public void setDeliveryDateDisp(String deliveryDateDisp) {
		this.deliveryDateDisp = deliveryDateDisp;
	}

	public int getDeliveryMonth() {
		return deliveryMonth;
	}

	public void setDeliveryMonth(int deliveryMonth) {
		this.deliveryMonth = deliveryMonth;
	}

	public int getDeliveryYear() {
		return deliveryYear;
	}

	public void setDeliveryYear(int deliveryYear) {
		this.deliveryYear = deliveryYear;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public float getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getStatusList() {
		return statusList;
	}

	public void setStatusList(String statusList) {
		this.statusList = statusList;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	@Override
	public String toString() {
		return "GetGroupByReportData [uId=" + uId + ", frId=" + frId + ", frName=" + frName + ", custId=" + custId
				+ ", custName=" + custName + ", orderComingFromId=" + orderComingFromId + ", orderComingFromName="
				+ orderComingFromName + ", payModeId=" + payModeId + ", payModeName=" + payModeName + ", deliveryDate="
				+ deliveryDate + ", deliveryDateDisp=" + deliveryDateDisp + ", deliveryMonth=" + deliveryMonth
				+ ", deliveryYear=" + deliveryYear + ", monthName=" + monthName + ", totalAmt=" + totalAmt
				+ ", statusList=" + statusList + ", orderCount=" + orderCount + "]";
	}

}
