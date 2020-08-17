package com.ats.ckweb.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.report.model.GrievanceDatewise;

public interface GrievanceDatewiseRepo extends JpaRepository<GrievanceDatewise, Integer> {

	@Query(value = " SELECT  UUID() as id,tn_order_header.delivery_date, tn_order_header.delivery_date AS delivery_month, "
			+ " SUM( tn_order_header.total_amt) as total_amt,COUNT(t_grievences.grieve_id) as griv_count,"
			+ "  mn_grievences_type_instructn.caption as filter_name,0 as e_pay, 0 as cash_pay "
			+ " FROM tn_order_header,mn_grievences_type_instructn,t_grievences,"
			+ " mn_grievences_instruction, m_franchisee "
			+ " WHERE "
			+ " t_grievences.order_id=tn_order_header.order_id and tn_order_header.fr_id=m_franchisee.fr_id "
			+ "  and t_grievences.grievence_type_id=mn_grievences_type_instructn.grev_type_id "
			+ " and t_grievences.grievence_subtype_id=mn_grievences_instruction.grievance_id  "
			+ " and  tn_order_header.delivery_date BETWEEN :fromDate and :toDate  "
			+ " and m_franchisee.fr_id in (:frIdList)  AND "
			+ " mn_grievences_type_instructn.grev_type_id in (:grievTypeIdList ) "
			+ " AND mn_grievences_instruction.grievance_id in (:grievSubTypeList) and "
			+ " t_grievences.current_status in (:statusList) "
			+ " GROUP by "
			+ " tn_order_header.delivery_date,t_grievences.grievence_type_id ", nativeQuery = true)
	List<GrievanceDatewise> getGrievanceDatewiseGrpByGrivType(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("frIdList") List<Integer> frIdList,
			@Param("grievTypeIdList") List<Integer> grievTypeIdList,
			@Param("grievSubTypeList") List<Integer> grievSubTypeList, @Param("statusList") List<Integer> statusList);

	
	@Query(value = " SELECT  UUID() as id,tn_order_header.delivery_date, tn_order_header.delivery_date AS delivery_month, "
			+ " SUM( tn_order_header.total_amt) as total_amt,COUNT(t_grievences.grieve_id) as griv_count,"
			+ "  mn_grievences_instruction.caption as filter_name,0 as e_pay, 0 as cash_pay "
			+ " FROM tn_order_header,mn_grievences_type_instructn,t_grievences,"
			+ " mn_grievences_instruction, m_franchisee "
			+ " WHERE "
			+ " t_grievences.order_id=tn_order_header.order_id and tn_order_header.fr_id=m_franchisee.fr_id "
			+ "  and t_grievences.grievence_type_id=mn_grievences_type_instructn.grev_type_id    "
			+ " and t_grievences.grievence_subtype_id=mn_grievences_instruction.grievance_id  "
			+ " and  tn_order_header.delivery_date BETWEEN :fromDate and :toDate  "
			+ " and m_franchisee.fr_id in (:frIdList)  and "
			+ " mn_grievences_type_instructn.grev_type_id in (:grievTypeIdList ) "
			+ " AND mn_grievences_instruction.grievance_id in (:grievSubTypeList) and "
			+ " t_grievences.current_status in (:statusList) "
			+ " GROUP by "
			+ " tn_order_header.delivery_date,t_grievences.grievence_subtype_id ", nativeQuery = true)
	List<GrievanceDatewise> getGrievanceDatewiseGrpByGrivSubType(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("frIdList") List<Integer> frIdList,
			@Param("grievTypeIdList") List<Integer> grievTypeIdList,
			@Param("grievSubTypeList") List<Integer> grievSubTypeList, @Param("statusList") List<Integer> statusList);

	
	@Query(value = " SELECT  UUID() as id,tn_order_header.delivery_date, tn_order_header.delivery_date AS delivery_month, "
			+ " SUM( tn_order_header.total_amt) as total_amt,COUNT(t_grievences.grieve_id) as griv_count,"
			+ "  m_franchisee.fr_name as filter_name,0 as e_pay, 0 as cash_pay "
			+ " FROM tn_order_header,mn_grievences_type_instructn,t_grievences,"
			+ " mn_grievences_instruction, m_franchisee "
			+ " WHERE "
			+ " t_grievences.order_id=tn_order_header.order_id and tn_order_header.fr_id=m_franchisee.fr_id "
			+ "  and t_grievences.grievence_type_id=mn_grievences_type_instructn.grev_type_id    "
			+ " and t_grievences.grievence_subtype_id=mn_grievences_instruction.grievance_id  "
			+ " and  tn_order_header.delivery_date BETWEEN :fromDate and :toDate  "
			+ " and m_franchisee.fr_id in (:frIdList)  and "
			+ " mn_grievences_type_instructn.grev_type_id in (:grievTypeIdList ) "
			+ " AND mn_grievences_instruction.grievance_id in (:grievSubTypeList) and "
			+ " t_grievences.current_status in (:statusList) "
			+ " GROUP by "
			+ " tn_order_header.delivery_date,tn_order_header.fr_id ", nativeQuery = true)
	List<GrievanceDatewise> getGrievanceDatewiseGrpByFrId(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("frIdList") List<Integer> frIdList,
			@Param("grievTypeIdList") List<Integer> grievTypeIdList,
			@Param("grievSubTypeList") List<Integer> grievSubTypeList, @Param("statusList") List<Integer> statusList);
	/*************************************************************************************************/
	
