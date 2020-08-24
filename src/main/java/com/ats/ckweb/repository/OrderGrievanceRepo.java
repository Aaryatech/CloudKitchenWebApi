package com.ats.ckweb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.OrderGrievance;

public interface OrderGrievanceRepo extends JpaRepository<OrderGrievance, Integer> {

	@Query(value="SELECT\n" + 
			"    grev.grieve_id,\n" + 
			"    grev.current_status,\n" + 
			"    grev.date,\n" + 
			"    grev.extra_int1,\n" + 
			"    grev.extra_int2,\n" + 
			"    grev.extra_var2,\n" + 
			"    grev.grievencce_no,\n" + 
			"    grev.grievence_subtype_id,\n" + 
			"    grev.grievence_subtype_name,\n" + 
			"    grev.grievence_type_id,\n" + 
			"    grev.grievence_type_name,\n" + 
			"    grev.insert_by_id,\n" + 
			"    grev.insert_date_time,\n" + 
			"    grev.order_id,\n" + 
			"    grev.platform,\n" + 
			"    grev.remark,\n" + 
			"    CASE WHEN grev.platform = 1 THEN(\n" + 
			"    SELECT\n" + 
			"        CONCAT(\n" + 
			"            m_customer.cust_name,\n" + 
			"            '-',\n" + 
			"            m_customer.phone_number\n" + 
			"        )\n" + 
			"    FROM\n" + 
			"        `m_customer`\n" + 
			"    WHERE\n" + 
			"        m_customer.cust_id = grev.insert_by_id AND m_customer.del_status = 0\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        CONCAT(\n" + 
			"            mn_user.user_name,\n" + 
			"            '-',\n" + 
			"            mn_user.user_mobile_no\n" + 
			"        )\n" + 
			"    FROM\n" + 
			"        `mn_user`\n" + 
			"    WHERE\n" + 
			"        mn_user.user_id = grev.insert_by_id AND mn_user.del_status = 0\n" + 
			")\n" + 
			"END AS extra_var1\n" + 
			"FROM\n" + 
			"    t_grievences grev\n" + 
			"WHERE\n" + 
			"    grev.order_id = :orderId",nativeQuery=true)
	OrderGrievance findByOrderId(@Param("orderId") int orderId);
	
	
	@Transactional
	@Modifying
	@Query("update OrderGrievance set extra_int1=:status WHERE grieve_id=:grieveId")
	int updateWalletStatus(@Param("status") int status, @Param("grieveId") int grieveId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_grievences SET current_status=:status , wallet_amt=:walletAmt , fr_affect_amt=:frAffectAmt  WHERE grieve_id=:grieveId",nativeQuery=true)
	int updateGrievHeaderStatusAndAmt(@Param("grieveId") int grieveId,@Param("status") int status,@Param("walletAmt") float walletAmt,@Param("frAffectAmt") float frAffectAmt);
	
}
