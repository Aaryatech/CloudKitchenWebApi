package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.GetOrderHeaderList;

public interface GetOrderHeaderListRepository extends JpaRepository<GetOrderHeaderList, Integer> {

	@Query(value = "select\n" + 
			"        oh.*,\n" + 
			"        cm.phone_number as area_name,\n" + 
			"        ct.city_name,\n" + 
			"        cm.cust_name,\n" + 
			"        CONCAT(fr.fr_name,' - ',fr.fr_code) as fr_name\n" + 
			"    from\n" + 
			"        tn_order_header oh,\n" + 
			"        mn_city ct, \n" + 
			"        m_customer cm,\n" + 
			"        m_franchisee fr\n" + 
			"    where\n" + 
			"        oh.del_status=0 \n" + 
			"        and oh.order_status in(:sts) \n" + 
			"        and ct.city_id=oh.city_id \n" + 
			"        and cm.cust_id=oh.cust_id\n" + 
			"        and oh.fr_id=fr.fr_id", nativeQuery = true)
	List<GetOrderHeaderList> getOrderListByStatus(@Param("sts") List<Integer> sts);

	
	@Query(value = "select\n" + 
			"        oh.*,\n" + 
			"        cm.phone_number as area_name,\n" + 
			"        ct.city_name,\n" + 
			"        cm.cust_name,\n" + 
			"        CONCAT(fr.fr_name,' - ',fr.fr_code) as fr_name     \n" + 
			"    from\n" + 
			"        tn_order_header oh,\n" + 
			"        mn_city ct, \n" + 
			"        m_customer cm,\n" + 
			"        m_franchisee fr     \n" + 
			"    where\n" + 
			"        delivery_date=:date \n" + 
			"        and oh.del_status=0          \n" + 
			"        and oh.order_status in(\n" + 
			"            5,6,7,8\n" + 
			"        )          \n" + 
			"        and ct.city_id=oh.city_id          \n" + 
			"        and cm.cust_id=oh.cust_id         \n" + 
			"        and oh.fr_id=fr.fr_id", nativeQuery = true)
	List<GetOrderHeaderList> getOrderListByStatusAndDate(@Param("date") String date);

	@Query(value = "select\n" + 
			"        oh.*,\n" + 
			"        cm.phone_number as area_name,\n" + 
			"        ct.city_name,\n" + 
			"        cm.cust_name,\n" + 
			"        CONCAT(fr.fr_name,' - ',fr.fr_code) as fr_name          \n" + 
			"    from\n" + 
			"        tn_order_header oh,\n" + 
			"        mn_city ct, \n" + 
			"        m_customer cm,\n" + 
			"        m_franchisee fr          \n" + 
			"    where\n" + 
			"        oh.del_status=0      \n" + 
			"        and ct.city_id=oh.city_id                   \n" + 
			"        and cm.cust_id=oh.cust_id                  \n" + 
			"        and oh.fr_id=fr.fr_id\n" + 
			"        and oh.cust_id=:custId\n" + 
			"    order by order_id desc", nativeQuery = true)
	List<GetOrderHeaderList> getOrderListByCustomerId(@Param("custId") int custId);

	@Query(value = "select\n" + 
			"        oh.*,\n" + 
			"        cm.phone_number as area_name,\n" + 
			"        ct.city_name,\n" + 
			"        cm.cust_name,\n" + 
			"        CONCAT(fr.fr_name,' - ',fr.fr_code) as fr_name          \n" + 
			"    from\n" + 
			"        tn_order_header oh,\n" + 
			"        mn_city ct, \n" + 
			"        m_customer cm,\n" + 
			"        m_franchisee fr          \n" + 
			"    where\n" + 
			"        oh.del_status=0      \n" + 
			"        and ct.city_id=oh.city_id                   \n" + 
			"        and cm.cust_id=oh.cust_id                  \n" + 
			"        and oh.fr_id=fr.fr_id\n" + 
			"        and oh.order_id=:orderId\n" + 
			"    order by order_id desc", nativeQuery = true)
	GetOrderHeaderList getOrderOrderId(@Param("orderId") int orderId);
	
	@Query(value = "select\n" + 
			"        oh.*,\n" + 
			"        cm.phone_number as area_name,\n" + 
			"        ct.city_name,\n" + 
			"        cm.cust_name,\n" + 
			"        CONCAT(fr.fr_name,' - ',fr.fr_code) as fr_name          \n" + 
			"    from\n" + 
			"        tn_order_header oh,\n" + 
			"        mn_city ct, \n" + 
			"        m_customer cm,\n" + 
			"        m_franchisee fr          \n" + 
			"    where\n" + 
			"        oh.del_status=0      \n" + 
			"        and ct.city_id=oh.city_id                   \n" + 
			"        and cm.cust_id=oh.cust_id                  \n" + 
			"        and oh.fr_id=fr.fr_id\n" + 
			"        and oh.uuid_no=:orderUUId\n" + 
			"    order by order_id desc", nativeQuery = true)
	GetOrderHeaderList getOrderOrderUUId(@Param("orderUUId") String orderUUId);

}
