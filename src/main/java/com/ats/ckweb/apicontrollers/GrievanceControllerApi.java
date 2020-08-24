package com.ats.ckweb.apicontrollers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.model.GetGrievanceHeader;
import com.ats.ckweb.model.GetGrievanceTrail;
import com.ats.ckweb.model.GetGrievienceList;
import com.ats.ckweb.model.GetGrievienceTailList;
import com.ats.ckweb.model.GetOrderDetailList;
import com.ats.ckweb.model.GetOrderHeaderList;
import com.ats.ckweb.model.GetOrderTrailList;
import com.ats.ckweb.model.GrievanceActionMaster;
import com.ats.ckweb.model.GrievanceHeaderWithOrderData;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.MnUser;
import com.ats.ckweb.model.OrderGrievance;
import com.ats.ckweb.model.OrderGrievanceTrail;
import com.ats.ckweb.report.model.GetOrderDetailDisplay;
import com.ats.ckweb.report.model.GetOrderDisplay;
import com.ats.ckweb.report.model.GetOrderHeaderDisplay;
import com.ats.ckweb.report.model.GetOrderTrailDisplay;
import com.ats.ckweb.report.model.GrievanceBetDate;
import com.ats.ckweb.report.model.GrievanceDatewise;
import com.ats.ckweb.report.repo.GetOrderDisplayRepo;
import com.ats.ckweb.report.repo.GetOrderTrailDisplayRepo;
import com.ats.ckweb.report.repo.GrievanceBetDateRepo;
import com.ats.ckweb.report.repo.GrievanceDatewiseRepo;
import com.ats.ckweb.repository.GetGrievanceHeaderRepo;
import com.ats.ckweb.repository.GetGrievanceTrailRepo;
import com.ats.ckweb.repository.GetGrievienceListRepository;
import com.ats.ckweb.repository.GetGrievienceTailListRepository;
import com.ats.ckweb.repository.GetOrderDetailListRepository;
import com.ats.ckweb.repository.GetOrderHeaderListRepository;
import com.ats.ckweb.repository.GetOrderTrailListRepository;
import com.ats.ckweb.repository.GrievanceActionMasterRepo;
import com.ats.ckweb.repository.MnUserRepo;
import com.ats.ckweb.repository.OrderGrievanceRepo;
import com.ats.ckweb.repository.OrderGrievanceTrailRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController

public class GrievanceControllerApi {
	@Autowired
	private GetGrievanceHeaderRepo getGrievanceHeaderRepo;

	@Autowired
	private GetGrievanceTrailRepo getGrievanceTrailRepo;

	@Autowired
	private GrievanceActionMasterRepo grievanceActionMasterRepo;

	@Autowired
	OrderGrievanceTrailRepo grievTrailRepo;
	
	@Autowired
	GetOrderDisplayRepo getOrderDisplayRepo;

	@Autowired
	OrderGrievanceRepo orderGrievanceRepo;
	
	@Autowired
	GetGrievienceListRepository grevListRepo;

