package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemWiseOfferData {

	@Id
	private int offerDetailId;
	private int offerId;
	private String offerName;
	private String offerDesc;
	private int type;
	private int applicableFor;
	private int offerType;
	private int frequencyType;
	private String frequency;
	private String fromDate;
	private String toDate;
	private String fromTime;
	private String toTime;
	private int offerSubType;
	private int primaryItemId;
	private String primaryItemName;
	private int primaryQty;
	private float discPer;
	private float offerLimit;
	private String couponCode;
	private int secondaryItemId;
	private String secondaryItemName;
	private float secondaryQty;

	public int getOfferDetailId() {
		return offerDetailId;
	}

	public void setOfferDetailId(int offerDetailId) {
		this.offerDetailId = offerDetailId;
	}

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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getApplicableFor() {
		return applicableFor;
	}

	public void setApplicableFor(int applicableFor) {
		this.applicableFor = applicableFor;
	}

	public int getOfferType() {
		return offerType;
	}

	public void setOfferType(int offerType) {
		this.offerType = offerType;
	}

	public int getFrequencyType() {
		return frequencyType;
	}

	public void setFrequencyType(int frequencyType) {
		this.frequencyType = frequencyType;
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

	public int getOfferSubType() {
		return offerSubType;
	}

	public void setOfferSubType(int offerSubType) {
		this.offerSubType = offerSubType;
	}

	public int getPrimaryItemId() {
		return primaryItemId;
	}

	public void setPrimaryItemId(int primaryItemId) {
		this.primaryItemId = primaryItemId;
	}

	public String getPrimaryItemName() {
		return primaryItemName;
	}

	public void setPrimaryItemName(String primaryItemName) {
		this.primaryItemName = primaryItemName;
	}

	public int getPrimaryQty() {
		return primaryQty;
	}

	public void setPrimaryQty(int primaryQty) {
		this.primaryQty = primaryQty;
	}

	public float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}

	public float getOfferLimit() {
		return offerLimit;
	}

	public void setOfferLimit(float offerLimit) {
		this.offerLimit = offerLimit;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public int getSecondaryItemId() {
		return secondaryItemId;
	}

	public void setSecondaryItemId(int secondaryItemId) {
		this.secondaryItemId = secondaryItemId;
	}

	public String getSecondaryItemName() {
		return secondaryItemName;
	}

	public void setSecondaryItemName(String secondaryItemName) {
		this.secondaryItemName = secondaryItemName;
	}

	public float getSecondaryQty() {
		return secondaryQty;
	}

	public void setSecondaryQty(float secondaryQty) {
		this.secondaryQty = secondaryQty;
	}

	@Override
	public String toString() {
		return "ItemWiseOfferData [offerDetailId=" + offerDetailId + ", offerId=" + offerId + ", offerName=" + offerName
				+ ", offerDesc=" + offerDesc + ", type=" + type + ", applicableFor=" + applicableFor + ", offerType="
				+ offerType + ", frequencyType=" + frequencyType + ", frequency=" + frequency + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", fromTime=" + fromTime + ", toTime=" + toTime + ", offerSubType="
				+ offerSubType + ", primaryItemId=" + primaryItemId + ", primaryItemName=" + primaryItemName
				+ ", primaryQty=" + primaryQty + ", discPer=" + discPer + ", offerLimit=" + offerLimit + ", couponCode="
				+ couponCode + ", secondaryItemId=" + secondaryItemId + ", secondaryItemName=" + secondaryItemName
				+ ", secondaryQty=" + secondaryQty + "]";
	}

}
