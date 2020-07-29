package com.ats.ckweb.apicontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.model.GetOrderDetailList;
import com.ats.ckweb.model.GetOrderHeaderList;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.OrderDetail;
import com.ats.ckweb.model.OrderHeader;
import com.ats.ckweb.model.OrderSaveData;
import com.ats.ckweb.model.OrderTrail;
import com.ats.ckweb.repository.GetOrderDetailListRepository;
import com.ats.ckweb.repository.GetOrderHeaderListRepository;
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

	@Autowired
	GetOrderHeaderListRepository getOrderHeaderListRepository;

	@Autowired
	GetOrderDetailListRepository getOrderDetailListRepository;

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

	@RequestMapping(value = { "/getOrderListByStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderHeaderList> getOrderListByStatus(@RequestParam("status") List<Integer> sts) {

		List<GetOrderHeaderList> list = new ArrayList<>();

		try {

			list = getOrderHeaderListRepository.getOrderListByStatus(sts);

			List<GetOrderDetailList> detailList = getOrderDetailListRepository.getOrderDetailListByStatus(sts);

			for (int i = 0; i < list.size(); i++) {
				List<GetOrderDetailList> detail = new ArrayList<>();

				for (int j = 0; j < detailList.size(); j++) {

					if (list.get(i).getOrderId() == detailList.get(i).getOrderId()) {
						detail.add(detailList.get(i));
					}
				}
				list.get(i).setDetailList(detail);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
