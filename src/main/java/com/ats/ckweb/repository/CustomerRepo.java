package com.ats.ckweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	
	
}
