package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.ckweb.model.GetFrConfigList;

public interface GetFrConfigListRepo extends JpaRepository<GetFrConfigList, Integer> {

	@Query(value="SELECT " + 
			"    t1.*, " + 
			"    t2.area_name, " + 
			"    t2.area_code, " + 
			"    t3.city_name, " + 
			"    t3.city_code " + 
			"FROM " + 
			"    ( " + 
			"    SELECT " + 
			"        config.fr_config_id, " + 
			"        config.fr_id, " + 
			"        config.fr_type, " + 
			"        config.city_ids, " + 
			"        config.area_ids, " + 
			"        config.from_latitude, " + 
			"        config.from_longitude, " + 
			"        config.to_latitude, " + 
			"        config.to_longitude, " + 
			"        config.km_area_covered, " + 
			"        config.is_active, " + 
			"        config.ex_int1, " + 
			"        config.ex_var1, " + 
			"        fr.fr_name, " + 
			"        fr.fr_code " + 
			"    FROM " + 
			"        tn_fr_config config, " + 
			"        m_franchisee fr " + 
			"    WHERE " + 
			"        config.del_status = 0 AND fr.del_status = 0 AND config.fr_id = fr.fr_id " + 
			"    GROUP BY " + 
			"        fr_config_id " + 
			"    ORDER BY " + 
			"        config.fr_config_id " + 
			"    DESC " + 
			") t1 " + 
			"LEFT JOIN( " + 
			"    SELECT " + 
			"        config.fr_config_id, " + 
			"        GROUP_CONCAT(AREA.area_name) AS area_name, " + 
			"        GROUP_CONCAT(AREA.area_code) AS area_code " + 
			"    FROM " + 
			"        mn_area AREA " + 
			"    INNER JOIN tn_fr_config config ON " + 
			"        FIND_IN_SET(AREA.area_id, config.area_ids) > 0 AND AREA.del_status = 0 AND config.del_status = 0 " + 
			"    GROUP BY " + 
			"        config.fr_config_id " + 
			") t2 " + 
			"ON " + 
			"    t1.fr_config_id = t2.fr_config_id " + 
			"LEFT JOIN( " + 
			"    SELECT " + 
			"        config.fr_config_id, " + 
			"        GROUP_CONCAT( " + 
			"            CONCAT( " + 
			"                c.city_name, " + 
			"                ' - ', " + 
			"                CASE WHEN c.ex_int1 = 0 THEN 'City' ELSE 'Village' " + 
			"            END " + 
			"        ) " + 
			") AS city_name, " + 
			"GROUP_CONCAT(c.city_code) AS city_code " + 
			"FROM " + 
			"    mn_city c " + 
			"INNER JOIN tn_fr_config config ON " + 
			"    FIND_IN_SET(c.city_id, config.city_ids) > 0 AND c.del_status = 0 AND config.del_status = 0 " + 
			"GROUP BY " + 
			"    config.fr_config_id " + 
			") t3 " + 
			"ON " + 
			"    t1.fr_config_id = t3.fr_config_id",nativeQuery=true)
	List<GetFrConfigList> getAllFrConfigList();
	
	
}
