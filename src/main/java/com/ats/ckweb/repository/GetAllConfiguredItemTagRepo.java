package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.GetAllConfiguredItemTag;

public interface GetAllConfiguredItemTagRepo extends JpaRepository<GetAllConfiguredItemTag, Integer> {

	@Query(value="SELECT\n" + 
			"    UUID() AS id, itm.id AS item_id,\n" + 
			"    itm.item_name,\n" + 
			"    cat.cat_id,\n" + 
			"    cat.cat_name,\n" + 
			"    dtl.*,   \n" + 
			"     CASE WHEN(\n" + 
			"        FIND_IN_SET(:tagId, dtl.tag_ids)> 0)THEN 1 ELSE 0 END AS checked\n" + 
			"    \n" + 
			"FROM\n" + 
			"	m_item itm,\n" + 
			"    m_category cat,\n" + 
			"  	mn_detail dtl\n" + 
			"WHERE    \n" + 
			"    itm.item_grp1=cat.cat_id AND\n" + 
			"    itm.del_status=0 AND\n" + 
			"    cat.del_status=0 AND\n" + 
			"    dtl.item_id=itm.id AND\n" + 
			"    dtl.del_status=0 ",nativeQuery=true)
	List<GetAllConfiguredItemTag> getAllItemTagsById(@Param("tagId") int tagId);

	
}
