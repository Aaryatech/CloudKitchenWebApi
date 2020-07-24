package com.ats.ckweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.CustomerAddress;

@Repository
public interface CustomerAddressRepo extends JpaRepository<CustomerAddress, Integer> {

	@Transactional
	@Modifying
	@Query(value = "update mn_cust_address set del_status=:status WHERE cust_address_id = :custAddressId", nativeQuery = true)
	public int deleteCustAddress(@Param("custAddressId") int custAddressId,@Param("status") int status);

}
