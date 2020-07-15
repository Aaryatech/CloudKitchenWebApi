package com.ats.ckweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.Ingrediant;

public interface IngrediantRepo extends JpaRepository<Ingrediant, Integer> {

	Ingrediant findByDelStatusAndIngrediantId(int del, int ingrediantId);
	
	List<Ingrediant> findByDelStatusOrderByIngrediantIdDesc(int del);
	
	List<Ingrediant> findByDelStatusAndIsActiveOrderByIngrediantIdDesc(int del, int status);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mn_ingrediant SET del_status=0 WHERE ingrediant_id=:ingrediantId",nativeQuery=true)
	int deleteIngerediantById(@Param("ingrediantId") int ingrediantId);
}
