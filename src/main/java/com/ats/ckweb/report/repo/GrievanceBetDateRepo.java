package com.ats.ckweb.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.report.model.GrievanceBetDate;

public interface GrievanceBetDateRepo extends JpaRepository<GrievanceBetDate, Integer> {
	
	@Query(value=" SELECT UUID() as id, tn_order_header.order_id, tn_order_header.order_no,tn_order_header.delivery_date,\n" + 
			"        tn_order_header.order_platform, " + 
			"        tn_order_header.fr_id, " + 
			"        tn_order_header.cust_id, " + 
			"        tn_order_header.total_amt, " + 
			"        tn_order_header.insert_user_id as order_user_id, " + 
			"        m_customer.cust_name, " + 
			"        m_customer.phone_number, " + 
			"        m_customer.whatsapp_no, " + 
			"        t_grievences.grieve_id, " + 
			"        t_grievences.grievencce_no," + 
			"        t_grievences.grievence_type_id,t_grievences.grievence_subtype_id," + 
			"        t_grievences.current_status as griv_status," + 
			"        t_grievences.date as griv_date," + 
			"         " + 
			"        mn_grievences_type_instructn.caption as type  ," + 
			"        mn_grievences_instruction.caption as sub_type," + 
			"         " + 
			"        m_franchisee.fr_name," + 
			"        m_franchisee.fr_code " + 
			"        " + 
			"        FROM " + 
			"        tn_order_header, " + 
			"        m_customer, " + 
			"        mn_grievences_type_instructn, " + 
			"        mn_grievences_instruction, " + 
			"        m_franchisee, " + 
			"        t_grievences  " + 
			"                " + 
			"         WHERE " + 
			"        t_grievences.order_id=tn_order_header.order_id " + 
			"        and t_grievences.grievence_type_id=mn_grievences_type_instructn.grev_type_id " + 
			"        and t_grievences.grievence_subtype_id=mn_grievences_instruction.grievance_id " + 
			"        AND m_customer.cust_id=tn_order_header.cust_id " + 
			"        and m_franchisee.fr_id=tn_order_header.fr_id and "
			+ " tn_order_header.delivery_date BETWEEN :fromDate and :toDate ",nativeQuery=true)
	List<GrievanceBetDate> getGrieBetGivenDeliveryDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	
	@Query(value="SELECT\n" + 
			"        UUID() as id,\n" + 
			"        tn_order_header.order_id,\n" + 
			"        tn_order_header.order_no,\n" + 
			"        tn_order_header.delivery_date,\n" + 
			"        tn_order_header.order_platform,\n" + 
			"        tn_order_header.fr_id,\n" + 
			"        tn_order_header.cust_id,\n" + 
			"        tn_order_header.total_amt,\n" + 
			"        tn_order_header.insert_user_id as order_user_id,\n" + 
			"        m_customer.cust_name,\n" + 
			"        m_customer.phone_number,\n" + 
			"        m_customer.whatsapp_no,\n" + 
			"        t_grievences.grieve_id,\n" + 
			"        t_grievences.grievencce_no,\n" + 
			"        t_grievences.grievence_type_id,\n" + 
			"        t_grievences.grievence_subtype_id,\n" + 
			"        t_grievences.current_status as griv_status,\n" + 
			"        t_grievences.date as griv_date,\n" + 
			"        mn_grievences_type_instructn.caption as type  ,\n" + 
			"        mn_grievences_instruction.caption as sub_type,\n" + 
			"        m_franchisee.fr_name,\n" + 
			"        m_franchisee.fr_code                 \n" + 
			"    FROM\n" + 
			"        tn_order_header,\n" + 
			"        m_customer,\n" + 
			"        mn_grievences_type_instructn,\n" + 
			"        mn_grievences_instruction,\n" + 
			"        m_franchisee,\n" + 
			"        t_grievences                           \n" + 
			"    WHERE\n" + 
			"        t_grievences.order_id=tn_order_header.order_id         \n" + 
			"        AND t_grievences.grievence_type_id=mn_grievences_type_instructn.grev_type_id         \n" + 
			"        AND t_grievences.grievence_subtype_id=mn_grievences_instruction.grievance_id         \n" + 
			"        AND m_customer.cust_id=tn_order_header.cust_id         \n" + 
			"        AND m_franchisee.fr_id=tn_order_header.fr_id \n" + 
			"        AND m_franchisee.fr_id=:frId\n" + 
			"        AND mn_grievences_type_instructn.grev_type_id IN (:grevTypeIds)\n" + 
			"        AND  tn_order_header.delivery_date BETWEEN :fromDate AND :toDate", nativeQuery=true)
	List<GrievanceBetDate> getGrieBetGivenDtl(@Param("fromDate") String fromDate, @Param("toDate") String toDate, 
			@Param("frId") int frId, @Param("grevTypeIds") List<Integer> grevTypeIds);

}
