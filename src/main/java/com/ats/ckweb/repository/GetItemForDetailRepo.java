package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.ckweb.model.GetItemForDetail;

public interface GetItemForDetailRepo extends JpaRepository<GetItemForDetail, Integer>{

	@Query(value="SELECT\r\n" + 
			"    i.id AS item_id,\r\n" + 
			"    i.item_name,\r\n" + 
			"    i.item_grp1 AS cat_id,\r\n" + 
			"    i.item_grp2 AS sub_cat_id\r\n" + 
			"FROM\r\n" + 
			"    m_item i\r\n" + 
			"WHERE\r\n" + 
			"    i.del_status = 0 AND i.id NOT IN (SELECT item_id FROM mn_detail WHERE del_status=0)",nativeQuery=true)
	List<GetItemForDetail> getItemsForDetail();
	
	
	@Query(value="SELECT\r\n" + 
			"    i.id AS item_id,\r\n" + 
			"    i.item_name,\r\n" + 
			"    i.item_grp1 AS cat_id,\r\n" + 
			"    i.item_grp2 AS sub_cat_id\r\n" + 
			"FROM\r\n" + 
			"    m_item i\r\n" + 
			"WHERE\r\n" + 
			"    i.del_status = 0",nativeQuery=true)
	List<GetItemForDetail> getAllItemsForDetail();

	
}
