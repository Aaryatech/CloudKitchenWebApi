package com.ats.ckweb.model;

import java.util.List;

public class GetGrievanceTypeListData {

	private List<GrievencesInstruction> grievanceTypeList;
	private Info info;

	public List<GrievencesInstruction> getGrievanceTypeList() {
		return grievanceTypeList;
	}

	public void setGrievanceTypeList(List<GrievencesInstruction> grievanceTypeList) {
		this.grievanceTypeList = grievanceTypeList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetGrievanceTypeListData [grievanceTypeList=" + grievanceTypeList + ", info=" + info + "]";
	}

}
