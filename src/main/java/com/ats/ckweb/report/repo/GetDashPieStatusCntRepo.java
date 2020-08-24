package com.ats.ckweb.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.report.model.GetDashPieStatusCnt;

public interface GetDashPieStatusCntRepo extends JpaRepository<GetDashPieStatusCnt, Integer> {

	@Query(value="SELECT\n" + 
			"        UUID() AS id,\n" + 
			"        COUNT(head.order_status) order_status_cnt,\n" + 
			"        head.order_status,\n" + 
			"        CASE \n" + 
			"            WHEN head.order_status=0 THEN 'Park Order'       \n" + 
			"            WHEN head.order_status=1 THEN 'Shop Confirmation Pending'        \n" + 
			"            WHEN head.order_status=2 THEN 'Accept'         \n" + 
			"            WHEN head.order_status=3 THEN 'Processing'          \n" + 
			"            WHEN head.order_status=4 THEN 'Delivery Pending'           \n" + 
			"            WHEN head.order_status=5 THEN 'Delivered'            \n" + 
			"            WHEN head.order_status=6 THEN 'Rejected by Shop'             \n" + 
			"            WHEN head.order_status=7 THEN 'Return Order'             \n" + 
			"            WHEN head.order_status=8 THEN 'Cancelled Order'            \n" + 
			"        ELSE  'Online Payment Pending'            \n" + 
			"        END AS status_name,\n" + 
			"        CONCAT(fr.fr_name,\"-\",fr.fr_code) AS fr_name,        \n" + 
			"        head.ex_int1,\n" + 
			"        head.ex_int2,\n" + 
			"        head.ex_int3,\n" + 
			"        head.ex_float1,\n" + 
			"        head.ex_float2,\n" + 
			"        head.ex_float3,\n" + 
			"        head.ex_var1,\n" + 
			"        head.ex_var2,\n" + 
			"        head.ex_var3\n" + 
			"    FROM\n" + 
			"        tn_order_header head,\n" + 
			"        m_franchisee fr\n" + 
			"    WHERE\n" + 
			"        head.del_status=0 \n" + 
			"        AND     head.delivery_date BETWEEN :fromDate AND :toDate   \n" + 
			"        AND 	head.fr_id=fr.fr_id\n" + 
			"    GROUP BY\n" + 
			"        head.order_status",nativeQuery=true)
	List<GetDashPieStatusCnt> getDashStatusCnt(@Param("fromDate") String fromDate, @Param("toDate") String toDate);


	@Query(value="SELECT \n" + 
			"    UUID() AS id,\n" + 
			"    COUNT(head.order_status) AS order_status_cnt, \n" + 
			"    CASE \n" + 
			"			             WHEN head.order_status=0 THEN 'Park Order'     \n" + 
			"			             WHEN head.order_status=1 THEN 'Shop Confirmation Pending'      \n" + 
			"			             WHEN head.order_status=2 THEN 'Accept'       \n" + 
			"			             WHEN head.order_status=3 THEN 'Processing'        \n" + 
			"			             WHEN head.order_status=4 THEN 'Delivery Pending'         \n" + 
			"			             WHEN head.order_status=5 THEN 'Delivered'          \n" + 
			"			             WHEN head.order_status=6 THEN 'Rejected by Shop'           \n" + 
			"			             WHEN head.order_status=7 THEN 'Return Order'           \n" + 
			"			             WHEN head.order_status=8 THEN 'Cancelled Order'          \n" + 
			"			         ELSE  'Online Payment Pending'          \n" + 
			"			       END AS status_name,\n" + 
			"    head.order_status, \n" + 
			"    fr.fr_id AS ex_int1,\n" + 
			"    CONCAT(fr.fr_name,\"-\",fr.fr_code) AS fr_name,\n" + 
			"    0 AS ex_int2,\n" + 
			"    0 AS ex_int3,\n" + 
			"    SUM(head.total_amt) AS ex_float1,\n" + 
			"    0 AS  ex_float2,\n" + 
			"    0 AS  ex_float3,\n" + 
			"    'na' AS ex_var1,\n" + 
			"    'na' AS ex_var2,\n" + 
			"    'na' AS ex_var3,\n" + 
			"    'na' AS from_date,\n" + 
			"    'na' AS to_date\n" + 
			"FROM \n" + 
			"    tn_order_header head,\n" + 
			"    m_franchisee fr\n" + 
			"WHERE \n" + 
			"    head.del_status=0 AND\n" + 
			"    head.order_status=:status AND\n" + 
			"    head.fr_id = fr.fr_id AND\n" + 
			"    fr.del_status=0 AND \n" + 
			"    head.delivery_date BETWEEN :fromDate AND :toDate\n" + 
			"    \n" + 
			"GROUP BY \n" + 
			"    head.fr_id",nativeQuery=true)
	List<GetDashPieStatusCnt> getStatusCntGrpFr(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("status") String status);

}


//SELECT\n" + 
//"	UUID() AS id,\n" + 
//"    COUNT(order_status) order_status_cnt,\n" + 
//"    head.order_status,\n" + 
//"    CASE WHEN head.order_status=0 THEN 'Park Order'\n" + 
//"      WHEN head.order_status=1 THEN 'Shop Confirmation Pending'\n" + 
//"       WHEN head.order_status=2 THEN 'Accept'\n" + 
//"        WHEN head.order_status=3 THEN 'Processing'\n" + 
//"         WHEN head.order_status=4 THEN 'Delivery Pending'\n" + 
//"          WHEN head.order_status=5 THEN 'Delivered'\n" + 
//"           WHEN head.order_status=6 THEN 'Rejected by Shop'\n" + 
//"            WHEN head.order_status=7 THEN 'Return Order'\n" + 
//"          	 WHEN head.order_status=8 THEN 'Cancelled Order'\n" + 
//"           ELSE  'Online Payment Pending'\n" + 
//"           END AS status_name,\n" + 
//"    head.ex_int1,\n" + 
//"    head.ex_int2\n" + 
//"FROM\n" + 
//"    tn_order_header head\n" + 
//"WHERE\n" + 
//"    head.del_status=0 AND\n" + 
//"    head.delivery_date BETWEEN :fromDate AND :toDate\n" + 
//"    GROUP BY head.order_status


