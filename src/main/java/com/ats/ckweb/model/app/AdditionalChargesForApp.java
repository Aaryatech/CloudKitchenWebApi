package com.ats.ckweb.model.app;

import java.util.List;

import com.ats.ckweb.model.CkDeliveryCharges;
import com.ats.ckweb.model.FrCharges;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.OfferHeader;

public class AdditionalChargesForApp {

	private CkDeliveryCharges deliveryCharges;
	private FrCharges additionalCharges;
	List<OfferHeader> offerList;
	Info info;

	public CkDeliveryCharges getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(CkDeliveryCharges deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	public FrCharges getAdditionalCharges() {
		return additionalCharges;
	}

	public void setAdditionalCharges(FrCharges additionalCharges) {
		this.additionalCharges = additionalCharges;
	}

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
		return "AdditionalChargesForApp [deliveryCharges=" + deliveryCharges + ", additionalCharges="
				+ additionalCharges + ", offerList=" + offerList + ", info=" + info + "]";
	}

}
