package com.ats.ckweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.ckweb.model.FrCharges;

public interface FrChargesRepo extends JpaRepository<FrCharges, Integer> {

	FrCharges findByfrId(int frId);
}
