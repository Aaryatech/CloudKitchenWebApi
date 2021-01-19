package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.FranchiseDataNew;

public interface FranchiseDataNewRepo extends JpaRepository<FranchiseDataNew, Integer>{
	
	@Query(value="SELECT\r\n" + 
			"    t1.*,\r\n" + 
			"    COALESCE(t2.is_courier, 0) AS is_courier\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        fc.fr_config_id,\r\n" + 
			"        fc.fr_id,\r\n" + 
			"        fc.fr_type,\r\n" + 
			"        f.fr_name,\r\n" + 
			"        CONCAT(\r\n" + 
			"            f.fr_code,\r\n" + 
			"            '~',\r\n" + 
			"            f.fba_license_date\r\n" + 
			"        ) AS fr_code,\r\n" + 
			"        f.fr_address,\r\n" + 
			"        f.fr_mob,\r\n" + 
			"        fc.from_latitude,\r\n" + 
			"        fc.from_longitude,\r\n" + 
			"        fc.to_latitude,\r\n" + 
			"        fc.to_longitude,\r\n" + 
			"        fc.km_area_covered,\r\n" + 
			"        fc.comp_id\r\n" + 
			"    FROM\r\n" + 
			"        tn_fr_config fc,\r\n" + 
			"        m_franchisee f\r\n" + 
			"    WHERE\r\n" + 
			"        fc.del_status = 0 AND fc.is_active = 0 AND fc.fr_id = f.fr_id\r\n" + 
			"    ORDER BY\r\n" + 
			"        f.fr_name\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT 1 AS is_courier,\r\n" + 
			"        m.fr_id,\r\n" + 
			"        m.fr_name\r\n" + 
			"    FROM\r\n" + 
			"        m_franchisee m\r\n" + 
			"    INNER JOIN t_setting_new ON FIND_IN_SET(m.fr_id, setting_value1) > 0 AND setting_key = 'SHIPROCKET_FR_IDS'\r\n" + 
			"    GROUP BY\r\n" + 
			"        m.fr_Id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.fr_id = t2.fr_id",nativeQuery=true)
	public  List<FranchiseDataNew> getAllFranchise();
	
	@Query(value="SELECT\r\n" + 
			"    t1.*,\r\n" + 
			"    COALESCE(t2.is_courier, 0) AS is_courier\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        fc.fr_config_id,\r\n" + 
			"        fc.fr_id,\r\n" + 
			"        fc.fr_type,\r\n" + 
			"        f.fr_name,\r\n" + 
			"        CONCAT(f.fr_code, '~', f.fba_license_date) AS fr_code,\r\n" + 
			"        f.fr_address,\r\n" + 
			"        f.fr_mob,\r\n" + 
			"        fc.from_latitude,\r\n" + 
			"        fc.from_longitude,\r\n" + 
			"        fc.to_latitude,\r\n" + 
			"        fc.to_longitude,\r\n" + 
			"        fc.km_area_covered,\r\n" + 
			"        fc.comp_id\r\n" + 
			"    FROM\r\n" + 
			"        tn_fr_config fc,\r\n" + 
			"        m_franchisee f\r\n" + 
			"    WHERE\r\n" + 
			"        fc.del_status = 0 AND fc.is_active = 0 AND fc.fr_id = f.fr_id AND f.fr_id = :frId\r\n" + 
			"    ORDER BY\r\n" + 
			"        f.fr_name\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        1 AS is_courier,\r\n" + 
			"        m.fr_id,\r\n" + 
			"        m.fr_name\r\n" + 
			"    FROM\r\n" + 
			"        m_franchisee m\r\n" + 
			"    INNER JOIN t_setting_new ON FIND_IN_SET(m.fr_id, setting_value1) > 0 AND setting_key = 'SHIPROCKET_FR_IDS'\r\n" + 
			"    GROUP BY\r\n" + 
			"        m.fr_Id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.fr_id = t2.fr_id",nativeQuery=true)
	public  FranchiseDataNew getFranchiseById(@Param("frId") int frId);
	
