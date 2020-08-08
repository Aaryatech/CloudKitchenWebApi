package com.ats.ckweb.model;

import java.util.List;

public class GetFranchiseData {

	private List<FranchiseData> franchise; 
	private Info info;

	public List<FranchiseData> getFranchise() {
		return franchise;
	}

	public void setFranchise(List<FranchiseData> franchise) {
		this.franchise = franchise;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
 
	@Override
	public String toString() {
		return "GetFranchiseData [franchise=" + franchise + ", info=" + info + "]";
	}

}
