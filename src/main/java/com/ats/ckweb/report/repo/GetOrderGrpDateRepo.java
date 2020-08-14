package com.ats.ckweb.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.report.model.GetOrderGrpDate;

public interface GetOrderGrpDateRepo extends JpaRepository<GetOrderGrpDate, Integer> {

	@Query(value="SELECT\n" + 
			"	 UUID() AS id,\n" + 
			"	 delivery_date,\n" + 
			"    count(order_no) AS order_cnt,\n" + 
			"    SUM(total_amt) AS total_amt,\n" + 
			"    0 AS month_name,\n" + 
			"    0 AS month_no, 0 AS year_val\n" + 
			"FROM\n" + 
			"    `tn_order_header`\n" + 
			"WHERE\n" + 
			"	order_status IN (:statusIds) AND\n" + 
			"    delivery_date BETWEEN :fromDate AND :toDate AND\n" + 
			"    del_status=0\n" + 
			"    GROUP BY delivery_date\n" + 
			"    ORDER BY delivery_date ASC",nativeQuery=true)
	public List<GetOrderGrpDate> getOrderGroupByDate(@Param("statusIds") List<String> statusIds, 
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	@Query(value="SELECT\n" + 
			"    UUID() AS id, 0 AS delivery_date, COUNT(order_no) AS order_cnt,\n" + 
			"    SUM(total_amt) AS total_amt,\n" + 
			"    MONTHNAME(delivery_date) AS month_name,\n" + 
			"    MONTH(delivery_date) AS month_no, YEAR(delivery_date) AS year_val\n" + 
			"FROM\n" + 
			"    tn_order_header\n" + 
			"WHERE\n" + 
			"	del_status=0 AND\n" + 
			"	order_status IN (:statusIds) AND\n" + 
			"   MONTH(delivery_date) BETWEEN MONTH(:fromDate) AND MONTH(:toDate)\n" + 
			"   AND YEAR(delivery_date) BETWEEN YEAR(:fromDate) AND YEAR(:toDate)\n" + 
			"   GROUP BY YEAR(delivery_date),MONTH(delivery_date)\n" + 
			"   ORDER BY YEAR(delivery_date), MONTH(delivery_date) ASC", nativeQuery=true)
	public List<GetOrderGrpDate> getOrderGroupByMonth(@Param("statusIds") List<String> statusIds, 
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);
}
