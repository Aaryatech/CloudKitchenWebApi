package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.CategoryData;

public interface CategoryDataRepo extends JpaRepository<CategoryData, Integer> {

	@Query(value = "SELECT\r\n" + 
			"    c.cat_id,\r\n" + 
			"    c.cat_name\r\n" + 
			"FROM\r\n" + 
			"    m_category c\r\n" + 
			"WHERE\r\n" + 
			"    c.del_status = 0 AND c.cat_id IN(\r\n" + 
			"    SELECT\r\n" + 
			"        i.item_grp1\r\n" + 
			"    FROM\r\n" + 
			"        tn_item_config_header ch,\r\n" + 
			"        tn_item_config_detail cd,\r\n" + 
			"        m_item i\r\n" + 
			"    WHERE\r\n" + 
			"        ch.item_config_id = cd.item_config_id AND ch.del_status = 0 AND ch.is_active = 0 AND cd.is_active = 0 AND cd.del_status = 0 AND cd.item_id = i.id AND i.del_status = 0 AND ch.fr_id = :frId\r\n" + 
			"    GROUP BY\r\n" + 
			"        i.item_grp1\r\n" + 
			")\r\n" + 
			"ORDER BY\r\n" + 
			"    c.seq_no,\r\n" + 
			"    c.cat_name", nativeQuery = true)
	public List<CategoryData> getCategoriesByFr(@Param("frId") int frId);

}
