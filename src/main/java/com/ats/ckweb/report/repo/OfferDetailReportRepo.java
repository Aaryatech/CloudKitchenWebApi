package com.ats.ckweb.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.report.model.OfferDetailReport;

public interface OfferDetailReportRepo extends JpaRepository<OfferDetailReport, Integer> {

	@Query(value="SELECT\r\n" + 
			"    sell_bill_no,\r\n" + 
			"    invoice_no,\r\n" + 
			"    DATE_FORMAT(bill_date, '%d-%m-%Y') AS bill_date,\r\n" + 
			"    user_name AS cust_name,\r\n" + 
			"    user_phone AS cust_phone,\r\n" + 
			"    COALESCE(grand_total,0) AS grand_total,\r\n" + 
			"    COALESCE(discount_amt,0) AS discount_amt,\r\n" + 
			"    COALESCE(payable_amt,0) AS payable_amt,\r\n" + 
			"    COALESCE(ext_float2,0) AS delivery_amt,\r\n" + 
			"    COALESCE(ext_float3,0) AS wallet_amt\r\n" + 
			"FROM\r\n" + 
			"    t_sell_bill_header\r\n" + 
			"WHERE\r\n" + 
			"    ext_int2 IN(\r\n" + 
			"    SELECT\r\n" + 
			"        order_id\r\n" + 
			"    FROM\r\n" + 
			"        tn_order_header\r\n" + 
			"    WHERE\r\n" + 
			"        offer_id = :offerId \r\n" + 
			")" + 
			"",nativeQuery=true)
	public List<OfferDetailReport>  getOfferDetailReport(@Param("offerId") int offerId);

	
	
}
