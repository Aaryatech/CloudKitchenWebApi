package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.GetOrderDetailList;

public interface GetOrderDetailListRepository extends JpaRepository<GetOrderDetailList, Integer>{

	@Query(value = "select od.*,i.item_name from tn_order_header oh, tn_order_detail od, m_item i where oh.del_status=0 "
			+ "and oh.order_status in(:sts) and od.order_id=oh.order_id and i.id=od.item_id and od.del_status=0", nativeQuery = true)
	List<GetOrderDetailList> getOrderDetailListByStatus(@Param("sts") List<Integer> sts);

	@Query(value = "select od.*,i.item_name from tn_order_header oh, tn_order_detail od, m_item i where delivery_date=:date and oh.del_status=0 "
			+ "and oh.order_status in(5,6,7,8) and od.order_id=oh.order_id and i.id=od.item_id and od.del_status=0", nativeQuery = true)
	List<GetOrderDetailList> getOrderDetailListByStatusAndDate(@Param("date") String date);

//	@Query(value = "select\n" + 
//			"        od.*,\n" + 
//			"        i.item_name \n" + 
//			"    from\n" + 
//			"        tn_order_header oh,\n" + 
//			"        tn_order_detail od,\n" + 
//			"        m_item i \n" + 
//			"    where\n" + 
//			"        oh.del_status=0 \n" + 
//			"        and oh.cust_id=:custId \n" + 
//			"        and od.order_id=oh.order_id \n" + 
//			"        and i.id=od.item_id and od.del_status=0", nativeQuery = true)
//	List<GetOrderDetailList> getOrderListByCustomerId(@Param("custId")int custId);
	
	
	
	@Query(value = "SELECT\n" + 
			"    od.order_detail_id,\n" + 
			"    od.order_id,\n" + 
			"    od.item_id,\n" + 
			"    od.hsn_code,\n" + 
			"    od.qty,\n" + 
			"    od.mrp,\n" + 
			"    od.rate,\n" + 
			"    od.taxable_amt,\n" + 
			"    od.cgst_per,\n" + 
			"    od.sgst_per,\n" + 
			"    od.igst_per,\n" + 
			"    od.cgst_amt,\n" + 
			"    od.sgst_amt,\n" + 
			"    od.igst_amt,\n" + 
			"    od.disc_amt,\n" + 
			"    od.tax_amt,\n" + 
			"    od.total_amt,\n" + 
			"    od.del_status,\n" + 
			"    od.remark,\n" + 
			"    od.ex_int1,\n" + 
			"    od.ex_int2,\n" + 
			"    od.ex_int3,\n" + 
			"    od.ex_int4,\n" + 
			"    s.item_uom as ex_var1,\n" + 
			"    od.ex_var2,\n" + 
			"    od.ex_var3,\n" + 
			"    od.ex_var4,\n" + 
			"    od.ex_float1,\n" + 
			"    od.ex_float2,\n" + 
			"    od.ex_float3,\n" + 
			"    od.ex_float4,\n" + 
			"    i.item_name\n" + 
			"    \n" + 
			"FROM\n" + 
			"    tn_order_header oh,\n" + 
			"    tn_order_detail od,\n" + 
			"    m_item i,\n" + 
			"    m_item_sup s\n" + 
			"WHERE\n" + 
			"    oh.del_status = 0 AND oh.cust_id = :custId AND od.order_id = oh.order_id AND i.id = od.item_id AND od.del_status = 0 AND i.id = s.item_id", nativeQuery = true)
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
			"        and i.id=od.item_id and od.del_status=0", nativeQuery = true)
	List<GetOrderDetailList> getOrderDetailOrderId(@Param("orderId") int orderId);

}
