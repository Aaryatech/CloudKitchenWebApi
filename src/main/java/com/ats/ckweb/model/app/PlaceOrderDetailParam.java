package com.ats.ckweb.model.app;

public class PlaceOrderDetailParam {

	int itemId;
	float selectedQty;
	int qty;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getSelectedQty() {
		return selectedQty;
	}

	public void setSelectedQty(float selectedQty) {
		this.selectedQty = selectedQty;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "PlaceOrderDetailParam [itemId=" + itemId + ", selectedQty=" + selectedQty + ", qty=" + qty + "]";
	}

}
