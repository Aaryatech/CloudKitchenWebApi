package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.CustomerAddressDisplay;

@Repository
public interface CustomerAddressDisplayRepo extends JpaRepository<CustomerAddressDisplay, Integer> {

	@Query(value = "SELECT\r\n" + 
			"    c.*,\r\n" + 
			"    a.area_name,\r\n" + 
			"    ct.city_name\r\n" + 
			"FROM\r\n" + 
			"    mn_cust_address c,\r\n" + 
			"    mn_area a,\r\n" + 
			"    mn_city ct\r\n" + 
			"WHERE\r\n" + 
			"    c.del_status = 0 AND a.del_status = 0 AND c.area_id = a.area_id  AND c.city_id = ct.city_id AND c.cust_id = :custId", nativeQuery = true)
	public List<CustomerAddressDisplay> getCustomerAddressList(@Param("custId") int custId);
	
}
