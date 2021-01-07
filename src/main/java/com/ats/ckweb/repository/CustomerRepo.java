package com.ats.ckweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	List<Customer> findByDelStatusAndCompIdOrderByCustIdDesc(int del, int compId);
	List<Customer> findByDelStatusAndCustId(int del, int custId);
	Customer findByCustId(int custId);
	
	@Query(value="select c.* from m_customer c, tn_order_header h where h.del_status=0 AND h.cust_id=c.cust_id AND h.order_id=:orderId",nativeQuery=true)
	Customer getCustomerByOrderId(@Param("orderId") int orderId);
	
	@Query(value="select c.* from m_customer c, t_grievences g, tn_order_header h where h.del_status=0 AND h.cust_id=c.cust_id AND h.order_id=g.order_id AND g.grieve_id=:grievId",nativeQuery=true)
	Customer getCustomerByGrievId(@Param("grievId") int grievId);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_customer SET profile_pic=:imgName WHERE cust_id=:custId",nativeQuery=true)
	public int updateProfilePic(@Param("custId") int custId,@Param("imgName") String imgName);
	
	
	
}
