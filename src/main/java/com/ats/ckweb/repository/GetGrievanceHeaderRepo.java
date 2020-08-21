package com.ats.ckweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.GetGrievanceHeader;




public interface GetGrievanceHeaderRepo extends JpaRepository<GetGrievanceHeader, Integer> {
	
	
	@Query(value="SELECT t_grievences.grieve_id,t_grievences.order_id,t_grievences.grievence_type_id,t_grievences.grievence_subtype_id,\n" + 
			"t_grievences.remark,t_grievences.current_status,t_grievences.date,t_grievences.extra_var1,t_grievences.extra_var2,t_grievences.platform,t_grievences.grievencce_no,t_grievences.insert_date_time,tn_order_header.order_no,tn_order_header.order_date,tn_order_header.fr_id,tn_order_header.cust_id,\n" + 
			"m_customer.cust_name,m_customer.phone_number,m_customer.whatsapp_no,\n" + 
			"mn_grievences_type_instructn.caption as type ,mn_grievences_instruction.caption as sub_type,m_franchisee.fr_name,m_franchisee.fr_code,\n" + 
			"COALESCE((user.user_name),0) as insert_user_name,"
			+ " COALESCE((SELECT COUNT(*) FROM t_grievences_trail WHERE t_grievences_trail.grievences_id=t_grievences.grieve_id),0)   as griv_trail_count, t_grievences.extra_int1    \n" + 
			"from  tn_order_header,m_customer,mn_grievences_type_instructn,mn_grievences_instruction,m_franchisee,t_grievences\n" + 
			"left JOIN mn_user user  on t_grievences.insert_by_id=user.user_id  \n" +
			//" t_grievences.grieve_id=trail.grievences_id \n" + 

			"\n" + 
			"WHERE  t_grievences.order_id=tn_order_header.order_id and t_grievences.grievence_type_id=mn_grievences_type_instructn.grev_type_id and t_grievences.grievence_subtype_id=mn_grievences_instruction.grievance_id AND m_customer.cust_id=tn_order_header.cust_id\n" + 
			"and m_franchisee.fr_id=tn_order_header.fr_id and  t_grievences.current_status IN (:statusList)  ",nativeQuery=true)
	
	List<GetGrievanceHeader> getGrievanceHeaderByStatus(@Param("statusList") List<Integer> statusList);
	

	@Query(value="SELECT t_grievences.grieve_id,t_grievences.order_id,t_grievences.grievence_type_id,t_grievences.grievence_subtype_id,\n" + 
			"t_grievences.remark,t_grievences.current_status,t_grievences.date,t_grievences.extra_var1,t_grievences.extra_var2,t_grievences.platform,t_grievences.grievencce_no,t_grievences.insert_date_time,tn_order_header.order_no,tn_order_header.order_date,tn_order_header.fr_id,tn_order_header.cust_id,\n" + 
			"m_customer.cust_name,m_customer.phone_number,m_customer.whatsapp_no,\n" + 
			"mn_grievences_type_instructn.caption as type ,mn_grievences_instruction.caption as sub_type,m_franchisee.fr_name,m_franchisee.fr_code,\n" + 
			"COALESCE((user.user_name),0) as insert_user_name ,"
			+ "  COALESCE((SELECT COUNT(*) FROM t_grievences_trail WHERE t_grievences_trail.grievences_id=t_grievences.grieve_id),0)   as griv_trail_count , t_grievences.extra_int1  " + 
			"  " + 
			" \n" + 
			"from  tn_order_header,m_customer,mn_grievences_type_instructn,mn_grievences_instruction,m_franchisee,t_grievences\n" + 
			"left JOIN mn_user user  on t_grievences.insert_by_id=user.user_id \n" + 
			//"left JOIN t_grievences_trail trail  on t_grievences.grieve_id=trail.grievences_id \n" + 

			"WHERE t_grievences.order_id=tn_order_header.order_id and t_grievences.grievence_type_id=mn_grievences_type_instructn.grev_type_id and t_grievences.grievence_subtype_id=mn_grievences_instruction.grievance_id AND m_customer.cust_id=tn_order_header.cust_id\n" + 
			"and m_franchisee.fr_id=tn_order_header.fr_id and  t_grievences.current_status IN (:statusList)"
			+ "and t_grievences.date BETWEEN :fromDate and :toDate  ",nativeQuery=true)
	
