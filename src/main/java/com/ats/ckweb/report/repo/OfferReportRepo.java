package com.ats.ckweb.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.report.model.OfferReport;

public interface OfferReportRepo extends JpaRepository<OfferReport, Integer> {

	@Query(value="SELECT\r\n" + 
			"    t1.offer_id,\r\n" + 
			"    t1.offer_name,\r\n" + 
			"    t1.offer_desc,\r\n" + 
			"    DATE_FORMAT(t1.maker_datetime,'%d-%m-%Y') AS offer_date,\r\n" + 
			"    t1.type as type,\r\n" + 
			"    CASE WHEN t1.type=1 THEN 'POS' ELSE 'Online' END AS type_text,\r\n" + 
			"    t1.applicable_for,\r\n" + 
			"    t1.offer_type,\r\n" + 
			"    CASE WHEN t1.offer_type=1 THEN 'Billwise Offer' ELSE 'Itemwise Offer' END AS offer_type_text,\r\n" + 
			"    t1.ex_int1 AS sub_type,\r\n" + 
			"    CASE WHEN t1.offer_type=1 THEN CASE WHEN t1.ex_int1=0 THEN 'Coupon wise Offer' ELSE 'Customer wise Offer' END ELSE '-' END AS sub_type_text,\r\n" + 
			"    t1.frequency_type,\r\n" + 
			"    CASE WHEN t1.frequency_type=1 THEN 'Day' ELSE 'Date' END AS frequency_type_text,\r\n" + 
			"    t1.frequency,\r\n" + 
			"    DATE_FORMAT(t1.from_date,'%d-%m-%Y') as from_date,\r\n" + 
			"    DATE_FORMAT(t1.to_date,'%d-%m-%Y') as to_date,\r\n" + 
			"    TIME_FORMAT(t1.from_time,'%h:%i %p') as from_time,\r\n" + 
			"    TIME_FORMAT(t1.to_time,'%h:%i %p') as to_time,\r\n" + 
			"    COALESCE(t2.total_used,0) AS total_used,\r\n" + 
			"    COALESCE(t2.grand_total,0) as grand_total,\r\n" + 
			"    COALESCE(t2.disc_amt,0) as disc_amt,\r\n" + 
			"    COALESCE(t2.payable_amt,0) as payable_amt,\r\n" + 
			"    COALESCE(t2.delivery_amt,0) as delivery_amt,\r\n" + 
			"    COALESCE(t2.wallet_amt,0) as wallet_amt,\r\n" + 
			"    (COALESCE(t2.grand_total,0) + COALESCE(t2.delivery_amt,0) + COALESCE(t2.disc_amt,0) + COALESCE(t2.wallet_amt,0)) AS bill_total\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        *\r\n" + 
			"    FROM\r\n" + 
			"        mn_offer_header h\r\n" + 
			"    WHERE\r\n" + 
			"        DATE(h.maker_datetime) BETWEEN :fromDate AND :toDate AND h.del_status = 0 AND h.is_active=0\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT oh.offer_id,\r\n" + 
			"    	COUNT(*) AS total_used,\r\n" + 
			"        SUM(h.grand_total) AS grand_total,\r\n" + 
			"        SUM(h.discount_amt) AS disc_amt,\r\n" + 
			"        SUM(h.payable_amt) AS payable_amt,\r\n" + 
			"        SUM(ext_float2) AS delivery_amt,\r\n" + 
			"        SUM(ext_float3) AS wallet_amt\r\n" + 
			"    FROM\r\n" + 
			"        t_sell_bill_header h,\r\n" + 
			"        tn_order_header oh\r\n" + 
			"    WHERE\r\n" + 
			"        h.del_status = 0 AND h.ext_int2 = oh.order_id\r\n" + 
			"    GROUP BY\r\n" + 
			"        oh.offer_id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.offer_id = t2.offer_id\r\n" + 
			"",nativeQuery=true)
	public List<OfferReport>  getOfferReport(@Param("fromDate") String fromDate, 
			@Param("toDate") String toDate);

}
