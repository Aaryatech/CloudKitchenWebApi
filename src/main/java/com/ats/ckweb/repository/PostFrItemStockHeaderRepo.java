package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.ckweb.model.PostFrItemStockHeader;


public interface PostFrItemStockHeaderRepo extends JpaRepository<PostFrItemStockHeader, Integer> {

	List<PostFrItemStockHeader> findByFrIdAndIsMonthClosed(int frId, int isMonthClosed);
	
}
