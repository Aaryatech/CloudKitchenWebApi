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

import com.ats.ckweb.model.MnUser;
import com.ats.ckweb.repository.GetUserDetailRepo;
import com.ats.ckweb.repository.MnUserRepo;
import com.ats.ckweb.repository.AccessRight.AssignRoleDetailListRepository;
import com.ats.ckweb.repository.AccessRight.GetUserRepo;
import com.ats.ckweb.services.AccessRightService;
import com.ats.ckweb.model.AccessRightModule;
import com.ats.ckweb.model.AccessRightModuleList;
import com.ats.ckweb.model.AssignRoleDetailList;
import com.ats.ckweb.model.CreatedRoleList;
import com.ats.ckweb.model.GetUser;
import com.ats.ckweb.model.GetUserDetail;
import com.ats.ckweb.model.GetUserDetailList;
import com.ats.ckweb.model.Info;

@RestController
public class AccessRightApiController {

	@Autowired
	AccessRightService accessRightService;

	@Autowired
	GetUserDetailRepo userDetail;// 22 MArch

	@Autowired
	AssignRoleDetailListRepository assignRoleDetailListRepository;

	@RequestMapping(value = { "/deleteRole" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteRole(@RequestParam int roleId) {

		int isDeleted = assignRoleDetailListRepository.deleteRole(roleId);
		Info info = new Info();
		if (isDeleted == 1) {
			info.setError(false);
			info.setMessage("Role  Deleted");
		} else {
			info.setError(true);
			info.setMessage("Role Deletion Failed");
		}
		return info;
	}

	@RequestMapping(value = { "/getUserDetail" }, method = RequestMethod.GET)
	public @ResponseBody GetUserDetailList getUserDetail() {

		GetUserDetailList userList = new GetUserDetailList();

		List<GetUserDetail> details = userDetail.getUserDetail();

		Info info = new Info();
		if (details != null && !details.isEmpty()) {
			userList.setUserDetail(details);
			info.setError(false);
			info.setMessage("Success");
		} else {
			info.setError(true);
			info.setMessage("failed");
		}
		userList.setInfo(info);

		System.err.println("User detail response /AccessRightApiController /getUserDetail" + userList.toString());
		return userList;
	}

	@RequestMapping(value = { "/getAllModuleAndSubModule" }, method = RequestMethod.GET)
	public @ResponseBody AccessRightModuleList getAllModuleAndSubModule() {

		AccessRightModuleList accessRightModuleList = new AccessRightModuleList();

		List<AccessRightModule> accessRightModule = accessRightService.getAllModulAndSubModule();

		Info info = new Info();
		if (accessRightModule != null && !accessRightModule.isEmpty()) {
			accessRightModuleList.setAccessRightModuleList(accessRightModule);
			info.setError(false);
			info.setMessage("Success");
		} else {

			info.setError(true);
			info.setMessage("failed");
		}
		accessRightModuleList.setInfo(info);
		return accessRightModuleList;
	}

	@RequestMapping(value = { "/saveAssignRole" }, method = RequestMethod.POST)
	public @ResponseBody Info saveAssignRole(@RequestBody AssignRoleDetailList assignRoleDetailList) {

		System.out.println(assignRoleDetailList.toString());

		Info info = accessRightService.saveAssignRole(assignRoleDetailList);

		return info;
	}

	@RequestMapping(value = { "/getAllAccessRole" }, method = RequestMethod.GET)
	public @ResponseBody CreatedRoleList getAllAccessRole() {

		CreatedRoleList createdRoleList = new CreatedRoleList();

		List<AssignRoleDetailList> assignRoleDetailList = accessRightService.getAllAccessRole();

		Info info = new Info();
		if (assignRoleDetailList != null && !assignRoleDetailList.isEmpty()) {
			createdRoleList.setAssignRoleDetailList(assignRoleDetailList);
			info.setError(false);
			info.setMessage("Success");
		} else {

			info.setError(true);
			info.setMessage("failed");
		}
		createdRoleList.setInfo(info);
		return createdRoleList;
	}

	@RequestMapping(value = { "/updateEmpRole" }, method = RequestMethod.POST)
	@ResponseBody
	public Info updateEmpRole(@RequestParam("id") int id, @RequestParam("roleId") int roleId) {
		return accessRightService.updateRoleIdByEmpId(id, roleId);
	}

	@RequestMapping(value = { "/getAllUser" }, method = RequestMethod.GET)
	public @ResponseBody List<MnUser> getAllUser() {

		List<MnUser> userList = accessRightService.getAllUser();

		return userList;
	}

	@RequestMapping(value = { "/getRoleJson" }, method = RequestMethod.POST)
	@ResponseBody
	public String getRoleJson(@RequestParam("usrId") int usrId) {

		return accessRightService.getRoleJson(usrId);
	}

	// 11 April..Sachin
	@RequestMapping(value = { "/getRoleJsonByRoleId" }, method = RequestMethod.POST)
	@ResponseBody
	public String getRoleJsonByRoleId(@RequestParam int roleId) {

		return accessRightService.getRoleJsonByRoleId(roleId, 0);

	}

	@RequestMapping(value = { "/getRoleByRoleId" }, method = RequestMethod.POST)
	@ResponseBody
	public AssignRoleDetailList getRoleByRoleId(@RequestParam("roleId") int roleId) {

		AssignRoleDetailList role = new AssignRoleDetailList();
		try {

			role = assignRoleDetailListRepository.findByRoleIdAndDelStatus(roleId, 0);// (roleId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return role;

	}

	@Autowired
	GetUserRepo getUserRepo;

	@RequestMapping(value = { "/getUserListForAssignRole" }, method = RequestMethod.GET)
	public @ResponseBody List<GetUser> getAllEmployees() {

		List<GetUser> empList = new ArrayList<GetUser>();
		try {
			empList = getUserRepo.getUserListForAssignRole();
		} catch (Exception e) {
			System.err.println("Exce in getUserListForAssignRole  " + e.getMessage());
		}

		return empList;

	}

	@Autowired
	MnUserRepo userRepo;
	
	@RequestMapping(value = { "/updateRoleOfUser" }, method = RequestMethod.POST)
	@ResponseBody
	public Info updateRoleOfUser(@RequestParam("userIdList") List<String> userIdList,
			@RequestParam("roleId") int roleId, @RequestParam("makerUserId") int makerUserId,
			@RequestParam("makerDttime") String makerDttime) {

		Info info = new Info();
		try {

			int update = userRepo.updateRoleId(roleId, userIdList);
			info.setError(false);
			info.setMessage("update");

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage("failed");
		}
		return info;

	}

}
