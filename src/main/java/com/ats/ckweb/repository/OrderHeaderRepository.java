package com.ats.ckweb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.OrderHeader;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Integer> {

	@Transactional
	@Modifying
	@Query("update OrderHeader set order_status=:status WHERE order_id=:orderId")
	int updateStatus(@Param("status") int status,@Param("orderId") int orderId);

}
