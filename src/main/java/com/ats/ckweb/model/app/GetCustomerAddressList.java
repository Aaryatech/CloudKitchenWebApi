package com.ats.ckweb.model.app;

import java.util.List;

import com.ats.ckweb.model.CustomerAddressDisplay;
import com.ats.ckweb.model.Info;

public class GetCustomerAddressList {

	List<CustomerAddressDisplay> addressList;
	Info info;

	public List<CustomerAddressDisplay> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<CustomerAddressDisplay> addressList) {
		this.addressList = addressList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetCustomerAddressList [addressList=" + addressList + "]";
	}

}
