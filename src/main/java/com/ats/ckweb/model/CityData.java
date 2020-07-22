package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CityData {

	@Id
	private int cityId;

	private int frConfigId;
	private int frId;
	private String cityName;
	private String description;
	private String cityCode;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
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

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	@Override
	public String toString() {
		return "CityData [cityId=" + cityId + ", frConfigId=" + frConfigId + ", frId=" + frId + ", cityName=" + cityName
				+ ", description=" + description + ", cityCode=" + cityCode + "]";
	}

}
