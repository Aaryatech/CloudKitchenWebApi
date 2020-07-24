package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.ItemListForOfferDetail;

@Repository
public interface ItemListForOfferDetailRepo extends JpaRepository<ItemListForOfferDetail, Integer> {

	@Query(value="SELECT\r\n" + 
			"    t1.*,COALESCE(t2.offer_detail_id,0) AS offer_detail_id,\r\n" + 
			"    COALESCE(t2.disc_per, 0) AS disc\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        d.item_d_id,\r\n" + 
			"        d.item_id,\r\n" + 
			"        d.item_desc,\r\n" + 
			"        i.item_name,\r\n" + 
			"        i.item_grp1 AS cat_id\r\n" + 
			"    FROM\r\n" + 
			"        mn_detail d,\r\n" + 
			"        m_item i\r\n" + 
			"    WHERE\r\n" + 
			"        d.del_status = 0 AND d.is_used = 0 AND i.del_status = 0 AND d.item_id = i.id\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT *\r\n" + 
			"    FROM\r\n" + 
			"        mn_offer_detail d\r\n" + 
			"    WHERE\r\n" + 
			"        d.del_status = 0 AND d.offer_id = :offerId \r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.item_id = t2.primary_item_id", nativeQuery=true)
	List<ItemListForOfferDetail> getAllItemList(@Param("offerId") int offerId);

}
