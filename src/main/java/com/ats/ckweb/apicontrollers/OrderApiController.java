package com.ats.ckweb.apicontrollers;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.commons.SMSUtility;
import com.ats.ckweb.model.Agent;
import com.ats.ckweb.model.Customer;
import com.ats.ckweb.model.CustomerAddressDisplay;
import com.ats.ckweb.model.CustomerDisplay;
import com.ats.ckweb.model.FrConfig;
import com.ats.ckweb.model.Franchisee;
import com.ats.ckweb.model.GetGrievienceList;
import com.ats.ckweb.model.GetGrievienceTailList;
import com.ats.ckweb.model.GetOrderDetailList;
import com.ats.ckweb.model.GetOrderHeaderList;
import com.ats.ckweb.model.GetOrderTrailList;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.ItemDisplay;
import com.ats.ckweb.model.NewSetting;
import com.ats.ckweb.model.OfferDetail;
import com.ats.ckweb.model.OrderDetail;
import com.ats.ckweb.model.OrderFeedback;
import com.ats.ckweb.model.OrderGrievance;
import com.ats.ckweb.model.OrderGrievanceTrail;
import com.ats.ckweb.model.OrderHeader;
import com.ats.ckweb.model.OrderListData;
import com.ats.ckweb.model.OrderSaveData;
import com.ats.ckweb.model.OrderTrail;
import com.ats.ckweb.model.Setting;
import com.ats.ckweb.model.Wallet;
import com.ats.ckweb.model.app.GetOrderHistory;
import com.ats.ckweb.model.app.GrievanceList;
import com.ats.ckweb.model.app.PlaceOrderDetailParam;
import com.ats.ckweb.model.app.PlaceOrderParam;
import com.ats.ckweb.model.app.VerifyCustomer;
import com.ats.ckweb.report.repo.WalletRepo;
import com.ats.ckweb.repository.AgentRepo;
import com.ats.ckweb.repository.CustomerAddressDisplayRepo;
import com.ats.ckweb.repository.CustomerDisplayRepo;
import com.ats.ckweb.repository.CustomerRepo;
import com.ats.ckweb.repository.FrConfigRepo;
import com.ats.ckweb.repository.FranchiseeRepository;
import com.ats.ckweb.repository.GetGrievienceListRepository;
import com.ats.ckweb.repository.GetGrievienceTailListRepository;
import com.ats.ckweb.repository.GetOrderDetailListRepository;
import com.ats.ckweb.repository.GetOrderHeaderListRepository;
import com.ats.ckweb.repository.GetOrderTrailListRepository;
import com.ats.ckweb.repository.ItemDisplayRepo;
import com.ats.ckweb.repository.NewSettingRepo;
import com.ats.ckweb.repository.OfferDetailRepo;
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

	@Autowired
	FrConfigRepo frConfigRepo;

	@Autowired
	AgentRepo agentRepo;

	@Autowired
	FranchiseeRepository franchiseeRepository;

	@Autowired
	ItemDisplayRepo itemDisplayRepo;

	@Autowired
	CustomerAddressDisplayRepo customerAddressDisplayRepo;

	@Autowired
	WalletRepo walletRepo;

	@Autowired
	OfferDetailRepo offerDetailRepo;

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

				Customer cust = customerRepo.getOne(orderSaveData.getOrderHeader().getCustId());
				FrConfig frConfig = frConfigRepo.findByFrId(orderSaveData.getOrderHeader().getFrId());

				NewSetting val = new NewSetting();

				String msg = "", msgAgent = "";

				if (orderSaveData.getOrderHeader().getOrderStatus() == 0) {
					val = newSettingRepo.findBySettingKeyAndDelStatus("msg_park_order", 0);

					msg = val.getSettingValue1();
					msg = msg.replace("###", cust.getCustName());

					if (frConfig != null) {
						String type = "dairy";
						if (frConfig.getFrType() == 2) {
							type = "restro";
						}
						msg = msg.replace("@@@", type);
					}

					SMSUtility.sendSMS(cust.getPhoneNumber(), msg, "MDVDRY");

				} else if (orderSaveData.getOrderHeader().getOrderStatus() == 1) {
					val = newSettingRepo.findBySettingKeyAndDelStatus("msg_place_order", 0);
					msg = val.getSettingValue1();

					msg = msg.replace("###", cust.getCustName());
					msg = msg.replace("$$$", orderSaveData.getOrderHeader().getOrderNo());
					// msg = msg.replace("@@@", "1234567899");

					SMSUtility.sendSMS(cust.getPhoneNumber(), msg, "MDVDRY");

					if (orderSaveData.getOrderHeader().getIsAgent() == 1) {

						Agent agent = agentRepo.findByAgentIdAndCompanyIdAndDelStatus(
								orderSaveData.getOrderHeader().getOrderDeliveredBy(), 1, 0);

						NewSetting val1 = new NewSetting();
						val1 = newSettingRepo.findBySettingKeyAndDelStatus("msg_place_order", 0);
						msgAgent = val1.getSettingValue1();

						msgAgent = msgAgent.replace("###", cust.getCustName());
						msgAgent = msgAgent.replace("$$$", orderSaveData.getOrderHeader().getOrderNo());
						// msgAgent = msgAgent.replace("@@@", "1234567899");

						if (agent != null) {
							SMSUtility.sendSMS(agent.getMobileNo(), msgAgent, "MDVDRY");
						}
					}
				}

				System.err.println("MSG - " + msg);

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
				Customer cust = customerRepo.getOne(orderHeader.getCustId());
				String msg = "", msgAgent = "";
				FrConfig frConfig = frConfigRepo.findByFrId(orderHeader.getFrId());

				if (orderHeader.getOrderStatus() == 0) {
					val = newSettingRepo.findBySettingKeyAndDelStatus("msg_park_order", 0);
					msg = val.getSettingValue1();

					msg = val.getSettingValue1();
					msg = msg.replace("###", cust.getCustName());

					if (frConfig != null) {
						String type = "dairy";
						if (frConfig.getFrType() == 2) {
							type = "restro";
						}
						msg = msg.replace("@@@", type);
					}

					SMSUtility.sendSMS(cust.getPhoneNumber(), msg, "MDVDRY");

				} else if (orderHeader.getOrderStatus() == 1) {
					val = newSettingRepo.findBySettingKeyAndDelStatus("msg_place_order", 0);
					msg = val.getSettingValue1();

					msg = val.getSettingValue1();

					msg = msg.replace("###", cust.getCustName());
					msg = msg.replace("$$$", res.getOrderNo());
					// msg = msg.replace("@@@", "1234567899");

					SMSUtility.sendSMS(cust.getPhoneNumber(), msg, "MDVDRY");

					if (orderHeader.getIsAgent() == 1) {
						NewSetting val1 = new NewSetting();
						val1 = newSettingRepo.findBySettingKeyAndDelStatus("msg_place_order", 0);
						msgAgent = val1.getSettingValue1();

						Agent agent = agentRepo.findByAgentIdAndCompanyIdAndDelStatus(orderHeader.getOrderDeliveredBy(),
								1, 0);

						msgAgent = msgAgent.replace("###", cust.getCustName());
						msgAgent = msgAgent.replace("$$$", res.getOrderNo());

						if (agent != null) {
							SMSUtility.sendSMS(agent.getMobileNo(), msgAgent, "MDVDRY");
						}
					}

				}

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

			System.err.println("UPDATE RES ======> " + update);
			if (update > 0) {

				try {

					if (status == 7 && type == 4) {

						SimpleDateFormat dttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						SimpleDateFormat yy = new SimpleDateFormat("yyyy-MM-dd");
						Date ct = new Date();

						OrderGrievance orderGrievance = new OrderGrievance();
						orderGrievance.setOrderId(orderId);
						orderGrievance.setInsertById(userId);
						orderGrievance.setInsertDateTime(dttime.format(ct));
						orderGrievance.setRemark(remark);
						orderGrievance.setPlatform(1);
						orderGrievance.setGrievenceSubtypeId(0);
						orderGrievance.setCurrentStatus(0);
						orderGrievance.setDate(yy.format(ct));
						orderGrievance.setGrievencceNo("1");

//						for (int i = 0; i < grievencesInstructionList.size(); i++) {
//
//							if (grievencesInstructionList.get(i).getGrievanceId() == grievencesInstructionId) {
//								orderGrievance.setGrievenceTypeId(grievencesInstructionList.get(i).getGrievenceTypeId());
//								break;
//							}
//						}

						OrderGrievanceTrail orderGrievanceTrail = new OrderGrievanceTrail();
						orderGrievanceTrail.setActionByUserId(userId);
						orderGrievanceTrail.setActionDateTime(dttime.format(ct));
						orderGrievanceTrail.setStatus(0);
						orderGrievanceTrail.setRemark(remark);
						orderGrievance.setOrderGrievanceTrail(orderGrievanceTrail);

						saveFeedBackOfOrder(orderGrievance);

					}

				} catch (Exception e) {
				}

				try {
					OrderHeader order = orderHeaderRepository.findByOrderId(orderId);
					Customer cust = customerRepo.getCustomerByOrderId(orderId);

					String msg = "";

					NewSetting val = new NewSetting();

					System.err.println("STATUS ---------------------======> " + status);

					if (status == 2) {
						val = newSettingRepo.findBySettingKeyAndDelStatus("msg_accept_order", 0);

						msg = val.getSettingValue1();
						msg = msg.replace("$$$", order.getOrderNo());

					} else if (status == 3) {
						val = newSettingRepo.findBySettingKeyAndDelStatus("msg_process_order", 0);
					} else if (status == 4) {

						try {
							val = newSettingRepo.findBySettingKeyAndDelStatus("msg_delivery_order", 0);

							msg = val.getSettingValue1();
							msg = msg.replace("CUSTNAME", cust.getCustName());
							msg = msg.replace("###", order.getOrderNo());

							String agentNm = "", agentMob = "";
							if (order.getIsAgent() == 1) {

								Agent agent = agentRepo
										.findByAgentIdAndCompanyIdAndDelStatus(order.getOrderDeliveredBy(), 1, 0);
								agentNm = agent.getAgentName();
								agentMob = agent.getMobileNo();

								msg = msg.replace("AGNAME", agentNm.toUpperCase());
								msg = msg.replace("AGMOB", agentMob);

							} else {

								if (order.getOrderDeliveredBy() != 0) {
									agentNm = agentRepo.getDeliveryBoyNameById(order.getOrderDeliveredBy());
									agentMob = agentRepo.getDeliveryBoyMobById(order.getOrderDeliveredBy());
									msg = msg.replace("AGNAME", agentNm.toUpperCase());
									msg = msg.replace("AGMOB", agentMob);
								}
							}

							System.err.println("DELIVERY SMS - " + msg);
						} catch (Exception e) {
							e.printStackTrace();
						}

					} else if (status == 5) {
						val = newSettingRepo.findBySettingKeyAndDelStatus("msg_delivered_order", 0);

						msg = val.getSettingValue1();
						msg = msg.replace("###", order.getOrderNo());

					} else if (status == 8) {
						val = newSettingRepo.findBySettingKeyAndDelStatus("msg_cancelled_order", 0);

						OrderTrail trail = orderTrailRepository.findByOrderIdAndStatus(order.getOrderId(), 8);

						msg = val.getSettingValue1();
						msg = msg.replace("###", trail.getExVar1());

						System.err.println("CANCEL - " + msg);

					}

					SMSUtility.sendSMS(cust.getPhoneNumber(), msg, "MDVDRY");

					if (status == 4) {

						try {

							NewSetting val1 = new NewSetting();
							val1 = newSettingRepo.findBySettingKeyAndDelStatus("msg_delivery_order_agent", 0);
							String sms = val1.getSettingValue1();

							sms = sms.replace("###", cust.getCustName());
							sms = sms.replace("@@@", cust.getPhoneNumber());

							String pmode = "";
							if (order.getPaymentMethod() == 1) {
								pmode = "COD";
							} else if (order.getPaymentMethod() == 2) {
								pmode = "Online Payment";
							}

							sms = sms.replace("PMODE", pmode);
							sms = sms.replace("OAMT", "" + order.getTotalAmt());

							Franchisee fr = franchiseeRepository.findByFrId(order.getFrId());
							sms = sms.replace("FRCODE", "" + fr.getFrCode());

							String agentMob = "";
							if (order.getIsAgent() == 1) {

								Agent agent = agentRepo
										.findByAgentIdAndCompanyIdAndDelStatus(order.getOrderDeliveredBy(), 1, 0);
								agentMob = agent.getMobileNo();

							} else {
								agentMob = agentRepo.getDeliveryBoyMobById(order.getOrderDeliveredBy());
							}

							System.err.println("AGENT DELIVERY SMS - " + sms);

							SMSUtility.sendSMS(agentMob, sms, "MDVDRY");

						} catch (Exception e) {
							e.printStackTrace();
						}

					}

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
			System.err.println("RESULT - " + update);

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

	@RequestMapping(value = { "/getOrderListByCustomerIdForApp" }, method = RequestMethod.POST)
	public @ResponseBody GetOrderHistory getOrderListByCustomerIdForApp(@RequestParam("custId") int custId) {

		GetOrderHistory res = new GetOrderHistory();

		List<GetOrderHeaderList> listbystatus = new ArrayList<>();
		Info info = new Info();

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

			info.setError(false);
			info.setMessage("success");

			res.setOrderList(listbystatus);

		} catch (Exception e) {
			e.printStackTrace();
			info.setError(true);
			info.setMessage("failed");
		}

		res.setInfo(info);

		return res;
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

	@RequestMapping(value = { "/getGrievienceListByCustomerIdForApp" }, method = RequestMethod.POST)
	public @ResponseBody GrievanceList getGrievienceListByCustomerIdForApp(@RequestParam("custId") int custId) {

		GrievanceList res = new GrievanceList();
		Info info = new Info();
		List<GetGrievienceList> listbystatus = new ArrayList<>();

		try {

			listbystatus = getGrievienceListRepository.getGrievienceListByCustomerId(custId);

			res.setGrievanceList(listbystatus);

			info.setError(false);
			info.setMessage("success");

		} catch (Exception e) {
			e.printStackTrace();

			info.setError(true);
			info.setMessage("failed");

		}

		res.setInfo(info);

		return res;
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

	@RequestMapping(value = { "/getOrderHeaderByOrderUUId" }, method = RequestMethod.POST)
	public @ResponseBody GetOrderHeaderList getOrderOrderUUId(@RequestParam("orderUUId") String orderUUId) {

		GetOrderHeaderList getOrderHeaderList = new GetOrderHeaderList();

		try {

			getOrderHeaderList = getOrderHeaderListRepository.getOrderOrderUUId(orderUUId);

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

	@RequestMapping(value = { "/getCustomerByMobileNoForApp" }, method = RequestMethod.POST)
	public @ResponseBody VerifyCustomer getCustomerByMobileNoForApp(@RequestParam("mobileNo") String mobileNo) {

		VerifyCustomer res = new VerifyCustomer();
		Info info = new Info();

		try {

			List<CustomerDisplay> custList = customerDisplayRepo.getCustomerByMobileNo(mobileNo);
			System.err.println("CUST LIST --------- " + custList);

			if (custList != null) {
				res.setCustomerDisplay(custList.get(0));
			}

			info.setError(false);
			info.setMessage("success");

		} catch (Exception e) {
			e.printStackTrace();
			info.setError(false);
			info.setMessage("success");
		}
		res.setInfo(info);

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

				SMSUtility.sendSMS(cust.getPhoneNumber(), val.getSettingValue1(), "MDVDRY");

			} catch (Exception e) {
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return res;
	}

	@RequestMapping(value = { "/saveGrievanceOfOrderForApp" }, method = RequestMethod.POST)
	public @ResponseBody Info saveGrievanceOfOrderForApp(@RequestBody OrderGrievance orderGrievance) {

		Info info = new Info();
		OrderGrievance res = new OrderGrievance();
		try {

			Setting setting = new Setting();
			setting = settingRepository.findBySettingKey("GRI_NO");

			int no = setting.getSettingValue();
			String grievencceNo = String.format("%0" + 5 + "d", no);

			orderGrievance.setGrievencceNo(grievencceNo);
			res = orderGrievanceRepo.save(orderGrievance);

			if (res != null) {
				if (res.getGrieveId() > 0) {
					info.setError(false);
					info.setMessage("success");

					no = no + 1;
					settingRepository.udateKeyAndValue("GRI_NO", no);

					orderGrievance.getOrderGrievanceTrail().setGrievencesId(res.getGrieveId());

					orderGrievanceTrailRepo.save(orderGrievance.getOrderGrievanceTrail());

					try {

						NewSetting val = newSettingRepo.findBySettingKeyAndDelStatus("msg_add_grievance", 0);

						Customer cust = customerRepo.getCustomerByOrderId(orderGrievance.getOrderId());

						SMSUtility.sendSMS(cust.getPhoneNumber(), val.getSettingValue1(), "MDVDRY");

					} catch (Exception e) {
					}

				} else {
					info.setError(true);
					info.setMessage("failed");
				}
			} else {
				info.setError(true);
				info.setMessage("failed");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return info;
	}

	@RequestMapping(value = { "/placeOrderForApp" }, method = RequestMethod.POST)
	public @ResponseBody Info placeOrderForApp(@RequestBody PlaceOrderParam placeOrderParam) {
		Info info = new Info();

		OrderHeader order = new OrderHeader();
		List<OrderDetail> orderDetailList = new ArrayList<>();
		OrderTrail orderTrail;

		List<ItemDisplay> itemData = itemDisplayRepo.getAllItemByFr(placeOrderParam.getFrId(), 2,
				placeOrderParam.getApplicableFor());

		DecimalFormat df = new DecimalFormat("#.00");

		try {

			if (placeOrderParam != null) {

				if (placeOrderParam.getOrderDetailParamList() != null) {

					float itemGrandTotal = 0;

					float finaTaxableAmt = 0;
					float finaTaxAmt = 0;
					float finaTotalAmt = 0;
					float finalCgstAmt = 0;
					float finalsgstAmt = 0;
					float finalIgstAmt = 0;
					float totalDiscAmt = 0, totalAddChargesAmt = 0;

					for (int i = 0; i < placeOrderParam.getOrderDetailParamList().size(); i++) {
						PlaceOrderDetailParam param = placeOrderParam.getOrderDetailParamList().get(i);
						if (itemData != null) {
							if (itemData.size() > 0) {
								for (ItemDisplay item : itemData) {
									if (param.getItemId() == item.getItemId()) {
										float qty = param.getSelectedQty() * param.getQty();
										itemGrandTotal = itemGrandTotal
												+ (item.getMrpDiscAmt() * Float.parseFloat(df.format(qty)));
									}
								}
							}
						}
					}

					System.err.println("ITEM GRAND TOTAL = " + itemGrandTotal);

					for (int i = 0; i < placeOrderParam.getOrderDetailParamList().size(); i++) {

						PlaceOrderDetailParam param = placeOrderParam.getOrderDetailParamList().get(i);

						if (itemData != null) {

							if (itemData.size() > 0) {

								for (ItemDisplay item : itemData) {

									if (param.getItemId() == item.getItemId()) {

										OrderDetail orderDetail = new OrderDetail();
										orderDetail.setItemId(param.getItemId());

										float qty = param.getSelectedQty() * param.getQty();
										orderDetail.setQty(Float.parseFloat(df.format(qty)));

										System.err.println("ITEM QTY = " + qty);

										orderDetail.setExFloat2(param.getSelectedQty());// App Selected Qty
										orderDetail.setExInt1(param.getQty());// App Qty

										orderDetail.setRate(item.getMrpDiscAmt());
										orderDetail.setMrp(item.getMrpDiscAmt());
										orderDetail.setCgstPer(item.getCgstPer());
										orderDetail.setIgstPer(item.getIgstPer());
										orderDetail.setSgstPer(item.getSgstPer());
										orderDetail.setRemark("");

										float detailDiscPer = 0;
										float detailDiscAmt = 0;

										if (placeOrderParam.getDiscAmt() > 0) {
											detailDiscPer = ((item.getMrpDiscAmt() * qty * 100) / itemGrandTotal);
											detailDiscAmt = ((detailDiscPer * placeOrderParam.getDiscAmt()) / 100);
											totalDiscAmt = totalDiscAmt + detailDiscAmt;
										}

										float chPer = 0, chAmt = 0;
										if (placeOrderParam.getDeliveryCharges() > 0) {
											chPer = ((item.getMrpDiscAmt() * qty * 100) / itemGrandTotal);
											System.err.println("DEL CH TOT = " + (item.getMrpDiscAmt() * qty * 100));
											chAmt = ((chPer * placeOrderParam.getDeliveryCharges()) / 100);
											totalAddChargesAmt = totalAddChargesAmt + chAmt;
										}

										System.err.println("DEL CH PER = " + chPer);
										System.err.println("DEL CH AMT = " + chAmt);

										float detailTotal = (item.getMrpDiscAmt() * qty) - detailDiscAmt + chAmt;

										float baseRate = (detailTotal * 100) / (100 + item.getIgstPer());
										float taxAmt = Float.parseFloat(df.format(detailTotal - baseRate));

										float taxableAmt = detailTotal - taxAmt;

										orderDetail.setTaxableAmt(Float.parseFloat(df.format(taxableAmt)));
										orderDetail.setTaxAmt(taxAmt);
										// orderDetail.setTotalAmt(itemJsonImportData[i].getTotal());
										orderDetail.setTotalAmt(Float.parseFloat(df.format(detailTotal)));

										float cgstAmt = Float.parseFloat(df.format(taxAmt / 2));

										orderDetail.setCgstAmt(cgstAmt);
										orderDetail.setSgstAmt(cgstAmt);
										orderDetail.setIgstAmt(taxAmt);

										orderDetail.setDiscAmt(detailDiscAmt);
										orderDetail.setExFloat1(chAmt);

										finalCgstAmt = Float.parseFloat(df.format(finalCgstAmt + (taxAmt / 2)));
										finalsgstAmt = Float.parseFloat(df.format(finalsgstAmt + (taxAmt / 2)));
										finalIgstAmt = Float.parseFloat(df.format(finalIgstAmt + (taxAmt)));

										finaTaxableAmt = Float.parseFloat(df.format(finaTaxableAmt + taxableAmt));
										finaTaxAmt = Float.parseFloat(df.format(finaTaxAmt + taxAmt));

										orderDetailList.add(orderDetail);
									}

								}

								finaTotalAmt = finaTaxableAmt + finaTaxAmt;

							}

						} else {
							info.setError(true);
							info.setMessage("failed");
						}

					}

					// Order Header---------------------------

					String uuid = UUID.randomUUID().toString();
					Date ct = new Date();
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat dttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

					order.setOrderNo("0002");
					order.setOrderDate(sf.format(ct));
					order.setFrId(placeOrderParam.getFrId());
					order.setCustId(placeOrderParam.getCustId());
					order.setOrderStatus(placeOrderParam.getOrderStatus());
					order.setPaidStatus(0);
					order.setPaymentMethod(placeOrderParam.getPayMode());

					CustomerAddressDisplay addr = customerAddressDisplayRepo
							.getCustomerAddressById(placeOrderParam.getAddressId());
					Customer cust = customerRepo.getOne(placeOrderParam.getCustId());

					order.setCityId(addr.getCityId());
					order.setAreaId(addr.getAreaId());
					order.setAddressId(placeOrderParam.getAddressId());
					order.setAddress(addr.getAddress());
					order.setWhatsappNo(cust.getPhoneNumber());
					order.setLandmark(addr.getLandmark());
					order.setDeliveryDate(placeOrderParam.getDeliveryDate());
					order.setDeliveryTime(placeOrderParam.getDeliveryTime());
					order.setInsertDateTime(dttime.format(ct));
					order.setInsertUserId(placeOrderParam.getCustId());
					order.setOrderPlatform(placeOrderParam.getOrderPlatform());
					order.setBillingName(cust.getCustName());
					order.setBillingAddress(addr.getAddress());
					order.setDeliveryType(placeOrderParam.getDeliveryType());
					order.setDeliveryInstId(placeOrderParam.getDeliveryInstructionId());
					order.setDeliveryInstText(placeOrderParam.getDeliveryInstructionText());
					order.setUuidNo(uuid);
					order.setExFloat1(placeOrderParam.getWallet());// Wallet Amt
					order.setExVar1(placeOrderParam.getGst());

					String coupon = "";
					try {
						if (placeOrderParam.getOfferId() > 0) {
							List<OfferDetail> offerDetailList = offerDetailRepo
									.findAllByOfferId(placeOrderParam.getOfferId());

							if (offerDetailList.size() > 0) {
								coupon = offerDetailList.get(0).getCouponCode();
							}
						}
					} catch (Exception e) {
					}

					// order.setExVar2(placeOrderParam.getCoupon());
					order.setExVar2(coupon);
					order.setOfferId(placeOrderParam.getOfferId());
					order.setDeliveryKm(placeOrderParam.getKm());

					order.setExFloat2(placeOrderParam.getItemTotal());// App Item Total
					order.setExFloat3(placeOrderParam.getDiscAmt());// App Disc Amt

					// Agent
					order.setIsAgent(0);
					order.setOrderDeliveredBy(0);

					order.setDiscAmt(totalDiscAmt - placeOrderParam.getWallet());
					order.setDeliveryCharges(totalAddChargesAmt);// Delivery and additional charges

					order.setTaxableAmt(finaTaxableAmt);
					order.setTaxAmt(finaTaxAmt);
					// order.setTotalAmt(finaTotalAmt + deliveryCharges);
					order.setTotalAmt(Float.parseFloat(df.format(finaTotalAmt)));
					order.setSgstAmt(finalsgstAmt);
					order.setCgstAmt(finalCgstAmt);
					order.setIgstAmt(finalIgstAmt);

					// Order Trail----------------
					orderTrail = new OrderTrail();
					orderTrail.setActionByUserId(placeOrderParam.getCustId());
					orderTrail.setActionDateTime(dttime.format(ct));
					orderTrail.setStatus(1);
					orderTrail.setExInt1(2);
					orderTrail.setExVar1("-");

					OrderSaveData data = new OrderSaveData();
					data.setOrderHeader(order);
					data.setOrderDetailList(orderDetailList);
					data.setOrderTrail(orderTrail);

					info = saveCloudOrder(data);

					if (info != null) {
						if (info.getError() == false) {

							try {
								if (placeOrderParam.getWallet() > 0) {

									Wallet wallet = new Wallet();
									wallet.setWalletId(0);
									wallet.setOrderId(Integer.parseInt(info.getMessage()));
									wallet.setSellBillNo(0);
									wallet.setFrId(placeOrderParam.getFrId());
									wallet.setPayMode(placeOrderParam.getPayMode());
									wallet.setIsFrAffected(0);
									wallet.setFrTranscType(0);
									wallet.setAmount(placeOrderParam.getWallet());
									wallet.setWalletTranscType(1);
									wallet.setUserId(placeOrderParam.getCustId());
									wallet.setWalletDate(sf.format(ct));
									wallet.setWalletDatetime(dttime.format(ct));
									wallet.setExInt1(0);
									wallet.setExInt2(0);
									wallet.setExVar1("");
									wallet.setExVar2("");
									wallet.setExFloat1(0);
									wallet.setExFloat1(1);

									walletRepo.save(wallet);

								}
							} catch (Exception e) {
							}

						}
					}

				} else {
					info.setError(true);
					info.setMessage("failed");
				}

			}

		} catch (Exception e) {
			info.setError(true);
			info.setMessage("failed");
		}

		return info;
	}

	public static String convertToYMD(String date) {

		String convertedDate = null;
		try {
			SimpleDateFormat ymdSDF = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dmySDF = new SimpleDateFormat("dd-MM-yyyy");
			Date dmyDate = dmySDF.parse(date);

			convertedDate = ymdSDF.format(dmyDate);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return convertedDate;

	}

}
