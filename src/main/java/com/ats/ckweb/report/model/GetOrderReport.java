package com.ats.ckweb.report.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetOrderReport {
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
	private int exInt1;
	private int exInt2;
    private int exInt3;
    private int exInt4;
    private String exVar1;
    private String exVar2;
    private String exVar3;
    private String exVar4;
    private float exFloat1;
    private float exFloat2;
    private float exFloat3;
    private float exFloat4;
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
	public int getExInt3() {
		return exInt3;
	}
	public void setExInt3(int exInt3) {
		this.exInt3 = exInt3;
	}
	public int getExInt4() {
		return exInt4;
	}
	public void setExInt4(int exInt4) {
		this.exInt4 = exInt4;
	}
	public String getExVar1() {
		return exVar1;
	}
	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}
	public String getExVar2() {
		return exVar2;
	}
	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}
	public String getExVar3() {
		return exVar3;
	}
	public void setExVar3(String exVar3) {
		this.exVar3 = exVar3;
	}
	public String getExVar4() {
		return exVar4;
	}
	public void setExVar4(String exVar4) {
		this.exVar4 = exVar4;
	}
	public float getExFloat1() {
		return exFloat1;
	}
	public void setExFloat1(float exFloat1) {
		this.exFloat1 = exFloat1;
	}
	public float getExFloat2() {
		return exFloat2;
	}
	public void setExFloat2(float exFloat2) {
		this.exFloat2 = exFloat2;
	}
	public float getExFloat3() {
		return exFloat3;
	}
	public void setExFloat3(float exFloat3) {
		this.exFloat3 = exFloat3;
	}
	public float getExFloat4() {
		return exFloat4;
	}
	public void setExFloat4(float exFloat4) {
		this.exFloat4 = exFloat4;
	}
	@Override
	public String toString() {
		return "GetOrderReport [orderId=" + orderId + ", orderNo=" + orderNo + ", orderDate=" + orderDate
				+ ", deliveryDate=" + deliveryDate + ", deliveryTime=" + deliveryTime + ", orderStatus=" + orderStatus
				+ ", totalAmt=" + totalAmt + ", paymentMethod=" + paymentMethod + ", frName=" + frName + ", frCode="
				+ frCode + ", custName=" + custName + ", phoneNumber=" + phoneNumber + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exInt3=" + exInt3 + ", exInt4=" + exInt4 + ", exVar1=" + exVar1
				+ ", exVar2=" + exVar2 + ", exVar3=" + exVar3 + ", exVar4=" + exVar4 + ", exFloat1=" + exFloat1
				+ ", exFloat2=" + exFloat2 + ", exFloat3=" + exFloat3 + ", exFloat4=" + exFloat4 + "]";
	}

	
}
