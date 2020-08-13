package com.ats.ckweb.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetGrievienceList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grieve_id")
	private int grieveId;

	@Column(name = "order_id")
	private int orderId;

	@Column(name = "grievence_type_id")
	private int grievenceTypeId;

	@Column(name = "grievence_subtype_id")
	private int grievenceSubtypeId;

	@Column(name = "remark")
	private String remark;

	@Column(name = "current_status")
	private int currentStatus;

	@Column(name = "insert_date_time")
	private Date insertDateTime;

	@Column(name = "insert_by_id")
	private int insertById;

	@Column(name = "grievence_type_name")
	private String grievenceTypeName;

	@Column(name = "grievence_subtype_name")
	private String grievenceSubtypeName;

	@Column(name = "date")
	private Date date;

	@Column(name = "extra_int1")
	private int extraInt1;

	@Column(name = "extra_int2")
	private int extraInt2;

	@Column(name = "extra_var1")
	private String extraVar1;

	@Column(name = "extra_var2")
	private String extraVar2;

	@Column(name = "platform")
	private int platform;

	@Column(name = "grievencce_no")
	private String grievencceNo;

	@Column(name = "grv_instrustion")
	private String grvInstrustion;

	@Column(name = "grv_type")
	private String grvType;

	@Column(name = "order_no")
	private String orderNo;
	
	@Transient
	private List<GetGrievienceTailList> getGrievienceTailList;

	public int getGrieveId() {
		return grieveId;
	}

	public void setGrieveId(int grieveId) {
		this.grieveId = grieveId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getGrievenceTypeId() {
		return grievenceTypeId;
	}

	public void setGrievenceTypeId(int grievenceTypeId) {
		this.grievenceTypeId = grievenceTypeId;
	}

	public int getGrievenceSubtypeId() {
		return grievenceSubtypeId;
	}

	public void setGrievenceSubtypeId(int grievenceSubtypeId) {
		this.grievenceSubtypeId = grievenceSubtypeId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(int currentStatus) {
		this.currentStatus = currentStatus;
	}

	@JsonFormat(locale = "English", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy hh:mm a")
	public Date getInsertDateTime() {
		return insertDateTime;
	}

	public void setInsertDateTime(Date insertDateTime) {
		this.insertDateTime = insertDateTime;
	}

	public int getInsertById() {
		return insertById;
	}

	public void setInsertById(int insertById) {
		this.insertById = insertById;
	}

	public String getGrievenceTypeName() {
		return grievenceTypeName;
	}

	public void setGrievenceTypeName(String grievenceTypeName) {
		this.grievenceTypeName = grievenceTypeName;
	}

	public String getGrievenceSubtypeName() {
		return grievenceSubtypeName;
	}

	public void setGrievenceSubtypeName(String grievenceSubtypeName) {
		this.grievenceSubtypeName = grievenceSubtypeName;
	}

	@JsonFormat(locale = "English", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getExtraInt1() {
		return extraInt1;
	}

	public void setExtraInt1(int extraInt1) {
		this.extraInt1 = extraInt1;
	}

	public int getExtraInt2() {
		return extraInt2;
	}

	public void setExtraInt2(int extraInt2) {
		this.extraInt2 = extraInt2;
	}

	public String getExtraVar1() {
		return extraVar1;
	}

	public void setExtraVar1(String extraVar1) {
		this.extraVar1 = extraVar1;
	}

	public String getExtraVar2() {
		return extraVar2;
	}

	public void setExtraVar2(String extraVar2) {
		this.extraVar2 = extraVar2;
	}

	public int getPlatform() {
		return platform;
	}

	public void setPlatform(int platform) {
		this.platform = platform;
	}

	public String getGrievencceNo() {
		return grievencceNo;
	}

	public void setGrievencceNo(String grievencceNo) {
		this.grievencceNo = grievencceNo;
	}

	public String getGrvInstrustion() {
		return grvInstrustion;
	}

	public void setGrvInstrustion(String grvInstrustion) {
		this.grvInstrustion = grvInstrustion;
	}

	public String getGrvType() {
		return grvType;
	}

	public void setGrvType(String grvType) {
		this.grvType = grvType;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public List<GetGrievienceTailList> getGetGrievienceTailList() {
		return getGrievienceTailList;
	}

	public void setGetGrievienceTailList(List<GetGrievienceTailList> getGrievienceTailList) {
		this.getGrievienceTailList = getGrievienceTailList;
	}

	@Override
	public String toString() {
		return "GetGrievienceList [grieveId=" + grieveId + ", orderId=" + orderId + ", grievenceTypeId="
				+ grievenceTypeId + ", grievenceSubtypeId=" + grievenceSubtypeId + ", remark=" + remark
				+ ", currentStatus=" + currentStatus + ", insertDateTime=" + insertDateTime + ", insertById="
				+ insertById + ", grievenceTypeName=" + grievenceTypeName + ", grievenceSubtypeName="
				+ grievenceSubtypeName + ", date=" + date + ", extraInt1=" + extraInt1 + ", extraInt2=" + extraInt2
				+ ", extraVar1=" + extraVar1 + ", extraVar2=" + extraVar2 + ", platform=" + platform + ", grievencceNo="
				+ grievencceNo + ", grvInstrustion=" + grvInstrustion + ", grvType=" + grvType + ", orderNo=" + orderNo
				+ ", getGrievienceTailList=" + getGrievienceTailList + "]";
	}

}
