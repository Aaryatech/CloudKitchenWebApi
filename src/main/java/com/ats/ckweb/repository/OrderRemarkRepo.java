package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.ckweb.model.OrderRemark;

public interface OrderRemarkRepo extends JpaRepository<OrderRemark, Integer> {

	public List<OrderRemark> findAllByRkTypeAndDelStatus(int type, int del);

}
