package com.ats.ckweb.model.app;

public class PaymentGatewayParam {

	String orderId;
	String orderAmount;
	String orderCurrency;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderCurrency() {
		return orderCurrency;
	}

	public void setOrderCurrency(String orderCurrency) {
		this.orderCurrency = orderCurrency;
	}

	@Override
	public String toString() {
		return "PaymentGatewayParam [orderId=" + orderId + ", orderAmount=" + orderAmount + ", orderCurrency="
				+ orderCurrency + "]";
	}

}
