package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.GetItemTagDetails;

public interface GetItemTagDetailsRepo extends JpaRepository<GetItemTagDetails, Integer> {
	
	@Query(value="SELECT\n" + 
			"	itm.id,\n" + 
			"    itm.item_name,\n" + 
			"    dtl.is_used\n" + 
			"FROM\n" + 
			"     mn_detail dtl,\n" + 
			"     m_item itm,\n" + 
			"     mn_tags tag\n" + 
			"WHERE\n" + 
			"    itm.id=dtl.item_id AND\n" + 
			"    tag.tag_id=:tagId AND\n" + 
			"    FIND_IN_SET(tag.tag_id, dtl.tag_ids) AND\n" + 
			"    itm.del_status=0 AND\n" + 
			"    tag.tag_delete_status=0 AND\n" + 
			"    tag.ex_int1=:compId AND\n" + 
			"    dtl.del_status=0 AND\n" + 
			"    dtl.ex_int1=:compId",nativeQuery=true)
	List<GetItemTagDetails> getItemTagDtls(@Param("tagId") int tagId, @Param("compId") int compId);

}
