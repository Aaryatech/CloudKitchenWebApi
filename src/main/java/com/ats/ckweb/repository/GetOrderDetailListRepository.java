package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.GetOrderDetailList;

public interface GetOrderDetailListRepository extends JpaRepository<GetOrderDetailList, Integer>{

	@Query(value = "select od.*,i.item_name from tn_order_header oh, tn_order_detail od, m_item i where oh.del_status=0 "
			+ "and oh.order_status in(:sts) and od.order_id=oh.order_id and i.id=od.item_id", nativeQuery = true)
	List<GetOrderDetailList> getOrderDetailListByStatus(@Param("sts") List<Integer> sts);

	@Query(value = "select od.*,i.item_name from tn_order_header oh, tn_order_detail od, m_item i where delivery_date=:date and oh.del_status=0 "
			+ "and oh.order_status in(5,6,7,8) and od.order_id=oh.order_id and i.id=od.item_id", nativeQuery = true)
	List<GetOrderDetailList> getOrderDetailListByStatusAndDate(@Param("date") String date);

	@Query(value = "select\n" + 
			"        od.*,\n" + 
			"        i.item_name \n" + 
			"    from\n" + 
			"        tn_order_header oh,\n" + 
			"        tn_order_detail od,\n" + 
			"        m_item i \n" + 
			"    where\n" + 
			"        oh.del_status=0 \n" + 
			"        and oh.cust_id=:custId \n" + 
			"        and od.order_id=oh.order_id \n" + 
			"        and i.id=od.item_id", nativeQuery = true)
	List<GetOrderDetailList> getOrderListByCustomerId(@Param("custId")int custId);

	@Query(value = "select\n" + 
			"        od.*,\n" + 
			"        i.item_name \n" + 
			"    from\n" + 
			"        tn_order_header oh,\n" + 
			"        tn_order_detail od,\n" + 
			"        m_item i \n" + 
			"    where\n" + 
			"        oh.del_status=0 \n" + 
			"        and oh.order_id=:orderId \n" + 
			"        and od.order_id=oh.order_id \n" + 
			"        and i.id=od.item_id", nativeQuery = true)
	List<GetOrderDetailList> getOrderDetailOrderId(@Param("orderId") int orderId);

}
