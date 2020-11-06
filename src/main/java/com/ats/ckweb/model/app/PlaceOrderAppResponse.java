package com.ats.ckweb.model.app;

import com.ats.ckweb.model.Info;

public class PlaceOrderAppResponse {

	private int orderId;
	private String uuidNo;
	private float amt;
	private int payMode;
	private int paidStatus;
	private int orderStatus;
	private Info info;
	private Object paymentResponse;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUuidNo() {
		return uuidNo;
	}

	public void setUuidNo(String uuidNo) {
		this.uuidNo = uuidNo;
	}

	public float getAmt() {
		return amt;
	}

	public void setAmt(float amt) {
		this.amt = amt;
	}

	public int getPayMode() {
		return payMode;
	}

	public void setPayMode(int payMode) {
		this.payMode = payMode;
	}

	public int getPaidStatus() {
		return paidStatus;
	}

	public void setPaidStatus(int paidStatus) {
		this.paidStatus = paidStatus;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public Object getPaymentResponse() {
		return paymentResponse;
	}

	public void setPaymentResponse(Object paymentResponse) {
		this.paymentResponse = paymentResponse;
	}

	@Override
	public String toString() {
		return "PlaceOrderAppResponse [orderId=" + orderId + ", uuidNo=" + uuidNo + ", amt=" + amt + ", payMode="
				+ payMode + ", paidStatus=" + paidStatus + ", orderStatus=" + orderStatus + ", info=" + info
				+ ", paymentResponse=" + paymentResponse + "]";
	}

}
