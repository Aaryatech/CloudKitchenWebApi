package com.ats.ckweb.apicontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.report.model.GetDashPieStatusCnt;
import com.ats.ckweb.report.model.GetGreivFrDtl;
import com.ats.ckweb.report.model.GrievanceDetailDash;
import com.ats.ckweb.report.model.GrievenceCnt;
import com.ats.ckweb.report.model.GetGrievanceCntByType;
import com.ats.ckweb.report.repo.GetDashPieStatusCntRepo;
import com.ats.ckweb.report.repo.GetGreivFrDtlRepo;
import com.ats.ckweb.report.repo.GrievanceDetailDashRepo;
import com.ats.ckweb.report.repo.GrievenceCntRepo;
import com.ats.ckweb.report.repo.GriveanceCntRepo;

@RestController
public class DashApiController {

	@Autowired GetDashPieStatusCntRepo dashRepo;
	
	@Autowired GrievenceCntRepo grevCntRepo;
	
	@Autowired GrievanceDetailDashRepo grievDtlRepo;
	
	@Autowired GriveanceCntRepo grievCntRepo;
	
	@Autowired GetGreivFrDtlRepo getGrievDtlRepo;
	
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
	
	@RequestMapping(value = { "/getGrievenceDtlByStatus" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GrievanceDetailDash> getGrievenceDtlByStatus(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("grievStatus") List<String> grievStatus, @RequestParam("setUnset") List<String> setUnset) {
		List<GrievanceDetailDash> res = new ArrayList<GrievanceDetailDash>();
		try {
			System.out.println(grievStatus+" "+setUnset);
			
			res = grievDtlRepo.getGrievanceData(fromDate, toDate, grievStatus, setUnset);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return res;
	}
	
	@RequestMapping(value = { "/getGrievenceCntByTypeId" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetGrievanceCntByType> getGrievenceCntByTypeId(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("grievTypeId") List<Integer> grievTypeId) {
		List<GetGrievanceCntByType> res = new ArrayList<GetGrievanceCntByType>();
		try {
			
			res = grievCntRepo.getGrievCnt(fromDate, toDate, grievTypeId);
			System.err.println("Griev Cnt------------>"+res);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return res;
	}
	
	
	@RequestMapping(value = { "/getGrievenceFrDtl" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetGreivFrDtl> getGrievenceFrDtl(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("grievTypeId") int grievTypeId, @RequestParam("frId") int frId) {
		List<GetGreivFrDtl> res = new ArrayList<GetGreivFrDtl>();
		try {
			
			res = getGrievDtlRepo.getGrievFrDtlList(fromDate, toDate, frId, grievTypeId);
			System.err.println("Griev Dtl ------------>"+res);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return res;
	}
}
