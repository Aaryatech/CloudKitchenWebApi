package com.ats.ckweb.order;

import org.springframework.stereotype.Service;

import com.ats.ckweb.model.OrderHeader;

@Service
public interface OrderHeaderService {

	OrderHeader insertOrderHeader(OrderHeader header);
	
}
