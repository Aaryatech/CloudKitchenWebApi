package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.CustWalletTransaction;

public interface CustWalletTransactionRepo extends JpaRepository<CustWalletTransaction, Integer> {

	
	@Query(value="SELECT\r\n" + 
			"    w.wallet_id,\r\n" + 
			"    h.order_id,\r\n" + 
			"    h.order_no,\r\n" + 
			"    DATE_FORMAT(h.order_date, '%d-%m-%Y') AS order_date,\r\n" + 
			"    h.total_amt,\r\n" + 
			"    w.amount,\r\n" + 
			"    DATE_FORMAT(w.wallet_date, '%d-%m-%Y') AS wallet_date,\r\n" + 
			"    CASE WHEN w.wallet_transc_type = 1 THEN 'Dr' ELSE 'CR'\r\n" + 
			"END AS transc_type,\r\n" + 
			"(\r\n" + 
			"    SELECT\r\n" + 
			"        bh.invoice_no\r\n" + 
			"    FROM\r\n" + 
			"        t_sell_bill_header bh\r\n" + 
			"    WHERE\r\n" + 
			"        bh.del_status = 0 AND bh.ext_int2 = h.order_id\r\n" + 
			") AS bill_no\r\n" + 
			"FROM\r\n" + 
			"    tn_wallet w,\r\n" + 
			"    tn_order_header h\r\n" + 
			"WHERE\r\n" + 
			"    w.order_id = h.order_id AND h.cust_id = :custId AND h.del_status = 0\r\n" + 
			"ORDER BY\r\n" + 
			"    w.wallet_date",nativeQuery=true)
	public List<CustWalletTransaction> getCustWalletTransc(@Param("custId") int custId);
	

}
