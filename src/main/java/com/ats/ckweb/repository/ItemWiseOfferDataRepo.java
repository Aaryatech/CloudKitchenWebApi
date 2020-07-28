package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.ItemWiseOfferData;

@Repository
public interface ItemWiseOfferDataRepo extends JpaRepository<ItemWiseOfferData, Integer> {

	@Query(value = "SELECT\r\n" + 
			"    h.offer_id,\r\n" + 
			"    h.offer_name,\r\n" + 
			"    h.offer_desc,\r\n" + 
			"    h.type,\r\n" + 
			"    h.applicable_for,\r\n" + 
			"    h.offer_type,\r\n" + 
			"    h.frequency_type,\r\n" + 
			"    h.frequency,\r\n" + 
			"    h.from_date,\r\n" + 
			"    h.to_date,\r\n" + 
			"    h.from_time,\r\n" + 
			"    h.to_time,\r\n" + 
			"    d.offer_detail_id,\r\n" + 
			"    d.offer_sub_type,\r\n" + 
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
			"d.disc_per,\r\n" + 
			"d.offer_limit,\r\n" + 
			"d.coupon_code,\r\n" + 
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
			"    mn_offer_header h,\r\n" + 
			"    mn_offer_detail d\r\n" + 
			"WHERE\r\n" + 
			"    h.offer_id = d.offer_id AND d.del_status = 0 AND h.offer_id IN(\r\n" + 
			"    SELECT\r\n" + 
			"        c.offer_id\r\n" + 
			"    FROM\r\n" + 
			"        mn_offer_config c\r\n" + 
			"    WHERE\r\n" + 
			"        FIND_IN_SET(:frId, c.fr_id) AND del_status = 0\r\n" + 
			") AND h.type = :type AND h.offer_type = 2 AND FIND_IN_SET(:applicableFor,h.applicable_for) AND h.del_status=0 AND h.is_active=0", nativeQuery = true)
	public List<ItemWiseOfferData> getAllOffersByFr(@Param("frId") int frId,@Param("type") int type,@Param("applicableFor") int applicableFor);
	

}
