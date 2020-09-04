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

import com.ats.ckweb.commons.SMSUtility;
import com.ats.ckweb.model.Customer;
import com.ats.ckweb.model.CustomerDisplay;
import com.ats.ckweb.model.GetGrievienceList;
import com.ats.ckweb.model.GetGrievienceTailList;
import com.ats.ckweb.model.GetOrderDetailList;
import com.ats.ckweb.model.GetOrderHeaderList;
import com.ats.ckweb.model.GetOrderTrailList;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.NewSetting;
import com.ats.ckweb.model.OrderDetail;
import com.ats.ckweb.model.OrderFeedback;
import com.ats.ckweb.model.OrderGrievance;
import com.ats.ckweb.model.OrderGrievanceTrail;
import com.ats.ckweb.model.OrderHeader;
import com.ats.ckweb.model.OrderListData;
import com.ats.ckweb.model.OrderSaveData;
import com.ats.ckweb.model.OrderTrail;
import com.ats.ckweb.model.Setting;
import com.ats.ckweb.repository.CustomerDisplayRepo;
import com.ats.ckweb.repository.CustomerRepo;
import com.ats.ckweb.repository.GetGrievienceListRepository;
import com.ats.ckweb.repository.GetGrievienceTailListRepository;
import com.ats.ckweb.repository.GetOrderDetailListRepository;
import com.ats.ckweb.repository.GetOrderHeaderListRepository;
import com.ats.ckweb.repository.GetOrderTrailListRepository;
import com.ats.ckweb.repository.NewSettingRepo;
import com.ats.ckweb.repository.OrderDetailRepository;
import com.ats.ckweb.repository.OrderFeedbackRepo;
import com.ats.ckweb.repository.OrderGrievanceRepo;
import com.ats.ckweb.repository.OrderGrievanceTrailRepo;
import com.ats.ckweb.repository.OrderHeaderRepository;
import com.ats.ckweb.repository.OrderTrailRepository;
import com.ats.ckweb.repository.SettingRepository;

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

	@Autowired
	OrderFeedbackRepo orderFeedbackRepo;

	@Autowired
	OrderGrievanceRepo orderGrievanceRepo;

	@Autowired
	OrderGrievanceTrailRepo orderGrievanceTrailRepo;

	@Autowired
	GetOrderTrailListRepository getOrderTrailListRepository;

	@Autowired
	SettingRepository settingRepository;

	@Autowired
	GetGrievienceListRepository getGrievienceListRepository;

	@Autowired
	GetGrievienceTailListRepository getGrievienceTailListRepository;

	@Autowired
	NewSettingRepo newSettingRepo;

	@Autowired
	CustomerRepo customerRepo;

	@RequestMapping(value = { "/saveCloudOrder" }, method = RequestMethod.POST)
	public @ResponseBody Info saveCloudOrder(@RequestBody OrderSaveData orderSaveData) {

		Info info = new Info();

		try {

			Setting setting = new Setting();
			setting = settingRepository.findBySettingKey("ORDER_NO");

			int no = setting.getSettingValue();
			String orderNo = String.format("%0" + 5 + "d", no);

			orderSaveData.getOrderHeader().setOrderNo(orderNo);

			OrderHeader res = orderHeaderRepository.save(orderSaveData.getOrderHeader());
			orderSaveData.getOrderTrail().setOrderId(res.getOrderId());

			no = no + 1;

			int updateOrderNo = settingRepository.udateKeyAndValue("ORDER_NO", no);

			OrderTrail orderRes = orderTrailRepository.save(orderSaveData.getOrderTrail());

			for (int i = 0; i < orderSaveData.getOrderDetailList().size(); i++) {
				orderSaveData.getOrderDetailList().get(i).setOrderId(res.getOrderId());
			}
			List<OrderDetail> orderDetailList = orderDetailRepository.saveAll(orderSaveData.getOrderDetailList());

			info.setError(false);
			info.setMessage(String.valueOf(res.getOrderId()));

			try {

				NewSetting val = new NewSetting();

				if (orderSaveData.getOrderHeader().getOrderStatus() == 0) {
					val = newSettingRepo.findBySettingKeyAndDelStatus("msg_park_order", 0);
				} else if (orderSaveData.getOrderHeader().getOrderStatus() == 1) {
					val = newSettingRepo.findBySettingKeyAndDelStatus("msg_place_order", 0);
				}

				Customer cust = customerRepo.getOne(orderSaveData.getOrderHeader().getCustId());

				SMSUtility.sendSMS(cust.getPhoneNumber(), val.getSettingValue1());

			} catch (Exception e) {
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/updateOrderHeader" }, method = RequestMethod.POST)
	public @ResponseBody OrderHeader saveCloudOrder(@RequestBody OrderHeader orderHeader) {

		OrderHeader res = new OrderHeader();

		try {

			res = orderHeaderRepository.save(orderHeader);

			try {

				NewSetting val = new NewSetting();

				
					if (orderHeader.getOrderStatus() == 0) {
						val = newSettingRepo.findBySettingKeyAndDelStatus("msg_park_order", 0);
					} else if (orderHeader.getOrderStatus() == 1) {
						val = newSettingRepo.findBySettingKeyAndDelStatus("msg_place_order", 0);
					}

					Customer cust = customerRepo.getOne(orderHeader.getCustId());

					SMSUtility.sendSMS(cust.getPhoneNumber(), val.getSettingValue1());
				
			} catch (Exception e) {
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@RequestMapping(value = { "/updateOrderHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<OrderDetail> saveCloudOrder(@RequestBody List<OrderDetail> detailList) {

		List<OrderDetail> res = new ArrayList<>();

		try {

			res = orderDetailRepository.saveAll(detailList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@RequestMapping(value = { "/insertOrderTrail" }, method = RequestMethod.POST)
	public @ResponseBody OrderTrail insertOrderTrail(@RequestBody OrderTrail orderTrail) {

		OrderTrail res = new OrderTrail();

		try {

			OrderTrail orderRes = orderTrailRepository.save(orderTrail);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@RequestMapping(value = { "/changeStatusByOrderId" }, method = RequestMethod.POST)
	public @ResponseBody Info changeStatusByOrderId(@RequestParam("status") int status,
			@RequestParam("userId") int userId, @RequestParam("orderId") int orderId,
			@RequestParam("remark") String remark, @RequestParam("type") int type) {

		Info info = new Info();

		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dt = new Date();

			int update = orderHeaderRepository.updateStatus(status, orderId);

			String UUID = orderHeaderRepository.getUuId(orderId);

			OrderTrail orderTrail = new OrderTrail();
			orderTrail.setOrderId(orderId);
			orderTrail.setActionByUserId(userId);
			orderTrail.setActionDateTime(sf.format(dt));
			orderTrail.setStatus(status);
			orderTrail.setExVar1(remark);
			orderTrail.setExInt1(type);
			OrderTrail orderRes = orderTrailRepository.save(orderTrail);

			info.setError(false);
			info.setMessage(UUID);

			if (update > 0) {
				try {

					NewSetting val = new NewSetting();

					if (status == 2) {
						val = newSettingRepo.findBySettingKeyAndDelStatus("msg_accept_order", 0);
					} else if (status == 3) {
						val = newSettingRepo.findBySettingKeyAndDelStatus("msg_process_order", 0);
					} else if (status == 4) {
						val = newSettingRepo.findBySettingKeyAndDelStatus("msg_delivery_order", 0);
					} else if (status == 5) {
						val = newSettingRepo.findBySettingKeyAndDelStatus("msg_delivered_order", 0);
					} else if (status == 8) {
						val = newSettingRepo.findBySettingKeyAndDelStatus("msg_cancelled_order", 0);
					}

					Customer cust = customerRepo.getCustomerByOrderId(orderId);

					SMSUtility.sendSMS(cust.getPhoneNumber(), val.getSettingValue1());

				} catch (Exception e) {
				}
			}

		} catch (Exception e) {
			info.setError(true);
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/updatePaymentSuccessful" }, method = RequestMethod.POST)
	public @ResponseBody Info updatePaymentSuccessful(@RequestParam("status") int status,
			@RequestParam("paid") int paid, @RequestParam("orderId") String orderId,
			@RequestParam("txStatus") String txStatus) {

		Info info = new Info();

		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dt = new Date();

			int update = orderHeaderRepository.updateStatusAndIsPaid(status, paid, orderId);

			if (status == 8) {

				OrderHeader orderHeader = orderHeaderRepository.findByUuidNo(orderId);
				OrderTrail orderTrail = new OrderTrail();
				orderTrail.setOrderId(orderHeader.getOrderId());
				orderTrail.setActionByUserId(orderHeader.getCustId());
				orderTrail.setActionDateTime(sf.format(dt));
				orderTrail.setStatus(status);
				orderTrail.setExVar1("Payment : " + txStatus);
				orderTrail.setExInt1(2);
				OrderTrail orderRes = orderTrailRepository.save(orderTrail);
			}

			info.setError(false);
			info.setMessage("Success");

		} catch (Exception e) {
			info.setError(true);
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

			List<GetOrderTrailList> trailListbystatus = getOrderTrailListRepository.trailListbystatus(sts);

			for (int i = 0; i < listbystatus.size(); i++) {
				List<GetOrderDetailList> detail = new ArrayList<>();

				for (int j = 0; j < detailListbystatus.size(); j++) {

					if (listbystatus.get(i).getOrderId() == detailListbystatus.get(j).getOrderId()) {
						detail.add(detailListbystatus.get(j));
					}
				}
				listbystatus.get(i).setDetailList(detail);

				List<GetOrderTrailList> traildetail = new ArrayList<>();

				for (int j = 0; j < trailListbystatus.size(); j++) {

					if (listbystatus.get(i).getOrderId() == trailListbystatus.get(j).getOrderId()) {
						traildetail.add(trailListbystatus.get(j));
					}
				}
				listbystatus.get(i).setTrailList(traildetail);
			}

			orderListData.setOrderListByStatus(listbystatus);

			Date dt = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

			List<GetOrderHeaderList> listbydate = getOrderHeaderListRepository
					.getOrderListByStatusAndDate(sf.format(dt));

			List<GetOrderDetailList> detailListbydate = getOrderDetailListRepository
					.getOrderDetailListByStatusAndDate(sf.format(dt));

			List<GetOrderTrailList> trailListbydate = getOrderTrailListRepository
					.trailListbyByStatusAndDate(sf.format(dt));

			for (int i = 0; i < listbydate.size(); i++) {
				List<GetOrderDetailList> detail = new ArrayList<>();

				for (int j = 0; j < detailListbydate.size(); j++) {

					if (listbydate.get(i).getOrderId() == detailListbydate.get(j).getOrderId()) {
						detail.add(detailListbydate.get(j));
					}
				}
				listbydate.get(i).setDetailList(detail);

				List<GetOrderTrailList> traildetail = new ArrayList<>();

				for (int j = 0; j < trailListbydate.size(); j++) {

					if (listbydate.get(i).getOrderId() == trailListbydate.get(j).getOrderId()) {
						traildetail.add(trailListbydate.get(j));
					}
				}
				listbydate.get(i).setTrailList(traildetail);
			}

			orderListData.setOrderListByStatusAndDate(listbydate);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderListData;
	}

	@RequestMapping(value = { "/getOrderListByCustomerId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderHeaderList> getOrderListByCustomerId(@RequestParam("custId") int custId) {

		List<GetOrderHeaderList> listbystatus = new ArrayList<>();

		try {

			listbystatus = getOrderHeaderListRepository.getOrderListByCustomerId(custId);

			List<GetOrderDetailList> detailListbystatus = getOrderDetailListRepository.getOrderListByCustomerId(custId);

			List<GetOrderTrailList> trailListbystatus = getOrderTrailListRepository.trailListbyByCustomerIds(custId);

			for (int i = 0; i < listbystatus.size(); i++) {
				List<GetOrderDetailList> detail = new ArrayList<>();

				for (int j = 0; j < detailListbystatus.size(); j++) {

					if (listbystatus.get(i).getOrderId() == detailListbystatus.get(j).getOrderId()) {
						detail.add(detailListbystatus.get(j));
					}
				}
				listbystatus.get(i).setDetailList(detail);

				List<GetOrderTrailList> traildetail = new ArrayList<>();

				for (int j = 0; j < trailListbystatus.size(); j++) {

					if (listbystatus.get(i).getOrderId() == trailListbystatus.get(j).getOrderId()) {
						traildetail.add(trailListbystatus.get(j));
					}
				}
				listbystatus.get(i).setTrailList(traildetail);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listbystatus;
	}

	@RequestMapping(value = { "/getGrievienceListByCustomerId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetGrievienceList> getGrievienceListByCustomerId(@RequestParam("custId") int custId) {

		List<GetGrievienceList> listbystatus = new ArrayList<>();

		try {

			listbystatus = getGrievienceListRepository.getGrievienceListByCustomerId(custId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listbystatus;
	}

	@RequestMapping(value = { "/getGriviencevByGrvId" }, method = RequestMethod.POST)
	public @ResponseBody GetGrievienceList getGriviencevByGrvId(@RequestParam("grvId") int grvId) {

		GetGrievienceList getGrievienceList = new GetGrievienceList();

		try {

			getGrievienceList = getGrievienceListRepository.getGriviencevByGrvId(grvId);
			List<GetGrievienceTailList> getGrievienceTailList = getGrievienceTailListRepository
					.getGriviencevDetailByGrvId(grvId);

			getGrievienceList.setGetGrievienceTailList(getGrievienceTailList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return getGrievienceList;
	}

	@RequestMapping(value = { "/getOrderOrderId" }, method = RequestMethod.POST)
	public @ResponseBody GetOrderHeaderList getOrderOrderId(@RequestParam("orderId") int orderId) {

		GetOrderHeaderList getOrderHeaderList = new GetOrderHeaderList();

		try {

			getOrderHeaderList = getOrderHeaderListRepository.getOrderOrderId(orderId);

			List<GetOrderDetailList> detailListbystatus = getOrderDetailListRepository.getOrderDetailOrderId(orderId);

			getOrderHeaderList.setDetailList(detailListbystatus);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return getOrderHeaderList;
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

	@RequestMapping(value = { "/saveFeedBackOfOrder" }, method = RequestMethod.POST)
	public @ResponseBody OrderFeedback saveFeedBackOfOrder(@RequestBody OrderFeedback feedback) {

		OrderFeedback res = new OrderFeedback();
		try {

			res = orderFeedbackRepo.save(feedback);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@RequestMapping(value = { "/saveGrievanceOfOrder" }, method = RequestMethod.POST)
	public @ResponseBody OrderGrievance saveFeedBackOfOrder(@RequestBody OrderGrievance orderGrievance) {

		OrderGrievance res = new OrderGrievance();
		try {

			Setting setting = new Setting();
			setting = settingRepository.findBySettingKey("GRI_NO");

			int no = setting.getSettingValue();
			String grievencceNo = String.format("%0" + 5 + "d", no);

			orderGrievance.setGrievencceNo(grievencceNo);
			res = orderGrievanceRepo.save(orderGrievance);

			no = no + 1;
			int updateOrderNo = settingRepository.udateKeyAndValue("GRI_NO", no);

			orderGrievance.getOrderGrievanceTrail().setGrievencesId(res.getGrieveId());

			OrderGrievanceTrail orderGrievanceTrailres = orderGrievanceTrailRepo
					.save(orderGrievance.getOrderGrievanceTrail());
			
			try {

				NewSetting val = newSettingRepo.findBySettingKeyAndDelStatus("msg_add_grievance", 0);

				Customer cust = customerRepo.getCustomerByOrderId(orderGrievance.getOrderId());

				SMSUtility.sendSMS(cust.getPhoneNumber(), val.getSettingValue1());

			} catch (Exception e) {
			}			
			

		} catch (Exception e) {
			e.printStackTrace();

		}

		return res;
	}

}
