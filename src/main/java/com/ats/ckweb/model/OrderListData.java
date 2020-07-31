package com.ats.ckweb.model;

import java.util.List;

public class OrderListData {

	private List<GetOrderHeaderList> orderListByStatus;
	private List<GetOrderHeaderList> orderListByStatusAndDate;
	public List<GetOrderHeaderList> getOrderListByStatus() {
		return orderListByStatus;
	}
	public void setOrderListByStatus(List<GetOrderHeaderList> orderListByStatus) {
		this.orderListByStatus = orderListByStatus;
	}
	public List<GetOrderHeaderList> getOrderListByStatusAndDate() {
		return orderListByStatusAndDate;
	}
	public void setOrderListByStatusAndDate(List<GetOrderHeaderList> orderListByStatusAndDate) {
		this.orderListByStatusAndDate = orderListByStatusAndDate;
	}
	@Override
	public String toString() {
		return "OrderListData [orderListByStatus=" + orderListByStatus + ", orderListByStatusAndDate="
				+ orderListByStatusAndDate + "]";
	}
	
	
}
