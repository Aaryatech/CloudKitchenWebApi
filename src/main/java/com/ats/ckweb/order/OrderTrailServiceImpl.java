package com.ats.ckweb.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ckweb.model.OrderTrail;
import com.ats.ckweb.repository.OrderTrailRepository;

@Service
public class OrderTrailServiceImpl implements OrderTrailService {

	@Autowired
	OrderTrailRepository orderTrailRepository;

	@Override
	public OrderTrail insertOrderTrail(OrderTrail trail) {

		OrderTrail res = orderTrailRepository.save(trail);
		if (res == null) {
			res = new OrderTrail();
		}

		return res;
	}

}
