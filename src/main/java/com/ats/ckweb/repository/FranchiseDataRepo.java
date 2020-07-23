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


}
