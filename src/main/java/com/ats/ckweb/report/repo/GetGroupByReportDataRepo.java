package com.ats.ckweb.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.report.model.GetGroupByReportData;

public interface GetGroupByReportDataRepo extends JpaRepository<GetGroupByReportData, Integer> {

	@Query(value="SELECT\r\n" + 
			"    t1.*,\r\n" + 
			"    COALESCE(t2.order_count, 0) AS order_count\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        UUID() AS u_id, h.fr_id, CONCAT(f.fr_name, ' - ', f.fr_code) AS fr_name,\r\n" + 
			"        0 AS cust_id,\r\n" + 
			"        '' AS cust_name,\r\n" + 
			"        0 AS order_coming_from_id,\r\n" + 
			"        '' AS order_coming_from_name,\r\n" + 
			"        0 AS pay_mode_id,\r\n" + 
			"        '' AS pay_mode_name,\r\n" + 
			"        h.delivery_date,\r\n" + 
			"        DATE_FORMAT(h.delivery_date, '%d-%m-%Y') AS delivery_date_disp,\r\n" + 
			"        MONTH(h.delivery_date) AS delivery_month,\r\n" + 
			"        YEAR(h.delivery_date) AS delivery_year,\r\n" + 
			"        CONCAT(\r\n" + 
			"            MONTHNAME(h.delivery_date),\r\n" + 
			"            ' - ',\r\n" + 
			"            YEAR(h.delivery_date)\r\n" + 
			"        ) AS month_name,\r\n" + 
			"        COALESCE(SUM(h.total_amt),\r\n" + 
			"        0) AS total_amt,\r\n" + 
			"        :status AS status_list\r\n" + 
			"    FROM\r\n" + 
			"        tn_order_header h,\r\n" + 
			"        m_franchisee f\r\n" + 
			"    WHERE\r\n" + 
			"        h.fr_id = f.fr_id AND h.del_status = 0 AND f.del_status = 0 AND h.delivery_date BETWEEN :fromDate AND :toDate AND h.order_status IN(:status) AND h.fr_id IN(:frIds)\r\n" + 
			"    GROUP BY\r\n" + 
			"        h.fr_id,\r\n" + 
			"        h.delivery_date) t1\r\n" + 
			"    LEFT JOIN(\r\n" + 
			"        SELECT\r\n" + 
			"            COUNT(*) AS order_count,\r\n" + 
			"            h.fr_id,\r\n" + 
			"            h.delivery_date\r\n" + 
			"        FROM\r\n" + 
			"            tn_order_header h\r\n" + 
			"        WHERE\r\n" + 
			"            h.del_status = 0 AND h.delivery_date BETWEEN :fromDate AND :toDate AND h.order_status IN(:status) AND h.fr_id IN(:frIds)\r\n" + 
			"        GROUP BY\r\n" + 
			"            h.fr_id,\r\n" + 
			"            h.delivery_date\r\n" + 
			"    ) t2\r\n" + 
			"ON\r\n" + 
			"    t1.fr_id = t2.fr_id AND t1.delivery_date = t2.delivery_date\r\n" + 
			"ORDER BY\r\n" + 
			"    delivery_date,\r\n" + 
			"    fr_id",nativeQuery=true)
	List<GetGroupByReportData> getOrderReportGroupByDateForFr(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("status") List<Integer> status, @Param("frIds") List<Integer> frIds);

	
	@Query(value="SELECT\r\n" + 
			"    t1.*,\r\n" + 
			"    COALESCE(t2.order_count, 0) AS order_count\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        UUID() AS u_id, h.fr_id, CONCAT(f.fr_name, ' - ', f.fr_code) AS fr_name,\r\n" + 
			"        0 AS cust_id,\r\n" + 
			"        '' AS cust_name,\r\n" + 
			"        0 AS order_coming_from_id,\r\n" + 
			"        '' AS order_coming_from_name,\r\n" + 
			"        0 AS pay_mode_id,\r\n" + 
			"        '' AS pay_mode_name,\r\n" + 
			"        h.delivery_date,\r\n" + 
			"        DATE_FORMAT(h.delivery_date, '%d-%m-%Y') AS delivery_date_disp,\r\n" + 
			"        MONTH(h.delivery_date) AS delivery_month,\r\n" + 
			"        YEAR(h.delivery_date) AS delivery_year,\r\n" + 
			"        CONCAT(\r\n" + 
			"            MONTHNAME(h.delivery_date),\r\n" + 
			"            ' - ',\r\n" + 
			"            YEAR(h.delivery_date)\r\n" + 
			"        ) AS month_name,\r\n" + 
			"        COALESCE(SUM(h.total_amt),\r\n" + 
			"        0) AS total_amt,\r\n" + 
			"        :status AS status_list\r\n" + 
			"    FROM\r\n" + 
			"        tn_order_header h,\r\n" + 
			"        m_franchisee f\r\n" + 
			"    WHERE\r\n" + 
			"        h.fr_id = f.fr_id AND h.del_status = 0 AND f.del_status = 0 AND h.delivery_date BETWEEN :fromDate AND :toDate AND h.order_status IN(:status) AND h.fr_id IN(:frIds)\r\n" + 
			"    GROUP BY\r\n" + 
			"        h.fr_id,\r\n" + 
			"        MONTH(h.delivery_date),\r\n" + 
			"        YEAR(h.delivery_date)) t1\r\n" + 
			"    LEFT JOIN(\r\n" + 
			"        SELECT\r\n" + 
			"            COUNT(*) AS order_count,\r\n" + 
			"            h.fr_id,\r\n" + 
			"            h.delivery_date,\r\n" + 
			"            MONTH(h.delivery_date) AS delivery_month,\r\n" + 
			"            YEAR(h.delivery_date) AS delivery_year\r\n" + 
			"        FROM\r\n" + 
			"            tn_order_header h\r\n" + 
			"        WHERE\r\n" + 
			"            h.del_status = 0 AND h.delivery_date BETWEEN :fromDate AND :toDate AND h.order_status IN(:status) AND h.fr_id IN(:frIds)\r\n" + 
			"        GROUP BY\r\n" + 
			"            h.fr_id,\r\n" + 
			"            MONTH(h.delivery_date),\r\n" + 
			"            YEAR(h.delivery_date)\r\n" + 
			"    ) t2\r\n" + 
			"ON\r\n" + 
			"    t1.fr_id = t2.fr_id AND t1.delivery_month = t2.delivery_month AND t1.delivery_year = t2.delivery_year\r\n" + 
			"ORDER BY\r\n" + 
			"    delivery_year,\r\n" + 
			"    delivery_month,\r\n" + 
			"    fr_id",nativeQuery=true)
	List<GetGroupByReportData> getOrderReportGroupByMonthForFr(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("status") List<Integer> status, @Param("frIds") List<Integer> frIds);

	
	@Query(value="SELECT\r\n" + 
			"    t1.*,\r\n" + 
			"    COALESCE(t2.order_count, 0) AS order_count\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        UUID() AS u_id, 0 AS fr_id, '' AS fr_name, h.cust_id AS cust_id, CONCAT(c.cust_name, ' - ', c.phone_number) AS cust_name,\r\n" + 
			"        0 AS order_coming_from_id,\r\n" + 
			"        '' AS order_coming_from_name,\r\n" + 
			"        0 AS pay_mode_id,\r\n" + 
			"        '' AS pay_mode_name,\r\n" + 
			"        h.delivery_date,\r\n" + 
			"        DATE_FORMAT(h.delivery_date, '%d-%m-%Y') AS delivery_date_disp,\r\n" + 
			"        MONTH(h.delivery_date) AS delivery_month,\r\n" + 
			"        YEAR(h.delivery_date) AS delivery_year,\r\n" + 
			"        CONCAT(\r\n" + 
			"            MONTHNAME(h.delivery_date),\r\n" + 
			"            ' - ',\r\n" + 
			"            YEAR(h.delivery_date)\r\n" + 
			"        ) AS month_name,\r\n" + 
			"        COALESCE(SUM(h.total_amt),\r\n" + 
			"        0) AS total_amt,\r\n" + 
			"        :status AS status_list\r\n" + 
			"    FROM\r\n" + 
			"        tn_order_header h,\r\n" + 
			"        m_customer c\r\n" + 
			"    WHERE\r\n" + 
			"        h.cust_id = c.cust_id AND h.del_status = 0 AND c.del_status = 0 AND h.delivery_date BETWEEN :fromDate AND :toDate AND h.order_status IN(:status) AND h.cust_id IN(:custIds)\r\n" + 
			"    GROUP BY\r\n" + 
			"        h.cust_id,\r\n" + 
			"        h.delivery_date) t1\r\n" + 
			"    LEFT JOIN(\r\n" + 
			"        SELECT\r\n" + 
			"            COUNT(*) AS order_count,\r\n" + 
			"            h.cust_id,\r\n" + 
			"            h.delivery_date\r\n" + 
			"        FROM\r\n" + 
			"            tn_order_header h\r\n" + 
			"        WHERE\r\n" + 
			"            h.del_status = 0 AND h.delivery_date BETWEEN :fromDate AND :toDate AND h.order_status IN(:status) AND h.cust_id IN(:custIds)\r\n" + 
			"        GROUP BY\r\n" + 
			"            h.cust_id,\r\n" + 
			"            h.delivery_date\r\n" + 
			"    ) t2\r\n" + 
			"ON\r\n" + 
			"    t1.cust_id = t2.cust_id AND t1.delivery_date = t2.delivery_date\r\n" + 
			"ORDER BY\r\n" + 
			"    delivery_date,\r\n" + 
			"    cust_name",nativeQuery=true)
	List<GetGroupByReportData> getOrderReportGroupByDateForCust(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("status") List<Integer> status, @Param("custIds") List<Integer> custIds);

	
	@Query(value="SELECT\r\n" + 
			"    t1.*,\r\n" + 
			"    COALESCE(t2.order_count, 0) AS order_count\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        UUID() AS u_id, 0 AS fr_id, '' AS fr_name, h.cust_id AS cust_id, CONCAT(c.cust_name, ' - ', c.phone_number) AS cust_name,\r\n" + 
			"        0 AS order_coming_from_id,\r\n" + 
			"        '' AS order_coming_from_name,\r\n" + 
			"        0 AS pay_mode_id,\r\n" + 
			"        '' AS pay_mode_name,\r\n" + 
			"        h.delivery_date,\r\n" + 
			"        DATE_FORMAT(h.delivery_date, '%d-%m-%Y') AS delivery_date_disp,\r\n" + 
			"        MONTH(h.delivery_date) AS delivery_month,\r\n" + 
			"        YEAR(h.delivery_date) AS delivery_year,\r\n" + 
			"        CONCAT(\r\n" + 
			"            MONTHNAME(h.delivery_date),\r\n" + 
			"            ' - ',\r\n" + 
			"            YEAR(h.delivery_date)\r\n" + 
			"        ) AS month_name,\r\n" + 
			"        COALESCE(SUM(h.total_amt),\r\n" + 
			"        0) AS total_amt,\r\n" + 
			"        :status AS status_list\r\n" + 
			"    FROM\r\n" + 
			"        tn_order_header h,\r\n" + 
			"        m_customer c\r\n" + 
			"    WHERE\r\n" + 
			"        h.cust_id = c.cust_id AND h.del_status = 0 AND c.del_status = 0 AND h.delivery_date BETWEEN :fromDate AND :toDate AND h.order_status IN(:status) AND h.cust_id IN(:custIds)\r\n" + 
			"    GROUP BY\r\n" + 
			"        h.cust_id,\r\n" + 
			"        MONTH(h.delivery_date),\r\n" + 
			"        YEAR(h.delivery_date)) t1\r\n" + 
			"    LEFT JOIN(\r\n" + 
			"        SELECT\r\n" + 
			"            COUNT(*) AS order_count,\r\n" + 
			"            h.cust_id,\r\n" + 
			"            h.delivery_date,\r\n" + 
			"            MONTH(h.delivery_date) AS delivery_month,\r\n" + 
			"            YEAR(h.delivery_date) AS delivery_year\r\n" + 
			"        FROM\r\n" + 
			"            tn_order_header h\r\n" + 
			"        WHERE\r\n" + 
			"            h.del_status = 0 AND h.delivery_date BETWEEN :fromDate AND :toDate AND h.order_status IN(:status) AND h.cust_id IN(:custIds)\r\n" + 
			"        GROUP BY\r\n" + 
			"            h.cust_id,\r\n" + 
			"            MONTH(h.delivery_date),\r\n" + 
			"            YEAR(h.delivery_date)\r\n" + 
			"    ) t2\r\n" + 
			"ON\r\n" + 
			"    t1.cust_id = t2.cust_id AND t1.delivery_month = t2.delivery_month AND t1.delivery_year = t2.delivery_year\r\n" + 
			"ORDER BY\r\n" + 
			"    delivery_year,\r\n" + 
			"    delivery_month,\r\n" + 
			"    cust_name",nativeQuery=true)
	List<GetGroupByReportData> getOrderReportGroupByMonthForCust(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("status") List<Integer> status, @Param("custIds") List<Integer> custIds);

	
	@Query(value="SELECT\r\n" + 
			"    t1.*,\r\n" + 
			"    COALESCE(t2.order_count, 0) AS order_count\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        UUID() AS u_id, 0 AS fr_id, '' AS fr_name, 0 AS cust_id, '' AS cust_name, h.order_platform AS order_coming_from_id, CASE WHEN h.order_platform = 1 THEN 'Executive' ELSE CASE WHEN h.order_platform = 2 THEN 'Mobile App' ELSE CASE WHEN h.order_platform = 3 THEN 'Website' ELSE ''\r\n" + 
			"        END\r\n" + 
			"END\r\n" + 
			"END AS order_coming_from_name, 0 AS pay_mode_id, '' AS pay_mode_name, h.delivery_date, DATE_FORMAT(h.delivery_date, '%d-%m-%Y') AS delivery_date_disp,\r\n" + 
			"MONTH(h.delivery_date) AS delivery_month,\r\n" + 
			"YEAR(h.delivery_date) AS delivery_year,\r\n" + 
			"CONCAT(\r\n" + 
			"    MONTHNAME(h.delivery_date),\r\n" + 
			"    ' - ',\r\n" + 
			"    YEAR(h.delivery_date)\r\n" + 
			") AS month_name,\r\n" + 
			"COALESCE(SUM(h.total_amt),\r\n" + 
			"0) AS total_amt,\r\n" + 
			":status AS status_list\r\n" + 
			"FROM\r\n" + 
			"    tn_order_header h\r\n" + 
			"WHERE\r\n" + 
			"    h.del_status = 0 AND h.delivery_date BETWEEN :fromDate AND :toDate AND h.order_status IN(:status) AND h.order_platform IN(:platform)\r\n" + 
			"GROUP BY\r\n" + 
			"    h.order_platform,\r\n" + 
			"    h.delivery_date) t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        COUNT(*) AS order_count,\r\n" + 
			"        h.order_platform,\r\n" + 
			"        h.delivery_date\r\n" + 
			"    FROM\r\n" + 
			"        tn_order_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.del_status = 0 AND h.delivery_date BETWEEN :fromDate AND :toDate AND h.order_status IN(:status) AND h.order_platform IN(:platform)\r\n" + 
			"    GROUP BY\r\n" + 
			"        h.order_platform,\r\n" + 
			"        h.delivery_date\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.order_coming_from_id = t2.order_platform AND t1.delivery_date = t2.delivery_date\r\n" + 
			"ORDER BY\r\n" + 
			"    delivery_date,\r\n" + 
			"    order_coming_from_id",nativeQuery=true)
	List<GetGroupByReportData> getOrderReportGroupByDateForPlatform(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("status") List<Integer> status, @Param("platform") List<Integer> platform);

	
	@Query(value="SELECT\r\n" + 
			"    t1.*,\r\n" + 
			"    COALESCE(t2.order_count, 0) AS order_count\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        UUID() AS u_id, 0 AS fr_id, '' AS fr_name, 0 AS cust_id, '' AS cust_name, h.order_platform AS order_coming_from_id, CASE WHEN h.order_platform = 1 THEN 'Executive' ELSE CASE WHEN h.order_platform = 2 THEN 'Mobile App' ELSE CASE WHEN h.order_platform = 3 THEN 'Website' ELSE ''\r\n" + 
			"        END\r\n" + 
			"END\r\n" + 
			"END AS order_coming_from_name, 0 AS pay_mode_id, '' AS pay_mode_name, h.delivery_date, DATE_FORMAT(h.delivery_date, '%d-%m-%Y') AS delivery_date_disp,\r\n" + 
			"MONTH(h.delivery_date) AS delivery_month,\r\n" + 
			"YEAR(h.delivery_date) AS delivery_year,\r\n" + 
			"CONCAT(\r\n" + 
			"    MONTHNAME(h.delivery_date),\r\n" + 
			"    ' - ',\r\n" + 
			"    YEAR(h.delivery_date)\r\n" + 
			") AS month_name,\r\n" + 
			"COALESCE(SUM(h.total_amt),\r\n" + 
			"0) AS total_amt,\r\n" + 
			":status AS status_list\r\n" + 
			"FROM\r\n" + 
			"    tn_order_header h\r\n" + 
			"WHERE\r\n" + 
			"    h.del_status = 0 AND h.delivery_date BETWEEN :fromDate AND :toDate AND h.order_status IN(:status) AND h.order_platform IN(:platform)\r\n" + 
			"GROUP BY\r\n" + 
			"    h.order_platform,\r\n" + 
			"    MONTH(h.delivery_date),\r\n" + 
			"    YEAR(h.delivery_date)) t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        COUNT(*) AS order_count,\r\n" + 
			"        h.order_platform,\r\n" + 
			"        h.delivery_date,\r\n" + 
			"        MONTH(h.delivery_date) AS delivery_month,\r\n" + 
			"        YEAR(h.delivery_date) AS delivery_year\r\n" + 
			"    FROM\r\n" + 
			"        tn_order_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.del_status = 0 AND h.delivery_date BETWEEN :fromDate AND :toDate AND h.order_status IN(:status) AND h.order_platform IN(:platform)\r\n" + 
			"    GROUP BY\r\n" + 
			"        h.order_platform,\r\n" + 
			"        MONTH(h.delivery_date),\r\n" + 
			"        YEAR(h.delivery_date)\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.order_coming_from_id = t2.order_platform AND t1.delivery_month = t2.delivery_month AND t1.delivery_year = t2.delivery_year\r\n" + 
			"ORDER BY\r\n" + 
			"    delivery_year,\r\n" + 
			"    delivery_month,\r\n" + 
			"    order_coming_from_id",nativeQuery=true)
	List<GetGroupByReportData> getOrderReportGroupByMonthForPlatform(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("status") List<Integer> status, @Param("platform") List<Integer> platform);

	
	@Query(value="SELECT\r\n" + 
			"    t1.*,\r\n" + 
			"    COALESCE(t2.order_count, 0) AS order_count\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        UUID() AS u_id, 0 AS fr_id, '' AS fr_name, 0 AS cust_id, '' AS cust_name, 0 AS order_coming_from_id, '' AS order_coming_from_name, h.payment_method AS pay_mode_id, CASE WHEN h.payment_method = 1 THEN 'CASH' ELSE CASE WHEN h.payment_method = 2 THEN 'CARD' ELSE CASE WHEN h.payment_method = 3 THEN 'E-Pay' ELSE ''\r\n" + 
			"        END\r\n" + 
			"END\r\n" + 
			"END AS pay_mode_name, h.delivery_date, DATE_FORMAT(h.delivery_date, '%d-%m-%Y') AS delivery_date_disp,\r\n" + 
			"MONTH(h.delivery_date) AS delivery_month,\r\n" + 
			"YEAR(h.delivery_date) AS delivery_year,\r\n" + 
			"CONCAT(\r\n" + 
			"    MONTHNAME(h.delivery_date),\r\n" + 
			"    ' - ',\r\n" + 
			"    YEAR(h.delivery_date)\r\n" + 
			") AS month_name,\r\n" + 
			"COALESCE(SUM(h.total_amt),\r\n" + 
			"0) AS total_amt,\r\n" + 
			":status AS status_list\r\n" + 
			"FROM\r\n" + 
			"    tn_order_header h\r\n" + 
			"WHERE\r\n" + 
			"    h.del_status = 0 AND h.delivery_date BETWEEN :fromDate AND :toDate AND h.order_status IN(:status) AND h.payment_method IN(:payment)\r\n" + 
			"GROUP BY\r\n" + 
			"    h.payment_method,\r\n" + 
			"    h.delivery_date) t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        COUNT(*) AS order_count,\r\n" + 
			"        h.payment_method,\r\n" + 
			"        h.delivery_date\r\n" + 
			"    FROM\r\n" + 
			"        tn_order_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.del_status = 0 AND h.delivery_date BETWEEN :fromDate AND :toDate AND h.order_status IN(:status) AND h.payment_method IN(:payment)\r\n" + 
			"    GROUP BY\r\n" + 
			"        h.payment_method,\r\n" + 
			"        h.delivery_date\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.pay_mode_id = t2.payment_method AND t1.delivery_date = t2.delivery_date\r\n" + 
			"ORDER BY\r\n" + 
			"    delivery_date,\r\n" + 
			"    pay_mode_id",nativeQuery=true)
	List<GetGroupByReportData> getOrderReportGroupByDateForPayment(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("status") List<Integer> status, @Param("payment") List<Integer> payment);

	
	@Query(value="SELECT\r\n" + 
			"    t1.*,\r\n" + 
			"    COALESCE(t2.order_count, 0) AS order_count\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        UUID() AS u_id, 0 AS fr_id, '' AS fr_name, 0 AS cust_id, '' AS cust_name, 0 AS order_coming_from_id, '' AS order_coming_from_name, h.payment_method AS pay_mode_id, CASE WHEN h.payment_method = 1 THEN 'CASH' ELSE CASE WHEN h.payment_method = 2 THEN 'CARD' ELSE CASE WHEN h.payment_method = 3 THEN 'E-Pay' ELSE ''\r\n" + 
			"        END\r\n" + 
			"END\r\n" + 
			"END AS pay_mode_name, h.delivery_date, DATE_FORMAT(h.delivery_date, '%d-%m-%Y') AS delivery_date_disp,\r\n" + 
			"MONTH(h.delivery_date) AS delivery_month,\r\n" + 
			"YEAR(h.delivery_date) AS delivery_year,\r\n" + 
			"CONCAT(\r\n" + 
			"    MONTHNAME(h.delivery_date),\r\n" + 
			"    ' - ',\r\n" + 
			"    YEAR(h.delivery_date)\r\n" + 
			") AS month_name,\r\n" + 
			"COALESCE(SUM(h.total_amt),\r\n" + 
			"0) AS total_amt,\r\n" + 
			":status AS status_list\r\n" + 
			"FROM\r\n" + 
			"    tn_order_header h\r\n" + 
			"WHERE\r\n" + 
			"    h.del_status = 0 AND h.delivery_date BETWEEN :fromDate AND :toDate AND h.order_status IN(:status) AND h.payment_method IN(:payment)\r\n" + 
			"GROUP BY\r\n" + 
			"    h.payment_method,\r\n" + 
			"    MONTH(h.delivery_date),\r\n" + 
			"    YEAR(h.delivery_date)) t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        COUNT(*) AS order_count,\r\n" + 
			"        h.payment_method,\r\n" + 
			"        h.delivery_date,\r\n" + 
			"        MONTH(h.delivery_date) AS delivery_month,\r\n" + 
			"        YEAR(h.delivery_date) AS delivery_year\r\n" + 
			"    FROM\r\n" + 
			"        tn_order_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.del_status = 0 AND h.delivery_date BETWEEN :fromDate AND :toDate AND h.order_status IN(:status) AND h.payment_method IN(:payment)\r\n" + 
			"    GROUP BY\r\n" + 
			"        h.payment_method,\r\n" + 
			"        MONTH(h.delivery_date),\r\n" + 
			"        YEAR(h.delivery_date)\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.pay_mode_id = t2.payment_method AND t1.delivery_month = t2.delivery_month AND t1.delivery_year = t2.delivery_year\r\n" + 
			"ORDER BY\r\n" + 
			"    delivery_year,\r\n" + 
			"    delivery_month,\r\n" + 
			"    pay_mode_id",nativeQuery=true)
	List<GetGroupByReportData> getOrderReportGroupByMonthForPayment(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("status") List<Integer> status, @Param("payment") List<Integer> payment);

}
