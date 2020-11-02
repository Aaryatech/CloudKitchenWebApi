package com.ats.ckweb.model.app;

import java.util.List;


import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.OfferHeader;

public class GetOffersForApp {

	List<OfferHeader> offerList;
	Info info;

	public List<OfferHeader> getOfferList() {
		return offerList;
	}

	public void setOfferList(List<OfferHeader> offerList) {
		this.offerList = offerList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetOffersForApp [offerList=" + offerList + "]";
	}

}
