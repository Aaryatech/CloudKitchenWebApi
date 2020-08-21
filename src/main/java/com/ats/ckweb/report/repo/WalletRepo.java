package com.ats.ckweb.report.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.ckweb.model.Wallet;


public interface WalletRepo extends JpaRepository<Wallet, Integer> {

	
	
}
