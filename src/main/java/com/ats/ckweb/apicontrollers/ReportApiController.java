package com.ats.ckweb.apicontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.model.Franchisee;
import com.ats.ckweb.report.model.GetOrderTrailDetails;
import com.ats.ckweb.report.model.Status;
import com.ats.ckweb.report.model.GetOrderReport;
import com.ats.ckweb.report.repo.GetOrderDetailsRepo;
import com.ats.ckweb.report.repo.GetOrderReportRepo;
import com.ats.ckweb.report.repo.StatusRepo;
import com.ats.ckweb.repository.FranchiseeRepository;

@RestController
public class ReportApiController {
	
	@Autowired StatusRepo statusRepo;
	
	@Autowired FranchiseeRepository frRepo;
	
	@Autowired GetOrderReportRepo reportRepo;
	
	@Autowired GetOrderDetailsRepo detlRepo;
	
	//@Autowired CommonReportRepo cmnRepRepo;
	
	  @RequestMapping(value = { "/getAllStatus" }, method = RequestMethod.GET)
	  public @ResponseBody List<Status> getAllStatus() {
	  
		  List<Status> res = new ArrayList<Status>();
		  res = statusRepo.findByDelStatusOrderByStatusIdAsc(0);
		   return res; 
	  }
	 
	
	  @RequestMapping(value = { "/getOrderReportByDateWise" }, method = RequestMethod.POST)
	  public @ResponseBody List<GetOrderReport> getOrderReportByDateWise(@RequestParam int status, @RequestParam String fromDate,
			  @RequestParam String toDate, @RequestParam int datetype) {
	  
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
		  }catch (Exception e) {
			e.printStackTrace();
		}
		  
		   return res; 
	  }
	  
	  
}
