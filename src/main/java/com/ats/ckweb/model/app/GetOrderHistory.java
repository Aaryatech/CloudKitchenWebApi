package com.ats.ckweb.model.app;

import java.util.List;

import com.ats.ckweb.model.GetOrderHeaderList;
import com.ats.ckweb.model.Info;

public class GetOrderHistory {

	List<GetOrderHeaderList> orderList;
	Info info;

	public List<GetOrderHeaderList> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<GetOrderHeaderList> orderList) {
		this.orderList = orderList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetOrderHistory [orderList=" + orderList + ", info=" + info + "]";
	}

}
