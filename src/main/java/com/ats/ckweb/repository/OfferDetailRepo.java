package com.ats.ckweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.OfferDetail;

@Repository
public interface OfferDetailRepo extends JpaRepository<OfferDetail, Integer> {

}
