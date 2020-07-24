package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetFrConfigList {

	@Id
	private int frConfigId;
	private int frId;
	private int frType;
	private int cityIds;
	private String areaIds;
	private double fromLatitude;
	private double fromLongitude;
	private double toLatitude;
	private double toLongitude;
	private float kmAreaCovered;
	private int isActive;
	private String cityName;
	private String cityCode;
	private String frName;
	private String frCode;
	private String areaName;
	private String areaCode;
	private String exVar1;
	private int exInt1;
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
	public int getFrType() {
		return frType;
	}
	public void setFrType(int frType) {
		this.frType = frType;
	}
	public int getCityIds() {
		return cityIds;
	}
	public void setCityIds(int cityIds) {
		this.cityIds = cityIds;
	}
	public String getAreaIds() {
		return areaIds;
	}
	public void setAreaIds(String areaIds) {
		this.areaIds = areaIds;
	}
	public double getFromLatitude() {
		return fromLatitude;
	}
	public void setFromLatitude(double fromLatitude) {
		this.fromLatitude = fromLatitude;
	}
	public double getFromLongitude() {
		return fromLongitude;
	}
	public void setFromLongitude(double fromLongitude) {
		this.fromLongitude = fromLongitude;
	}
	public double getToLatitude() {
		return toLatitude;
	}
	public void setToLatitude(double toLatitude) {
		this.toLatitude = toLatitude;
	}
	public double getToLongitude() {
		return toLongitude;
	}
	public void setToLongitude(double toLongitude) {
		this.toLongitude = toLongitude;
	}
	public float getKmAreaCovered() {
		return kmAreaCovered;
	}
	public void setKmAreaCovered(float kmAreaCovered) {
		this.kmAreaCovered = kmAreaCovered;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getFrName() {
		return frName;
	}
	public void setFrName(String frName) {
		this.frName = frName;
	}
	public String getFrCode() {
		return frCode;
	}
	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getExVar1() {
		return exVar1;
	}
	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}
	public int getExInt1() {
		return exInt1;
	}
	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}
	@Override
	public String toString() {
		return "GetFrConfigList [frConfigId=" + frConfigId + ", frId=" + frId + ", frType=" + frType + ", cityIds="
				+ cityIds + ", areaIds=" + areaIds + ", fromLatitude=" + fromLatitude + ", fromLongitude="
				+ fromLongitude + ", toLatitude=" + toLatitude + ", toLongitude=" + toLongitude + ", kmAreaCovered="
				+ kmAreaCovered + ", isActive=" + isActive + ", cityName=" + cityName + ", cityCode=" + cityCode
				+ ", frName=" + frName + ", frCode=" + frCode + ", areaName=" + areaName + ", areaCode=" + areaCode
				+ ", exVar1=" + exVar1 + ", exInt1=" + exInt1 + "]";
	}
	
	
}
