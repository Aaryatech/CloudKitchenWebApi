package com.ats.ckweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.ItemDetailNew;

public interface ItemDetailNewRepo extends JpaRepository<ItemDetailNew, Integer> {

	@Query(value="SELECT COUNT(item_d_id) FROM `mn_detail` WHERE FIND_IN_SET(:tagId, tag_ids) AND del_status=0", nativeQuery=true)
	int getItemDetailByTagId(@Param("tagId") int tagId);

	@Query(value="SELECT COUNT(item_d_id) FROM `mn_detail` WHERE FIND_IN_SET(:ingerediantId, taste_type_ids) AND del_status=0", nativeQuery=true)
	int getItemTasteByid(@Param("ingerediantId") int ingerediantId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mn_detail SET tag_ids=CONCAT(tag_ids,',',:tagId) WHERE item_d_id IN(:itemDId)",nativeQuery=true)
	public int updateTagIdsByItemDId(@Param("itemDId") List<Integer> itemDIds,@Param("tagId") int tagId);

	@Transactional
	@Modifying
	@Query(value="UPDATE mn_detail SET tag_ids = TRIM(BOTH ',' FROM REPLACE(REPLACE(tag_ids,:tagId, ''), ',,', ',')) WHERE item_d_id IN(:itemDId)",nativeQuery=true)
	public int removeTagIdsByItemDId(@Param("itemDId") List<Integer> itemDIds,@Param("tagId") int tagId);
	
	ItemDetailNew findByItemDId(int i);


}
