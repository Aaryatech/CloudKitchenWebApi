package com.ats.ckweb.services;

import java.util.List;

import com.ats.ckweb.model.AccessRightModule;
import com.ats.ckweb.model.AssignRoleDetailList;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.MnUser;

public interface AccessRightService {

	List<AccessRightModule> getAllModulAndSubModule();

	Info saveAssignRole(AssignRoleDetailList assignRoleDetailList);

	List<AssignRoleDetailList> getAllAccessRole();
	
	Info updateRoleIdByEmpId(int id, int roleId);

	List<MnUser> getAllUser();

	String getRoleJson(int usrId);

	String getRoleJsonByRoleId(int roleId,int delStatus);
	
	
}
