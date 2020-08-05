package com.ats.ckweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_feedback")
public class OrderFeedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "feedback_id")
	private int feedbackId;

	@Column(name = "order_id")
	private int orderId;

	@Column(name = "remark")
	private String remark;
	
	@Column(name = "insert_datetime")
	private String insertDatetime;

	@Column(name = "insert_user_id")
	private int insertUserId;
	
	@Column(name = "platform")
	private int platform;
	
	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getInsertDatetime() {
		return insertDatetime;
	}

	public void setInsertDatetime(String insertDatetime) {
		this.insertDatetime = insertDatetime;
	}

	public int getInsertUserId() {
		return insertUserId;
	}

	public void setInsertUserId(int insertUserId) {
		this.insertUserId = insertUserId;
	}

	public int getPlatform() {
		return platform;
	}

	public void setPlatform(int platform) {
		this.platform = platform;
	}

	@Override
	public String toString() {
		return "OrderFeedback [feedbackId=" + feedbackId + ", orderId=" + orderId + ", remark=" + remark
				+ ", insertDatetime=" + insertDatetime + ", insertUserId=" + insertUserId + ", platform=" + platform
				+ "]";
	}
	
	

}
