package com.ats.ckweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.OfferHeader;

@Repository
public interface OfferHeaderRepo extends JpaRepository<OfferHeader, Integer> {

	OfferHeader findByOfferId(int i);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mn_offer_header SET offer_type=:type WHERE offer_id =:offerId",nativeQuery=true)
	public int updateOfferType(@Param("offerId") int offerId,@Param("type") int type);
	
	List<OfferHeader> findByCompIdAndDelStatusAndIsActive(int i,int j,int k);
	
	List<OfferHeader> findByCompIdAndDelStatusOrderByOfferIdDesc(int compId, int del);
	
}
