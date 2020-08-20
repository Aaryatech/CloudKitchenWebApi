package com.ats.ckweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.ckweb.model.OrderGrievance;

public interface OrderGrievanceRepo extends JpaRepository<OrderGrievance, Integer> {

	OrderGrievance findByOrderId(int orderId);
	
}
