package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.GetOrderDetailList;

public interface GetOrderDetailListRepository extends JpaRepository<GetOrderDetailList, Integer>{

	@Query(value = "select od.* from tn_order_header oh,tn_order_detail od where oh.del_status=0 and oh.order_status in(:sts) "
			+ "and od.order_id=oh.order_id", nativeQuery = true)
	List<GetOrderDetailList> getOrderDetailListByStatus(@Param("sts") List<Integer> sts);

}
