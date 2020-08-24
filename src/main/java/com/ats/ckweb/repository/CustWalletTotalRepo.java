package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.CustWalletTotal;

public interface CustWalletTotalRepo extends JpaRepository<CustWalletTotal, Integer> {

	
	@Query(value="select t1.*, (COALESCE(t3.cr,0)-COALESCE(t2.dr,0)) as total from\r\n" + 
			"(\r\n" + 
			"select h.cust_id from tn_wallet w, tn_order_header h where h.order_id=w.order_id and h.cust_id=:custId group by cust_id\r\n" + 
			") t1 \r\n" + 
			"LEFT JOIN\r\n" + 
			"(\r\n" + 
			"select h.cust_id, SUM(amount) as dr from tn_wallet w, tn_order_header h where h.order_id=w.order_id and w.wallet_transc_type=1 group by cust_id\r\n" + 
			") t2 on t1.cust_id=t2.cust_id\r\n" + 
			"LEFT JOIN\r\n" + 
			"(\r\n" + 
			"select h.cust_id, SUM(amount) as cr from tn_wallet w, tn_order_header h where h.order_id=w.order_id and w.wallet_transc_type=2 group by cust_id\r\n" + 
			") t3 on t1.cust_id=t3.cust_id",nativeQuery=true)
	public CustWalletTotal getCustTotalWalletAmt(@Param("custId") int custId);
	

}
