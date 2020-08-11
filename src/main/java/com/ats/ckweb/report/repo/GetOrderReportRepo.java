package com.ats.ckweb.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.report.model.GetOrderReport;

public interface GetOrderReportRepo extends JpaRepository<GetOrderReport, Integer> {

	@Query(value="SELECT\n" + 
			"    head.order_id,\n" + 
			"    head.order_no,\n" + 
			"    head.order_date,\n" + 
			"    head.delivery_date,\n" + 
			"    head.delivery_time,\n" + 
			"    head.order_status,\n" + 
			"    head.total_amt,\n" + 
			"    head.payment_method,\n" + 
			"    fr.fr_name,\n" + 
			"    fr.fr_code,\n" + 
			"    cust.cust_name,\n" + 
			"    cust.phone_number,\n" + 
			"    0 as ex_int1,\n" + 
			"    0 as ex_int2,\n" + 
			"    0 as ex_int3,\n" + 
			"    0 as ex_int4,\n" + 
			"    'na'as ex_var1,\n" + 
			"    'na'as ex_var2,\n" + 
			"    'na'as ex_var3, \n" + 
			"    'na'as ex_var4,\n" + 
			"    0 as ex_float1,\n" + 
			"    0 as ex_float2,\n" + 
			"    0 as ex_float3,\n" + 
			"    0 as ex_float4\n" + 
			"FROM\n" + 
			"    tn_order_header head,\n" + 
			"    m_customer cust,\n" + 
			"    m_franchisee fr\n" + 
			"WHERE\n" + 
			"    head.del_status=0 AND\n" + 
			"    cust.del_status=0 AND\n" + 
			"    fr.del_status=0 AND\n" + 
			"    head.fr_id=fr.fr_id AND\n" + 
			"    head.cust_id=cust.cust_id AND\n" + 
			"    head.delivery_date BETWEEN :fromDate AND :toDate AND\n" + 
			"    head.order_status=:status ORDER BY head.order_id DESC",nativeQuery=true)
	public List<GetOrderReport> getOrderReportDateWise(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("status") int status);
	
//	@Query(value="SELECT\n" + 
//			"	head.order_id,\n" + 
//			"    head.order_no,\n" + 
//			"    SUM(head.total_amt) AS total_amt,\n" + 
//			"    0 as delivery_date,\n" + 
//			"    fr.fr_name,\n" + 
//			"    fr.fr_code,\n" + 
//			"    head.order_status\n" + 
//			"FROM\n" + 
//			"    tn_order_header head,\n" + 
//			"    m_franchisee fr\n" + 
//			"WHERE\n" + 
//			"	head.del_status=0 AND \n" + 
//			"    head.delivery_date BETWEEN :fromDate AND :toDate AND\n" + 
//			"    head.order_status=:status AND\n" + 
//			"    head.fr_id=fr.fr_id AND\n" + 
//			"    fr.del_status=0 \n" + 
//			"    GROUP BY head.order_no\n" + 
//			"    ORDER BY head.delivery_date DESC", nativeQuery=true)
//	public List<GetOrderReport> getOrderReportBtwenDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
//			@Param("status") int status);
}
