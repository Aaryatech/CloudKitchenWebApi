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

}
