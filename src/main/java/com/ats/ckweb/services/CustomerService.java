package com.ats.ckweb.services;

import org.springframework.stereotype.Service;
import com.ats.ckweb.model.Customer;

@Service
public interface CustomerService {

	Customer insertNewCustomer(Customer customer);

}
