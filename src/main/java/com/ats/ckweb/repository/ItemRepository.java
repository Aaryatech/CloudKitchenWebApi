package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.ckweb.model.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	@Query(value="SELECT\n" + 
			"    t1.*,\n" + 
			"    COALESCE(t2.checked, 0) AS checked\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        d.item_id,\n" + 
			"        i.item_name,\n" + 
			"        i.item_grp1 AS cat_id\n" + 
			"    FROM\n" + 
			"        mn_detail d,\n" + 
			"        m_item i\n" + 
			"    WHERE\n" + 
			"        d.item_id = i.id AND d.del_status = 0 AND i.del_status = 0 AND d.is_used = 0 AND d.item_id != 0\n" + 
			") t1\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        dtl.item_id,\n" + 
			"        1 AS checked\n" + 
			"    FROM\n" + 
			"        mn_detail dtl\n" + 
			"    INNER JOIN tn_config_related_product itm ON\n" + 
			"        FIND_IN_SET(\n" + 
			"            dtl.item_id,\n" + 
			"            itm.configr_related_product_ids\n" + 
			"        ) > 0 AND dtl.del_status = 0 AND dtl.is_used = 0 AND itm.del_status = 0\n" + 
			"    GROUP BY\n" + 
			"        dtl.item_id\n" + 
			") t2\n" + 
			"ON\n" + 
			"    t1.item_id = t2.item_id",nativeQuery=true)
		public List<Item> getAllItems();
	
		@Query(value="SELECT\n" + 
				"    t1.*,\n" + 
				"    COALESCE(t2.checked, 0) AS checked\n" + 
				"FROM\n" + 
				"    (\n" + 
				"    SELECT\n" + 
				"        d.item_id,\n" + 
				"        i.item_name,\n" + 
				"        i.item_grp1 AS cat_id\n" + 
				"    FROM\n" + 
				"        mn_detail d,\n" + 
				"        m_item i\n" + 
				"    WHERE\n" + 
				"        d.item_id = i.id AND d.del_status = 0 AND i.del_status = 0 AND d.is_used = 0 AND d.item_id != :itemId\n" + 
				") t1\n" + 
				"LEFT JOIN(\n" + 
				"    SELECT\n" + 
				"        dtl.item_id,\n" + 
				"        1 AS checked\n" + 
				"    FROM\n" + 
				"        mn_detail dtl\n" + 
				"    INNER JOIN tn_config_related_product itm ON\n" + 
				"        FIND_IN_SET(\n" + 
				"            dtl.item_id,\n" + 
				"            itm.configr_related_product_ids\n" + 
				"        ) > 0 AND dtl.del_status = 0 AND dtl.is_used = 0 AND itm.del_status = 0  AND itm.product_id=:itemId\n" + 
				"    GROUP BY\n" + 
				"        dtl.item_id\n" + 
				") t2\n" + 
				"ON\n" + 
				"    t1.item_id = t2.item_id",nativeQuery=true)
		public List<Item> getAllItemsById(@Param("itemId") int itemId);
}

