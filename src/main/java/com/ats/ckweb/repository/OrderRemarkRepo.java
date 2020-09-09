package com.ats.ckweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.ckweb.model.OrderRemark;

public interface OrderRemarkRepo extends JpaRepository<OrderRemark, Integer> {

	public List<OrderRemark> findAllByRkTypeAndDelStatus(int type, int del);
	
	public List<OrderRemark> findByDelStatusOrderByRkIdDesc(int del);

	@Transactional
	@Modifying
	@Query(value="UPDATE `mn_remark` SET del_status=1 WHERE rk_id=:remarkId",nativeQuery=true)
	public int deleteRemark(int remarkId);

	public OrderRemark findByRkId(int remarkId);

}
