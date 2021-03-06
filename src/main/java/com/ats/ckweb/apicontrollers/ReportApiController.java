package com.ats.ckweb.apicontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.model.Customer;
import com.ats.ckweb.model.Franchisee;
import com.ats.ckweb.report.model.GetOrderTrailDetails;
import com.ats.ckweb.report.model.OfferDetailReport;
import com.ats.ckweb.report.model.OfferReport;
import com.ats.ckweb.report.model.Status;
import com.ats.ckweb.report.model.GetOrderGrpDate;
import com.ats.ckweb.report.model.GetOrderReport;
import com.ats.ckweb.report.repo.GetOrderDetailsRepo;
import com.ats.ckweb.report.repo.GetOrderGrpDateRepo;
import com.ats.ckweb.report.repo.GetOrderReportRepo;
import com.ats.ckweb.report.repo.OfferDetailReportRepo;
import com.ats.ckweb.report.repo.OfferReportRepo;
import com.ats.ckweb.report.repo.StatusRepo;
import com.ats.ckweb.repository.CustomerRepo;
import com.ats.ckweb.repository.FranchiseeRepository;

@RestController
public class ReportApiController {

	@Autowired
	StatusRepo statusRepo;

	@Autowired
	FranchiseeRepository frRepo;

	@Autowired
	GetOrderReportRepo reportRepo;

	@Autowired
	GetOrderDetailsRepo detlRepo;

	@Autowired
	CustomerRepo custRepo;

	@Autowired
	GetOrderGrpDateRepo orderReportRepo;

	@Autowired
	OfferReportRepo offerReportRepo;
	
	@Autowired
	OfferDetailReportRepo offerDetailReportRepo;
	

	@RequestMapping(value = { "/getOrderReportDateWise" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderGrpDate> getOrderReportDateWise(@RequestParam List<String> statusIds,
			@RequestParam String fromDate, @RequestParam String toDate) {

		List<GetOrderGrpDate> res = new ArrayList<GetOrderGrpDate>();
		res = orderReportRepo.getOrderGroupByDate(statusIds, fromDate, toDate);
		return res;
	}

	@RequestMapping(value = { "/getOrderReportMonthWise" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderGrpDate> getOrderReportMonthWise(@RequestParam List<String> statusIds,
			@RequestParam String fromDate, @RequestParam String toDate) {

		List<GetOrderGrpDate> res = new ArrayList<GetOrderGrpDate>();
		res = orderReportRepo.getOrderGroupByMonth(statusIds, fromDate, toDate);
		return res;
	}

	@RequestMapping(value = { "/getAllStatus" }, method = RequestMethod.GET)
	public @ResponseBody List<Status> getAllStatus() {

		List<Status> res = new ArrayList<Status>();
		res = statusRepo.findByDelStatusOrderByStatusIdAsc(0);
		return res;
	}

	@RequestMapping(value = { "/getAllCustomer" }, method = RequestMethod.POST)
	public @ResponseBody List<Customer> getOrderReportDateWise(@RequestParam int compId) {

		List<Customer> res = custRepo.findByDelStatusAndCompIdOrderByCustIdDesc(0, compId);
		return res;
	}

	/*********************************************************************************************/

	@RequestMapping(value = { "/getOrderReportByDateWise" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderReport> getOrderReportByDateWise(@RequestParam int status,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam int datetype) {

		List<GetOrderReport> res = new ArrayList<>();
		res = reportRepo.getOrderReportDateWise(fromDate, toDate, status);
//		  if(datetype==1) {
//			  System.out.println("Date Wise");
//			  
//		  }else if(datetype==2) {
//			  System.out.println("Between Date");
//			  res = reportRepo.getOrderReportBtwenDate(fromDate, toDate, status);
//		  }else {
//			  
//		  }

		return res;
	}

//	  @RequestMapping(value = { "/getOrderReportByDateWise" }, method = RequestMethod.POST)
//	  public @ResponseBody List<JSONObject> getOrderReportByDateWise1(@RequestParam int status, @RequestParam String fromDate,
//			  @RequestParam String toDate, @RequestParam int datetype) {
//	  
//		  List<JSONObject> res = new ArrayList<>();
//		  if(datetype==1) {
//			  System.out.println("Date Wise");
//			  res = cmnRepRepo.getOrderReportDateWise(fromDate, toDate, status);
//		  }else if(datetype==2) {
//			  System.out.println("Between Date");
//			  res = cmnRepRepo.getOrderReportBtwenDate(fromDate, toDate, status);
//		  }else {
//			  
//		  }
//		  
//		   return res; 
//	  }

	@RequestMapping(value = { "/getOrdertrailDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderTrailDetails> getOrderReportByDateWise(@RequestParam int orderId) {

		List<GetOrderTrailDetails> res = new ArrayList<>();
		try {
			res = detlRepo.getOrderTrailDetail(orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	// Offer Report
	@RequestMapping(value = { "/getOfferReport" }, method = RequestMethod.POST)
	public @ResponseBody List<OfferReport> getOfferReport(@RequestParam String fromDate, @RequestParam String toDate) {

		List<OfferReport> res = new ArrayList<OfferReport>();
		res = offerReportRepo.getOfferReport(fromDate, toDate);
		return res;
	}
	
	@RequestMapping(value = { "/getOfferDetailReport" }, method = RequestMethod.POST)
	public @ResponseBody List<OfferDetailReport> getOfferDetailReport(@RequestParam int offerId) {

		List<OfferDetailReport> res = new ArrayList<OfferDetailReport>();
		res = offerDetailReportRepo.getOfferDetailReport(offerId);
		return res;
	}
	
	
	
	
	

}