	@Query(value="SELECT\r\n" + 
			"    t1.*,\r\n" + 
			"    COALESCE(t2.is_courier, 0) AS is_courier\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        fc.fr_config_id,\r\n" + 
			"        fc.fr_id,\r\n" + 
			"        fc.fr_type,\r\n" + 
			"        f.fr_name,\r\n" + 
			"        CONCAT(f.fr_code, '~', f.fba_license_date) AS fr_code,\r\n" + 
			"        f.fr_address,\r\n" + 
			"        f.fr_mob,\r\n" + 
			"        fc.from_latitude,\r\n" + 
			"        fc.from_longitude,\r\n" + 
			"        fc.to_latitude,\r\n" + 
			"        fc.to_longitude,\r\n" + 
			"        fc.km_area_covered,\r\n" + 
			"        fc.comp_id\r\n" + 
			"    FROM\r\n" + 
			"        tn_fr_config fc,\r\n" + 
			"        m_franchisee f\r\n" + 
			"    WHERE\r\n" + 
			"        fc.del_status = 0 AND fc.is_active = 0 AND fc.fr_id = f.fr_id AND f.fr_id = :frId\r\n" + 
			"    ORDER BY\r\n" + 
			"        f.fr_name\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        1 AS is_courier,\r\n" + 
			"        m.fr_id,\r\n" + 
			"        m.fr_name\r\n" + 
			"    FROM\r\n" + 
			"        m_franchisee m\r\n" + 
			"    INNER JOIN t_setting_new ON FIND_IN_SET(m.fr_id, setting_value1) > 0 AND setting_key = 'SHIPROCKET_FR_IDS'\r\n" + 
			"    GROUP BY\r\n" + 
			"        m.fr_Id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.fr_id = t2.fr_id",nativeQuery=true)
	public  FranchiseDataNew getFranchiseByIdApp(@Param("frId") int frId);

	@Query(value="SELECT\r\n" + 
			"    t1.*,\r\n" + 
			"    COALESCE(t2.is_courier, 0) AS is_courier\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        fc.fr_config_id,\r\n" + 
			"        fc.fr_id,\r\n" + 
			"        fc.fr_type,\r\n" + 
			"        f.fr_name,\r\n" + 
			"        CONCAT(f.fr_code, '~', f.fba_license_date) AS fr_code,\r\n" + 
			"        f.fr_address,\r\n" + 
			"        f.fr_mob,\r\n" + 
			"        fc.from_latitude,\r\n" + 
			"        fc.from_longitude,\r\n" + 
			"        fc.to_latitude,\r\n" + 
			"        fc.to_longitude,\r\n" + 
			"        fc.km_area_covered,\r\n" + 
			"        fc.comp_id\r\n" + 
			"    FROM\r\n" + 
			"        tn_fr_config fc,\r\n" + 
			"        m_franchisee f\r\n" + 
			"    WHERE\r\n" + 
			"        fc.del_status = 0 AND fc.is_active = 0 AND fc.fr_id = f.fr_id AND FIND_IN_SET(:cityId, fc.city_ids)\r\n" + 
			"    ORDER BY\r\n" + 
			"        f.fr_name\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        1 AS is_courier,\r\n" + 
			"        m.fr_id,\r\n" + 
			"        m.fr_name\r\n" + 
			"    FROM\r\n" + 
			"        m_franchisee m\r\n" + 
			"    INNER JOIN t_setting_new ON FIND_IN_SET(m.fr_id, setting_value1) > 0 AND setting_key = 'SHIPROCKET_FR_IDS'\r\n" + 
			"    GROUP BY\r\n" + 
			"        m.fr_Id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.fr_id = t2.fr_id",nativeQuery=true)
	public List<FranchiseDataNew> getShopByCityId(@Param("cityId") int cityId);
	
	
	@Query(value="SELECT e.ex_var1  FROM m_fr_emp e WHERE e.del_status=0 AND e.ex_var1!='' AND e.ex_var1!='NA' AND e.fr_id=:frId",nativeQuery=true)
	public List<String> getAllTokenListByFr(@Param("frId") int frId);

}
