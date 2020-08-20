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
	int updateStatus(@Param("status") int status, @Param("orderId") int orderId);

	@Query(value = "select uuid_no from tn_order_header where order_id=:orderId", nativeQuery = true)
	String getUuId(@Param("orderId") int orderId);

	@Transactional
	@Modifying
	@Query("update OrderHeader set order_status=:status, paid_status=:paid WHERE uuid_no=:orderId")
	int updateStatusAndIsPaid(int status, int paid, String orderId);

	OrderHeader findByUuidNo(String orderId);

}
