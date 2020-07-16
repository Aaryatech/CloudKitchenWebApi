package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.ckweb.model.IngredientDetailList;


public interface IngredientDetailListRepo extends JpaRepository<IngredientDetailList, Integer> {

	@Query(value="SELECT\n" + 
			"    ing.ingrediant_id,\n" + 
			"    ing.ingrediant_name,\n" + 
			"    ing.is_active,\n" + 
			"    ing.ingrediant_desc,\n" + 
			"    ing.ex_int1,\n" + 
			"    ing.ex_var1,\n" + 
			"    cat.ingrediant_cat_name\n" + 
			"FROM\n" + 
			"    mn_ingrediant ing,\n" + 
			"    mn_ingrediant_category cat\n" + 
			"WHERE\n" + 
			"    ing.del_status = 0 AND cat.del_status = 0 AND ing.ingrediant_cat_id = cat.ingrediant_cat_id\n" + 
			"ORDER BY\n" + 
			"    ing.ingrediant_id\n" + 
			"DESC",nativeQuery=true)
	public List<IngredientDetailList> getIngredientDetail();
}
