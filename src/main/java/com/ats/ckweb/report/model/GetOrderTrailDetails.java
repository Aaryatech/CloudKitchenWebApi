package com.ats.ckweb.report.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class GetOrderTrailDetails {
	@Id
	private int orderId;
	private String orderNo;
	private Date orderDate;
	private Date deliveryDate;
	private String deliveryTime;
	private String orderStatus;
	private int totalAmt;
	private int paymentMethod;
	private String frName;
	private String frCode;
	private String custName;
	private String phoneNumber;
    private float taxableAmt;
    private float taxAmt;
    private float deliveryCharges;
    private int orderType;
    private int trailId;
    private int status;
    private int actionByUserId;
    private String trailDateTime;
    private String trailUserName;
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
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(int totalAmt) {
		this.totalAmt = totalAmt;
	}
	public int getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
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
	public float getTaxableAmt() {
		return taxableAmt;
	}
	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}
	public float getTaxAmt() {
		return taxAmt;
	}
	public void setTaxAmt(float taxAmt) {
		this.taxAmt = taxAmt;
	}
	public float getDeliveryCharges() {
		return deliveryCharges;
	}
	public void setDeliveryCharges(float deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	
	public int getTrailId() {
		return trailId;
	}
	public void setTrailId(int trailId) {
		this.trailId = trailId;
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
	public String getTrailDateTime() {
		return trailDateTime;
	}
	public void setTrailDateTime(String trailDateTime) {
		this.trailDateTime = trailDateTime;
	}
	
	public String getTrailUserName() {
		return trailUserName;
	}
	public void setTrailUserName(String trailUserName) {
		this.trailUserName = trailUserName;
	}
	@Override
	public String toString() {
		return "GetOrderDetails [orderId=" + orderId + ", orderNo=" + orderNo + ", orderDate=" + orderDate
				+ ", deliveryDate=" + deliveryDate + ", deliveryTime=" + deliveryTime + ", orderStatus=" + orderStatus
				+ ", totalAmt=" + totalAmt + ", paymentMethod=" + paymentMethod + ", frName=" + frName + ", frCode="
				+ frCode + ", custName=" + custName + ", phoneNumber=" + phoneNumber + ", taxableAmt=" + taxableAmt
				+ ", taxAmt=" + taxAmt + ", deliveryCharges=" + deliveryCharges + ", orderType=" + orderType
				+ ", trailId=" + trailId + ", status=" + status + ", actionByUserId=" + actionByUserId
				+ ", trailDateTime=" + trailDateTime + ", trailUserName=" + trailUserName + "]";
	}
    
}
