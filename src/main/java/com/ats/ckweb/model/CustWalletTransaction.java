package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustWalletTransaction {

	@Id
	private int walletId;
	private int orderId;
	private String orderNo;
	private String orderDate;
	private float totalAmt;
	private float amount;
	private String walletDate;
	private String transcType;
	private String billNo;

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
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

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public float getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getWalletDate() {
		return walletDate;
	}

	public void setWalletDate(String walletDate) {
		this.walletDate = walletDate;
	}

	public String getTranscType() {
		return transcType;
	}

	public void setTranscType(String transcType) {
		this.transcType = transcType;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	@Override
	public String toString() {
		return "CustWalletTransaction [walletId=" + walletId + ", orderId=" + orderId + ", orderNo=" + orderNo
				+ ", orderDate=" + orderDate + ", totalAmt=" + totalAmt + ", amount=" + amount + ", walletDate="
				+ walletDate + ", transcType=" + transcType + ", billNo=" + billNo + "]";
	}

}
