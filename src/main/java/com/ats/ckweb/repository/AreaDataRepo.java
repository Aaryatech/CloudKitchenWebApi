package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.AreaData;

public interface AreaDataRepo extends JpaRepository<AreaData, Integer> {

	@Query(value = "SELECT\r\n" + 
			"    fc.fr_config_id,\r\n" + 
			"    fc.fr_id,\r\n" + 
			"    a.city_id,\r\n" + 
			"    a.area_id,\r\n" + 
			"    a.area_name,\r\n" + 
			"    a.description,\r\n" + 
			"    a.area_code,\r\n" + 
			"    a.pincode,\r\n" + 
			"    a.latitude,\r\n" + 
			"    a.longitude\r\n" + 
			"FROM\r\n" + 
			"    mn_area a\r\n" + 
			"INNER JOIN tn_fr_config fc ON\r\n" + 
			"    FIND_IN_SET(a.area_id, fc.area_ids) > 0 AND fc.comp_id = 1 AND fc.is_active = 0 AND fc.del_status = 0 AND a.is_active = 0 AND a.del_status = 0 AND fc.fr_id = :frId\r\n" + 
			"GROUP BY\r\n" + 
			"    a.area_id\r\n" + 
			"ORDER BY\r\n" + 
			"    a.area_name", nativeQuery = true)
	public List<AreaData> getAllAreasByFr(@Param("frId") int frId);

}
