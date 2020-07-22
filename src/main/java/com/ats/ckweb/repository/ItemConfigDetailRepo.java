package com.ats.ckweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.ckweb.model.ItemConfigDetail;

@Repository
public interface ItemConfigDetailRepo extends JpaRepository<ItemConfigDetail, Integer> {

}
