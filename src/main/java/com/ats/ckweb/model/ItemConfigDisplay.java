package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemConfigDisplay {

	@Id
	private int itemConfigId;
	private int frId;
	private String frName;
	private int configType;
	private int compId;
	private int noOfItems;

	public int getItemConfigId() {
		return itemConfigId;
	}

	public void setItemConfigId(int itemConfigId) {
		this.itemConfigId = itemConfigId;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public int getConfigType() {
		return configType;
	}

	public void setConfigType(int configType) {
		this.configType = configType;
	}

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	@Override
	public String toString() {
		return "ItemConfigDisplay [itemConfigId=" + itemConfigId + ", frId=" + frId + ", frName=" + frName
				+ ", configType=" + configType + ", compId=" + compId + ", noOfItems=" + noOfItems + "]";
	}

}
