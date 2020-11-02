package com.ats.ckweb.model.app;

import com.ats.ckweb.model.Customer;
import com.ats.ckweb.model.Info;

public class SaveCustomer {

	private Customer customer;
	private Info info;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "SaveCustomer [customer=" + customer + ", info=" + info + "]";
	}

}
