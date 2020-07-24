package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.OfferDetail;

@Repository
public interface OfferDetailRepo extends JpaRepository<OfferDetail, Integer> {
	
	List<OfferDetail> findAllByOfferIdAndIsActiveAndDelStatus(int id,int j,int k);

}
