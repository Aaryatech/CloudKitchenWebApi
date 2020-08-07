package com.ats.ckweb.apicontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.model.GetGrievanceHeader;
import com.ats.ckweb.model.GetGrievanceTrail;
import com.ats.ckweb.model.LoginResponse;
import com.ats.ckweb.repository.GetGrievanceHeaderRepo;
import com.ats.ckweb.repository.GetGrievanceTrailRepo;

@RestController

public class GrievanceControllerApi {
	@Autowired
	private GetGrievanceHeaderRepo getGrievanceHeaderRepo;

	@Autowired
	private GetGrievanceTrailRepo getGrievanceTrailRepo;

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
}
