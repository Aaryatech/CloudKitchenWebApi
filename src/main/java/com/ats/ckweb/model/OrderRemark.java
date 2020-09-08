package com.ats.ckweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mn_remark")
public class OrderRemark {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "rk_id")
	private int rkId;

	@Column(name = "rk_name")
	private String rkName;

	@Column(name = "rk_type")
	private int rkType;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "ex_int1")
	private int exInt1;

	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "ex_var1")
	private String exVar1;

	@Column(name = "ex_var2")
	private String exVar2;

	public int getRkId() {
		return rkId;
	}

	public void setRkId(int rkId) {
		this.rkId = rkId;
	}

	public String getRkName() {
		return rkName;
	}

	public void setRkName(String rkName) {
		this.rkName = rkName;
	}

	public int getRkType() {
		return rkType;
	}

	public void setRkType(int rkType) {
		this.rkType = rkType;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	@Override
	public String toString() {
		return "OrderRemark [rkId=" + rkId + ", rkName=" + rkName + ", rkType=" + rkType + ", delStatus=" + delStatus
				+ ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}

}
