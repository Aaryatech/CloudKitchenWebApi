package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	List<Customer> findByDelStatusAndCompIdOrderByCustIdDesc(int del, int compId);
	
}
