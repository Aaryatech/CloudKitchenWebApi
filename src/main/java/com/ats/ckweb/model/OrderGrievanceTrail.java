package com.ats.ckweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_grievences_trail")
public class OrderGrievanceTrail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trail_id")
	private int trailId;

	@Column(name = "grievences_id")
	private int grievencesId;

	@Column(name = "remark")
	private String remark;

	@Column(name = "status")
	private int status;

	@Column(name = "action_by_user_id")
	private int actionByUserId;

	@Column(name = "action_date_time")
	private String actionDateTime;

	@Column(name = "extra_int1")
	private int extraInt1;

	@Column(name = "extra_int2")
	private int extraInt2;

	@Column(name = "extra_var1")
	private String extraVar1;

	@Column(name = "extra_var2")
	private String extraVar2;

	@Column(name = "identified_root_cause")
	private String identifiedRootCause;

	@Column(name = "grievence_res_type")
	private int grievenceResType;

	@Column(name = "resolution_detail")
	private String resolutionDetail;

	@Column(name = "repay_amt")
	private float repayAmt;

	@Column(name = "repay_details")
	private String repayDetails;
	@Column(name = "griv_action_value")
	private int grivActionValue;
	@Column(name = "griv_action_text")
	private String grivActionText;

	public int getTrailId() {
		return trailId;
	}

	public void setTrailId(int trailId) {
		this.trailId = trailId;
	}

	public int getGrievencesId() {
		return grievencesId;
	}

	public void setGrievencesId(int grievencesId) {
		this.grievencesId = grievencesId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getActionByUserId() {
		return actionByUserId;
	}

	public void setActionByUserId(int actionByUserId) {
		this.actionByUserId = actionByUserId;
	}

	public String getActionDateTime() {
		return actionDateTime;
	}

	public void setActionDateTime(String actionDateTime) {
		this.actionDateTime = actionDateTime;
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

	public String getIdentifiedRootCause() {
		return identifiedRootCause;
	}

	public void setIdentifiedRootCause(String identifiedRootCause) {
		this.identifiedRootCause = identifiedRootCause;
	}

	public int getGrievenceResType() {
		return grievenceResType;
	}

	public void setGrievenceResType(int grievenceResType) {
		this.grievenceResType = grievenceResType;
	}

	public String getResolutionDetail() {
		return resolutionDetail;
	}

	public void setResolutionDetail(String resolutionDetail) {
		this.resolutionDetail = resolutionDetail;
	}

	public float getRepayAmt() {
		return repayAmt;
	}

	public void setRepay_amt(float repayAmt) {
		this.repayAmt = repayAmt;
	}

	public String getRepayDetails() {
		return repayDetails;
	}

	public void setRepayDetails(String repayDetails) {
		this.repayDetails = repayDetails;
	}

	public int getGrivActionValue() {
		return grivActionValue;
	}

	public void setGrivActionValue(int grivActionValue) {
		this.grivActionValue = grivActionValue;
	}

	public String getGrivActionText() {
		return grivActionText;
	}

	public void setGrivActionText(String grivActionText) {
		this.grivActionText = grivActionText;
	}

	@Override
	public String toString() {
		return "OrderGrievanceTrail [trailId=" + trailId + ", grievencesId=" + grievencesId + ", remark=" + remark
				+ ", status=" + status + ", actionByUserId=" + actionByUserId + ", actionDateTime=" + actionDateTime
				+ ", extraInt1=" + extraInt1 + ", extraInt2=" + extraInt2 + ", extraVar1=" + extraVar1 + ", extraVar2="
				+ extraVar2 + ", identifiedRootCause=" + identifiedRootCause + ", grievenceResType=" + grievenceResType
				+ ", resolutionDetail=" + resolutionDetail + ", repayAmt=" + repayAmt + ", repayDetails=" + repayDetails
				+ ", grivActionValue=" + grivActionValue + ", grivActionText=" + grivActionText + "]";
	}

}
