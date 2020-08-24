package com.ats.ckweb.apicontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.report.model.GetDashPieStatusCnt;
import com.ats.ckweb.report.model.GrievenceCnt;
import com.ats.ckweb.report.repo.GetDashPieStatusCntRepo;
import com.ats.ckweb.report.repo.GrievenceCntRepo;

@RestController
public class DashApiController {

	@Autowired GetDashPieStatusCntRepo dashRepo;
	
	@Autowired GrievenceCntRepo grevCntRepo;
	
	@RequestMapping(value = { "/getAllStatusCount" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetDashPieStatusCnt> getGrievanceHeader(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
		List<GetDashPieStatusCnt> res = new ArrayList<GetDashPieStatusCnt>();
		try {
			
			res = dashRepo.getDashStatusCnt(fromDate, toDate);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return res;
	}
	
	@RequestMapping(value = { "/getAllStatusFrCount" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetDashPieStatusCnt> getAllStatusFrCount(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") String status) {
		List<GetDashPieStatusCnt> res = new ArrayList<GetDashPieStatusCnt>();
		try {
			
			res = dashRepo.getStatusCntGrpFr(fromDate, toDate, status);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return res;
	}
	
	
	@RequestMapping(value = { "/getAllGrievenceCount" }, method = RequestMethod.POST)
	@ResponseBody
	public GrievenceCnt getAllGrievenceCount(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
		GrievenceCnt res = new GrievenceCnt();
		try {
			
			res = grevCntRepo.getGrievenceCntData(fromDate, toDate);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return res;
	}
}
