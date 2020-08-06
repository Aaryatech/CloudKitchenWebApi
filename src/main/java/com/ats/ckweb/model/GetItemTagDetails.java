package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetItemTagDetails {
@Id
	private int id;
	private String itemName;
	private int isUsed;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}
	@Override
	public String toString() {
		return "GetItemTagDetails [id=" + id + ", itemName=" + itemName + ", isUsed=" + isUsed + "]";
	}
	
	
}
