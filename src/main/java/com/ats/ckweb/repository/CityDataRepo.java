package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.CityData;

public interface CityDataRepo extends JpaRepository<CityData, Integer> {

	@Query(value = "SELECT\r\n" + 
			"    fc.fr_config_id,\r\n" + 
			"    fc.fr_id,\r\n" + 
			"    c.city_id,\r\n" + 
			"    c.city_name,\r\n" + 
			"    c.description,\r\n" + 
			"    c.city_code\r\n" + 
			"FROM\r\n" + 
			"    mn_city c\r\n" + 
			"INNER JOIN tn_fr_config fc ON\r\n" + 
			"    FIND_IN_SET(c.city_id, fc.city_ids) > 0 AND fc.comp_id = 1 AND fc.is_active = 0 AND fc.del_status = 0 AND c.is_active = 0 AND c.del_status = 0 AND fc.fr_id = :frId\r\n" + 
			"GROUP BY\r\n" + 
			"    c.city_id\r\n" + 
			"ORDER BY\r\n" + 
			"    c.city_name", nativeQuery = true)
	public List<CityData> getAllCityByFr(@Param("frId") int frId);

}
