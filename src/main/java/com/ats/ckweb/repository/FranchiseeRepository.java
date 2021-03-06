package com.ats.ckweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.Franchisee;


@Repository("franchiseeRepository")
public interface FranchiseeRepository extends JpaRepository<Franchisee, Integer> {
	 
		public Franchisee save(Franchisee franchisee);


		//public Franchisee findByFrCode(String frCode);

		public List<Franchisee> findAllByDelStatus(int i);
		

		@Modifying
		@Transactional
		@Query("Update Franchisee  SET fr_password=:adminPwd WHERE fr_id=:frId")
		public int updateAdminPwd(@Param("frId")int frId,@Param("adminPwd")String adminPwd);

		@Query(value="select MAX(fr_id)+1 from m_franchisee",nativeQuery=true)
		public int getUnigueFrCode();

		public List<Franchisee> findAllByDelStatusOrderByFrNameAsc(int i);

		public List<Franchisee> findByDelStatusAndFrIdIn(int i, List<Integer> frids);

		public Franchisee findByfrCodeAndDelStatus(String frCode, int del);


		@Modifying
		@Transactional
		@Query("Update Franchisee  SET fr_password=:newPass WHERE fr_id=:frId")
		public int changeOPSPassword(@Param("frId")int frId,@Param("newPass")String newPass);
		
		@Query(value="SELECT * FROM `m_franchisee` where del_status=0 ORDER BY fr_name ASC",nativeQuery=true)
		public List<Franchisee> findAllFranchisee();
		
		public Franchisee findByFrId(int frId);
		
		@Query(value="SELECT * FROM m_franchisee f WHERE f.del_status=0 AND f.fr_id NOT IN(SELECT fr_id FROM tn_fr_config WHERE del_status=0 ) ORDER BY f.fr_name",nativeQuery=true)
		public List<Franchisee> getAllNotConfiguredFranchisee();
		
		
	}