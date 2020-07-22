package com.ats.ckweb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class FranchiseData {

	@Id
	private int frConfigId;

	private int frId;
	private int frType;
	private String frName;
	private String frCode;
	private String frAddress;
	private String frMob;
	private String fromLatitude;
	private String fromLongitude;
	private String toLatitude;
	private String toLongitude;
	private float kmAreaCovered;
	private int compId;

	@Transient
	List<CityData> cityList;

	@Transient
	List<AreaData> areaList;

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

	public String getFrAddress() {
		return frAddress;
	}

	public void setFrAddress(String frAddress) {
		this.frAddress = frAddress;
	}

	public String getFrMob() {
		return frMob;
	}

	public void setFrMob(String frMob) {
		this.frMob = frMob;
	}

	public String getFromLatitude() {
		return fromLatitude;
	}

	public void setFromLatitude(String fromLatitude) {
		this.fromLatitude = fromLatitude;
	}

	public String getFromLongitude() {
		return fromLongitude;
	}

	public void setFromLongitude(String fromLongitude) {
		this.fromLongitude = fromLongitude;
	}

	public String getToLatitude() {
		return toLatitude;
	}

	public void setToLatitude(String toLatitude) {
		this.toLatitude = toLatitude;
	}

	public String getToLongitude() {
		return toLongitude;
	}

	public void setToLongitude(String toLongitude) {
		this.toLongitude = toLongitude;
	}

	public float getKmAreaCovered() {
		return kmAreaCovered;
	}

	public void setKmAreaCovered(float kmAreaCovered) {
		this.kmAreaCovered = kmAreaCovered;
	}

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public List<CityData> getCityList() {
		return cityList;
	}

	public void setCityList(List<CityData> cityList) {
		this.cityList = cityList;
	}

	public List<AreaData> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<AreaData> areaList) {
		this.areaList = areaList;
	}

	@Override
	public String toString() {
		return "FranchiseData [frConfigId=" + frConfigId + ", frId=" + frId + ", frType=" + frType + ", frName="
				+ frName + ", frCode=" + frCode + ", frAddress=" + frAddress + ", frMob=" + frMob + ", fromLatitude="
				+ fromLatitude + ", fromLongitude=" + fromLongitude + ", toLatitude=" + toLatitude + ", toLongitude="
				+ toLongitude + ", kmAreaCovered=" + kmAreaCovered + ", compId=" + compId + ", cityList=" + cityList
				+ ", areaList=" + areaList + "]";
	}

}
