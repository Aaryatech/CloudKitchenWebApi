package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.ItemDisplay;

public interface ItemDisplayRepo extends JpaRepository<ItemDisplay, Integer> {

	@Query(value = "SELECT\r\n" + 
			"    t2.*,\r\n" + 
			"    t3.tag_name,\r\n" + 
			"    t4.taste_name,\r\n" + 
			"    t1.rate_amt,\r\n" + 
			"    t1.mrp_amt,\r\n" + 
			"    t1.sp_rate_amt,\r\n" + 
			"    t1.cgst_per,\r\n" + 
			"    t1.sgst_per,\r\n" + 
			"    t1.igst_per,\r\n" + 
			"    t1.hsncd,\r\n" + 
			"    COALESCE(t5.rel_item_ids, '') AS rel_item_ids\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        d.item_id,\r\n" + 
			"        d.item_config_detail_id,\r\n" + 
			"        d.rate_amt,\r\n" + 
			"        d.mrp_amt,\r\n" + 
			"        d.sp_rate_amt,\r\n" + 
			"        d.cgst_per,\r\n" + 
			"        d.sgst_per,\r\n" + 
			"        d.igst_per,\r\n" + 
			"        d.hsncd\r\n" + 
			"    FROM\r\n" + 
			"        tn_item_config_header h,\r\n" + 
			"        tn_item_config_detail d\r\n" + 
			"    WHERE\r\n" + 
			"        h.item_config_id = d.item_config_id AND h.del_status = 0 AND h.is_active = 0 AND d.del_status = 0 AND h.fr_id =:frId AND d.status = 0 AND h.config_type =:type\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        i.id AS item_id,\r\n" + 
			"        i.item_name,\r\n" + 
			"        i.item_grp1 AS cat_id,\r\n" + 
			"        c.cat_name,\r\n" + 
			"        i.item_grp2 AS sub_cat_id,\r\n" + 
			"        s.sub_cat_name,\r\n" + 
			"        i.item_sort_id,\r\n" + 
			"        i.ext_int2 AS is_decimal,\r\n" + 
			"        sup.item_uom,\r\n" + 
			"        sup.uom_id,\r\n" + 
			"        d.item_desc,\r\n" + 
			"        d.product_type,\r\n" + 
			"        d.product_status,\r\n" + 
			"        d.product_category,\r\n" + 
			"        CASE WHEN d.product_category = 1 THEN 'Veg' ELSE 'Non Veg'\r\n" + 
			"END AS product_category_name,\r\n" + 
			"d.preperation_time,\r\n" + 
			"d.show_in_order,\r\n" + 
			"d.ex_float1 AS rating,\r\n" + 
			"d.tag_ids,\r\n" + 
			"d.taste_type_ids\r\n" + 
			"FROM\r\n" + 
			"    m_item i,\r\n" + 
			"    mn_detail d,\r\n" + 
			"    m_category c,\r\n" + 
			"    m_cat_sub s,\r\n" + 
			"    m_item_sup sup\r\n" + 
			"WHERE\r\n" + 
			"    i.del_status = 0 AND d.del_status = 0 AND d.is_used = 0 AND i.id = d.item_id AND i.item_grp1 = c.cat_id AND i.item_grp2 = s.sub_cat_id AND c.del_status = 0 AND s.del_status = 0 AND i.id = sup.item_id AND sup.del_status = 0\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.item_id = t2.item_id\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        d.item_id,\r\n" + 
			"        GROUP_CONCAT(t.tag_name) AS tag_name\r\n" + 
			"    FROM\r\n" + 
			"        mn_tags t\r\n" + 
			"    INNER JOIN mn_detail d ON\r\n" + 
			"        FIND_IN_SET(t.tag_id, d.tag_ids) > 0 AND d.del_status = 0 AND t.tag_delete_status = 0\r\n" + 
			"    GROUP BY\r\n" + 
			"        d.item_id\r\n" + 
			") t3\r\n" + 
			"ON\r\n" + 
			"    t2.item_id = t3.item_id\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        d.item_id,\r\n" + 
			"        GROUP_CONCAT(i.ingrediant_name) AS taste_name\r\n" + 
			"    FROM\r\n" + 
			"        mn_ingrediant i\r\n" + 
			"    INNER JOIN mn_detail d ON\r\n" + 
			"        FIND_IN_SET(\r\n" + 
			"            i.ingrediant_id,\r\n" + 
			"            d.taste_type_ids\r\n" + 
			"        ) > 0 AND i.del_status = 0 AND d.del_status = 0\r\n" + 
			"    GROUP BY\r\n" + 
			"        d.item_id\r\n" + 
			") t4\r\n" + 
			"ON\r\n" + 
			"    t2.item_id = t4.item_id\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        r.product_id AS item_id,\r\n" + 
			"        r.configr_related_product_ids AS rel_item_ids\r\n" + 
			"    FROM\r\n" + 
			"        tn_config_related_product r\r\n" + 
			"    WHERE\r\n" + 
			"        r.del_status = 0 AND r.is_active = 0\r\n" + 
			") t5\r\n" + 
			"ON\r\n" + 
			"    t2.item_id = t5.item_id\r\n" + 
			"ORDER BY\r\n" + 
			"    t2.item_sort_id", nativeQuery = true)
	public List<ItemDisplay> getAllItemByFr(@Param("frId") int frId,@Param("type") int type);
	
}