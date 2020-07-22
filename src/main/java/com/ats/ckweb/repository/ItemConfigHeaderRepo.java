package com.ats.ckweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.ItemConfigHeader;

@Repository
public interface ItemConfigHeaderRepo extends JpaRepository<ItemConfigHeader, Integer> {
	
	

}
