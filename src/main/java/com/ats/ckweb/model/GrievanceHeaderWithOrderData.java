package com.ats.ckweb.model;

import com.ats.ckweb.report.model.GetOrderHeaderDisplay;

public class GrievanceHeaderWithOrderData {

	private GetGrievanceHeader grievanceHeader;
	private GetOrderHeaderDisplay order;
	private String orderJson;

	public GetGrievanceHeader getGrievanceHeader() {
		return grievanceHeader;
	}

	public void setGrievanceHeader(GetGrievanceHeader grievanceHeader) {
		this.grievanceHeader = grievanceHeader;
	}

	public GetOrderHeaderDisplay getOrder() {
		return order;
	}

	public void setOrder(GetOrderHeaderDisplay order) {
		this.order = order;
	}

	public String getOrderJson() {
		return orderJson;
	}

	public void setOrderJson(String orderJson) {
		this.orderJson = orderJson;
	}

	@Override
	public String toString() {
		return "GrievanceHeaderWithOrderData [grievanceHeader=" + grievanceHeader + ", order=" + order + ", orderJson="
				+ orderJson + "]";
	}

}
