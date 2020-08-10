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
			"    m_customer c,\r\n" + 
			"    mn_language l,\r\n" + 
			"    mn_city ct\r\n" + 
			"WHERE\r\n" + 
			"    c.is_active = 0 AND c.del_status = 0 AND l.del_status = 0 AND c.lang_id = l.lang_id AND ct.del_status = 0 AND c.city_id = ct.city_id", nativeQuery = true)
	public List<CustomerDisplay> getAllCustomer();
	
	
	@Query(value = "SELECT\r\n" + 
			"        c.*,\r\n" + 
			"        l.lang_name,\r\n" + 
			"        '' as city_name  \r\n" + 
			"    FROM\r\n" + 
			"        m_customer c,\r\n" + 
			"        mn_language l \r\n" + 
			"    WHERE\r\n" + 
			"        c.is_active = 0 \r\n" + 
			"        AND c.del_status = 0 \r\n" + 
			"        AND l.del_status = 0 \r\n" + 
			"        AND c.lang_id = l.lang_id  \r\n" + 
			"        AND c.cust_id=:custId", nativeQuery = true)
	public CustomerDisplay getCustomerById(@Param("custId") int custId);

	@Query(value = "SELECT\r\n" + 
			"        c.*,\r\n" + 
			"        l.lang_name,\r\n" + 
			"        '' as city_name  \r\n" + 
			"    FROM\r\n" + 
			"        m_customer c,\r\n" + 
			"        mn_language l \r\n" + 
			"    WHERE\r\n" + 
			"        c.del_status = 0  \r\n" + 
			"        AND c.lang_id = l.lang_id  \r\n" + 
			"        AND c.phone_number=:mobileNo", nativeQuery = true)
	public List<CustomerDisplay> getCustomerByMobileNo(@Param("mobileNo")String mobileNo);
	
	
	
	//Sachin Handge 10-08-2020 to get data from m_customer to show in grievance list for filtering
	
	@Query(value = " SELECT " + 
			"    c.*,'0' as city_name,'0' as lang_name "+
		
			" FROM " + 
			"    m_customer c "+
			" WHERE " + 
			"    c.is_active = 0 AND c.del_status = 0 ", nativeQuery = true)
	public List<CustomerDisplay> getAllCustomerList();
	
	
	
}
