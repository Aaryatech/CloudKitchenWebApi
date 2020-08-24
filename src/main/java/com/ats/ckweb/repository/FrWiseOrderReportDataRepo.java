package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.FrWiseOrderReportData;

public interface FrWiseOrderReportDataRepo extends JpaRepository<FrWiseOrderReportData, Integer> {

	
	@Query(value="SELECT\r\n" + 
			"	uuid() AS id,\r\n" + 
			"    t1.*,\r\n" + 
			"    COALESCE(t2.cash_amt, 0) AS cash,\r\n" + 
			"    COALESCE(t3.online_amt, 0) AS online,\r\n" + 
			"    ROUND(COALESCE(t2.fr_to_comp, 0),\r\n" + 
			"    2) AS fr_to_comp,\r\n" + 
			"    ROUND(COALESCE(t3.comp_to_fr, 0),\r\n" + 
			"    2) AS comp_to_fr\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        h.order_id,\r\n" + 
			"        DATE_FORMAT(h.order_date, '%d-%m-%Y') AS order_date,\r\n" + 
			"        SUM(h.total_amt) AS order_amt,\r\n" + 
			"        h.fr_id,\r\n" + 
			"        CONCAT(f.fr_name, ' - ', f.fr_code) AS fr_name\r\n" + 
			"    FROM\r\n" + 
			"        tn_order_header h,\r\n" + 
			"        m_franchisee f\r\n" + 
			"    WHERE\r\n" + 
			"        h.fr_id = f.fr_id AND h.del_status = 0 AND h.order_date BETWEEN :fromDate AND :toDate AND h.fr_id IN(:frIds)\r\n" + 
			"    GROUP BY\r\n" + 
			"        h.order_date,\r\n" + 
			"        h.fr_id\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        DATE_FORMAT(h.order_date, '%d-%m-%Y') AS order_date,\r\n" + 
			"        SUM(h.total_amt) AS cash_amt,\r\n" + 
			"        h.fr_id,\r\n" + 
			"        (\r\n" + 
			"            (\r\n" + 
			"                COALESCE(\r\n" + 
			"                    (\r\n" + 
			"                    SELECT\r\n" + 
			"                        setting_value1\r\n" + 
			"                    FROM\r\n" + 
			"                        t_setting_new\r\n" + 
			"                    WHERE\r\n" + 
			"                        setting_id = 7\r\n" + 
			"                ),\r\n" + 
			"                0\r\n" + 
			"                ) * SUM(h.total_amt)\r\n" + 
			"            ) / 100\r\n" + 
			"        ) AS fr_to_comp\r\n" + 
			"    FROM\r\n" + 
			"        tn_order_header h,\r\n" + 
			"        m_franchisee f\r\n" + 
			"    WHERE\r\n" + 
			"        h.fr_id = f.fr_id AND h.del_status = 0 AND h.order_date BETWEEN :fromDate AND :toDate AND h.fr_id IN(:frIds) AND h.payment_method = 1\r\n" + 
			"    GROUP BY\r\n" + 
			"        h.order_date,\r\n" + 
			"        h.fr_id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.order_date = t2.order_date AND t1.fr_id = t2.fr_id\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        DATE_FORMAT(h.order_date, '%d-%m-%Y') AS order_date,\r\n" + 
			"        SUM(h.total_amt) AS online_amt,\r\n" + 
			"        h.fr_id,\r\n" + 
			"        (\r\n" + 
			"            (\r\n" + 
			"                COALESCE(\r\n" + 
			"                    (\r\n" + 
			"                    SELECT\r\n" + 
			"                        setting_value1\r\n" + 
			"                    FROM\r\n" + 
			"                        t_setting_new\r\n" + 
			"                    WHERE\r\n" + 
			"                        setting_id = 6\r\n" + 
			"                ),\r\n" + 
			"                0\r\n" + 
			"                ) * SUM(h.total_amt)\r\n" + 
			"            ) / 100\r\n" + 
			"        ) AS comp_to_fr\r\n" + 
			"    FROM\r\n" + 
			"        tn_order_header h,\r\n" + 
			"        m_franchisee f\r\n" + 
			"    WHERE\r\n" + 
			"        h.fr_id = f.fr_id AND h.del_status = 0 AND h.order_date BETWEEN :fromDate AND :toDate AND h.fr_id IN(:frIds) AND h.payment_method = 2\r\n" + 
			"    GROUP BY\r\n" + 
			"        h.order_date,\r\n" + 
			"        h.fr_id\r\n" + 
			") t3\r\n" + 
			"ON\r\n" + 
			"    t1.order_date = t3.order_date AND t1.fr_id = t3.fr_id\r\n" + 
			"    ORDER BY order_date",nativeQuery=true)
	public List<FrWiseOrderReportData> getFrWiseOrderReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("frIds") List<Integer> frIds);
	



}
