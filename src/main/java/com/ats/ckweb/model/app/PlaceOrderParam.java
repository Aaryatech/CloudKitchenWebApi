package com.ats.ckweb.model.app;

import java.util.List;

public class PlaceOrderParam {

	int frId;
	int custId;
	int applicableFor;
	int orderStatus;
	int payMode;
	int paidStatus;
	int cityId;
	int addressId;
	String address;
	String deliveryDate;
	String deliveryTime;
	int orderPlatform;
	int offerId;
	String gst;
	String coupon;
	float wallet;
	int deliveryType;
	int deliveryInstructionId;
	String deliveryInstructionText;
	float km;
	float deliveryCharges;
	float itemTotal;
	float discAmt;

	List<PlaceOrderDetailParam> orderDetailParamList;

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getApplicableFor() {
		return applicableFor;
	}

	public void setApplicableFor(int applicableFor) {
		this.applicableFor = applicableFor;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
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

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public int getOrderPlatform() {
		return orderPlatform;
	}

	public void setOrderPlatform(int orderPlatform) {
		this.orderPlatform = orderPlatform;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public float getWallet() {
		return wallet;
	}

	public void setWallet(float wallet) {
		this.wallet = wallet;
	}

	public int getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(int deliveryType) {
		this.deliveryType = deliveryType;
	}

	public int getDeliveryInstructionId() {
		return deliveryInstructionId;
	}

	public void setDeliveryInstructionId(int deliveryInstructionId) {
		this.deliveryInstructionId = deliveryInstructionId;
	}

	public String getDeliveryInstructionText() {
		return deliveryInstructionText;
	}

	public void setDeliveryInstructionText(String deliveryInstructionText) {
		this.deliveryInstructionText = deliveryInstructionText;
	}

	public float getKm() {
		return km;
	}

	public void setKm(float km) {
		this.km = km;
	}

	public float getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(float deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	public float getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(float itemTotal) {
		this.itemTotal = itemTotal;
	}

	public float getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}

	public List<PlaceOrderDetailParam> getOrderDetailParamList() {
		return orderDetailParamList;
	}

	public void setOrderDetailParamList(List<PlaceOrderDetailParam> orderDetailParamList) {
		this.orderDetailParamList = orderDetailParamList;
	}

	@Override
	public String toString() {
		return "PlaceOrderParam [frId=" + frId + ", custId=" + custId + ", applicableFor=" + applicableFor
				+ ", orderStatus=" + orderStatus + ", payMode=" + payMode + ", paidStatus=" + paidStatus + ", cityId="
				+ cityId + ", addressId=" + addressId + ", address=" + address + ", deliveryDate=" + deliveryDate
				+ ", deliveryTime=" + deliveryTime + ", orderPlatform=" + orderPlatform + ", offerId=" + offerId
				+ ", gst=" + gst + ", coupon=" + coupon + ", wallet=" + wallet + ", deliveryType=" + deliveryType
				+ ", deliveryInstructionId=" + deliveryInstructionId + ", deliveryInstructionText="
				+ deliveryInstructionText + ", km=" + km + ", deliveryCharges=" + deliveryCharges + ", itemTotal="
				+ itemTotal + ", discAmt=" + discAmt + ", orderDetailParamList=" + orderDetailParamList + "]";
	}

}
