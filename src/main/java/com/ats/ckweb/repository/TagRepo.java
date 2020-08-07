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

	@Query(value="SELECT DISTINCT\n" + 
			"    tag.tag_id,\n" + 
			"    tag.tag_name,\n" + 
			"    tag.tag_desc,\n" + 
			"    tag.tag_is_active,\n" + 
			"    tag.tag_delete_status,\n" + 
			"    tag.tag_sort_number,\n" + 
			"    tag.ex_int1,\n" + 
			"    tag.ex_var1,\n" + 
			"    tag.ex_var2,\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        COUNT(dtl.item_d_id)\n" + 
			"    FROM\n" + 
			"        mn_detail dtl\n" + 
			"    WHERE\n" + 
			"        FIND_IN_SET(tag.tag_id, dtl.tag_ids)\n" + 
			") AS ex_int2\n" + 
			"FROM\n" + 
			"    mn_tags tag,\n" + 
			"    mn_detail dtl\n" + 
			"WHERE\n" + 
			"    tag.tag_delete_status = 0 AND tag.tag_is_active = 0 AND tag.ex_int1 = :compId",nativeQuery=true)
	public List<Tags> findByTagDeleteStatusAndTagIsActive(@Param("compId") int compId);
	
	public List<Tags> findByTagDeleteStatusAndExInt1OrderByTagIdDesc(int del, int compId);
	
	public Tags findByTagIdAndTagDeleteStatus(int tagId, int del);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mn_tags SET tag_delete_status = 1 WHERE tag_id=:tagId",nativeQuery=true)
	public int deleteTagById(@Param("tagId") int tagId);
	
	
	@Query(value="SELECT\n" + 
			"    t.*\n" + 
			"FROM\n" + 
			"    mn_tags t\n" + 
			"INNER JOIN(\n" + 
			"    SELECT\n" + 
			"        h.fr_id,\n" + 
			"        i.tag_ids\n" + 
			"    FROM\n" + 
			"        tn_item_config_header h,\n" + 
			"        tn_item_config_detail d,\n" + 
			"        mn_detail i\n" + 
			"    WHERE\n" + 
			"        h.item_config_id = d.item_config_id AND h.del_status = 0 AND d.del_status = 0 AND i.del_status = 0 AND i.is_used = 0 AND i.item_id = d.item_id AND h.fr_id = :frId AND h.config_type = :type\n" + 
			") t1\n" + 
			"ON\n" + 
			"    FIND_IN_SET(t.tag_id, t1.tag_ids) > 0 AND t.tag_is_active = 0 AND t.tag_delete_status = 0\n" + 
			"GROUP BY\n" + 
			"    t.tag_id",nativeQuery=true)
	public List<Tags> getTagListByFr(@Param("frId") int frId, @Param("type") int type);
	
	@Query(value="SELECT\n" + 
			"    t.*\n" + 
			"FROM\n" + 
			"    mn_tags t\n" + 
			"INNER JOIN mn_detail d ON\n" + 
			"    FIND_IN_SET(t.tag_id, d.taste_type_ids) > 0 AND d.item_id = 327\n" + 
			"GROUP BY\n" + 
			"    t.tag_id",nativeQuery=true)
	public List<Tags> getTagListByItem(@Param("itemId") int itemId);
	
	
}
