package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.GetGrievienceList;

public interface GetGrievienceListRepository extends JpaRepository<GetGrievienceList, Integer> {

	@Query(value = "select gr.*,gi.caption as grv_instrustion,gt.caption as grv_type,oh.order_no from t_grievences gr, "
			+ "tn_order_header oh,mn_grievences_instruction gi,mn_grievences_type_instructn gt where oh.order_id=gr.order_id and "
			+ "oh.cust_id=:custId and gi.grievance_id=gr.grievence_subtype_id and gt.grev_type_id=gr.grievence_type_id order by grieve_id desc", nativeQuery = true)
	List<GetGrievienceList> getGrievienceListByCustomerId(@Param("custId") int custId);

	@Query(value = "select gr.*,gi.caption as grv_instrustion,gt.caption as grv_type,oh.order_no from t_grievences gr, "
			+ "tn_order_header oh,mn_grievences_instruction gi,mn_grievences_type_instructn gt where oh.order_id=gr.order_id and "
			+ "gr.grieve_id=:grvId and gi.grievance_id=gr.grievence_subtype_id and gt.grev_type_id=gr.grievence_type_id order by grieve_id desc", nativeQuery = true)
	GetGrievienceList getGriviencevByGrvId(@Param("grvId") int grvId);

	
	
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
			"END AS extra_var1,\n" + 
			"    'NA' AS grv_instrustion,\n" +
			"    'NA' AS grv_type,\n" +
			"    'NA' AS order_no\n" +
			"FROM\n" + 
			"    t_grievences grev\n" + 
			"WHERE\n" + 
			"    grev.order_id = :orderId",nativeQuery=true)
	GetGrievienceList findByOrderId(@Param("orderId") int orderId);
}