	//Sachin 14-08-2020 04:39
	@Query(value = " SELECT  UUID() as id,tn_order_header.delivery_date, tn_order_header.delivery_date AS delivery_month, "
			+ " SUM( tn_order_header.total_amt) as total_amt,COUNT(t_grievences.grieve_id) as griv_count,"
			+ "  mn_grievences_type_instructn.caption as filter_name,0 as e_pay, 0 as cash_pay "
			+ " FROM tn_order_header,mn_grievences_type_instructn,t_grievences,"
			+ " mn_grievences_instruction, m_franchisee "
			+ " WHERE "
			+ " t_grievences.order_id=tn_order_header.order_id and tn_order_header.fr_id=m_franchisee.fr_id "
			+ "  and t_grievences.grievence_type_id=mn_grievences_type_instructn.grev_type_id "
			+ " and t_grievences.grievence_subtype_id=mn_grievences_instruction.grievance_id  "
			+ " and  tn_order_header.delivery_date BETWEEN :fromDate and :toDate  "
			+ " and m_franchisee.fr_id in (:frIdList)  AND "
			+ " mn_grievences_type_instructn.grev_type_id in (:grievTypeIdList ) "
			+ " AND mn_grievences_instruction.grievance_id in (:grievSubTypeList) and "
			+ " t_grievences.current_status in (:statusList) "
			+ " GROUP by "
			+ " YEAR(tn_order_header.delivery_date),MONTH(tn_order_header.delivery_date),t_grievences.grievence_type_id ", nativeQuery = true)
	List<GrievanceDatewise> getGrievanceDatewiseGrpByGrivTypeM1(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("frIdList") List<Integer> frIdList,
			@Param("grievTypeIdList") List<Integer> grievTypeIdList,
			@Param("grievSubTypeList") List<Integer> grievSubTypeList, @Param("statusList") List<Integer> statusList);

	
	@Query(value = " SELECT  UUID() as id,tn_order_header.delivery_date, tn_order_header.delivery_date AS delivery_month, "
			+ " SUM( tn_order_header.total_amt) as total_amt,COUNT(t_grievences.grieve_id) as griv_count,"
			+ "  mn_grievences_instruction.caption as filter_name,0 as e_pay, 0 as cash_pay "
			+ " FROM tn_order_header,mn_grievences_type_instructn,t_grievences,"
			+ " mn_grievences_instruction, m_franchisee "
			+ " WHERE "
			+ " t_grievences.order_id=tn_order_header.order_id and tn_order_header.fr_id=m_franchisee.fr_id "
			+ "  and t_grievences.grievence_type_id=mn_grievences_type_instructn.grev_type_id    "
			+ " and t_grievences.grievence_subtype_id=mn_grievences_instruction.grievance_id  "
			+ " and  tn_order_header.delivery_date BETWEEN :fromDate and :toDate  "
			+ " and m_franchisee.fr_id in (:frIdList)  and "
			+ " mn_grievences_type_instructn.grev_type_id in (:grievTypeIdList ) "
			+ " AND mn_grievences_instruction.grievance_id in (:grievSubTypeList) and "
			+ " t_grievences.current_status in (:statusList) "
			+ " GROUP by "
			+ " YEAR(tn_order_header.delivery_date),MONTH(tn_order_header.delivery_date),t_grievences.grievence_subtype_id ", nativeQuery = true)
	List<GrievanceDatewise> getGrievanceDatewiseGrpByGrivSubTypeM2(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("frIdList") List<Integer> frIdList,
			@Param("grievTypeIdList") List<Integer> grievTypeIdList,
			@Param("grievSubTypeList") List<Integer> grievSubTypeList, @Param("statusList") List<Integer> statusList);

	
	@Query(value = " SELECT  UUID() as id,tn_order_header.delivery_date, tn_order_header.delivery_date AS delivery_month, "
			+ " SUM( tn_order_header.total_amt) as total_amt,COUNT(t_grievences.grieve_id) as griv_count,"
			+ "  m_franchisee.fr_name as filter_name,0 as e_pay, 0 as cash_pay "
			+ " FROM tn_order_header,mn_grievences_type_instructn,t_grievences,"
			+ " mn_grievences_instruction, m_franchisee "
			+ " WHERE "
			+ " t_grievences.order_id=tn_order_header.order_id and tn_order_header.fr_id=m_franchisee.fr_id "
			+ "  and t_grievences.grievence_type_id=mn_grievences_type_instructn.grev_type_id    "
			+ " and t_grievences.grievence_subtype_id=mn_grievences_instruction.grievance_id  "
			+ " and  tn_order_header.delivery_date BETWEEN :fromDate and :toDate  "
			+ " and m_franchisee.fr_id in (:frIdList)  and "
			+ " mn_grievences_type_instructn.grev_type_id in (:grievTypeIdList ) "
			+ " AND mn_grievences_instruction.grievance_id in (:grievSubTypeList) and "
			+ " t_grievences.current_status in (:statusList) "
			+ " GROUP by "
			+ " YEAR(tn_order_header.delivery_date),MONTH(tn_order_header.delivery_date),tn_order_header.fr_id ", nativeQuery = true)
	List<GrievanceDatewise> getGrievanceDatewiseGrpByFrIdM3(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("frIdList") List<Integer> frIdList,
			@Param("grievTypeIdList") List<Integer> grievTypeIdList,
			@Param("grievSubTypeList") List<Integer> grievSubTypeList, @Param("statusList") List<Integer> statusList);

	
}
