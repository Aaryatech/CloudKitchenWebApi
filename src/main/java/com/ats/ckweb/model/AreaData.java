package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AreaData {

	@Id
	private int areaId;

	private int frConfigId;
	private int frId;
	private int cityId;
	private String areaName;
	private String description;
	private String areaCode;
	private String pincode;
	private String latitude;
	private String longitude;

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public int getFrConfigId() {
		return frConfigId;
	}

	public void setFrConfigId(int frConfigId) {
		this.frConfigId = frConfigId;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "AreaData [areaId=" + areaId + ", frConfigId=" + frConfigId + ", frId=" + frId + ", cityId=" + cityId
				+ ", areaName=" + areaName + ", description=" + description + ", areaCode=" + areaCode + ", pincode="
				+ pincode + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
