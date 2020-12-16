package com.ats.ckweb.order;

import org.springframework.stereotype.Service;

import com.ats.ckweb.model.OrderTrail;

@Service
public interface OrderTrailService {

	OrderTrail insertOrderTrail(OrderTrail trail);

}
