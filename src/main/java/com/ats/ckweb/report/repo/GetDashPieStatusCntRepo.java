package com.ats.ckweb.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.report.model.GetDashPieStatusCnt;

public interface GetDashPieStatusCntRepo extends JpaRepository<GetDashPieStatusCnt, Integer> {

	@Query(value="SELECT\n" + 
			"	UUID() AS id,\n" + 
			"    COUNT(order_status) order_status_cnt,\n" + 
			"    head.order_status,\n" + 
			"    CASE WHEN head.order_status=0 THEN 'Park Order'\n" + 
			"      WHEN head.order_status=1 THEN 'Shop Confirmation Pending'\n" + 
			"       WHEN head.order_status=2 THEN 'Accept'\n" + 
			"        WHEN head.order_status=3 THEN 'Processing'\n" + 
			"         WHEN head.order_status=4 THEN 'Delivery Pending'\n" + 
			"          WHEN head.order_status=5 THEN 'Delivered'\n" + 
			"           WHEN head.order_status=6 THEN 'Rejected by Shop'\n" + 
			"            WHEN head.order_status=7 THEN 'Return Order'\n" + 
			"          	 WHEN head.order_status=8 THEN 'Cancelled Order'\n" + 
			"           ELSE  'Online Payment Pending'\n" + 
			"           END AS status_name,\n" + 
			"    head.ex_int1,\n" + 
			"    head.ex_int2\n" + 
			"FROM\n" + 
			"    tn_order_header head\n" + 
			"WHERE\n" + 
			"    head.del_status=0 AND\n" + 
			"    head.delivery_date BETWEEN :fromDate AND :toDate\n" + 
			"    GROUP BY head.order_status",nativeQuery=true)
	List<GetDashPieStatusCnt> getDashStatusCnt(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
}
