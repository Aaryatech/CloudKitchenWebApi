package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.ShowItemDetailNewList;

@Repository
public interface ShowItemDetailNewListRepo extends JpaRepository<ShowItemDetailNewList, Integer> {

	@Query(value = "SELECT d.item_d_id,d.item_id,i.item_name,d.product_type,d.product_category,d.product_status,d.product_show_in "
			+ "FROM mn_detail d,m_item i WHERE d.item_id=i.id AND d.del_status=0 AND d.is_used=0 AND d.ex_int1=:compId", nativeQuery = true)
	List<ShowItemDetailNewList> getItemDetailNewList(@Param("compId") int compId);

}
