package com.ats.ckweb.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.ckweb.report.model.Status;

public interface StatusRepo extends JpaRepository<Status, Integer> {

	List<Status> findByDelStatusOrderByStatusIdAsc(int del);
}
