package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.ckweb.model.UserType;

public interface UserTypeRepo extends JpaRepository<UserType, Integer> {

	List<UserType> findByDelStatus(int del);
}
