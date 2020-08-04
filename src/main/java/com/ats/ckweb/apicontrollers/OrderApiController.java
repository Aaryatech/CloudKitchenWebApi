package com.ats.ckweb.apicontrollers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.model.CustomerDisplay;
import com.ats.ckweb.model.GetOrderDetailList;
import com.ats.ckweb.model.GetOrderHeaderList;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.OrderDetail;
import com.ats.ckweb.model.OrderHeader;
import com.ats.ckweb.model.OrderListData;
import com.ats.ckweb.model.OrderSaveData;
import com.ats.ckweb.model.OrderTrail;
import com.ats.ckweb.repository.CustomerDisplayRepo;
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

	@Autowired
	CustomerDisplayRepo customerDisplayRepo;

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
	public @ResponseBody OrderListData getOrderListByStatus(@RequestParam("status") List<Integer> sts) {

		OrderListData orderListData = new OrderListData();

		try {

			List<GetOrderHeaderList> listbystatus = getOrderHeaderListRepository.getOrderListByStatus(sts);

			List<GetOrderDetailList> detailListbystatus = getOrderDetailListRepository.getOrderDetailListByStatus(sts);

			for (int i = 0; i < listbystatus.size(); i++) {
				List<GetOrderDetailList> detail = new ArrayList<>();

				for (int j = 0; j < detailListbystatus.size(); j++) {

					if (listbystatus.get(i).getOrderId() == detailListbystatus.get(j).getOrderId()) {
						detail.add(detailListbystatus.get(j));
					}
				}
				listbystatus.get(i).setDetailList(detail);
			}

			orderListData.setOrderListByStatus(listbystatus);

			Date dt = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

			List<GetOrderHeaderList> listbydate = getOrderHeaderListRepository
					.getOrderListByStatusAndDate(sf.format(dt));

			List<GetOrderDetailList> detailListbydate = getOrderDetailListRepository
					.getOrderDetailListByStatusAndDate(sf.format(dt));

			for (int i = 0; i < listbydate.size(); i++) {
				List<GetOrderDetailList> detail = new ArrayList<>();

				for (int j = 0; j < detailListbydate.size(); j++) {

					if (listbydate.get(i).getOrderId() == detailListbydate.get(j).getOrderId()) {
						detail.add(detailListbydate.get(j));
					}
				}
				listbydate.get(i).setDetailList(detail);
			}

			orderListData.setOrderListByStatusAndDate(listbydate);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderListData;
	}

	@RequestMapping(value = { "/getCustomerByMobileNo" }, method = RequestMethod.POST)
	public @ResponseBody List<CustomerDisplay> getCustomerByMobileNo(@RequestParam("mobileNo") String mobileNo) {

		List<CustomerDisplay> res = new ArrayList<>();
		try {

			res = customerDisplayRepo.getCustomerByMobileNo(mobileNo);
 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

}
