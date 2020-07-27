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
	@Query(value="UPDATE mn_ingrediant SET del_status=1 WHERE ingrediant_id=:ingrediantId",nativeQuery=true)
	int deleteIngerediantById(@Param("ingrediantId") int ingrediantId);
	
	@Query(value = "SELECT\n" + 
			"    i.*\n" + 
			"FROM\n" + 
			"    mn_ingrediant i\n" + 
			"INNER JOIN mn_detail d ON\n" + 
			"    FIND_IN_SET(\n" + 
			"        i.ingrediant_id,\n" + 
			"        d.taste_type_ids\n" + 
			"    ) > 0 AND d.item_id = :itemId\n" + 
			"GROUP BY\n" + 
			"    i.ingrediant_id", nativeQuery = true)
	public List<Ingrediant> getTasteListByItem(@Param("itemId") int itemId);
}
