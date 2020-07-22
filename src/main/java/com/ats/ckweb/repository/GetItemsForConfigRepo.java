package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.GetItemsForConfig;

@Repository
public interface GetItemsForConfigRepo extends JpaRepository<GetItemsForConfig, Integer>{

	@Query(value="SELECT\r\n" + 
			"    t1.item_id,\r\n" + 
			"    t1.item_name,\r\n" + 
			"    t1.hsncd,\r\n" + 
			"    t1.mrp AS rate_amt,\r\n" + 
			"    CASE WHEN(COALESCE(t2.checked, 0) = 1) THEN t2.mrp_amt ELSE t1.mrp\r\n" + 
			"END AS mrp_amt,\r\n" + 
			"CASE WHEN(COALESCE(t2.checked, 0) = 1) THEN t2.sp_rate_amt ELSE t1.mrp\r\n" + 
			"END AS sp_rate_amt,\r\n" + 
			"t1.tax1,\r\n" + 
			"t1.tax2,\r\n" + 
			"t1.tax3,\r\n" + 
			"COALESCE(t2.status, 0) AS\r\n" + 
			"STATUS\r\n" + 
			"    ,\r\n" + 
			"    COALESCE(t2.checked, 0) AS checked, COALESCE(t2.item_config_id, 0) AS item_config_id,\r\n" + 
			"    COALESCE(t2.item_config_detail_id, 0) AS item_config_detail_id \r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        i.id AS item_id,\r\n" + 
			"        i.item_name,\r\n" + 
			"        i.item_mrp1 AS mrp,\r\n" + 
			"        i.item_tax1 AS tax1,\r\n" + 
			"        i.item_tax2 AS tax2,\r\n" + 
			"        i.item_tax3 AS tax3,\r\n" + 
			"        sup.item_hsncd AS hsncd\r\n" + 
			"    FROM\r\n" + 
			"        m_item i,\r\n" + 
			"        m_item_sup sup\r\n" + 
			"    WHERE\r\n" + 
			"        i.del_status = 0 AND sup.del_status = 0 AND i.id = sup.item_id\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        cd.*,\r\n" + 
			"        1 AS checked\r\n" + 
			"    FROM\r\n" + 
			"        tn_item_config_header ch,\r\n" + 
			"        tn_item_config_detail cd\r\n" + 
			"    WHERE\r\n" + 
			"        ch.item_config_id = cd.item_config_id AND ch.del_status = 0 AND cd.del_status = 0 AND ch.fr_id = :frId AND ch.config_type=:configType AND ch.comp_id = :compId\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.item_id = t2.item_id",nativeQuery=true)
	List<GetItemsForConfig> getItemsForConfigByFrId(@Param("frId") int frId,@Param("configType") int configType, @Param("compId") int compId);

	

}
