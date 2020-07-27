package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.GetProductRelatedList;

public interface GetProductRelatedListRepo extends JpaRepository<GetProductRelatedList, Integer> {

	@Query(value="SELECT\n" + 
			"    pro.related_product_id,\n" + 
			"    pro.product_id,\n" + 
			"(\n" + 
			"    SELECT\n" + 
			"        item.item_name\n" + 
			"    FROM\n" + 
			"        m_item item\n" + 
			"    WHERE\n" + 
			"        item.id=pro.product_id\n" + 
			") AS product_name,\n" + 
			"GROUP_CONCAT(itm.id) AS related_product_ids,\n" + 
			"GROUP_CONCAT(itm.item_name) AS related_product,\n" + 
			"pro.ex_var1,\n" + 
			"pro.ex_var2\n" + 
			"FROM\n" + 
			"    tn_config_related_product pro\n" + 
			"INNER JOIN m_item itm ON\n" + 
			"    FIND_IN_SET(\n" + 
			"        itm.id,\n" + 
			"        pro.configr_related_product_ids\n" + 
			"    ) > 0 AND itm.del_status = 0 AND pro.del_status = 0 AND pro.ex_int1=:compId\n" + 
			"GROUP BY\n" + 
			"    pro.product_id  ORDER BY pro.related_product_id DESC",nativeQuery=true)
	public List<GetProductRelatedList> getAllConfigureRelatedProducts(@Param("compId") int compId);
}
