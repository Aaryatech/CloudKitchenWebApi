package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.SubCategoryData;

public interface SubCategoryDataRepo  extends JpaRepository<SubCategoryData, Integer> {

	@Query(value = "SELECT\r\n" + 
			"    s.sub_cat_id,\r\n" + 
			"    s.cat_id,\r\n" + 
			"    c.cat_name,\r\n" + 
			"    s.sub_cat_name\r\n" + 
			"FROM\r\n" + 
			"    m_cat_sub s,\r\n" + 
			"    m_category c\r\n" + 
			"WHERE\r\n" + 
			"    s.del_status = 0 AND c.del_status = 0 AND s.cat_id = c.cat_id AND s.sub_cat_id IN(\r\n" + 
			"    SELECT\r\n" + 
			"        i.item_grp2\r\n" + 
			"    FROM\r\n" + 
			"        tn_item_config_header ch,\r\n" + 
			"        tn_item_config_detail cd,\r\n" + 
			"        m_item i\r\n" + 
			"    WHERE\r\n" + 
			"        ch.item_config_id = cd.item_config_id AND ch.del_status = 0 AND ch.is_active = 0 AND cd.is_active = 0 AND cd.del_status = 0 AND cd.item_id = i.id AND i.del_status = 0 AND ch.fr_id = :frId\r\n" + 
			"    GROUP BY\r\n" + 
			"        i.item_grp2\r\n" + 
			")\r\n" + 
			"ORDER BY\r\n" + 
			"    s.seq_no,\r\n" + 
			"    s.sub_cat_name", nativeQuery = true)
	public List<SubCategoryData> getSubCategoriesByFr(@Param("frId") int frId);
	
	@Query(value = "SELECT\r\n" + 
			"    s.sub_cat_id,\r\n" + 
			"    s.cat_id,\r\n" + 
			"    c.cat_name,\r\n" + 
			"    s.sub_cat_name\r\n" + 
			"FROM\r\n" + 
			"    m_cat_sub s,\r\n" + 
			"    m_category c\r\n" + 
			"WHERE\r\n" + 
			"    s.del_status = 0 AND c.del_status = 0 AND s.cat_id = c.cat_id AND s.sub_cat_id IN(\r\n" + 
			"    SELECT\r\n" + 
			"        i.item_grp2\r\n" + 
			"    FROM\r\n" + 
			"        tn_item_config_header ch,\r\n" + 
			"        tn_item_config_detail cd,\r\n" + 
			"        m_item i\r\n" + 
			"    WHERE\r\n" + 
			"        ch.item_config_id = cd.item_config_id AND ch.del_status = 0 AND ch.is_active = 0 AND cd.is_active = 0 AND cd.del_status = 0 AND cd.item_id = i.id AND i.del_status = 0 AND ch.fr_id = :frId AND ch.config_type =:type \r\n" + 
			"    GROUP BY\r\n" + 
			"        i.item_grp2\r\n" + 
			")\r\n" + 
			"ORDER BY\r\n" + 
			"    s.seq_no,\r\n" + 
			"    s.sub_cat_name", nativeQuery = true)
	public List<SubCategoryData> getSubCategoriesByFrAndType(@Param("frId") int frId, @Param("type") int type);

}
