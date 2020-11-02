package com.ats.ckweb.model.app;

import com.ats.ckweb.model.CustomerDisplay;
import com.ats.ckweb.model.Info;

public class VerifyCustomer {
	private CustomerDisplay customerDisplay;
	private Info info;

	public CustomerDisplay getCustomerDisplay() {
		return customerDisplay;
	}

	public void setCustomerDisplay(CustomerDisplay customerDisplay) {
		this.customerDisplay = customerDisplay;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "VerifyCustomer [customerDisplay=" + customerDisplay + ", info=" + info + "]";
	}

}
