package com.ats.ckweb.apicontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.OrderDetail;
import com.ats.ckweb.model.OrderHeader;
import com.ats.ckweb.model.OrderSaveData;
import com.ats.ckweb.model.OrderTrail;
import com.ats.ckweb.repository.OrderDetailRepository;
import com.ats.ckweb.repository.OrderHeaderRepository;
import com.ats.ckweb.repository.OrderTrailRepository;

@RestController
public class OrderApiController {

	@Autowired
	OrderHeaderRepository orderHeaderRepository;

	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Autowired
	OrderTrailRepository orderTrailRepository;

	@RequestMapping(value = { "/saveCloudOrder" }, method = RequestMethod.POST)
	public @ResponseBody Info saveCloudOrder(@RequestBody OrderSaveData orderSaveData) {

		Info info = new Info();

		try {

			OrderHeader res = orderHeaderRepository.save(orderSaveData.getOrderHeader());
			orderSaveData.getOrderTrail().setOrderId(res.getOrderId());

			OrderTrail orderRes = orderTrailRepository.save(orderSaveData.getOrderTrail());

			for (int i = 0; i < orderSaveData.getOrderDetailList().size(); i++) {
				orderSaveData.getOrderDetailList().get(i).setOrderId(res.getOrderId());
			}
			List<OrderDetail> orderDetailList = orderDetailRepository.saveAll(orderSaveData.getOrderDetailList());

			info.setError(false);
			info.setMessage(String.valueOf(res.getOrderId()));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

}
