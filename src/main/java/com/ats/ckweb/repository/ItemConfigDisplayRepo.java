package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.ItemConfigDisplay;

@Repository
public interface ItemConfigDisplayRepo extends JpaRepository<ItemConfigDisplay, Integer> {
	
	@Query(value="SELECT\r\n" + 
			"    t1.item_config_id,\r\n" + 
			"    t1.fr_id,\r\n" + 
			"    t1.fr_name,\r\n" + 
			"    t1.config_type,\r\n" + 
			"    t1.comp_id,\r\n" + 
			"    COALESCE(t2.no_of_items, 0) AS no_of_items\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        h.*,\r\n" + 
			"        CONCAT(f.fr_name, ' - ', f.fr_code) AS fr_name\r\n" + 
			"    FROM\r\n" + 
			"        tn_item_config_header h,\r\n" + 
			"        m_franchisee f\r\n" + 
			"    WHERE\r\n" + 
			"        h.comp_id = :compId AND h.del_status = 0 AND h.is_active = 0 AND h.fr_id = f.fr_id AND f.del_status = 0\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        COUNT(*) AS no_of_items,\r\n" + 
			"        d.item_config_id,\r\n" + 
			"        d.item_config_detail_id\r\n" + 
			"    FROM\r\n" + 
			"        tn_item_config_detail d\r\n" + 
			"    WHERE\r\n" + 
			"        d.del_status = 0\r\n" + 
			"    GROUP BY\r\n" + 
			"        d.item_config_id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.item_config_id = t2.item_config_id", nativeQuery=true)
	List<ItemConfigDisplay> getAllConfigByComp(@Param("compId") int compId);


	
	
}
