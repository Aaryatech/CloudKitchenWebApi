package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

public class ItemWiseOfferDetailDisplay {

	private int offerDetailId;
	private int primaryItemId;
	private int secondaryItemId;
	private float secondaryItemQty;
	private String secondaryItemName;

	public ItemWiseOfferDetailDisplay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemWiseOfferDetailDisplay(int offerDetailId, int primaryItemId, int secondaryItemId, float secondaryItemQty,
			String secondaryItemName) {
		super();
		this.offerDetailId = offerDetailId;
		this.primaryItemId = primaryItemId;
		this.secondaryItemId = secondaryItemId;
		this.secondaryItemQty = secondaryItemQty;
		this.secondaryItemName = secondaryItemName;
	}

	public int getOfferDetailId() {
		return offerDetailId;
	}

	public void setOfferDetailId(int offerDetailId) {
		this.offerDetailId = offerDetailId;
	}

	public int getSecondaryItemId() {
		return secondaryItemId;
	}

	public void setSecondaryItemId(int secondaryItemId) {
		this.secondaryItemId = secondaryItemId;
	}

	public float getSecondaryItemQty() {
		return secondaryItemQty;
	}

	public void setSecondaryItemQty(float secondaryItemQty) {
		this.secondaryItemQty = secondaryItemQty;
	}

	public String getSecondaryItemName() {
		return secondaryItemName;
	}

	public void setSecondaryItemName(String secondaryItemName) {
		this.secondaryItemName = secondaryItemName;
	}

	public int getPrimaryItemId() {
		return primaryItemId;
	}

	public void setPrimaryItemId(int primaryItemId) {
		this.primaryItemId = primaryItemId;
	}

	@Override
	public String toString() {
		return "ItemWiseOfferDetailDisplay [offerDetailId=" + offerDetailId + ", primaryItemId=" + primaryItemId
				+ ", secondaryItemId=" + secondaryItemId + ", secondaryItemQty=" + secondaryItemQty
				+ ", secondaryItemName=" + secondaryItemName + "]";
	}

}
