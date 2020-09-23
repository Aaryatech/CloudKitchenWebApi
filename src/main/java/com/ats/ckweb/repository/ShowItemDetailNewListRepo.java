package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.ShowItemDetailNewList;

@Repository
public interface ShowItemDetailNewListRepo extends JpaRepository<ShowItemDetailNewList, Integer> {

	
	
	//@Query(value = "SELECT d.item_d_id,d.item_id,i.item_name,d.product_type,d.product_category,d.product_status,d.product_show_in "
	//		+ "FROM mn_detail d,m_item i WHERE d.item_id=i.id AND d.del_status=0 AND d.is_used=0 AND d.ex_int1=:compId", nativeQuery = true)
	
	//22-09-2020
	//add two more columns
	@Query(value="SELECT\r\n" + 
			"        d.item_d_id,\r\n" + 
			"        d.item_id,\r\n" + 
			"        i.item_name,\r\n" + 
			"        d.product_type,\r\n" + 
			"        d.product_category,\r\n" + 
			"        d.product_status,\r\n" + 
			"        d.product_show_in,\r\n" + 
			"        d.ex_float1 as rating,\r\n" + 
			"        d.preperation_time       \r\n" + 
			"    FROM\r\n" + 
			"        mn_detail d,\r\n" + 
			"        m_item i \r\n" + 
			"    WHERE\r\n" + 
			"        d.item_id=i.id \r\n" + 
			"        AND d.del_status=0 \r\n" + 
			"        AND d.is_used=0 \r\n" + 
			"        AND d.ex_int1=:compId",nativeQuery=true)
	List<ShowItemDetailNewList> getItemDetailNewList(@Param("compId") int compId);

}
