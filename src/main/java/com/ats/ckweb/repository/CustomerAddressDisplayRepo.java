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
			"        c.cust_address_id,\r\n" + 
			"        c.cust_id,\r\n" + 
			"        c.address_caption,\r\n" + 
			"        c.address,\r\n" + 
			"        c.area_id,\r\n" + 
			"        c.area,\r\n" + 
			"        c.landmark,\r\n" + 
			"        c.pincode,\r\n" + 
			"        c.city_id,\r\n" + 
			"        c.del_status,\r\n" + 
			"        c.latitude,\r\n" + 
			"        c.longitude,\r\n" + 
			"        ct.ex_int1,\r\n" + 
			"        c.ex_int2,\r\n" + 
			"        c.ex_int3,\r\n" + 
			"        c.ex_var1,\r\n" + 
			"        c.ex_var2,\r\n" + 
			"        c.ex_var3,\r\n" + 
			"        c.ex_float1,\r\n" + 
			"        c.ex_float2,\r\n" + 
			"        c.ex_float3,\r\n" + 
			"        '' as area_name,\r\n" + 
			"        ct.city_name  \r\n" + 
			"    FROM\r\n" + 
			"        mn_cust_address c,\r\n" + 
			"        mn_city ct  \r\n" + 
			"    WHERE\r\n" + 
			"        c.del_status = 0 \r\n" + 
			"        AND  c.city_id = ct.city_id \r\n" + 
			"        AND c.cust_id = :custId", nativeQuery = true)
	public List<CustomerAddressDisplay> getCustomerAddressList(@Param("custId") int custId);
	
	
	@Query(value = "SELECT\r\n" + 
			"    c.*,\r\n" + 
			"    '' as area_name,\r\n" + 
			"    ct.city_name\r\n" + 
			"FROM\r\n" + 
			"    mn_cust_address c, mn_city ct\r\n" + 
			"WHERE\r\n" + 
			"    c.del_status = 0 AND  c.city_id = ct.city_id AND c.cust_address_Id = :custAddressId", nativeQuery = true)
	public CustomerAddressDisplay getCustomerAddressById(@Param("custAddressId") int custAddressId);
	
}
