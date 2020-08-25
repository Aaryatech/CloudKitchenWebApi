package com.ats.ckweb.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.report.model.GetGreivFrDtl;

public interface GetGreivFrDtlRepo extends JpaRepository<GetGreivFrDtl, Integer> {

	@Query(value="SELECT\n" + 
			"        UUID() AS id,\n" + 
			"        mn.caption,\n" + 
			"        g.grievencce_no,\n" + 
			"        g.date,\n" + 
			"        g.current_status,\n" + 
			"        g.order_id,\n" + 
			"        CONCAT(c.cust_name,\n" + 
			"        \"-\",\n" + 
			"        c.phone_number) AS cust_name,\n" + 
			"        h.order_no,\n" + 
			"        h.total_amt AS order_amt,\n" + 
			"        g.extra_int1 AS is_set,     \n" + 
			"        CONCAT(f.fr_name,\"-\",f.fr_code) AS fr_name\n" + 
			"    FROM\n" + 
			"        t_grievences g,\n" + 
			"        mn_grievences_type_instructn mn,\n" + 
			"        m_customer c,\n" + 
			"        tn_order_header h,\n" + 
			"        m_franchisee f\n" + 
			"    WHERE\n" + 
			"    	mn.grev_type_id=:grievTypeId \n" + 
			"        AND	g.grievence_type_id=mn.grev_type_id\n" + 
			"        AND g.order_id=h.order_id \n" + 
			"        AND h.cust_id=c.cust_id\n" + 
			"        AND f.fr_id=h.fr_id        \n" + 
			"        AND f.fr_id=:frId\n" + 
			"        AND h.delivery_date BETWEEN :fromDate AND :toDate",nativeQuery=true)
	public List<GetGreivFrDtl> getGrievFrDtlList(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frId") int frId, @Param("grievTypeId") int grievTypeId);
}
