package com.ats.ckweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.IngrediantCategory;

@Repository
public interface IngrediantCategoryRepo extends JpaRepository<IngrediantCategory, Integer>{
	
	public List<IngrediantCategory> findBydelStatusOrderByIngrediantCatIdDesc(int del);

	public List<IngrediantCategory> findByDelStatusAndIsActiveOrderByIngrediantCatIdDesc(int del, int status);
	
	public IngrediantCategory findByIngrediantCatIdAndDelStatus(int ingerediantCatId, int del);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mn_ingrediant_category SET del_status=0 WHERE ingrediant_cat_id=:ingerediantCatId", nativeQuery=true)
	public int deleteIngrediantCatById(@Param("ingerediantCatId") int ingerediantCatId);
}
