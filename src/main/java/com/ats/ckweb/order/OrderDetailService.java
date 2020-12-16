package com.ats.ckweb.order;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.ckweb.model.OrderDetail;

@Service
public interface OrderDetailService {

	OrderDetail insertOrderDetail(OrderDetail orderDetail);

	List<OrderDetail> insertOrderDetailList(List<OrderDetail> orderDetailList);

}
