package com.ats.ckweb.apicontrollers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.report.model.GetGroupByReportData;
import com.ats.ckweb.report.model.GetOrderDetailDisplay;
import com.ats.ckweb.report.model.GetOrderDisplay;
import com.ats.ckweb.report.model.GetOrderHeaderDisplay;
import com.ats.ckweb.report.model.GetOrderTrailDisplay;
import com.ats.ckweb.report.repo.GetGroupByReportDataRepo;
import com.ats.ckweb.report.repo.GetOrderDisplayRepo;
import com.ats.ckweb.report.repo.GetOrderTrailDisplayRepo;

@RestController
public class OrderReportController {

	@Autowired
	GetOrderDisplayRepo getOrderDisplayRepo;

	@Autowired
	GetOrderTrailDisplayRepo getOrderTrailDisplayRepo;

	@Autowired
	GetGroupByReportDataRepo getGroupByReportDataRepo;

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
			List<GetOrderTrailDisplay> allTrailList = getOrderTrailDisplayRepo
					.getOrderTrailDataByDateAndStatus(fromDate, toDate, status);

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

	// ORDER REPORT - GROUP BY DATE FOR FRANCHISE
	@RequestMapping(value = { "/getOrderReportGroupByDateAndStatusForFr" }, method = RequestMethod.POST)
	public @ResponseBody List<GetGroupByReportData> getOrderReportGroupByDateAndStatusForFr(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") List<Integer> status, @RequestParam("frIds") List<Integer> frIds) {

		List<GetGroupByReportData> orderList = new ArrayList<>();

		try {

			orderList = getGroupByReportDataRepo.getOrderReportGroupByDateForFr(fromDate, toDate, status, frIds);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderList;

	}

	// ORDER REPORT - BY DATE AND STATUS FOR FRANCHISE - ON ACTION
	@RequestMapping(value = { "/getOrderReportForDateAndStatusAndFrOnAction" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderHeaderDisplay> getOrderReportForDateAndStatusAndFrOnAction(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") List<Integer> status, @RequestParam("frIds") List<Integer> frIds) {

		List<GetOrderHeaderDisplay> orderList = new ArrayList<>();

		try {

			List<GetOrderDisplay> res = getOrderDisplayRepo.getAllOrdersByDeliveryDateAndStatusAndFr(fromDate, toDate,
					status, frIds);
			List<GetOrderTrailDisplay> allTrailList = getOrderTrailDisplayRepo
					.getOrderTrailDataByDateAndStatusAndFr(fromDate, toDate, status, frIds);

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

	// ORDER REPORT - GROUP BY MONTH FOR FRANCHISE
	@RequestMapping(value = { "/getOrderReportGroupByMonthAndStatusForFr" }, method = RequestMethod.POST)
	public @ResponseBody List<GetGroupByReportData> getOrderReportGroupByMonthAndStatusForFr(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") List<Integer> status, @RequestParam("frIds") List<Integer> frIds) {

		List<GetGroupByReportData> orderList = new ArrayList<>();

		try {

			orderList = getGroupByReportDataRepo.getOrderReportGroupByMonthForFr(fromDate, toDate, status, frIds);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderList;

	}

	// ORDER REPORT - BY MONTH AND STATUS FOR FRANCHISE - ON ACTION
	@RequestMapping(value = { "/getOrderReportForMonthAndStatusAndFrOnAction" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderHeaderDisplay> getOrderReportForMonthAndStatusAndFrOnAction(
			@RequestParam("month") int month, @RequestParam("year") int year,
			@RequestParam("status") List<Integer> status, @RequestParam("frIds") List<Integer> frIds) {

		List<GetOrderHeaderDisplay> orderList = new ArrayList<>();

		try {

			// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

			String fromDate = "", toDate = "";

			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.MONTH, (month - 1));
			cal.set(Calendar.YEAR, year);
			int lastDay = cal.getActualMaximum(Calendar.DATE);

			if (month < 10) {
				fromDate = year + "-0" + month + "-01";
				toDate = year + "-0" + month + "-" + lastDay;
			} else {
				fromDate = year + "-" + month + "-01";
				toDate = year + "-" + month + "-" + lastDay;
			}

			List<GetOrderDisplay> res = getOrderDisplayRepo.getAllOrdersByDeliveryMonthAndStatusAndFr(month, year,
					status, frIds);
			List<GetOrderTrailDisplay> allTrailList = getOrderTrailDisplayRepo
					.getOrderTrailDataByDateAndStatusAndFr(fromDate, toDate, status, frIds);

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

	// ORDER REPORT - GROUP BY DATE FOR CUSTOMER
	@RequestMapping(value = { "/getOrderReportGroupByDateAndStatusForCust" }, method = RequestMethod.POST)
	public @ResponseBody List<GetGroupByReportData> getOrderReportGroupByDateAndStatusForCust(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") List<Integer> status, @RequestParam("custIds") List<Integer> custIds) {

		List<GetGroupByReportData> orderList = new ArrayList<>();

		try {

			orderList = getGroupByReportDataRepo.getOrderReportGroupByDateForCust(fromDate, toDate, status, custIds);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderList;

	}

	// ORDER REPORT - BY DATE AND STATUS FOR CUSTOMER - ON ACTION
	@RequestMapping(value = { "/getOrderReportForDateAndStatusAndCustOnAction" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderHeaderDisplay> getOrderReportForDateAndStatusAndCustOnAction(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") List<Integer> status, @RequestParam("custIds") List<Integer> custIds) {

		List<GetOrderHeaderDisplay> orderList = new ArrayList<>();

		try {

			List<GetOrderDisplay> res = getOrderDisplayRepo.getAllOrdersByDeliveryDateAndStatusAndCust(fromDate, toDate,
					status, custIds);
			List<GetOrderTrailDisplay> allTrailList = getOrderTrailDisplayRepo
					.getOrderTrailDataByDateAndStatusAndCust(fromDate, toDate, status, custIds);

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

	// ORDER REPORT - GROUP BY MONTH FOR CUSTOMER
	@RequestMapping(value = { "/getOrderReportGroupByMonthAndStatusForCust" }, method = RequestMethod.POST)
	public @ResponseBody List<GetGroupByReportData> getOrderReportGroupByMonthAndStatusForCust(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") List<Integer> status, @RequestParam("custIds") List<Integer> custIds) {

		List<GetGroupByReportData> orderList = new ArrayList<>();

		try {

			orderList = getGroupByReportDataRepo.getOrderReportGroupByMonthForCust(fromDate, toDate, status, custIds);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderList;

	}

	// ORDER REPORT - BY MONTH AND STATUS FOR CUSTOMER - ON ACTION
	@RequestMapping(value = { "/getOrderReportForMonthAndStatusAndCustOnAction" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderHeaderDisplay> getOrderReportForMonthAndStatusAndCustOnAction(
			@RequestParam("month") int month, @RequestParam("year") int year,
			@RequestParam("status") List<Integer> status, @RequestParam("custIds") List<Integer> custIds) {

		List<GetOrderHeaderDisplay> orderList = new ArrayList<>();

		try {

			// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

			String fromDate = "", toDate = "";

			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.MONTH, (month - 1));
			cal.set(Calendar.YEAR, year);
			int lastDay = cal.getActualMaximum(Calendar.DATE);

			if (month < 10) {
				fromDate = year + "-0" + month + "-01";
				toDate = year + "-0" + month + "-" + lastDay;
			} else {
				fromDate = year + "-" + month + "-01";
				toDate = year + "-" + month + "-" + lastDay;
			}

			List<GetOrderDisplay> res = getOrderDisplayRepo.getAllOrdersByDeliveryMonthAndStatusAndCust(month, year,
					status, custIds);
			List<GetOrderTrailDisplay> allTrailList = getOrderTrailDisplayRepo
					.getOrderTrailDataByDateAndStatusAndCust(fromDate, toDate, status, custIds);

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

	// ORDER REPORT - GROUP BY DATE FOR ORDER PLATFORM
	@RequestMapping(value = { "/getOrderReportGroupByDateAndStatusForOrderPlatform" }, method = RequestMethod.POST)
	public @ResponseBody List<GetGroupByReportData> getOrderReportGroupByDateAndStatusForOrderPlatform(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") List<Integer> status, @RequestParam("platform") List<Integer> platform) {

		List<GetGroupByReportData> orderList = new ArrayList<>();

		try {

			orderList = getGroupByReportDataRepo.getOrderReportGroupByDateForPlatform(fromDate, toDate, status,
					platform);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderList;

	}

	// ORDER REPORT - BY DATE AND STATUS FOR ORDER PLATFORM - ON ACTION
	@RequestMapping(value = { "/getOrderReportForDateAndStatusAndOrderPlatformOnAction" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderHeaderDisplay> getOrderReportForDateAndStatusAndOrderPlatformOnAction(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") List<Integer> status, @RequestParam("platform") List<Integer> platform) {

		List<GetOrderHeaderDisplay> orderList = new ArrayList<>();

		try {

			List<GetOrderDisplay> res = getOrderDisplayRepo
					.getAllOrdersByDeliveryDateAndStatusAndOrderPlatform(fromDate, toDate, status, platform);

			List<GetOrderTrailDisplay> allTrailList = getOrderTrailDisplayRepo
					.getOrderTrailDataByDateAndStatusAndOrderPlatform(fromDate, toDate, status, platform);

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

	// ORDER REPORT - GROUP BY MONTH FOR ORDER PLATFORM
	@RequestMapping(value = { "/getOrderReportGroupByMonthAndStatusForOrderPlatform" }, method = RequestMethod.POST)
	public @ResponseBody List<GetGroupByReportData> getOrderReportGroupByMonthAndStatusForOrderPlatform(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") List<Integer> status, @RequestParam("platform") List<Integer> platform) {

		List<GetGroupByReportData> orderList = new ArrayList<>();

		try {

			orderList = getGroupByReportDataRepo.getOrderReportGroupByMonthForPlatform(fromDate, toDate, status,
					platform);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderList;

	}

	// ORDER REPORT - BY MONTH AND STATUS FOR ORDER PLATFORM - ON ACTION
	@RequestMapping(value = { "/getOrderReportForMonthAndStatusAndOrderPlatformOnAction" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderHeaderDisplay> getOrderReportForMonthAndStatusAndOrderPlatformOnAction(
			@RequestParam("month") int month, @RequestParam("year") int year,
			@RequestParam("status") List<Integer> status, @RequestParam("platform") List<Integer> platform) {

		List<GetOrderHeaderDisplay> orderList = new ArrayList<>();

		try {

			// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

			String fromDate = "", toDate = "";

			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.MONTH, (month - 1));
			cal.set(Calendar.YEAR, year);
			int lastDay = cal.getActualMaximum(Calendar.DATE);

			if (month < 10) {
				fromDate = year + "-0" + month + "-01";
				toDate = year + "-0" + month + "-" + lastDay;
			} else {
				fromDate = year + "-" + month + "-01";
				toDate = year + "-" + month + "-" + lastDay;
			}

			List<GetOrderDisplay> res = getOrderDisplayRepo.getAllOrdersByDeliveryMonthAndStatusAndOrderPlatform(month,
					year, status, platform);
			List<GetOrderTrailDisplay> allTrailList = getOrderTrailDisplayRepo
					.getOrderTrailDataByDateAndStatusAndCust(fromDate, toDate, status, platform);

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

	// ORDER REPORT - GROUP BY DATE FOR PAYMENT METHOD
	@RequestMapping(value = { "/getOrderReportGroupByDateAndStatusForPayment" }, method = RequestMethod.POST)
	public @ResponseBody List<GetGroupByReportData> getOrderReportGroupByDateAndStatusForPayment(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") List<Integer> status, @RequestParam("payment") List<Integer> payment) {

		List<GetGroupByReportData> orderList = new ArrayList<>();

		try {

			orderList = getGroupByReportDataRepo.getOrderReportGroupByDateForPayment(fromDate, toDate, status, payment);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderList;

	}

	// ORDER REPORT - BY DATE AND STATUS FOR ORDER PLATFORM - ON ACTION
	@RequestMapping(value = { "/getOrderReportForDateAndStatusAndPaymentModeOnAction" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderHeaderDisplay> getOrderReportForDateAndStatusAndPaymentModeOnAction(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") List<Integer> status, @RequestParam("payment") List<Integer> payment) {

		List<GetOrderHeaderDisplay> orderList = new ArrayList<>();

		try {

			List<GetOrderDisplay> res = getOrderDisplayRepo.getAllOrdersByDeliveryDateAndStatusAndPayment(fromDate,
					toDate, status, payment);

			List<GetOrderTrailDisplay> allTrailList = getOrderTrailDisplayRepo
					.getOrderTrailDataByDateAndStatusAndPaymentMode(fromDate, toDate, status, payment);

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

	// ORDER REPORT - GROUP BY MONTH FOR PAYMENT METHOD
	@RequestMapping(value = { "/getOrderReportGroupByMonthAndStatusForPayment" }, method = RequestMethod.POST)
	public @ResponseBody List<GetGroupByReportData> getOrderReportGroupByMonthAndStatusForPayment(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") List<Integer> status, @RequestParam("payment") List<Integer> payment) {

		List<GetGroupByReportData> orderList = new ArrayList<>();

		try {

			orderList = getGroupByReportDataRepo.getOrderReportGroupByMonthForPayment(fromDate, toDate, status,
					payment);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderList;

	}

	// ORDER REPORT - BY MONTH AND STATUS FOR PAYMENT MODE - ON ACTION
	@RequestMapping(value = { "/getOrderReportForMonthAndStatusAndPaymentOnAction" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderHeaderDisplay> getOrderReportForMonthAndStatusAndPaymentOnAction(
			@RequestParam("month") int month, @RequestParam("year") int year,
			@RequestParam("status") List<Integer> status, @RequestParam("payment") List<Integer> payment) {

		List<GetOrderHeaderDisplay> orderList = new ArrayList<>();

		try {

			// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

			String fromDate = "", toDate = "";

			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.MONTH, (month - 1));
			cal.set(Calendar.YEAR, year);
			int lastDay = cal.getActualMaximum(Calendar.DATE);

			if (month < 10) {
				fromDate = year + "-0" + month + "-01";
				toDate = year + "-0" + month + "-" + lastDay;
			} else {
				fromDate = year + "-" + month + "-01";
				toDate = year + "-" + month + "-" + lastDay;
			}

			List<GetOrderDisplay> res = getOrderDisplayRepo.getAllOrdersByDeliveryMonthAndStatusAndPayment(month, year,
					status, payment);
			List<GetOrderTrailDisplay> allTrailList = getOrderTrailDisplayRepo
					.getOrderTrailDataByDateAndStatusAndPaymentMode(fromDate, toDate, status, payment);

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
