package com.ats.ckweb.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.report.model.GetGrievanceCntByType;

public interface GriveanceCntRepo extends JpaRepository<GetGrievanceCntByType, Integer> {

	@Query(value="SELECT\n" + 
			"	UUID() as id,\n" + 
			"	COUNT(grievence_type_id) AS griev_cnt,\n" + 
			"	g.grev_type_id,\n" + 
			"    t.grieve_id,\n" + 
			"    t.grievence_type_id,\n" + 
			"    CONCAT(f.fr_name,\"-\",f.fr_code) AS fr_name,\n" + 
			"    f.fr_id,\n" + 
			"    g.caption\n" + 
			"FROM\n" + 
			"    mn_grievences_type_instructn g,\n" + 
			"    t_grievences t,\n" + 
			"    tn_order_header h,\n" + 
			"    m_franchisee f\n" + 
			"WHERE\n" + 
			"    t.grievence_type_id=g.grev_type_id AND\n" + 
			"    t.order_id=h.order_id AND\n" + 
			"    h.fr_id=f.fr_id AND\n" + 
			"    g.del_status=0 AND\n" + 
			"    h.del_status=0 AND\n" + 
			"    f.del_status=0 AND\n" + 
			"    g.grev_type_id IN (:grievTypeId) AND\n" + 
			"    h.delivery_date BETWEEN :fromDate AND :toDate\n" + 
			"    GROUP BY g.grev_type_id, h.fr_id",nativeQuery=true)
	public List<GetGrievanceCntByType>  getGrievCnt(@Param("fromDate") String fromDate, 
			@Param("toDate") String toDate, @Param("grievTypeId") List<Integer> grievTypeId);
}
