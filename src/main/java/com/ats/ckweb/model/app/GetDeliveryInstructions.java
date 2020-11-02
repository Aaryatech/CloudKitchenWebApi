package com.ats.ckweb.model.app;

import java.util.List;

import com.ats.ckweb.model.DeliveryInstruction;
import com.ats.ckweb.model.Info;

public class GetDeliveryInstructions {

	List<DeliveryInstruction> deliveryInstruction;
	Info info;

	public List<DeliveryInstruction> getDeliveryInstruction() {
		return deliveryInstruction;
	}

	public void setDeliveryInstruction(List<DeliveryInstruction> deliveryInstruction) {
		this.deliveryInstruction = deliveryInstruction;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetDeliveryInstructions [deliveryInstruction=" + deliveryInstruction + "]";
	}

}
