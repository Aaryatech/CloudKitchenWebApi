package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemWiseOfferHeaderDisplay {
	
	@Id
	private int offerDetailId;
	private int offerId;
	private String offerName;
	private String offerDesc;
	private int type;
	private int applicableFor;
	private int offerType;
	private int frequencyType;
	private String frequency;
	private String fromDate;
	private String toDate;
	private String fromTime;
	private String toTime;
	
	
	
	

}
