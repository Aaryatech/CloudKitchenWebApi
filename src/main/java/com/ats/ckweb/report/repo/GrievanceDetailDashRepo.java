package com.ats.ckweb.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.report.model.GrievanceDetailDash;

public interface GrievanceDetailDashRepo extends JpaRepository<GrievanceDetailDash, Integer> {

	@Query(value="SELECT\n" + 
			"		 UUID() AS id,\n" +			
			"		 g.grievencce_no,\n" + 
			"        g.date,\n" + 
			"        g.current_status,\n" + 
			"        g.order_id,\n" + 
			"        CONCAT(c.cust_name,\"-\",c.phone_number) AS cust_name,\n" + 
			"        h.order_no,\n" + 
			"        h.total_amt AS order_amt,\n" + 
			"        g.extra_int1 AS is_set\n" + 
			"    FROM\n" + 
			"        t_grievences g,\n" + 
			"        m_customer c,\n" + 
			"        tn_order_header h\n" + 
			"        WHERE g.order_id=h.order_id AND h.cust_id=c.cust_id AND g.current_status IN(:grievStatus) AND g.extra_int1 IN(:setUnset) AND h.delivery_date BETWEEN :fromDate AND :toDate",nativeQuery=true)
	public List<GrievanceDetailDash> getGrievanceData(@Param("fromDate") String fromDate, @Param("toDate") String toDate, 
			@Param("grievStatus") List<String> grievStatus, @Param("setUnset") List<String> setUnset);
}


//SELECT\n" + 
//"	UUID() AS id,\n" + 
//"    t1.*,\n" + 
//"    COALESCE(t2.settled_cnt,0) AS settled_cnt,\n" + 
//"    COALESCE(t3.unsettled_cnt,0) AS unsettled_cnt\n" + 
//"FROM\n" + 
//"    (\n" + 
//"    SELECT\n" + 
//"        g.order_id,\n" + 
//"        g.grievencce_no,\n" + 
//"        g.date,\n" + 
//"        c.cust_name,\n" + 
//"        h.order_no,\n" + 
//"        SUM(h.total_amt) AS order_amt\n" + 
//"    FROM\n" + 
//"        t_grievences g,\n" + 
//"        m_customer c,\n" + 
//"        tn_order_header h\n" + 
//"        WHERE g.order_id=h.order_id AND h.cust_id=c.cust_id AND g.current_status IN (:grievStatus) AND g.extra_int1 IN (:setUnset) AND h.delivery_date BETWEEN :fromDate AND :toDate\n" + 
//"    GROUP BY\n" + 
//"        g.order_id\n" + 
//") t1\n" + 
//"LEFT JOIN(\n" + 
//"    SELECT COUNT(*) AS settled_cnt,\n" + 
//"        g.order_id\n" + 
//"    FROM\n" + 
//"        t_grievences g\n" + 
//"    WHERE\n" + 
//"        g.extra_int1 = 1 AND g.current_status IN (:grievStatus)\n" + 
//"    GROUP BY\n" + 
//"        g.order_id\n" + 
//") t2\n" + 
//"ON\n" + 
//"    t1.order_id = t2.order_id\n" + 
//"LEFT JOIN(\n" + 
//"    SELECT COUNT(*) AS unsettled_cnt,\n" + 
//"        g.order_id\n" + 
//"    FROM\n" + 
//"        t_grievences g\n" + 
//"    WHERE\n" + 
//"        g.extra_int1 = 0 AND g.current_status IN (:grievStatus)\n" + 
//"    GROUP BY\n" + 
//"        g.order_id\n" + 
//") t3\n" + 
//"ON\n" + 
//"    t1.order_id = t3.order_id
