package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.GetOrderTrailList;

public interface GetOrderTrailListRepository extends JpaRepository<GetOrderTrailList, Integer> {

	@Query(value = "select ot.*,case when(ot.ex_int1=1) then (select concat(u.user_name,' (',ut.user_type_name,')') from mn_user u,mn_user_type ut where "
			+ "u.user_id=ot.action_by_user_id and ut.user_type_id=u.user_type) when(ot.ex_int1=4) then (select concat(fremp.fr_emp_name,' (',fr.fr_name,')') "
			+ "from m_fr_emp fremp,m_franchisee fr where fremp.fr_emp_id=ot.action_by_user_id and fr.fr_id=fremp.fr_id) else (select concat(c.cust_name,' (Customer)') "
			+ "from m_customer c  where c.cust_id=ot.action_by_user_id )  end as action_user_name from tn_order_trail ot,tn_order_header oh where oh.order_id=ot.order_id "
			+ "and oh.order_status in(:sts)", nativeQuery = true)
	List<GetOrderTrailList> trailListbystatus(@Param("sts") List<Integer> sts);

	@Query(value = "select ot.*,case when(ot.ex_int1=1) then (select concat(u.user_name,' (',ut.user_type_name,')') from mn_user u,mn_user_type ut where "
			+ "u.user_id=ot.action_by_user_id and ut.user_type_id=u.user_type) when(ot.ex_int1=4) then (select concat(fremp.fr_emp_name,' (',fr.fr_name,')') "
			+ "from m_fr_emp fremp,m_franchisee fr where fremp.fr_emp_id=ot.action_by_user_id and fr.fr_id=fremp.fr_id) else (select concat(c.cust_name,' (Customer)') "
			+ "from m_customer c  where c.cust_id=ot.action_by_user_id )  end as action_user_name from tn_order_trail ot,tn_order_header oh where oh.delivery_date=:date "
			+ "and oh.order_id=ot.order_id "
			+ "and oh.order_status in(5,6,7,8)", nativeQuery = true)
	List<GetOrderTrailList> trailListbyByStatusAndDate(@Param("date") String date);

	@Query(value = "select ot.*,case when(ot.ex_int1=1) then (select concat(u.user_name,' (',ut.user_type_name,')') from mn_user u,mn_user_type ut where "
			+ "u.user_id=ot.action_by_user_id and ut.user_type_id=u.user_type) when(ot.ex_int1=4) then (select concat(fremp.fr_emp_name,' (',fr.fr_name,')') "
			+ "from m_fr_emp fremp,m_franchisee fr where fremp.fr_emp_id=ot.action_by_user_id and fr.fr_id=fremp.fr_id) else (select concat(c.cust_name,' (Customer)') "
			+ "from m_customer c  where c.cust_id=ot.action_by_user_id )  end as action_user_name from tn_order_trail ot,tn_order_header oh where oh.order_id=ot.order_id "
			+ "and oh.cust_id=:custId", nativeQuery = true)
	List<GetOrderTrailList> trailListbyByCustomerIds(@Param("custId")int custId);

}
