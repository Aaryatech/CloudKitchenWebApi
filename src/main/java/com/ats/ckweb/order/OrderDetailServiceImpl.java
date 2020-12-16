package com.ats.ckweb.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ckweb.model.OrderDetail;
import com.ats.ckweb.repository.OrderDetailRepository;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Override
	public OrderDetail insertOrderDetail(OrderDetail orderDetail) {

		OrderDetail res = orderDetailRepository.save(orderDetail);
		if (res == null) {
			res = new OrderDetail();
		}

		return res;
	}

	@Override
	public List<OrderDetail> insertOrderDetailList(List<OrderDetail> orderDetailList) {

		List<OrderDetail> res = orderDetailRepository.saveAll(orderDetailList);
		if (res == null) {
			res = new ArrayList<>();
		}

		return res;
	}

}
