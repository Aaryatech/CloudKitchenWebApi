package com.ats.ckweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.ckweb.model.OrderFeedback;

public interface OrderFeedbackRepo extends JpaRepository<OrderFeedback, Integer>{

}
