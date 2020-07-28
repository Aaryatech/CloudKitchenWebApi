package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.ckweb.model.IngredientDetailList;


public interface IngredientDetailListRepo extends JpaRepository<IngredientDetailList, Integer> {

	@Query(value="SELECT\n" + 
			"    ing.*,\n" + 
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
	

	@Query(value="SELECT\n" + 
			"    i.ingrediant_id,\n" + 
			"    i.ingrediant_cat_id,\n" + 
			"    i.ingrediant_name,\n" + 
			"    c.ex_int2 AS del_status,\n" + 
			"    i.is_active,\n" + 
			"    i.ingrediant_image,\n" + 
			"    i.ex_int1,\n" + 
			"    i.ex_int2,\n" + 
			"    i.ex_var1,\n" + 
			"    i.ex_var2,\n" + 
			"    i.ex_float1,\n" + 
			"    i.ex_float2,\n" + 
			"    i.last_opration_datetime,\n" + 
			"    i.ingrediant_desc,\n" + 
			"    c.ingrediant_cat_name\n" + 
			"FROM\n" + 
			"    mn_ingrediant i,\n" + 
			"    mn_ingrediant_category c\n" + 
			"WHERE\n" + 
			"    i.del_status = 0 AND c.del_status = 0 AND i.ingrediant_cat_id = c.ingrediant_cat_id\n" + 
			"ORDER BY\n" + 
			"    i.ingrediant_id\n" + 
			"DESC",nativeQuery=true)
	public List<IngredientDetailList> getTasteListForAddItemDetail();
}
