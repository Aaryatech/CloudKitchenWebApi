package com.ats.ckweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mn_user_type")
public class UserType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "user_type_id")
	private int userTypeId;
	
	@Column(name = "user_type_name")
	private String userTypeName;
	
	@Column(name = "user_type_desc")
	private String userTypeDesc;
	
	@Column(name = "is_active")
	private int isActive;
	
	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "comapny_id_required")
	private int comapnyIdRequired;
	
	@Column(name = "login_appcatble_to")
	private int loginAppcatbleTo;
	
	@Column(name = "ex_int1")
	private int exInt1;
	
	@Column(name = "ex_int2")
	private int exInt2;
	
	@Column(name = "ex_int3")
	private int exInt3;
	
	@Column(name = "ex_float1")
	private float exFloat1;
	
	@Column(name = "ex_float2")
	private float exFloat2;
	
	@Column(name = "ex_float3")
	private float exFloat3;
	
	@Column(name = "ex_var1")
	private String exVar1;
	
	@Column(name = "ex_var2")
	private String exVar2;
	
	@Column(name = "ex_var3")
	private String exVar3;
	
	@Column(name = "ex_var4")
	private String exVar4;

	

	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public String getUserTypeDesc() {
		return userTypeDesc;
	}

	public void setUserTypeDesc(String userTypeDesc) {
		this.userTypeDesc = userTypeDesc;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getComapnyIdRequired() {
		return comapnyIdRequired;
	}

	public void setComapnyIdRequired(int comapnyIdRequired) {
		this.comapnyIdRequired = comapnyIdRequired;
	}

	public int getLoginAppcatbleTo() {
		return loginAppcatbleTo;
	}

	public void setLoginAppcatbleTo(int loginAppcatbleTo) {
		this.loginAppcatbleTo = loginAppcatbleTo;
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

	public int getExInt3() {
		return exInt3;
	}

	public void setExInt3(int exInt3) {
		this.exInt3 = exInt3;
	}

	public float getExFloat1() {
		return exFloat1;
	}

	public void setExFloat1(float exFloat1) {
		this.exFloat1 = exFloat1;
	}

	public float getExFloat2() {
		return exFloat2;
	}

	public void setExFloat2(float exFloat2) {
		this.exFloat2 = exFloat2;
	}

	public float getExFloat3() {
		return exFloat3;
	}

	public void setExFloat3(float exFloat3) {
		this.exFloat3 = exFloat3;
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

	public String getExVar3() {
		return exVar3;
	}

	public void setExVar3(String exVar3) {
		this.exVar3 = exVar3;
	}

	public String getExVar4() {
		return exVar4;
	}

	public void setExVar4(String exVar4) {
		this.exVar4 = exVar4;
	}

	@Override
	public String toString() {
		return "UserType [userTypeId=" + userTypeId + ", userTypeName=" + userTypeName + ", userTypeDesc="
				+ userTypeDesc + ", isActive=" + isActive + ", delStatus=" + delStatus + ", comapnyIdRequired="
				+ comapnyIdRequired + ", loginAppcatbleTo=" + loginAppcatbleTo + ", exInt1=" + exInt1 + ", exInt2="
				+ exInt2 + ", exInt3=" + exInt3 + ", exFloat1=" + exFloat1 + ", exFloat2=" + exFloat2 + ", exFloat3="
				+ exFloat3 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3 + ", exVar4=" + exVar4
				+ "]";
	}

	
	
}
