package com.ats.ckweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.ckweb.model.OrderTrail;

public interface OrderTrailRepository extends JpaRepository<OrderTrail, Integer> {
	
	OrderTrail findByOrderIdAndStatus(int i,int j);

}
