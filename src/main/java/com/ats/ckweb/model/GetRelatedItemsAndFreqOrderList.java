package com.ats.ckweb.model;

import java.util.List;

public class GetRelatedItemsAndFreqOrderList {

	private List<ItemDisplay> relatedItemList;
	private List<ItemDisplay> freqOrderItemList;

	public List<ItemDisplay> getRelatedItemList() {
		return relatedItemList;
	}

	public void setRelatedItemList(List<ItemDisplay> relatedItemList) {
		this.relatedItemList = relatedItemList;
	}

	public List<ItemDisplay> getFreqOrderItemList() {
		return freqOrderItemList;
	}

	public void setFreqOrderItemList(List<ItemDisplay> freqOrderItemList) {
		this.freqOrderItemList = freqOrderItemList;
	}

	@Override
	public String toString() {
		return "GetRelatedItemsAndFreqOrderList [relatedItemList=" + relatedItemList + ", freqOrderItemList="
				+ freqOrderItemList + "]";
	}

}
