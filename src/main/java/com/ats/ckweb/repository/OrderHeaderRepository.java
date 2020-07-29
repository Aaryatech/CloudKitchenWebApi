package com.ats.ckweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.ckweb.model.OrderHeader;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Integer>{

}
