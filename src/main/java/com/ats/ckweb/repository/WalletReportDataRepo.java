package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.WalletReportData;

public interface WalletReportDataRepo  extends JpaRepository<WalletReportData, Integer> {

	
	@Query(value="select t1.*,COALESCE(t2.dr_amt,0) as dr_amt, COALESCE(t3.cr_amt,0) as cr_amt from \r\n" + 
			"(\r\n" + 
			"select uuid() as id,h.order_id, h.order_no, h.order_date, SUM(h.total_amt) as order_amt from tn_wallet w, tn_order_header h where h.order_id=w.order_id and h.order_date between :fromDate and :toDate and h.del_status=0 and w.wallet_transc_type IN(:transcType) and h.cust_id=:custId group by h.order_id\r\n" + 
			") t1 \r\n" + 
			"LEFT JOIN \r\n" + 
			"(\r\n" + 
			"select w.order_id, SUM(w.amount) as dr_amt from tn_wallet w where w.wallet_transc_type=1 group by w.order_id\r\n" + 
			") t2 on t1.order_id=t2.order_id\r\n" + 
			"LEFT JOIN \r\n" + 
			"(\r\n" + 
			"select w.order_id, SUM(w.amount) as cr_amt from tn_wallet w where w.wallet_transc_type=2 group by w.order_id\r\n" + 
			") t3 on t1.order_id=t3.order_id\r\n" + 
			"order by order_date",nativeQuery=true)
	public List<WalletReportData> getWalletReportByDateAndCust(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("transcType") List<Integer> transcType,  @Param("custId") int custId);
	
	
}
