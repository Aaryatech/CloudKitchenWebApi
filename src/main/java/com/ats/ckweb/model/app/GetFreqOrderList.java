package com.ats.ckweb.model.app;

import java.util.List;

import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.ItemDisplay;

public class GetFreqOrderList {

	List<ItemDisplay> itemList;
	Info info;

	public List<ItemDisplay> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemDisplay> itemList) {
		this.itemList = itemList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetFreqOrderList [itemList=" + itemList + ", info=" + info + "]";
	}

}
