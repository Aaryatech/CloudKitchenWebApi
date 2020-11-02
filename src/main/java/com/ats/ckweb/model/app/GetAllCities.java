package com.ats.ckweb.model.app;

import java.util.List;

import com.ats.ckweb.model.City;
import com.ats.ckweb.model.Info;

public class GetAllCities {

	List<City> cityList;
	Info info;

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetAllCities [cityList=" + cityList + ", info=" + info + "]";
	}

}
