package com.ats.ckweb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

public class ItemWiseOfferHeaderDisplay {

	private int offerId;
	private String offerName;
	private String offerDesc;
	private int type;
	private String applicableFor;
	private int offerType;
	private int offerSubType;
	private int frequencyType;
	private String frequency;
	private String fromDate;
	private String toDate;
	private String fromTime;
	private String toTime;
	private int primaryItemId;
	private String primaryItemName;
	private float primaryQty;
	private float discPer;

	private List<ItemWiseOfferDetailDisplay> offerDetailList;

	public ItemWiseOfferHeaderDisplay() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public ItemWiseOfferHeaderDisplay(int offerId, String offerName, String offerDesc, int type, String applicableFor,
			int offerType, int offerSubType, int frequencyType, String frequency, String fromDate, String toDate,
			String fromTime, String toTime, int primaryItemId, String primaryItemName, float primaryQty,
			float discPer) {
		super();
		this.offerId = offerId;
		this.offerName = offerName;
		this.offerDesc = offerDesc;
		this.type = type;
		this.applicableFor = applicableFor;
		this.offerType = offerType;
		this.offerSubType = offerSubType;
		this.frequencyType = frequencyType;
		this.frequency = frequency;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.primaryItemId = primaryItemId;
		this.primaryItemName = primaryItemName;
		this.primaryQty = primaryQty;
		this.discPer = discPer;
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

	public int getOfferSubType() {
		return offerSubType;
	}

	public void setOfferSubType(int offerSubType) {
		this.offerSubType = offerSubType;
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

	public List<ItemWiseOfferDetailDisplay> getOfferDetailList() {
		return offerDetailList;
	}

	public void setOfferDetailList(List<ItemWiseOfferDetailDisplay> offerDetailList) {
		this.offerDetailList = offerDetailList;
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

	public float getPrimaryQty() {
		return primaryQty;
	}

	public void setPrimaryQty(float primaryQty) {
		this.primaryQty = primaryQty;
	}

	public float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}

	@Override
	public String toString() {
		return "ItemWiseOfferHeaderDisplay [offerId=" + offerId + ", offerName=" + offerName + ", offerDesc="
				+ offerDesc + ", type=" + type + ", applicableFor=" + applicableFor + ", offerType=" + offerType
				+ ", offerSubType=" + offerSubType + ", frequencyType=" + frequencyType + ", frequency=" + frequency
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", fromTime=" + fromTime + ", toTime=" + toTime
				+ ", primaryItemId=" + primaryItemId + ", primaryItemName=" + primaryItemName + ", primaryQty="
				+ primaryQty + ", discPer=" + discPer + ", offerDetailList=" + offerDetailList + "]";
	}

}
