package com.ats.ckweb.report.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OfferReport {

	@Id
	private int offerId;
	private String offerName;
	private String offerDesc;
	private String offerDate;
	private int type;
	private String typeText;
	private String applicableFor;
	private int offerType;
	private String offerTypeText;
	private int subType;
	private String subTypeText;
	private int frequencyType;
	private String frequencyTypeText;
	private String frequency;
	private String fromDate;
	private String toDate;
	private String fromTime;
	private String toTime;
	private int totalUsed;
	private float grandTotal;
	private float discAmt;
	private float payableAmt;
	private float deliveryAmt;
	private float walletAmt;
	private float billTotal;

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getOfferDesc() {
		return offerDesc;
	}

	public void setOfferDesc(String offerDesc) {
		this.offerDesc = offerDesc;
	}

	public String getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(String offerDate) {
		this.offerDate = offerDate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTypeText() {
		return typeText;
	}

	public void setTypeText(String typeText) {
		this.typeText = typeText;
	}

	public String getApplicableFor() {
		return applicableFor;
	}

	public void setApplicableFor(String applicableFor) {
		this.applicableFor = applicableFor;
	}

	public int getOfferType() {
		return offerType;
	}

	public void setOfferType(int offerType) {
		this.offerType = offerType;
	}

	public String getOfferTypeText() {
		return offerTypeText;
	}

	public void setOfferTypeText(String offerTypeText) {
		this.offerTypeText = offerTypeText;
	}

	public int getSubType() {
		return subType;
	}

	public void setSubType(int subType) {
		this.subType = subType;
	}

	public String getSubTypeText() {
		return subTypeText;
	}

	public void setSubTypeText(String subTypeText) {
		this.subTypeText = subTypeText;
	}

	public int getFrequencyType() {
		return frequencyType;
	}

	public void setFrequencyType(int frequencyType) {
		this.frequencyType = frequencyType;
	}

	public String getFrequencyTypeText() {
		return frequencyTypeText;
	}

	public void setFrequencyTypeText(String frequencyTypeText) {
		this.frequencyTypeText = frequencyTypeText;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	public int getTotalUsed() {
		return totalUsed;
	}

	public void setTotalUsed(int totalUsed) {
		this.totalUsed = totalUsed;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public float getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}

	public float getPayableAmt() {
		return payableAmt;
	}

	public void setPayableAmt(float payableAmt) {
		this.payableAmt = payableAmt;
	}

	public float getDeliveryAmt() {
		return deliveryAmt;
	}

	public void setDeliveryAmt(float deliveryAmt) {
		this.deliveryAmt = deliveryAmt;
	}

	public float getWalletAmt() {
		return walletAmt;
	}

	public void setWalletAmt(float walletAmt) {
		this.walletAmt = walletAmt;
	}

	public float getBillTotal() {
		return billTotal;
	}

	public void setBillTotal(float billTotal) {
		this.billTotal = billTotal;
	}

	@Override
	public String toString() {
		return "OfferReport [offerId=" + offerId + ", offerName=" + offerName + ", offerDesc=" + offerDesc
				+ ", offerDate=" + offerDate + ", type=" + type + ", typeText=" + typeText + ", applicableFor="
				+ applicableFor + ", offerType=" + offerType + ", offerTypeText=" + offerTypeText + ", subType="
				+ subType + ", subTypeText=" + subTypeText + ", frequencyType=" + frequencyType + ", frequencyTypeText="
				+ frequencyTypeText + ", frequency=" + frequency + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", fromTime=" + fromTime + ", toTime=" + toTime + ", totalUsed=" + totalUsed + ", grandTotal="
				+ grandTotal + ", discAmt=" + discAmt + ", payableAmt=" + payableAmt + ", deliveryAmt=" + deliveryAmt
				+ ", walletAmt=" + walletAmt + ", billTotal=" + billTotal + "]";
	}

}
