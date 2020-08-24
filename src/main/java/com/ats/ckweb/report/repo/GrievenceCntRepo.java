package com.ats.ckweb.report.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.report.model.GrievenceCnt;
@Repository
public interface GrievenceCntRepo extends JpaRepository<GrievenceCnt, Integer> {

	@Query(value="SELECT\n" + 
			"    UUID() AS id,\n" + 
			"    COALESCE(t1.total_cnt, 0) AS total_cnt,\n" + 
			"    COALESCE(t2.total_amt, 0) AS total_amt,\n" + 
			"    COALESCE(t3.pending_amt, 0) AS pending_amt,\n" + 
			"    COALESCE(t4.pending_cnt, 0) AS pending_cnt,\n" + 
			"    COALESCE(t5.resolved_amt, 0) AS resolved_amt, \n" + 
			"    COALESCE(t6.resolved_cnt, 0) AS resolved_cnt,\n" + 
			"    COALESCE(t7.damaged_amt, 0) AS damaged_amt,\n" + 
			"    COALESCE(t8.damaged_cnt, 0) AS damaged_cnt,\n" + 
			"    COALESCE(t9.settled_amt, 0) AS settled_amt,\n" + 
			"    COALESCE(t10.settled_cnt, 0) AS settled_cnt,\n" + 
			"    COALESCE(t11.un_settled_amt, 0) AS un_settled_amt,\n" + 
			"    COALESCE(t12.un_settled_cnt, 0) AS un_settled_cnt\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        COUNT(*) AS total_cnt,\n" + 
			"        1 AS flag\n" + 
			"    FROM\n" + 
			"        `t_grievences`\n" + 
			"    WHERE\n" + 
			"        t_grievences.date BETWEEN  :fromDate AND :toDate\n" + 
			") t1\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        SUM(h.total_amt) AS total_amt,\n" + 
			"        1 AS flag\n" + 
			"    FROM\n" + 
			"        tn_order_header h,\n" + 
			"        t_grievences g\n" + 
			"    WHERE\n" + 
			"        h.order_id = g.order_id AND g.date BETWEEN  :fromDate AND :toDate\n" + 
			") t2\n" + 
			"ON\n" + 
			"    t1.flag = t2.flag\n" + 
			"    \n" + 
			"    LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        SUM(h.total_amt) AS pending_amt,\n" + 
			"        1 AS flag\n" + 
			"    FROM\n" + 
			"        tn_order_header h,\n" + 
			"        t_grievences g\n" + 
			"    WHERE\n" + 
			"        h.order_id = g.order_id AND g.date BETWEEN  :fromDate AND :toDate\n" + 
			"        AND g.current_status=0\n" + 
			") t3\n" + 
			"ON\n" + 
			"    t1.flag = t3.flag\n" + 
			"      LEFT JOIN(\n" + 
			"     SELECT\n" + 
			"        COUNT(*) AS pending_cnt,\n" + 
			"        1 AS flag\n" + 
			"    FROM\n" + 
			"        `t_grievences` \n" + 
			"    WHERE\n" + 
			"        t_grievences.date BETWEEN  :fromDate AND :toDate\n" + 
			"        AND current_status=0\n" + 
			") t4\n" + 
			"ON\n" + 
			"    t1.flag = t4.flag\n" + 
			"    \n" + 
			"    LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        SUM(h.total_amt) AS resolved_amt,\n" + 
			"        1 AS flag\n" + 
			"    FROM\n" + 
			"        tn_order_header h,\n" + 
			"        t_grievences g\n" + 
			"    WHERE\n" + 
			"        h.order_id = g.order_id AND g.date BETWEEN  :fromDate AND :toDate\n" + 
			"        AND g.current_status=1\n" + 
			") t5\n" + 
			"ON\n" + 
			"    t1.flag = t5.flag\n" + 
			"      LEFT JOIN(\n" + 
			"     SELECT\n" + 
			"        COUNT(*) AS resolved_cnt,\n" + 
			"        1 AS flag\n" + 
			"    FROM\n" + 
			"        `t_grievences` \n" + 
			"    WHERE\n" + 
			"        t_grievences.date BETWEEN  :fromDate AND :toDate\n" + 
			"        AND current_status=1\n" + 
			") t6\n" + 
			"ON\n" + 
			"    t1.flag = t6.flag\n" + 
			"    \n" + 
			" LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        SUM(h.total_amt) AS damaged_amt,\n" + 
			"        1 AS flag\n" + 
			"    FROM\n" + 
			"        tn_order_header h,\n" + 
			"        t_grievences g\n" + 
			"    WHERE\n" + 
			"        h.order_id = g.order_id AND g.date BETWEEN  :fromDate AND :toDate\n" + 
			"        AND g.current_status=2\n" + 
			") t7\n" + 
			"ON\n" + 
			"    t1.flag = t7.flag\n" + 
			"      LEFT JOIN(\n" + 
			"     SELECT\n" + 
			"        COUNT(*) AS damaged_cnt,\n" + 
			"        1 AS flag\n" + 
			"    FROM\n" + 
			"        `t_grievences` \n" + 
			"    WHERE\n" + 
			"        t_grievences.date BETWEEN  :fromDate AND :toDate\n" + 
			"        AND current_status=2\n" + 
			") t8\n" + 
			"ON\n" + 
			"    t1.flag = t8.flag\n" + 
			"    \n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        SUM(h.total_amt) AS settled_amt,\n" + 
			"        1 AS flag\n" + 
			"    FROM\n" + 
			"        tn_order_header h,\n" + 
			"        t_grievences g\n" + 
			"    WHERE\n" + 
			"        h.order_id = g.order_id AND g.date BETWEEN  :fromDate AND :toDate\n" + 
			"        AND g.extra_int1=1\n" + 
			") t9\n" + 
			"ON\n" + 
			"    t1.flag = t9.flag\n" + 
			"      LEFT JOIN(\n" + 
			"     SELECT\n" + 
			"        COUNT(*) AS settled_cnt,\n" + 
			"        1 AS flag\n" + 
			"    FROM\n" + 
			"        `t_grievences` \n" + 
			"    WHERE\n" + 
			"        t_grievences.date BETWEEN  :fromDate AND :toDate\n" + 
			"        AND extra_int1=1\n" + 
			") t10\n" + 
			"ON\n" + 
			"    t1.flag = t10.flag\n" + 
			"\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        SUM(h.total_amt) AS un_settled_amt,\n" + 
			"        1 AS flag\n" + 
			"    FROM\n" + 
			"        tn_order_header h,\n" + 
			"        t_grievences g\n" + 
			"    WHERE\n" + 
			"        h.order_id = g.order_id AND g.date BETWEEN :fromDate AND :toDate\n" + 
			"        AND g.extra_int1=0\n" + 
			") t11\n" + 
			"ON\n" + 
			"    t1.flag = t11.flag\n" + 
			"      LEFT JOIN(\n" + 
			"     SELECT\n" + 
			"        COUNT(*) AS un_settled_cnt,\n" + 
			"        1 AS flag\n" + 
			"    FROM\n" + 
			"        `t_grievences` \n" + 
			"    WHERE\n" + 
			"        t_grievences.date BETWEEN :fromDate AND :toDate\n" + 
			"        AND extra_int1=0\n" + 
			") t12\n" + 
			"ON\n" + 
			"    t1.flag = t12.flag", nativeQuery=true)
	public GrievenceCnt getGrievenceCntData(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
}
