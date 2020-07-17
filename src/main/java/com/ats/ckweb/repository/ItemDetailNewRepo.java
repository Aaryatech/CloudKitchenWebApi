package com.ats.ckweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.ItemDetailNew;

public interface ItemDetailNewRepo extends JpaRepository<ItemDetailNew, Integer> {

	@Query(value="SELECT COUNT(item_d_id) FROM `mn_detail` WHERE FIND_IN_SET(:tagId, tag_ids) AND del_status=0", nativeQuery=true)
	int getItemDetailByTagId(@Param("tagId") int tagId);

	@Query(value="SELECT COUNT(item_d_id) FROM `mn_detail` WHERE FIND_IN_SET(:ingerediantId, taste_type_ids) AND del_status=0", nativeQuery=true)
	int getItemTasteByid(@Param("ingerediantId") int ingerediantId);
	

}
