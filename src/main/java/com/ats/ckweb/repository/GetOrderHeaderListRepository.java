package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.GetOrderHeaderList;

public interface GetOrderHeaderListRepository extends JpaRepository<GetOrderHeaderList, Integer> {

	@Query(value = "select oh.*,ar.area_name,ct.city_name from tn_order_header oh,mn_city ct,mn_area ar where oh.del_status=0 "
			+ "and oh.order_status in(:sts) and ct.city_id=oh.city_id and ar.area_id=oh.area_id", nativeQuery = true)
	List<GetOrderHeaderList> getOrderListByStatus(@Param("sts") List<Integer> sts);

}
