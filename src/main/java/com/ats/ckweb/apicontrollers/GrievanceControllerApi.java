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
import com.ats.ckweb.model.LoginResponse;
import com.ats.ckweb.repository.GetGrievanceHeaderRepo;

@RestController

public class GrievanceControllerApi {
	@Autowired
	private GetGrievanceHeaderRepo getGrievanceHeaderRepo;

	@RequestMapping(value = { "/getGrievanceHeaderList" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetGrievanceHeader> getGrievanceHeaderList(@RequestParam("statusList") List<Integer> statusList,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
		
		List<GetGrievanceHeader> grivList = new ArrayList<GetGrievanceHeader>();

		if (fromDate.equals("null")) {
			grivList = getGrievanceHeaderRepo.getGrievanceHeaderByStatus(statusList);
		} else {
			grivList = getGrievanceHeaderRepo.getGrievanceHeaderByStatusAndDate(statusList, fromDate, toDate);
		}

		return grivList;

	}

}
