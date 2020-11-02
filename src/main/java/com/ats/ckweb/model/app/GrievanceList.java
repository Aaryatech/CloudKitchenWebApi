package com.ats.ckweb.model.app;

import java.util.List;

import com.ats.ckweb.model.GetGrievienceList;
import com.ats.ckweb.model.Info;

public class GrievanceList {

	List<GetGrievienceList> grievanceList;
	Info info;

	public List<GetGrievienceList> getGrievanceList() {
		return grievanceList;
	}

	public void setGrievanceList(List<GetGrievienceList> grievanceList) {
		this.grievanceList = grievanceList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GrievanceList [grievanceList=" + grievanceList + ", info=" + info + "]";
	}

}
