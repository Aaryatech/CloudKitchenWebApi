package com.ats.ckweb.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.report.model.GetOrderReport;
import com.ats.ckweb.report.model.GetOrderTrailDisplay;


public interface GetOrderTrailDisplayRepo extends JpaRepository<GetOrderTrailDisplay, Integer> {

	@Query(value="SELECT\r\n" + 
			"    *\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        t1.*,\r\n" + 
			"        COALESCE(t2.user_name, '') AS user_name,\r\n" + 
			"        DATE_FORMAT(\r\n" + 
			"            t1.action_date_time,\r\n" + 
			"            '%d-%m-%Y %h:%i %p'\r\n" + 
			"        ) AS trail_date\r\n" + 
			"    FROM\r\n" + 
			"        (\r\n" + 
			"        SELECT\r\n" + 
			"    t.*\r\n" + 
			"FROM\r\n" + 
			"    tn_order_trail t\r\n" + 
			"WHERE\r\n" + 
			"    t.order_id IN(\r\n" + 
			"    SELECT\r\n" + 
			"        order_id\r\n" + 
			"    FROM\r\n" + 
			"        tn_order_header\r\n" + 
			"    WHERE\r\n" + 
			"        del_status = 0 AND delivery_date BETWEEN :fromDate AND :toDate \r\n" + 
			") " + 
			"    ) t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        u.user_id,\r\n" + 
			"        CONCAT(\r\n" + 
			"            u.user_name,\r\n" + 
			"            ' (',\r\n" + 
			"            t.user_type_name,\r\n" + 
			"            ') '\r\n" + 
			"        ) AS user_name\r\n" + 
			"    FROM\r\n" + 
			"        mn_user u,\r\n" + 
			"        mn_user_type t\r\n" + 
			"    WHERE\r\n" + 
			"        u.del_status = 0 AND u.user_type = t.user_type_id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.action_by_user_id = t2.user_id\r\n" + 
			") tbl\r\n" + 
			"ORDER BY\r\n" + 
			"    order_id,\r\n" + 
			"    trail_id",nativeQuery=true)
	public List<GetOrderTrailDisplay> getOrderTrailDataByDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	
	@Query(value="SELECT\r\n" + 
			"    *\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        t1.*,\r\n" + 
			"        COALESCE(t2.user_name, '') AS user_name,\r\n" + 
			"        DATE_FORMAT(\r\n" + 
			"            t1.action_date_time,\r\n" + 
			"            '%d-%m-%Y %h:%i %p'\r\n" + 
			"        ) AS trail_date\r\n" + 
			"    FROM\r\n" + 
			"        (\r\n" + 
			"        SELECT\r\n" + 
			"    t.*\r\n" + 
			"FROM\r\n" + 
			"    tn_order_trail t\r\n" + 
			"WHERE\r\n" + 
			"    t.order_id IN(\r\n" + 
			"    SELECT\r\n" + 
			"        order_id\r\n" + 
			"    FROM\r\n" + 
			"        tn_order_header\r\n" + 
			"    WHERE\r\n" + 
			"        del_status = 0 AND order_status IN(:status) AND delivery_date BETWEEN :fromDate AND :toDate \r\n" + 
			") " + 
			"    ) t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        u.user_id,\r\n" + 
			"        CONCAT(\r\n" + 
			"            u.user_name,\r\n" + 
			"            ' (',\r\n" + 
			"            t.user_type_name,\r\n" + 
			"            ') '\r\n" + 
			"        ) AS user_name\r\n" + 
			"    FROM\r\n" + 
			"        mn_user u,\r\n" + 
			"        mn_user_type t\r\n" + 
			"    WHERE\r\n" + 
			"        u.del_status = 0 AND u.user_type = t.user_type_id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.action_by_user_id = t2.user_id\r\n" + 
			") tbl\r\n" + 
			"ORDER BY\r\n" + 
			"    order_id,\r\n" + 
			"    trail_id",nativeQuery=true)
	public List<GetOrderTrailDisplay> getOrderTrailDataByDateAndStatus(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("status") List<Integer> status);
	
	
	@Query(value="SELECT\r\n" + 
			"    *\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        t1.*,\r\n" + 
			"        COALESCE(t2.user_name, '') AS user_name,\r\n" + 
			"        DATE_FORMAT(\r\n" + 
			"            t1.action_date_time,\r\n" + 
			"            '%d-%m-%Y %h:%i %p'\r\n" + 
			"        ) AS trail_date\r\n" + 
			"    FROM\r\n" + 
			"        (\r\n" + 
			"        SELECT\r\n" + 
			"            t.*\r\n" + 
			"        FROM\r\n" + 
			"            tn_order_trail t\r\n" + 
			"        WHERE\r\n" + 
			"            t.order_id IN(\r\n" + 
			"            SELECT\r\n" + 
			"                order_id\r\n" + 
			"            FROM\r\n" + 
			"                tn_order_header\r\n" + 
			"            WHERE\r\n" + 
			"                del_status = 0 AND order_status IN(:status) AND fr_id IN(:frIds) AND delivery_date BETWEEN :fromDate AND :toDate \r\n" + 
			"        )\r\n" + 
			"    ) t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        u.user_id,\r\n" + 
			"        CONCAT(\r\n" + 
			"            u.user_name,\r\n" + 
			"            ' (',\r\n" + 
			"            t.user_type_name,\r\n" + 
			"            ') '\r\n" + 
			"        ) AS user_name\r\n" + 
			"    FROM\r\n" + 
			"        mn_user u,\r\n" + 
			"        mn_user_type t\r\n" + 
			"    WHERE\r\n" + 
			"        u.del_status = 0 AND u.user_type = t.user_type_id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.action_by_user_id = t2.user_id\r\n" + 
			") tbl\r\n" + 
			"ORDER BY\r\n" + 
			"    order_id,\r\n" + 
			"    trail_id",nativeQuery=true)
	public List<GetOrderTrailDisplay> getOrderTrailDataByDateAndStatusAndFr(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("status") List<Integer> status,@Param("frIds") List<Integer> frIds);
	
	

