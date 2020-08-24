package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.FrWiseGrievenceReportData;

public interface FrWiseGrievenceReportDataRepo extends JpaRepository<FrWiseGrievenceReportData, Integer> {

	
	@Query(value="SELECT\r\n" + 
			"    UUID() AS id, g.grieve_id, g.order_id, DATE_FORMAT(g.date, '%d-%m-%Y') AS grieve_date,\r\n" + 
			"    g.fr_affect_amt,\r\n" + 
			"    h.fr_id,\r\n" + 
			"    CONCAT(f.fr_name, ' - ', f.fr_code) AS fr_name\r\n" + 
			"FROM\r\n" + 
			"    t_grievences g,\r\n" + 
			"    tn_order_header h,\r\n" + 
			"    m_franchisee f\r\n" + 
			"WHERE\r\n" + 
			"    g.order_id = h.order_id AND h.del_status = 0 AND h.fr_id = f.fr_id AND g.date BETWEEN :fromDate AND :toDate AND h.fr_id IN(:frIds)\r\n" + 
			"GROUP BY\r\n" + 
			"    g.date,\r\n" + 
			"    h.fr_id\r\n" + 
			"ORDER BY\r\n" + 
			"    grieve_date",nativeQuery=true)
	public List<FrWiseGrievenceReportData> getFrWiseGrievanceReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("frIds") List<Integer> frIds);
	


}
