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

	public List<Tags> findByTagDeleteStatusAndTagIsActive(int del, int status);
	
	public List<Tags> findByTagDeleteStatusOrderByTagIdDesc(int del);
	
	public Tags findByTagIdAndTagDeleteStatus(int tagId, int del);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mn_tags SET tag_delete_status = 0 WHERE tag_id=:tagId",nativeQuery=true)
	public int deleteTagById(@Param("tagId") int tagId);
	
}
