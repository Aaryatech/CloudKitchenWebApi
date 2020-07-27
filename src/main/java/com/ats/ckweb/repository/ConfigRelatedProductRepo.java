package com.ats.ckweb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.ats.ckweb.model.ConfigRelatedProduct;

public interface ConfigRelatedProductRepo extends JpaRepository<ConfigRelatedProduct, Integer> {

	@Transactional
	@Modifying
	@Query(value="UPDATE\n" + 
			"    `tn_config_related_product`\n" + 
			"SET\n" + 
			"	configr_related_product_ids=:relatedItemIds ,\n" + 
			"    updated_date_time=:updateDatTime ,\n" + 
			"    maker_user_id=:userId\n" + 
			"WHERE\n" + 
			"    product_id=:productId",nativeQuery=true)
	int updateConfigRelateProduct(@RequestParam("productId") int productId, 
			@RequestParam("relatedItemIds") String relatedItemIds, @RequestParam("userId") int userId,
			@RequestParam("updateDatTime") String updateDatTime);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE\n" + 
			"    tn_config_related_product\n" + 
			"SET\n" + 
			"	del_status=1\n" + 
			"WHERE\n" + 
			"    related_product_id=:relatedProductId",nativeQuery=true)
	public int deleteRelateProductById(@RequestParam("relatedProductId") int relatedProductId);
	
	ConfigRelatedProduct findByProductIdAndDelStatus(int itemId, int del);
}