	List<GetGrievanceHeader> getGrievanceHeaderByStatusAndDate(@Param("statusList") List<Integer> statusList,
			@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	
	@Query(value="SELECT t_grievences.grieve_id,t_grievences.order_id,t_grievences.grievence_type_id,t_grievences.grievence_subtype_id,\n" + 
			"t_grievences.remark,t_grievences.current_status,t_grievences.date,t_grievences.extra_var1,t_grievences.extra_var2,t_grievences.platform,t_grievences.grievencce_no,t_grievences.insert_date_time,tn_order_header.order_no,tn_order_header.order_date,tn_order_header.fr_id,tn_order_header.cust_id,\n" + 
			"m_customer.cust_name,m_customer.phone_number,m_customer.whatsapp_no,\n" + 
			"mn_grievences_type_instructn.caption as type ,mn_grievences_instruction.caption as sub_type,m_franchisee.fr_name,m_franchisee.fr_code,\n" + 
			"COALESCE((user.user_name),0) as insert_user_name ,"
			+ " COALESCE((SELECT COUNT(*) FROM t_grievences_trail WHERE t_grievences_trail.grievences_id=t_grievences.grieve_id),0)   as griv_trail_count , t_grievences.extra_int1 " + 
			"from  tn_order_header,m_customer,mn_grievences_type_instructn,mn_grievences_instruction,m_franchisee,t_grievences\n" + 
			"left JOIN mn_user user  on t_grievences.insert_by_id=user.user_id \n" + 
			//"left JOIN t_grievences_trail trail  on t_grievences.grieve_id=trail.grievences_id \n" + 

			"WHERE t_grievences.order_id=tn_order_header.order_id and t_grievences.grievence_type_id=mn_grievences_type_instructn.grev_type_id and t_grievences.grievence_subtype_id=mn_grievences_instruction.grievance_id AND m_customer.cust_id=tn_order_header.cust_id\n" + 
			"and m_franchisee.fr_id=tn_order_header.fr_id and m_customer.cust_id=:custId ",nativeQuery=true)
	

	List<GetGrievanceHeader> getGrievanceHeaderByCustId(@Param("custId") int custId);

	
	  @Query(
	  value="SELECT t_grievences.grieve_id,t_grievences.order_id,t_grievences.grievence_type_id,t_grievences.grievence_subtype_id, "
	  +
	  "t_grievences.remark,t_grievences.current_status,t_grievences.date,t_grievences.extra_var1,t_grievences.extra_var2,t_grievences.platform,t_grievences.grievencce_no,t_grievences.insert_date_time,tn_order_header.order_no,tn_order_header.order_date,tn_order_header.fr_id,tn_order_header.cust_id, "
	  + "m_customer.cust_name,m_customer.phone_number,m_customer.whatsapp_no,\n" +
	  "mn_grievences_type_instructn.caption as type ,mn_grievences_instruction.caption as sub_type,m_franchisee.fr_name,m_franchisee.fr_code, "
	  +
	  "COALESCE((user.user_name),0) as insert_user_name , "
	  + "COALESCE((SELECT COUNT(*) FROM t_grievences_trail WHERE t_grievences_trail.grievences_id=t_grievences.grieve_id),0)   as griv_trail_count  , t_grievences.extra_int1 "
	  +
	  "from tn_order_header,m_customer,mn_grievences_type_instructn,mn_grievences_instruction,m_franchisee,t_grievences "
	  + "left JOIN mn_user user  on t_grievences.insert_by_id=user.user_id \n" +
		//"left JOIN t_grievences_trail trail  on t_grievences.grieve_id=trail.grievences_id \n" + 

	  "WHERE t_grievences.order_id=tn_order_header.order_id and t_grievences.grievence_type_id=mn_grievences_type_instructn.grev_type_id and t_grievences.grievence_subtype_id=mn_grievences_instruction.grievance_id AND m_customer.cust_id=tn_order_header.cust_id "
	  +
	  "and m_franchisee.fr_id=tn_order_header.fr_id and t_grievences.grieve_id=:grieveId  "
	  ,nativeQuery=true)
	  
	  GetGrievanceHeader getGrievanceHeaderByGrieveId(@Param("grieveId")int
	  grieveId);
	 
	@Transactional
	@Modifying
	@Query(value="UPDATE t_grievences SET current_status=:status  WHERE grieve_id=:grieveId",nativeQuery=true)
	int updateGrievHeaderStatus(@Param("grieveId") int grieveId,@Param("status") int status);
	
}
