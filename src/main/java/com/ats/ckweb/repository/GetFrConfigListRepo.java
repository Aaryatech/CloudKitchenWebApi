package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.ckweb.model.GetFrConfigList;

public interface GetFrConfigListRepo extends JpaRepository<GetFrConfigList, Integer> {

	@Query(value="Select t1.*, t2.area_name, t2.area_code FROM(\n" + 
			"\n" + 
			"SELECT\n" + 
			"    config.fr_config_id,\n" + 
			"    config.fr_id,\n" + 
			"    config.fr_type,\n" + 
			"    config.city_ids,\n" + 
			"    config.area_ids,\n" + 
			"    config.from_latitude,\n" + 
			"    config.from_longitude,\n" + 
			"    config.to_latitude,\n" + 
			"    config.to_longitude,\n" + 
			"    config.km_area_covered,\n" + 
			"    config.is_active,\n" + 
			"    config.ex_int1,\n" + 
			"    config.ex_var1,\n" + 
			"    city.city_name,\n" + 
			"    city.city_code,\n" + 
			"    fr.fr_name,\n" + 
			"    fr.fr_code\n" + 
			"    \n" + 
			"FROM\n" + 
			"    tn_fr_config config,\n" + 
			"    mn_city city,\n" + 
			"    m_franchisee fr\n" + 
			"WHERE\n" + 
			"    config.del_status=0 AND \n" + 
			"    fr.del_status=0 AND\n" + 
			"    city.del_status=0 AND\n" + 
			"    config.fr_id=fr.fr_id AND\n" + 
			"    config.city_ids=city.city_id\n" + 
			"    GROUP BY fr_config_id"
			+ "  ORDER BY config.fr_config_id DESC) t1\n" + 
			"    \n" + 
			"    LEFT JOIN (\n" + 
			"    SELECT\n" + 
			"	config.fr_config_id, \n" + 
			"    GROUP_CONCAT(area.area_name) as area_name,\n" + 
			"    GROUP_CONCAT(area.area_code) as area_code\n" + 
			"FROM\n" + 
			" mn_area area\n" + 
			"    \n" + 
			"    INNER JOIN tn_fr_config config ON    FIND_IN_SET(area.area_id, config.area_ids) > 0 AND area.del_status=0 and\n" + 
			"    config.del_status=0\n" + 
			"    GROUP by config.fr_config_id\n" + 
			"    )t2 ON t1.fr_config_id=t2.fr_config_id",nativeQuery=true)
	List<GetFrConfigList> getAllFrConfigList();
	
	
}