	@Query(value="SELECT\r\n" + 
			"    *\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        t1.*,\r\n" + 
			"        COALESCE(t2.user_name, '') AS user_name,\r\n" + 
			"        DATE_FORMAT(\r\n" + 
			"            t1.action_date_time,\r\n" + 
			"            '%d-%m-%Y %h:%i %p'\r\n" + 
			"        ) AS trail_date\r\n" + 
			"    FROM\r\n" + 
			"        (\r\n" + 
			"        SELECT\r\n" + 
			"            t.*\r\n" + 
			"        FROM\r\n" + 
			"            tn_order_trail t\r\n" + 
			"        WHERE\r\n" + 
			"            t.order_id IN(\r\n" + 
			"            SELECT\r\n" + 
			"                order_id\r\n" + 
			"            FROM\r\n" + 
			"                tn_order_header\r\n" + 
			"            WHERE\r\n" + 
			"                del_status = 0 AND order_status IN(:status) AND cust_id IN(:custIds) AND delivery_date BETWEEN :fromDate AND :toDate \r\n" + 
			"        )\r\n" + 
			"    ) t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        u.user_id,\r\n" + 
			"        CONCAT(\r\n" + 
			"            u.user_name,\r\n" + 
			"            ' (',\r\n" + 
			"            t.user_type_name,\r\n" + 
			"            ') '\r\n" + 
			"        ) AS user_name\r\n" + 
			"    FROM\r\n" + 
			"        mn_user u,\r\n" + 
			"        mn_user_type t\r\n" + 
			"    WHERE\r\n" + 
			"        u.del_status = 0 AND u.user_type = t.user_type_id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.action_by_user_id = t2.user_id\r\n" + 
			") tbl\r\n" + 
			"ORDER BY\r\n" + 
			"    order_id,\r\n" + 
			"    trail_id",nativeQuery=true)
	public List<GetOrderTrailDisplay> getOrderTrailDataByDateAndStatusAndCust(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("status") List<Integer> status,@Param("custIds") List<Integer> custIds);
	
	
	@Query(value="SELECT\r\n" + 
			"    *\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        t1.*,\r\n" + 
			"        COALESCE(t2.user_name, '') AS user_name,\r\n" + 
			"        DATE_FORMAT(\r\n" + 
			"            t1.action_date_time,\r\n" + 
			"            '%d-%m-%Y %h:%i %p'\r\n" + 
			"        ) AS trail_date\r\n" + 
			"    FROM\r\n" + 
			"        (\r\n" + 
			"        SELECT\r\n" + 
			"            t.*\r\n" + 
			"        FROM\r\n" + 
			"            tn_order_trail t\r\n" + 
			"        WHERE\r\n" + 
			"            t.order_id IN(\r\n" + 
			"            SELECT\r\n" + 
			"                order_id\r\n" + 
			"            FROM\r\n" + 
			"                tn_order_header\r\n" + 
			"            WHERE\r\n" + 
			"                del_status = 0 AND order_status IN(:status) AND order_platform IN(:platform) AND delivery_date BETWEEN :fromDate AND :toDate \r\n" + 
			"        )\r\n" + 
			"    ) t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        u.user_id,\r\n" + 
			"        CONCAT(\r\n" + 
			"            u.user_name,\r\n" + 
			"            ' (',\r\n" + 
			"            t.user_type_name,\r\n" + 
			"            ') '\r\n" + 
			"        ) AS user_name\r\n" + 
			"    FROM\r\n" + 
			"        mn_user u,\r\n" + 
			"        mn_user_type t\r\n" + 
			"    WHERE\r\n" + 
			"        u.del_status = 0 AND u.user_type = t.user_type_id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.action_by_user_id = t2.user_id\r\n" + 
			") tbl\r\n" + 
			"ORDER BY\r\n" + 
			"    order_id,\r\n" + 
			"    trail_id",nativeQuery=true)
	public List<GetOrderTrailDisplay> getOrderTrailDataByDateAndStatusAndOrderPlatform(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("status") List<Integer> status,@Param("platform") List<Integer> platform);
	
	
	@Query(value="SELECT\r\n" + 
			"    *\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        t1.*,\r\n" + 
			"        COALESCE(t2.user_name, '') AS user_name,\r\n" + 
			"        DATE_FORMAT(\r\n" + 
			"            t1.action_date_time,\r\n" + 
			"            '%d-%m-%Y %h:%i %p'\r\n" + 
			"        ) AS trail_date\r\n" + 
			"    FROM\r\n" + 
			"        (\r\n" + 
			"        SELECT\r\n" + 
			"            t.*\r\n" + 
			"        FROM\r\n" + 
			"            tn_order_trail t\r\n" + 
			"        WHERE\r\n" + 
			"            t.order_id IN(\r\n" + 
			"            SELECT\r\n" + 
			"                order_id\r\n" + 
			"            FROM\r\n" + 
			"                tn_order_header\r\n" + 
			"            WHERE\r\n" + 
			"                del_status = 0 AND order_status IN(:status) AND payment_method IN(:payment) AND delivery_date BETWEEN :fromDate AND :toDate \r\n" + 
			"        )\r\n" + 
			"    ) t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        u.user_id,\r\n" + 
			"        CONCAT(\r\n" + 
			"            u.user_name,\r\n" + 
			"            ' (',\r\n" + 
			"            t.user_type_name,\r\n" + 
			"            ') '\r\n" + 
			"        ) AS user_name\r\n" + 
			"    FROM\r\n" + 
			"        mn_user u,\r\n" + 
			"        mn_user_type t\r\n" + 
			"    WHERE\r\n" + 
			"        u.del_status = 0 AND u.user_type = t.user_type_id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.action_by_user_id = t2.user_id\r\n" + 
			") tbl\r\n" + 
			"ORDER BY\r\n" + 
			"    order_id,\r\n" + 
			"    trail_id",nativeQuery=true)
	public List<GetOrderTrailDisplay> getOrderTrailDataByDateAndStatusAndPaymentMode(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("status") List<Integer> status,@Param("payment") List<Integer> payment);
	
	
}
