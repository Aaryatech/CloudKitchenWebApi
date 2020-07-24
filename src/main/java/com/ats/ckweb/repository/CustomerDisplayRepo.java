package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.CustomerDisplay;

@Repository
public interface CustomerDisplayRepo extends JpaRepository<CustomerDisplay, Integer> {

	@Query(value = "SELECT\r\n" + 
			"    c.*,\r\n" + 
			"    l.lang_name,\r\n" + 
			"    ct.city_name\r\n" + 
			"FROM\r\n" + 
			"    mn_customer c,\r\n" + 
			"    mn_language l,\r\n" + 
			"    mn_city ct\r\n" + 
			"WHERE\r\n" + 
			"    c.is_active = 0 AND c.del_status = 0 AND l.del_status = 0 AND c.lang_id = l.lang_id AND ct.del_status = 0 AND c.city_id = ct.city_id", nativeQuery = true)
	public List<CustomerDisplay> getAllCustomer();
	
	
	@Query(value = "SELECT\r\n" + 
			"    c.*,\r\n" + 
			"    l.lang_name,\r\n" + 
			"    ct.city_name\r\n" + 
			"FROM\r\n" + 
			"    mn_customer c,\r\n" + 
			"    mn_language l,\r\n" + 
			"    mn_city ct\r\n" + 
			"WHERE\r\n" + 
			"    c.is_active = 0 AND c.del_status = 0 AND l.del_status = 0 AND c.lang_id = l.lang_id AND ct.del_status = 0 AND c.city_id = ct.city_id AND c.cust_id=:custId", nativeQuery = true)
	public CustomerDisplay getCustomerById(@Param("custId") int custId);
	
	
}