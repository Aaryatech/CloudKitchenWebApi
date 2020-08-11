package com.ats.ckweb.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.report.model.GetOrderTrailDetails;

public interface GetOrderDetailsRepo extends JpaRepository<GetOrderTrailDetails, Integer> {

	@Query(value="SELECT\n" + 
			"    t1.*,\n" + 
			"    COALESCE(\n" + 
			"        CONCAT(\n" + 
			"            t2.user_name,\n" + 
			"            ' (',\n" + 
			"            t2.user_type_name,\n" + 
			"            ')'\n" + 
			"        ),\n" + 
			"        ''\n" + 
			"    ) AS trail_user_name\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        head.order_id,\n" + 
			"        head.order_no,\n" + 
			"        head.order_date,\n" + 
			"        head.delivery_date,\n" + 
			"        head.delivery_time,\n" + 
			"        head.order_status,\n" + 
			"        head.total_amt,\n" + 
			"        head.payment_method,\n" + 
			"        fr.fr_name,\n" + 
			"        fr.fr_code,\n" + 
			"        cust.cust_name,\n" + 
			"        cust.phone_number,\n" + 
			"        head.taxable_amt,\n" + 
			"        head.igst_amt AS tax_amt,\n" + 
			"        head.delivery_charges,\n" + 
			"        head.order_platform AS order_type,\n" + 
			"        tr.trail_id,\n" + 
			"        tr.status,\n" + 
			"        tr.action_by_user_id,\n" + 
			"        DATE_FORMAT(\n" + 
			"            tr.action_date_time,\n" + 
			"            '%d-%m-%Y %h:%m:%s'\n" + 
			"        ) trail_date_time\n" + 
			"    FROM\n" + 
			"        tn_order_header head,\n" + 
			"        m_customer cust,\n" + 
			"        m_franchisee fr,\n" + 
			"        tn_order_trail tr\n" + 
			"    WHERE\n" + 
			"        head.del_status = 0 AND cust.del_status = 0 AND fr.del_status = 0 AND head.fr_id = fr.fr_id AND head.cust_id = cust.cust_id AND head.order_id = :orderId AND head.order_id = tr.order_id\n" + 
			"    ORDER BY\n" + 
			"        head.order_id,\n" + 
			"        tr.trail_id\n" + 
			"    DESC\n" + 
			") t1\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT mn_user.*,\n" + 
			"        TYPE.user_type_name\n" + 
			"    FROM\n" + 
			"        mn_user,\n" + 
			"        mn_user_type TYPE\n" + 
			"    WHERE\n" + 
			"        mn_user.del_status = 0 AND TYPE.user_type_id = mn_user.user_type\n" + 
			") t2\n" + 
			"ON\n" + 
			"    t1.action_by_user_id = t2.user_id",nativeQuery=true)
	public List<GetOrderTrailDetails> getOrderTrailDetail(@Param("orderId") int orderId);
}
