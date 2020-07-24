package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.ItemBuyGetFreeOffer;

@Repository
public interface ItemBuyGetFreeOfferRepo extends JpaRepository<ItemBuyGetFreeOffer, Integer>{

	@Query(value="SELECT\r\n" + 
			"    d.offer_detail_id,\r\n" + 
			"    d.primary_item_id,\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        i.item_name\r\n" + 
			"    FROM\r\n" + 
			"        m_item i\r\n" + 
			"    WHERE\r\n" + 
			"        i.id = d.primary_item_id\r\n" + 
			") AS primary_item_name,\r\n" + 
			"d.primary_qty,\r\n" + 
			"d.secondary_item_id,\r\n" + 
			"(\r\n" + 
			"    SELECT\r\n" + 
			"        i.item_name\r\n" + 
			"    FROM\r\n" + 
			"        m_item i\r\n" + 
			"    WHERE\r\n" + 
			"        i.id = d.secondary_item_id\r\n" + 
			") AS secondary_item_name,\r\n" + 
			"d.secondary_qty\r\n" + 
			"FROM\r\n" + 
			"    mn_offer_detail d\r\n" + 
			"WHERE\r\n" + 
			"    d.del_status = 0 AND d.is_active = 0 AND d.offer_id = :offerId", nativeQuery=true)
	List<ItemBuyGetFreeOffer> getOfferDetailListForBuyGetFree(@Param("offerId") int offerId);
	
}
