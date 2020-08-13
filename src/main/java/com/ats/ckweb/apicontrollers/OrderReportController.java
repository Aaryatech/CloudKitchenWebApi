package com.ats.ckweb.apicontrollers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.report.model.GetOrderDetailDisplay;
import com.ats.ckweb.report.model.GetOrderDisplay;
import com.ats.ckweb.report.model.GetOrderHeaderDisplay;
import com.ats.ckweb.report.model.GetOrderTrailDisplay;
import com.ats.ckweb.report.repo.GetOrderDisplayRepo;
import com.ats.ckweb.report.repo.GetOrderTrailDisplayRepo;

@RestController
public class OrderReportController {

	@Autowired
	GetOrderDisplayRepo getOrderDisplayRepo;

	@Autowired
	GetOrderTrailDisplayRepo getOrderTrailDisplayRepo;

	@RequestMapping(value = { "/getOrderReportByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderHeaderDisplay> getOrderReportByDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetOrderHeaderDisplay> orderList = new ArrayList<>();

		try {

			List<GetOrderDisplay> res = getOrderDisplayRepo.getAllOrdersByDeliveryDate(fromDate, toDate);
			List<GetOrderTrailDisplay> allTrailList = getOrderTrailDisplayRepo.getOrderTrailDataByDate(fromDate,
					toDate);

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
										order.getOrderNo(), order.getOrderDate(), order.getFrId(), order.getCustId(),
										order.getStatus(), order.getTaxableAmt(), order.getCgstAmt(),
										order.getSgstAmt(), order.getIgstAmt(), order.getDiscAmt(),
										order.getItemDiscAmt(), order.getTaxAmt(), order.getTotalAmt(),
										order.getOrderStatus(), order.getPaidStatus(), order.getPaymentMethod(),
										order.getPaymentRemark(), order.getCityId(), order.getAreaId(),
										order.getAddressId(), order.getAddress(), order.getWhatsappNo(),
										order.getLandmark(), order.getDeliveryDate(), order.getDeliveryTime(),
										order.getInsertDateTime(), order.getInsertUserId(), order.getOrderPlatform(),
										order.getDelStatus(), order.getOfferId(), order.getRemark(),
										order.getOrderDeliveredBy(), order.getExInt1(), order.getExInt2(),
										order.getExInt3(), order.getExInt4(), order.getExVar1(), order.getExVar2(),
										order.getExVar3(), order.getExVar4(), order.getExFloat1(), order.getExFloat2(),
										order.getExFloat3(), order.getExFloat4(), order.getExDate1(),
										order.getExDate2(), order.getBillingName(), order.getBillingAddress(),
										order.getCustomerGstnNo(), order.getDeliveryType(), order.getDeliveryInstId(),
										order.getDeliveryInstText(), order.getDeliveryKm(), order.getDeliveryCharges(),
										order.getPaymentSubMode(), order.getIsAgent(), order.getOrderDeliveredByName(),
										order.getCustName(), order.getCustMobile(), order.getCustWhatsappNo(),
										order.getFrName(), order.getCityName(), order.getAreaName(),
										order.getOfferName(), order.getOfferDesc(), order.getDeliveryMonth(),
										order.getDeliveryYear(), order.getDeliveryDateDisplay(),
										order.getDeliveryTimeDisplay(), order.getMonthName(), detailList, trailList);

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

								GetOrderDetailDisplay detail = new GetOrderDetailDisplay(order.getOrderDetailId(),
										order.getOrderId(), order.getItemId(), order.getHsnCode(), order.getQty(),
										order.getMrp(), order.getRate(), order.getDetailTaxableAmt(),
										order.getCgstPer(), order.getSgstPer(), order.getIgstPer(),
										order.getDetailCgstAmt(), order.getDetailSgstAmt(), order.getDetailIgstAmt(),
										order.getDetailDiscAmt(), order.getDetailTaxAmt(), order.getDetailTotalAmt(),
										order.getDelStatus(), order.getDetailRemark(), order.getDetailExInt1(),
										order.getDetailExInt2(), order.getDetailExInt3(), order.getDetailExInt4(),
										order.getDetailExVar1(), order.getDetailExVar2(), order.getDetailExVar3(),
										order.getDetailExVar4(), order.getDetailExFloat1(), order.getDetailExFloat2(),
										order.getDetailExFloat3(), order.getDetailExFloat4(), order.getItemName(),
										order.getCatId(), order.getCatName(), order.getItemUom(), order.getUomId());
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

		return orderList;

	}

	@RequestMapping(value = { "/getOrderReportBetweenDateAndStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderHeaderDisplay> getOrderReportBetweenDateAndStatus(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") List<Integer> status) {

		List<GetOrderHeaderDisplay> orderList = new ArrayList<>();

		try {

			List<GetOrderDisplay> res = getOrderDisplayRepo.getAllOrdersByDeliveryDateAndStatus(fromDate, toDate,
					status);
			List<GetOrderTrailDisplay> allTrailList = getOrderTrailDisplayRepo.getOrderTrailDataByDate(fromDate,
					toDate);

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
										order.getOrderNo(), order.getOrderDate(), order.getFrId(), order.getCustId(),
										order.getStatus(), order.getTaxableAmt(), order.getCgstAmt(),
										order.getSgstAmt(), order.getIgstAmt(), order.getDiscAmt(),
										order.getItemDiscAmt(), order.getTaxAmt(), order.getTotalAmt(),
										order.getOrderStatus(), order.getPaidStatus(), order.getPaymentMethod(),
										order.getPaymentRemark(), order.getCityId(), order.getAreaId(),
										order.getAddressId(), order.getAddress(), order.getWhatsappNo(),
										order.getLandmark(), order.getDeliveryDate(), order.getDeliveryTime(),
										order.getInsertDateTime(), order.getInsertUserId(), order.getOrderPlatform(),
										order.getDelStatus(), order.getOfferId(), order.getRemark(),
										order.getOrderDeliveredBy(), order.getExInt1(), order.getExInt2(),
										order.getExInt3(), order.getExInt4(), order.getExVar1(), order.getExVar2(),
										order.getExVar3(), order.getExVar4(), order.getExFloat1(), order.getExFloat2(),
										order.getExFloat3(), order.getExFloat4(), order.getExDate1(),
										order.getExDate2(), order.getBillingName(), order.getBillingAddress(),
										order.getCustomerGstnNo(), order.getDeliveryType(), order.getDeliveryInstId(),
										order.getDeliveryInstText(), order.getDeliveryKm(), order.getDeliveryCharges(),
										order.getPaymentSubMode(), order.getIsAgent(), order.getOrderDeliveredByName(),
										order.getCustName(), order.getCustMobile(), order.getCustWhatsappNo(),
										order.getFrName(), order.getCityName(), order.getAreaName(),
										order.getOfferName(), order.getOfferDesc(), order.getDeliveryMonth(),
										order.getDeliveryYear(), order.getDeliveryDateDisplay(),
										order.getDeliveryTimeDisplay(), order.getMonthName(), detailList, trailList);

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

								GetOrderDetailDisplay detail = new GetOrderDetailDisplay(order.getOrderDetailId(),
										order.getOrderId(), order.getItemId(), order.getHsnCode(), order.getQty(),
										order.getMrp(), order.getRate(), order.getDetailTaxableAmt(),
										order.getCgstPer(), order.getSgstPer(), order.getIgstPer(),
										order.getDetailCgstAmt(), order.getDetailSgstAmt(), order.getDetailIgstAmt(),
										order.getDetailDiscAmt(), order.getDetailTaxAmt(), order.getDetailTotalAmt(),
										order.getDelStatus(), order.getDetailRemark(), order.getDetailExInt1(),
										order.getDetailExInt2(), order.getDetailExInt3(), order.getDetailExInt4(),
										order.getDetailExVar1(), order.getDetailExVar2(), order.getDetailExVar3(),
										order.getDetailExVar4(), order.getDetailExFloat1(), order.getDetailExFloat2(),
										order.getDetailExFloat3(), order.getDetailExFloat4(), order.getItemName(),
										order.getCatId(), order.getCatName(), order.getItemUom(), order.getUomId());
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

		return orderList;

	}
	
	
	
	

}
