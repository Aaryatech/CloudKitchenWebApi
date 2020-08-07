package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.ItemDisplay;

public interface ItemDisplayRepo extends JpaRepository<ItemDisplay, Integer> {

	@Query(value = "SELECT " + 
			"    t2.*, " + 
			"    t3.tag_name, " + 
			"    t4.taste_name, " + 
			"    t1.rate_amt, " + 
			"    t1.mrp_amt, " + 
			"    t1.sp_rate_amt, " + 
			"    t1.cgst_per, " + 
			"    t1.sgst_per, " + 
			"    t1.igst_per, " + 
			"    t1.hsncd, " + 
			"    COALESCE(t5.rel_item_ids, '') AS rel_item_ids, " + 
			"    COALESCE(t6.disc_per, 0) AS disc_per, " + 
			"    ROUND( " + 
			"        ( " + 
			"            COALESCE(t1.mrp_amt, 0) -( " + 
			"                COALESCE(t1.mrp_amt, 0) *(COALESCE(t6.disc_per, 0) / 100) " + 
			"            ) " + 
			"        ), " + 
			"        2 " + 
			"    ) AS mrp_disc_amt, " + 
			"    ROUND( " + 
			"        ( " + 
			"            COALESCE(t1.sp_rate_amt, 0) -( " + 
			"                COALESCE(t1.sp_rate_amt, 0) *(COALESCE(t6.disc_per, 0) / 100) " + 
			"            ) " + 
			"        ), " + 
			"        2 " + 
			"    ) AS sp_disc_amt, " + 
			"    COALESCE(t7.offer_ids, '') AS offer_ids, 0 AS freq_ordered_qty " + 
			"FROM " + 
			"    ( " + 
			"    SELECT " + 
			"        d.item_id, " + 
			"        d.item_config_detail_id, " + 
			"        d.rate_amt, " + 
			"        d.mrp_amt, " + 
			"        d.sp_rate_amt, " + 
			"        d.cgst_per, " + 
			"        d.sgst_per, " + 
			"        d.igst_per, " + 
			"        d.hsncd " + 
			"    FROM " + 
			"        tn_item_config_header h, " + 
			"        tn_item_config_detail d " + 
			"    WHERE " + 
			"        h.item_config_id = d.item_config_id AND h.del_status = 0 AND h.is_active = 0 AND d.del_status = 0 AND d.is_active=0 AND h.fr_id = :frId AND d.status = 0 AND h.config_type = :type " + 
			") t1 " + 
			"LEFT JOIN( " + 
			"    SELECT " + 
			"        i.id AS item_id, " + 
			"        i.item_name, " + 
			"        i.item_grp1 AS cat_id, " + 
			"        c.cat_name, " + 
			"        i.item_grp2 AS sub_cat_id, " + 
			"        s.sub_cat_name, " + 
			"        i.item_sort_id, " + 
			"        i.ext_int2 AS is_decimal, " + 
			"        sup.item_uom, " + 
			"        sup.uom_id, " + 
			"        d.item_desc, " + 
			"        d.product_type, " + 
			"        d.product_status, " + 
			"        d.product_category, " + 
			"        CASE WHEN d.product_category = 1 THEN 'Veg' ELSE 'Non Veg' " + 
			"END AS product_category_name, " + 
			"d.preperation_time, " + 
			"d.show_in_order, " + 
			"d.ex_float1 AS rating, " + 
			"d.tag_ids, " + 
			"d.taste_type_ids " + 
			"FROM " + 
			"    m_item i, " + 
			"    mn_detail d, " + 
			"    m_category c, " + 
			"    m_cat_sub s, " + 
			"    m_item_sup sup " + 
			"WHERE " + 
			"    i.del_status = 0 AND d.del_status = 0 AND d.is_used = 0 AND i.id = d.item_id AND i.item_grp1 = c.cat_id AND i.item_grp2 = s.sub_cat_id AND c.del_status = 0 AND s.del_status = 0 AND i.id = sup.item_id AND sup.del_status = 0 " + 
			") t2 " + 
			"ON " + 
			"    t1.item_id = t2.item_id " + 
			"LEFT JOIN( " + 
			"    SELECT " + 
			"        d.item_id, " + 
			"        GROUP_CONCAT(t.tag_name) AS tag_name " + 
			"    FROM " + 
			"        mn_tags t " + 
			"    INNER JOIN mn_detail d ON " + 
			"        FIND_IN_SET(t.tag_id, d.tag_ids) > 0 AND d.del_status = 0 AND t.tag_delete_status = 0 " + 
			"    GROUP BY " + 
			"        d.item_id " + 
			") t3 " + 
			"ON " + 
			"    t2.item_id = t3.item_id " + 
			"LEFT JOIN( " + 
			"    SELECT " + 
			"        d.item_id, " + 
			"        GROUP_CONCAT(i.ingrediant_name) AS taste_name " + 
			"    FROM " + 
			"        mn_ingrediant i " + 
			"    INNER JOIN mn_detail d ON " + 
			"        FIND_IN_SET( " + 
			"            i.ingrediant_id, " + 
			"            d.taste_type_ids " + 
			"        ) > 0 AND i.del_status = 0 AND d.del_status = 0 " + 
			"    GROUP BY " + 
			"        d.item_id " + 
			") t4 " + 
			"ON " + 
			"    t2.item_id = t4.item_id " + 
			"LEFT JOIN( " + 
			"    SELECT " + 
			"        r.product_id AS item_id, " + 
			"        r.configr_related_product_ids AS rel_item_ids " + 
			"    FROM " + 
			"        tn_config_related_product r " + 
			"    WHERE " + 
			"        r.del_status = 0 AND r.is_active = 0 " + 
			") t5 " + 
			"ON " + 
			"    t2.item_id = t5.item_id " + 
			"LEFT JOIN( " + 
			"    SELECT " + 
			"        h.offer_id, " + 
			"        d.primary_item_id AS item_id, " + 
			"        d.disc_per " + 
			"    FROM " + 
			"        mn_offer_header h, " + 
			"        mn_offer_detail d " + 
			"    WHERE " + 
			"        h.offer_id = d.offer_id AND d.del_status = 0 AND h.offer_id IN( " + 
			"        SELECT " + 
			"            c.offer_id " + 
			"        FROM " + 
			"            mn_offer_config c " + 
			"        WHERE " + 
			"            FIND_IN_SET(:frId, c.fr_id) AND del_status = 0 " + 
			"    ) AND h.type = :type AND h.offer_type = 2 AND d.offer_sub_type = 1 AND IF( " + 
			"        h.frequency_type = 1, " + 
			"        IF( " + 
			"            FIND_IN_SET( " + 
			"                DAYOFWEEK(CURDATE()), " + 
			"                h.frequency), " + 
			"                1, " + 
			"                0 " + 
			"            ), " + 
			"            0 " + 
			"        ) = 1 OR IF( " + 
			"            h.frequency_type = 2, " + 
			"            IF( " + 
			"                CURDATE() BETWEEN h.from_date AND h.to_date, 1, 0), " + 
			"                0 " + 
			"            ) = 1 AND CURTIME() BETWEEN h.from_time AND h.to_time AND FIND_IN_SET(:applicableFor, h.applicable_for) " + 
			"        GROUP BY " + 
			"            d.primary_item_id) t6 " + 
			"        ON " + 
			"            t2.item_id = t6.item_id " + 
			"        LEFT JOIN( " + 
			"            SELECT " + 
			"                d.offer_detail_id, " + 
			"                d.primary_item_id AS item_id, " + 
			"                GROUP_CONCAT(d.offer_id) AS offer_ids " + 
			"            FROM " + 
			"                mn_offer_detail d " + 
			"            WHERE " + 
			"                d.is_active = 0 AND d.del_status = 0 AND d.offer_id IN( " + 
			"                SELECT " + 
			"                    h.offer_id " + 
			"                FROM " + 
			"                    mn_offer_header h " + 
			"                WHERE " + 
			"                    IF( " + 
			"                        h.frequency_type = 1, " + 
			"                        IF( " + 
			"                            FIND_IN_SET( " + 
			"                                DAYOFWEEK(CURDATE()), " + 
			"                                h.frequency), " + 
			"                                1, " + 
			"                                0 " + 
			"                            ), " + 
			"                            0 " + 
			"                        ) = 1 OR IF( " + 
			"                            h.frequency_type = 2, " + 
			"                            IF( " + 
			"                                CURDATE() BETWEEN h.from_date AND h.to_date, 1, 0), " + 
			"                                0 " + 
			"                            ) = 1 AND CURTIME() BETWEEN h.from_time AND h.to_time AND h.offer_id IN( " + 
			"                            SELECT " + 
			"                                c.offer_id " + 
			"                            FROM " + 
			"                                mn_offer_config c " + 
			"                            WHERE " + 
			"                                FIND_IN_SET(:frId, c.fr_id) AND c.del_status = 0 " + 
			"                        ) AND h.offer_type = :type AND FIND_IN_SET(:applicableFor, h.applicable_for)) " + 
			"                        GROUP BY " + 
			"                            d.primary_item_id " + 
			"                        ) t7 " + 
			"                    ON " + 
			"                        t2.item_id = t7.item_id " + 
			"                    ORDER BY " + 
			"                        t2.item_sort_id", nativeQuery = true)
	public List<ItemDisplay> getAllItemByFr(@Param("frId") int frId,@Param("type") int type,@Param("applicableFor") int applicableFor);
	
	
	@Query(value = "SELECT * FROM " + 
			"    ( SELECT " + 
			"    t2.*, " + 
			"    t3.tag_name, " + 
			"    t4.taste_name, " + 
			"    t1.rate_amt, " + 
			"    t1.mrp_amt, " + 
			"    t1.sp_rate_amt, " + 
			"    t1.cgst_per, " + 
			"    t1.sgst_per, " + 
			"    t1.igst_per, " + 
			"    t1.hsncd, " + 
			"    COALESCE(t5.rel_item_ids, '') AS rel_item_ids, " + 
			"    COALESCE(t6.disc_per, 0) AS disc_per, " + 
			"    ROUND( " + 
			"        ( " + 
			"            COALESCE(t1.mrp_amt, 0) -( " + 
			"                COALESCE(t1.mrp_amt, 0) *(COALESCE(t6.disc_per, 0) / 100) " + 
			"            ) " + 
			"        ), " + 
			"        2 " + 
			"    ) AS mrp_disc_amt, " + 
			"    ROUND( " + 
			"        ( " + 
			"            COALESCE(t1.sp_rate_amt, 0) -( " + 
			"                COALESCE(t1.sp_rate_amt, 0) *(COALESCE(t6.disc_per, 0) / 100) " + 
			"            ) " + 
			"        ), " + 
			"        2 " + 
			"    ) AS sp_disc_amt, " + 
			"    COALESCE(t7.offer_ids, '') AS offer_ids, COALESCE(t8.freq_ordered_qty,0) AS freq_ordered_qty " + 
			"FROM " + 
			"    ( " + 
			"    SELECT " + 
			"        d.item_id, " + 
			"        d.item_config_detail_id, " + 
			"        d.rate_amt, " + 
			"        d.mrp_amt, " + 
			"        d.sp_rate_amt, " + 
			"        d.cgst_per, " + 
			"        d.sgst_per, " + 
			"        d.igst_per, " + 
			"        d.hsncd " + 
			"    FROM " + 
			"        tn_item_config_header h, " + 
			"        tn_item_config_detail d " + 
			"    WHERE " + 
			"        h.item_config_id = d.item_config_id AND h.del_status = 0 AND h.is_active = 0 AND d.del_status = 0 AND d.is_active=0 AND h.fr_id = :frId AND d.status = 0 AND h.config_type = :type " + 
			") t1 " + 
			"LEFT JOIN( " + 
			"    SELECT " + 
			"        i.id AS item_id, " + 
			"        i.item_name, " + 
			"        i.item_grp1 AS cat_id, " + 
			"        c.cat_name, " + 
			"        i.item_grp2 AS sub_cat_id, " + 
			"        s.sub_cat_name, " + 
			"        i.item_sort_id, " + 
			"        i.ext_int2 AS is_decimal, " + 
			"        sup.item_uom, " + 
			"        sup.uom_id, " + 
			"        d.item_desc, " + 
			"        d.product_type, " + 
			"        d.product_status, " + 
			"        d.product_category, " + 
			"        CASE WHEN d.product_category = 1 THEN 'Veg' ELSE 'Non Veg' " + 
			"END AS product_category_name, " + 
			"d.preperation_time, " + 
			"d.show_in_order, " + 
			"d.ex_float1 AS rating, " + 
			"d.tag_ids, " + 
			"d.taste_type_ids " + 
			"FROM " + 
			"    m_item i, " + 
			"    mn_detail d, " + 
			"    m_category c, " + 
			"    m_cat_sub s, " + 
			"    m_item_sup sup " + 
			"WHERE " + 
			"    i.del_status = 0 AND d.del_status = 0 AND d.is_used = 0 AND i.id = d.item_id AND i.item_grp1 = c.cat_id AND i.item_grp2 = s.sub_cat_id AND c.del_status = 0 AND s.del_status = 0 AND i.id = sup.item_id AND sup.del_status = 0 " + 
			") t2 " + 
			"ON " + 
			"    t1.item_id = t2.item_id " + 
			"LEFT JOIN( " + 
			"    SELECT " + 
			"        d.item_id, " + 
			"        GROUP_CONCAT(t.tag_name) AS tag_name " + 
			"    FROM " + 
			"        mn_tags t " + 
			"    INNER JOIN mn_detail d ON " + 
			"        FIND_IN_SET(t.tag_id, d.tag_ids) > 0 AND d.del_status = 0 AND t.tag_delete_status = 0 " + 
			"    GROUP BY " + 
			"        d.item_id " + 
			") t3 " + 
			"ON " + 
			"    t2.item_id = t3.item_id " + 
			"LEFT JOIN( " + 
			"    SELECT " + 
			"        d.item_id, " + 
			"        GROUP_CONCAT(i.ingrediant_name) AS taste_name " + 
			"    FROM " + 
			"        mn_ingrediant i " + 
			"    INNER JOIN mn_detail d ON " + 
			"        FIND_IN_SET( " + 
			"            i.ingrediant_id, " + 
			"            d.taste_type_ids " + 
			"        ) > 0 AND i.del_status = 0 AND d.del_status = 0 " + 
			"    GROUP BY " + 
			"        d.item_id " + 
			") t4 " + 
			"ON " + 
			"    t2.item_id = t4.item_id " + 
			"LEFT JOIN( " + 
			"    SELECT " + 
			"        r.product_id AS item_id, " + 
			"        r.configr_related_product_ids AS rel_item_ids " + 
			"    FROM " + 
			"        tn_config_related_product r " + 
			"    WHERE " + 
			"        r.del_status = 0 AND r.is_active = 0 " + 
			") t5 " + 
			"ON " + 
			"    t2.item_id = t5.item_id " + 
			"LEFT JOIN( " + 
			"    SELECT " + 
			"        h.offer_id, " + 
			"        d.primary_item_id AS item_id, " + 
			"        d.disc_per " + 
			"    FROM " + 
			"        mn_offer_header h, " + 
			"        mn_offer_detail d " + 
			"    WHERE " + 
			"        h.offer_id = d.offer_id AND d.del_status = 0 AND h.offer_id IN( " + 
			"        SELECT " + 
			"            c.offer_id " + 
			"        FROM " + 
			"            mn_offer_config c " + 
			"        WHERE " + 
			"            FIND_IN_SET(:frId, c.fr_id) AND del_status = 0 " + 
			"    ) AND h.type = :type AND h.offer_type = 2 AND d.offer_sub_type = 1 AND IF( " + 
			"        h.frequency_type = 1, " + 
			"        IF( " + 
			"            FIND_IN_SET( " + 
			"                DAYOFWEEK(CURDATE()), " + 
			"                h.frequency), " + 
			"                1, " + 
			"                0 " + 
			"            ), " + 
			"            0 " + 
			"        ) = 1 OR IF( " + 
			"            h.frequency_type = 2, " + 
			"            IF( " + 
			"                CURDATE() BETWEEN h.from_date AND h.to_date, 1, 0), " + 
			"                0 " + 
			"            ) = 1 AND CURTIME() BETWEEN h.from_time AND h.to_time AND FIND_IN_SET(:applicableFor, h.applicable_for) " + 
			"        GROUP BY " + 
			"            d.primary_item_id) t6 " + 
			"        ON " + 
			"            t2.item_id = t6.item_id " + 
			"        LEFT JOIN( " + 
			"            SELECT " + 
			"                d.offer_detail_id, " + 
			"                d.primary_item_id AS item_id, " + 
			"                GROUP_CONCAT(d.offer_id) AS offer_ids " + 
			"            FROM " + 
			"                mn_offer_detail d " + 
			"            WHERE " + 
			"                d.is_active = 0 AND d.del_status = 0 AND d.offer_id IN( " + 
			"                SELECT " + 
			"                    h.offer_id " + 
			"                FROM " + 
			"                    mn_offer_header h " + 
			"                WHERE " + 
			"                    IF( " + 
			"                        h.frequency_type = 1, " + 
			"                        IF( " + 
			"                            FIND_IN_SET( " + 
			"                                DAYOFWEEK(CURDATE()), " + 
			"                                h.frequency), " + 
			"                                1, " + 
			"                                0 " + 
			"                            ), " + 
			"                            0 " + 
			"                        ) = 1 OR IF( " + 
			"                            h.frequency_type = 2, " + 
			"                            IF( " + 
			"                                CURDATE() BETWEEN h.from_date AND h.to_date, 1, 0), " + 
			"                                0 " + 
			"                            ) = 1 AND CURTIME() BETWEEN h.from_time AND h.to_time AND h.offer_id IN( " + 
			"                            SELECT " + 
			"                                c.offer_id " + 
			"                            FROM " + 
			"                                mn_offer_config c " + 
			"                            WHERE " + 
			"                                FIND_IN_SET(:frId, c.fr_id) AND c.del_status = 0 " + 
			"                        ) AND h.offer_type = :type AND FIND_IN_SET(:applicableFor, h.applicable_for)) " + 
			"                        GROUP BY " + 
			"                            d.primary_item_id " + 
			"                        ) t7 " + 
			"                    ON " + 
			"                        t2.item_id = t7.item_id  LEFT JOIN( " + 
			"                        SELECT " + 
			"                            d.order_detail_id, " + 
			"                            d.order_id, " + 
			"                            d.item_id, " + 
			"                            SUM(d.qty) AS freq_ordered_qty " + 
			"                        FROM " + 
			"                            tn_order_header h, " + 
			"                            tn_order_detail d, " + 
			"                            mn_detail i " + 
			"                        WHERE " + 
			"                            h.del_status = 0 AND d.del_status = 0 AND h.order_id = d.order_id AND d.item_id = i.item_id AND i.show_in_order = 1 AND h.order_status = 5 AND h.cust_id = :custId " + 
			"                        GROUP BY " + 
			"                            d.item_id " + 
			"                        ORDER BY " + 
			"                            qty " + 
			"                        DESC " + 
			"                    ) t8 " + 
			"                ON " + 
			"                    t2.item_id = t8.item_id" +
			"   ) tbl WHERE freq_ordered_qty > 0 ORDER BY freq_ordered_qty DESC " 
			, nativeQuery = true)
	public List<ItemDisplay> getFrequentlyOrderedItemListByCust(@Param("frId") int frId,@Param("type") int type,@Param("applicableFor") int applicableFor,@Param("custId") int custId);
	
	
}
