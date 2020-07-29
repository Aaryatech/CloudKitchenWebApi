package com.ats.ckweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.ckweb.model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

}
