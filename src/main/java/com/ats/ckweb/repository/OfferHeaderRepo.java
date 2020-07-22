package com.ats.ckweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.OfferHeader;

@Repository
public interface OfferHeaderRepo extends JpaRepository<OfferHeader, Integer> {

}
