package com.ats.ckweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ckweb.commons.SMSUtility;
import com.ats.ckweb.model.Customer;
import com.ats.ckweb.model.NewSetting;
import com.ats.ckweb.repository.CustomerRepo;
import com.ats.ckweb.repository.NewSettingRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	NewSettingRepo newSettingRepo;

	@Override
	public Customer insertNewCustomer(Customer customer) {

		Customer result = new Customer();

		try {

			String ph1 = customer.getPhoneNumber();
			String ph2 = customer.getWhatsappNo();

			ph1 = ph1.trim().replaceAll(" ", "");
			ph2 = ph2.trim().replaceAll(" ", "");

			if (ph1.length() > 11) {
				customer.setPhoneNumber(ph1.substring(ph1.length() - 10));
			} else if (ph1.length() == 10) {
				customer.setPhoneNumber(ph1);
			}

			if (ph2.length() > 11) {
				customer.setWhatsappNo(ph2.substring(ph2.length() - 10));
			} else if (ph2.length() == 10) {
				customer.setWhatsappNo(ph2);
			}

			result = customerRepo.save(customer);
			if (result != null) {
				if (customer.getCustId() == 0) {
					NewSetting val = newSettingRepo.findBySettingKeyAndDelStatus("msg_new_cust", 0);
					SMSUtility.sendSMS(result.getPhoneNumber(), val.getSettingValue1(), "MADHVI");
				}
			}

		} catch (Exception e) {
			System.err.println("Exception in insertNewCustomer : " + e.getMessage());
		}

		return result;
	}

}
