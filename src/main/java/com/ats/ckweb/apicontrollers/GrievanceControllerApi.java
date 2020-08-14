package com.ats.ckweb.apicontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.model.GetGrievanceHeader;
import com.ats.ckweb.model.GetGrievanceTrail;
import com.ats.ckweb.model.GrievanceActionMaster;
import com.ats.ckweb.model.MnUser;
import com.ats.ckweb.model.OrderGrievanceTrail;
import com.ats.ckweb.report.model.GrievanceBetDate;
import com.ats.ckweb.report.model.GrievanceDatewise;
import com.ats.ckweb.report.repo.GrievanceBetDateRepo;
import com.ats.ckweb.report.repo.GrievanceDatewiseRepo;
import com.ats.ckweb.repository.GetGrievanceHeaderRepo;
import com.ats.ckweb.repository.GetGrievanceTrailRepo;
import com.ats.ckweb.repository.GrievanceActionMasterRepo;
import com.ats.ckweb.repository.MnUserRepo;
import com.ats.ckweb.repository.OrderGrievanceTrailRepo;

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
	

}
