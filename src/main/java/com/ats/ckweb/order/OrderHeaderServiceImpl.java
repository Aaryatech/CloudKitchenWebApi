package com.ats.ckweb.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ckweb.model.OrderHeader;
import com.ats.ckweb.repository.OrderHeaderRepository;

@Service
public class OrderHeaderServiceImpl implements OrderHeaderService {

	@Autowired
	OrderHeaderRepository orderHeaderRepository;

	@Override
	public OrderHeader insertOrderHeader(OrderHeader header) {

		OrderHeader res = orderHeaderRepository.save(header);
		if (res == null) {
			res = new OrderHeader();
		}

		return res;
	}

}
