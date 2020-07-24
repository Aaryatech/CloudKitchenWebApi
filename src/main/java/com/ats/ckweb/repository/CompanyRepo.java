package com.ats.ckweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.Company;
@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer> {

	@Query(value="SELECT\n" + 
			"    comp.company_id,\n" + 
			"    comp.company_name,\n" + 
			"    comp.company_address,\n" + 
			"    comp.company_contact_no,\n" + 
			"    comp.contact_person_name,\n" + 
			"    comp.contact_person_mobile,\n" + 
			"    comp.contact_person_name1,\n" + 
			"    comp.contact_person_mobile1,\n" + 
			"    comp.company_gst_no,\n" + 
			"    comp.company_website,\n" + 
			"    comp.company_email,\n" + 
			"    comp.cin_no,\n" + 
			"    comp.reg_date,\n" + 
			"    comp.starting_date,\n" + 
			"    comp.is_used,\n" + 
			"    comp.company_logo,\n" + 
			"    comp.pan_card,\n" + 
			"    comp.city,  comp.del_status,\n" + 
			"    comp.ex_int1,\n" + 
			"    comp.ex_int2,\n" + 
			"    comp.ex_int3,\n" + 
			"    comp.ex_var1,\n" + 
			"    comp.ex_var2,\n" + 
			"    city.city_name AS ex_var3\n" + 
			"FROM\n" + 
			"    mn_company comp,\n" + 
			"    mn_city city\n" + 
			"WHERE\n" + 
			"    comp.city=city.city_id AND\n" + 
			"    comp.del_status=0 AND\n" + 
			"    city.del_status=0 ORDER BY comp.company_id DESC",nativeQuery=true)
	List<Company> getAllCompaniesDetails(); 
	
	List<Company> findByDelStatus(int del);
	
	Company findByCompanyIdAndDelStatus(int compId, int del);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mn_company SET del_status=1 WHERE company_id=:compId", nativeQuery=true)
	int deleteCompanyById(@Param("compId") int compId);
	
	List<Company> findByDelStatusAndIsUsed(int del, int isUsed);
	
}
