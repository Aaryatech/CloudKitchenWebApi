package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.FranchiseData;

public interface FranchiseDataRepo extends JpaRepository<FranchiseData, Integer>{
	
	@Query(value="SELECT" + 
			"    fc.fr_config_id," + 
			"    fc.fr_id," + 
			"    fc.fr_type," + 
			"    f.fr_name," + 
			"    f.fr_code," + 
			"    f.fr_address," + 
			"    f.fr_mob," + 
			"    fc.from_latitude," + 
			"    fc.from_longitude," + 
			"    fc.to_latitude," + 
			"    fc.to_longitude," + 
			"    fc.km_area_covered," + 
			"    fc.comp_id " + 
			"FROM" + 
			"    tn_fr_config fc," + 
			"    m_franchisee f " + 
			"WHERE" + 
			"    fc.del_status = 0 AND fc.is_active = 0 AND fc.fr_id = f.fr_id ORDER BY f.fr_name",nativeQuery=true)
	public  List<FranchiseData> getAllFranchise();
	
	@Query(value="SELECT" + 
			"    fc.fr_config_id," + 
			"    fc.fr_id," + 
			"    fc.fr_type," + 
			"    f.fr_name," + 
			"    f.fr_code," + 
			"    f.fr_address," + 
			"    f.fr_mob," + 
			"    fc.from_latitude," + 
			"    fc.from_longitude," + 
			"    fc.to_latitude," + 
			"    fc.to_longitude," + 
			"    fc.km_area_covered," + 
			"    fc.comp_id " + 
			"FROM" + 
			"    tn_fr_config fc," + 
			"    m_franchisee f " + 
			"WHERE" + 
			"    fc.del_status = 0 AND fc.is_active = 0 AND fc.fr_id = f.fr_id AND f.fr_id=:frId ORDER BY f.fr_name",nativeQuery=true)
	public  FranchiseData getFranchiseById(@Param("frId") int frId);

	@Query(value="SELECT\r\n" + 
			"        fc.fr_config_id,\r\n" + 
			"        fc.fr_id,\r\n" + 
			"        fc.fr_type,\r\n" + 
			"        f.fr_name,\r\n" + 
			"        f.fr_code,\r\n" + 
			"        f.fr_address,\r\n" + 
			"        f.fr_mob,\r\n" + 
			"        fc.from_latitude,\r\n" + 
			"        fc.from_longitude,\r\n" + 
			"        fc.to_latitude,\r\n" + 
			"        fc.to_longitude,\r\n" + 
			"        fc.km_area_covered,\r\n" + 
			"        fc.comp_id" + 
			"    FROM\r\n" + 
			"        tn_fr_config fc,\r\n" + 
			"        m_franchisee f \r\n" + 
			"    WHERE\r\n" + 
			"        fc.del_status = 0 \r\n" + 
			"        AND fc.is_active = 0 \r\n" + 
			"        AND fc.fr_id = f.fr_id\r\n" + 
			"        and FIND_IN_SET(:cityId,fc.city_ids)\r\n" + 
			"    ORDER BY\r\n" + 
			"        f.fr_name",nativeQuery=true)
	public List<FranchiseData> getShopByCityId(@Param("cityId") int cityId);
	
	
	@Query(value="SELECT e.ex_var1  FROM m_fr_emp e WHERE e.del_status=0 AND e.ex_var1!='' AND e.ex_var1!='NA' AND e.fr_id=:frId",nativeQuery=true)
	public List<String> getAllTokenListByFr(@Param("frId") int frId);

}
