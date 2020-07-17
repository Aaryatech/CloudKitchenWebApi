package com.ats.ckweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.Tags;

@Repository
public interface TagRepo extends JpaRepository<Tags, Integer> {

	@Query(value="select\n" + 
			"	DISTINCT\n" + 
			"      tag.tag_id,\n" + 
			"      tag.tag_name,\n" + 
			"      tag.tag_desc,\n" + 
			"      tag.tag_is_active,\n" + 
			"      tag.tag_delete_status,\n" + 
			"      tag.tag_sort_number,\n" + 
			"      tag.ex_int2,\n" + 
			"      tag.ex_var1,\n" + 
			"      tag.ex_var2,\n" + 
			"      \n" + 
			"      (SELECT COUNT(dtl.item_d_id) FROM mn_detail dtl WHERE FIND_IN_SET(tag.tag_id, dtl.tag_ids)) AS ex_int1\n" + 
			"    from\n" + 
			"        mn_tags tag, \n" + 
			"        mn_detail dtl\n" + 
			"    where\n" + 
			"        tag.tag_delete_status=:del\n" + 
			"        and tag.tag_is_active=:status",nativeQuery=true)
	public List<Tags> findByTagDeleteStatusAndTagIsActive(int del, int status);
	
	public List<Tags> findByTagDeleteStatusOrderByTagIdDesc(int del);
	
	public Tags findByTagIdAndTagDeleteStatus(int tagId, int del);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mn_tags SET tag_delete_status = 1 WHERE tag_id=:tagId",nativeQuery=true)
	public int deleteTagById(@Param("tagId") int tagId);
	
}
