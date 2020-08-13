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

}