	@RequestMapping(value = { "/getGrievanceHeaderList" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetGrievanceHeader> getGrievanceHeaderList(@RequestParam("statusList") List<Integer> statusList,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("custId") int custId) {

		List<GetGrievanceHeader> grivList = new ArrayList<GetGrievanceHeader>();
		try {
			System.err.println("statusList " + statusList.toString() + "custId " + custId);
			if (fromDate.equals("null") && custId < 1) {
				System.err.println("A");
				grivList = getGrievanceHeaderRepo.getGrievanceHeaderByStatus(statusList);
			} else if (custId < 1) {
				System.err.println("B");
				grivList = getGrievanceHeaderRepo.getGrievanceHeaderByStatusAndDate(statusList, fromDate, toDate);
			} else {
				System.err.println("C");
				grivList = getGrievanceHeaderRepo.getGrievanceHeaderByCustId(custId);
			}
			if (grivList == null) {
				System.err.println("in null ");
				grivList = new ArrayList<GetGrievanceHeader>();
			}
		} catch (Exception e) {
			grivList = new ArrayList<GetGrievanceHeader>();
			e.printStackTrace();
		}
		return grivList;

	}

	@RequestMapping(value = { "/getGrievanceHeader" }, method = RequestMethod.POST)
	@ResponseBody
	public GetGrievanceHeader getGrievanceHeader(@RequestParam("grieveId") int grieveId) {
		GetGrievanceHeader grivHeader = null;// new GetGrievanceHeader();
		try {
			grivHeader = getGrievanceHeaderRepo.getGrievanceHeaderByGrieveId(grieveId);
		} catch (Exception e) {
			grivHeader = new GetGrievanceHeader();
		}
		return grivHeader;
	}

	@RequestMapping(value = { "/getGrievanceTrailByGrivId" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetGrievanceTrail> getGrievanceTrailByGrivId(@RequestParam("grieveId") int grieveId) {

		List<GetGrievanceTrail> grievTrailList = null;
		try {
			grievTrailList = getGrievanceTrailRepo.getGrievanceTrailListByGrievencesId(grieveId);

			if (grievTrailList == null) {
				grievTrailList = new ArrayList<GetGrievanceTrail>();
			}
		} catch (Exception e) {
			grievTrailList = new ArrayList<GetGrievanceTrail>();
		}
		return grievTrailList;
	}

	@RequestMapping(value = { "/getGrivActionList" }, method = RequestMethod.GET)
	@ResponseBody
	public List<GrievanceActionMaster> getGrivActionList() {

		List<GrievanceActionMaster> grievTrailList = null;
		try {
			grievTrailList = grievanceActionMasterRepo.findAllByIsActiveAndDelStatus(1, 1);
			if (grievTrailList == null) {
				grievTrailList = new ArrayList<GrievanceActionMaster>();
			}
		} catch (Exception e) {
			grievTrailList = new ArrayList<GrievanceActionMaster>();
		}

		return grievTrailList;
	}

	// Sachin 2020-08-08
	// Desc - To save grievance trail and update grievance header for status.

	@RequestMapping(value = { "/saveGrievTrailAndUpdateHeader" }, method = RequestMethod.POST)
	@ResponseBody
	public OrderGrievanceTrail saveGrievTrailAndUpdateHeader(@RequestBody OrderGrievanceTrail grivTrail) {
		OrderGrievanceTrail trailRes = new OrderGrievanceTrail();

		try {

			GrievanceActionMaster actionName = grievanceActionMasterRepo
					.findByGrivActionValue(grivTrail.getGrivActionValue());

			grivTrail.setGrivActionText("" + actionName.getGrivActionText());

			trailRes = grievTrailRepo.save(grivTrail);

			if (trailRes != null) {

				int x = getGrievanceHeaderRepo.updateGrievHeaderStatus(trailRes.getGrievencesId(),
						trailRes.getStatus());

			}

		} catch (Exception e) {
			trailRes = new OrderGrievanceTrail();

		}

		return trailRes;

	}

	// Sachin 11-08-2020
	// Desc-get Grievances of orders delivery between given date.

	@Autowired
	GrievanceBetDateRepo grievanceBetDateRepo;

	@RequestMapping(value = { "/getGrievanceBetOrderDelDate" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GrievanceBetDate> getGrievanceBetOrderDelDate(@RequestParam String fromDate,
			@RequestParam String toDate) {

		List<GrievanceBetDate> grivList = null;
		try {
			grivList = grievanceBetDateRepo.getGrieBetGivenDeliveryDate(fromDate, toDate);
			if (grivList == null) {
				grivList = new ArrayList<GrievanceBetDate>();
			}
		} catch (Exception e) {
			e.printStackTrace();
			grivList = new ArrayList<GrievanceBetDate>();
		}

		return grivList;
	}

	// Sachin 11-08-2020
	// Desc-show user list by type and compId
	@Autowired
	MnUserRepo userRepo;

	@RequestMapping(value = { "/getUserListByTypeAndCompId" }, method = RequestMethod.POST)
	@ResponseBody
	public List<MnUser> getUserListByTypeAndCompId(@RequestParam int compId, @RequestParam int userType) {

		List<MnUser> userList = null;
		try {
			userList = userRepo.getUserListByTypeAndCompId(compId, userType);
			if (userList == null) {
				userList = new ArrayList<MnUser>();
			}
		} catch (Exception e) {
			e.printStackTrace();
			userList = new ArrayList<MnUser>();
		}

		return userList;
	}

	// Sachin 13-08-2020
	// Desc-show Griv Report Date wise
	@Autowired
	GrievanceDatewiseRepo grivReportDatewise;

	@RequestMapping(value = { "/getGrievanceDatewise" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GrievanceDatewise> getGrievanceBetOrderDelDate(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam List<Integer> frIdList,
			@RequestParam List<Integer> grievTypeIdList, @RequestParam List<Integer> grievSubTypeList,
			@RequestParam List<Integer> statusList, @RequestParam Integer reportNo) {

		List<GrievanceDatewise> grivList = null;
		try {
			
			if (reportNo.equals(1))
				grivList = grivReportDatewise.getGrievanceDatewiseGrpByGrivType(fromDate, toDate, frIdList,
						grievTypeIdList, grievSubTypeList, statusList);
			
			if (reportNo.equals(2))
				grivList = grivReportDatewise.getGrievanceDatewiseGrpByGrivSubType(fromDate, toDate, frIdList,
						grievTypeIdList, grievSubTypeList, statusList);
			
			if (reportNo.equals(3))
				grivList = grivReportDatewise.getGrievanceDatewiseGrpByFrId(fromDate, toDate, frIdList, grievTypeIdList,
						grievSubTypeList, statusList);

			if (grivList == null) {
				grivList = new ArrayList<GrievanceDatewise>();
			}
		} catch (Exception e) {
			e.printStackTrace();
			grivList = new ArrayList<GrievanceDatewise>();
		}

		return grivList;
	}
	
	
	@RequestMapping(value = { "/getGrievanceMonthwise" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GrievanceDatewise> getGrievanceMonthwise(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam List<Integer> frIdList,
			@RequestParam List<Integer> grievTypeIdList, @RequestParam List<Integer> grievSubTypeList,
			@RequestParam List<Integer> statusList, @RequestParam Integer reportNo) {

		List<GrievanceDatewise> grivList = null;
		try {
			
			if (reportNo.equals(1))
				grivList = grivReportDatewise.getGrievanceDatewiseGrpByGrivTypeM1(fromDate, toDate, frIdList,
						grievTypeIdList, grievSubTypeList, statusList);
			
			if (reportNo.equals(2))
				grivList = grivReportDatewise.getGrievanceDatewiseGrpByGrivSubTypeM2(fromDate, toDate, frIdList,
						grievTypeIdList, grievSubTypeList, statusList);
			
			if (reportNo.equals(3))
				grivList = grivReportDatewise.getGrievanceDatewiseGrpByFrIdM3(fromDate, toDate, frIdList, grievTypeIdList,
						grievSubTypeList, statusList);

			if (grivList == null) {
				grivList = new ArrayList<GrievanceDatewise>();
			}
		} catch (Exception e) {
			e.printStackTrace();
			grivList = new ArrayList<GrievanceDatewise>();
		}

		return grivList;
	}
	
	
	
	//Sachin 17-08-2020
	//Desc - to show order header detail and its trail
	
	@Autowired
	GetOrderHeaderListRepository getOrderHeaderListRepository;

	@Autowired
	GetOrderDetailListRepository getOrderDetailListRepository;

	@Autowired
	GetOrderTrailListRepository getOrderTrailListRepository;
	@Autowired
	GetOrderTrailDisplayRepo getOrderTrailDisplayRepo;
	
	 @Autowired
	GetGrievienceTailListRepository getGrievienceTailListRepository;
		
	

	@RequestMapping(value = { "/getOrderDataByOrderId" }, method = RequestMethod.POST)
	public @ResponseBody GetOrderHeaderList getOrderDataByOrderId(
			@RequestParam("orderId") int orderId) {

		GetOrderHeaderList getOrderHeaderList = new GetOrderHeaderList();

		try {

			getOrderHeaderList = getOrderHeaderListRepository.getOrderOrderId(orderId);

			List<GetOrderDetailList> detailListbystatus = getOrderDetailListRepository.getOrderDetailOrderId(orderId);

			getOrderHeaderList.setDetailList(detailListbystatus);
			
			List<GetOrderTrailDisplay> trailDetailList = getOrderTrailDisplayRepo.getOrderTrailDataOrderId(orderId);
			getOrderHeaderList.setTrailDetailList(trailDetailList);
			
			//Mahendra //20-08-2020
			GetGrievienceList gervData = grevListRepo.findByOrderId(getOrderHeaderList.getOrderId());
			getOrderHeaderList.setOrderGriev(gervData);
			
			List<GetGrievienceTailList> grievTrailList = getGrievienceTailListRepository.getGriviencevDetailByGrvId(gervData.getGrieveId());			
			getOrderHeaderList.setGrievTrailList(grievTrailList);
			
		//	System.err.println("Griev Trail----------->"+getOrderHeaderList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return getOrderHeaderList;
	}

	//Mahendra Singh //19-08-2020
	@RequestMapping(value = { "/getGrievanceBetOrderDetail" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GrievanceBetDate> getGrievanceBetOrderDetail(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam int frId, @RequestParam("grevTypeIds") List<Integer> grevTypeIds) {

		List<GrievanceBetDate> grivList = null;
		try {
			grivList = grievanceBetDateRepo.getGrieBetGivenDtl(fromDate, toDate,frId, grevTypeIds);
			if (grivList == null) {
				grivList = new ArrayList<GrievanceBetDate>();
			}
		} catch (Exception e) {
			e.printStackTrace();
			grivList = new ArrayList<GrievanceBetDate>();
		}

		return grivList;
	}
	
	// Anmol 20-08-2020 Get Grievance header with order data
		@RequestMapping(value = { "/getGrievanceHeaderWithOrder" }, method = RequestMethod.POST)
		@ResponseBody
		public GrievanceHeaderWithOrderData getGrievanceHeaderWithOrderData(@RequestParam("grieveId") int grieveId) {
			GrievanceHeaderWithOrderData grievData = new GrievanceHeaderWithOrderData();
			try {
				GetGrievanceHeader grivHeader = getGrievanceHeaderRepo.getGrievanceHeaderByGrieveId(grieveId);

				List<GetOrderDisplay> res = new ArrayList<>();
				List<GetOrderHeaderDisplay> orderList = new ArrayList<>();

				if (grivHeader != null) {

					res = getOrderDisplayRepo.getOrderById(grivHeader.getOrderId());

					try {

						List<GetOrderTrailDisplay> allTrailList = getOrderTrailDisplayRepo
								.getOrderTrailDataOrderId(grivHeader.getOrderId());

						if (res != null) {

							Set<Integer> setOrderIds = new HashSet<Integer>();
							for (GetOrderDisplay order : res) {
								setOrderIds.add(order.getOrderId());
							}

							List<Integer> orderIds = new ArrayList<>();
							orderIds.addAll(setOrderIds);

							if (orderIds.size() > 0) {

								// ----------HEADER LIST---------
								for (int i = 0; i < orderIds.size(); i++) {
									for (GetOrderDisplay order : res) {

										if (orderIds.get(i) == order.getOrderId()) {

											List<GetOrderTrailDisplay> trailList = new ArrayList<>();

											if (allTrailList != null) {
												for (GetOrderTrailDisplay trail : allTrailList) {
													if (order.getOrderId() == trail.getOrderId()) {
														trailList.add(trail);
													}
												}

											}

											List<GetOrderDetailDisplay> detailList = new ArrayList<>();

											GetOrderHeaderDisplay header = new GetOrderHeaderDisplay(order.getOrderId(),
													order.getOrderNo(), order.getOrderDate(), order.getFrId(),
													order.getCustId(), order.getStatus(), order.getTaxableAmt(),
													order.getCgstAmt(), order.getSgstAmt(), order.getIgstAmt(),
													order.getDiscAmt(), order.getItemDiscAmt(), order.getTaxAmt(),
													order.getTotalAmt(), order.getOrderStatus(), order.getPaidStatus(),
													order.getPaymentMethod(), order.getPaymentRemark(), order.getCityId(),
													order.getAreaId(), order.getAddressId(), order.getAddress(),
													order.getWhatsappNo(), order.getLandmark(), order.getDeliveryDate(),
													order.getDeliveryTime(), order.getInsertDateTime(),
													order.getInsertUserId(), order.getOrderPlatform(), order.getDelStatus(),
													order.getOfferId(), order.getRemark(), order.getOrderDeliveredBy(),
													order.getExInt1(), order.getExInt2(), order.getExInt3(),
													order.getExInt4(), order.getExVar1(), order.getExVar2(),
													order.getExVar3(), order.getExVar4(), order.getExFloat1(),
													order.getExFloat2(), order.getExFloat3(), order.getExFloat4(),
													order.getExDate1(), order.getExDate2(), order.getBillingName(),
													order.getBillingAddress(), order.getCustomerGstnNo(),
													order.getDeliveryType(), order.getDeliveryInstId(),
													order.getDeliveryInstText(), order.getDeliveryKm(),
													order.getDeliveryCharges(), order.getPaymentSubMode(),
													order.getIsAgent(), order.getOrderDeliveredByName(),
													order.getCustName(), order.getCustMobile(), order.getCustWhatsappNo(),
													order.getFrName(), order.getCityName(), order.getAreaName(),
													order.getOfferName(), order.getOfferDesc(), order.getDeliveryMonth(),
													order.getDeliveryYear(), order.getDeliveryDateDisplay(),
													order.getDeliveryTimeDisplay(), order.getMonthName(), detailList,
													trailList);

											orderList.add(header);

											break;

										}

									}
								}

								// ----------DETAIL LIST--------------
								for (int i = 0; i < orderList.size(); i++) {

									List<GetOrderDetailDisplay> detailList = new ArrayList<>();

									for (GetOrderDisplay order : res) {

										if (orderList.get(i).getOrderId() == order.getOrderId()) {

											GetOrderDetailDisplay detail = new GetOrderDetailDisplay(
													order.getOrderDetailId(), order.getOrderId(), order.getItemId(),
													order.getHsnCode(), order.getQty(), order.getMrp(), order.getRate(),
													order.getDetailTaxableAmt(), order.getCgstPer(), order.getSgstPer(),
													order.getIgstPer(), order.getDetailCgstAmt(), order.getDetailSgstAmt(),
													order.getDetailIgstAmt(), order.getDetailDiscAmt(),
													order.getDetailTaxAmt(), order.getDetailTotalAmt(),
													order.getDelStatus(), order.getDetailRemark(), order.getDetailExInt1(),
													order.getDetailExInt2(), order.getDetailExInt3(),
													order.getDetailExInt4(), order.getDetailExVar1(),
													order.getDetailExVar2(), order.getDetailExVar3(),
													order.getDetailExVar4(), order.getDetailExFloat1(),
													order.getDetailExFloat2(), order.getDetailExFloat3(),
													order.getDetailExFloat4(), order.getItemName(), order.getCatId(),
													order.getCatName(), order.getItemUom(), order.getUomId());
											detailList.add(detail);

										}

									}

									orderList.get(i).setOrderDetailList(detailList);
								}

							}

						}

					} catch (Exception e) {
						e.printStackTrace();
					}

				}

				grievData.setGrievanceHeader(grivHeader);

				if (orderList != null) {
					if (orderList.size() > 0) {

						grievData.setOrder(orderList.get(0));

						// ------------JSON STRING------------------------------
						ObjectMapper Obj = new ObjectMapper();

						try {
							String jsonStr = Obj.writeValueAsString(orderList.get(0));
							grievData.setOrderJson(jsonStr);
						} catch (IOException e) {
						}

					}
				}

			} catch (Exception e) {
			}

			return grievData;
		}

		@RequestMapping(value = { "/updateGrievanceHeaderWalletStatus" }, method = RequestMethod.POST)
		@ResponseBody
		public Info updateGrievanceHeaderWalletStatus(@RequestParam int status, @RequestParam int grieveId) {

			Info info = new Info();

			try {
				int res = orderGrievanceRepo.updateWalletStatus(status, grieveId);
				if (res > 0) {
					info.setError(false);
				} else {
					info.setError(true);
				}
			} catch (Exception e) {
				e.printStackTrace();
				info.setError(true);
			}

			return info;
		}
		
		
		@RequestMapping(value = { "/saveGrievTrailAndUpdateHeaderAmt" }, method = RequestMethod.POST)
		@ResponseBody
		public OrderGrievanceTrail saveGrievTrailAndUpdateHeaderAmt(@RequestBody OrderGrievanceTrail grivTrail) {
			OrderGrievanceTrail trailRes = new OrderGrievanceTrail();

			try {

				GrievanceActionMaster actionName = grievanceActionMasterRepo
						.findByGrivActionValue(grivTrail.getGrivActionValue());

				grivTrail.setGrivActionText("" + actionName.getGrivActionText());

				trailRes = grievTrailRepo.save(grivTrail);

				if (trailRes != null) {

					int x = orderGrievanceRepo.updateGrievHeaderStatusAndAmt(trailRes.getGrievencesId(),
							trailRes.getStatus(),trailRes.getRepayAmt(),trailRes.getFrAffectAmt());

				}

			} catch (Exception e) {
				trailRes = new OrderGrievanceTrail();

			}

			return trailRes;

		}
	
}
