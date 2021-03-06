package com.ats.ckweb.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "m_customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cust_id")
	private int custId;

	@Column(name = "cust_name")
	private String custName;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "whatsapp_no")
	private String whatsappNo;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "profile_pic")
	private String profilePic;

	@Column(name = "gender")
	private int gender;

	@Column(name = "cust_dob")
	private String custDob;

	@Column(name = "age_group")
	private String ageGroup;

	@Column(name = "lang_id")
	private int langId;

	@Column(name = "comp_id")
	private int compId;

	@Column(name = "city_id")
	private int cityId;

	@Column(name = "fr_id")
	private int frId;

	@Column(name = "is_buiss_head")
	private int isBuissHead;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "gst_no")
	private String gstNo;

	@Column(name = "address")
	private String address;

	@Column(name = "is_active")
	private int isActive;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "cust_add_platform")
	private int custAddPlatform;

	@Column(name = "cust_add_datetime")
	private String custAddDatetime;

	@Column(name = "added_from_type")
	private int addedFormType;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "is_premium_cust")
	private int isPremiumCust;

	@Column(name = "ex_int1")
	private int exInt1;

	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "ex_int3")
	private int exInt3;

	@Column(name = "ex_int4")
	private int exInt4;

	@Column(name = "ex_int5")
	private int exInt5;

	@Column(name = "ex_var1")
	private String exVar1;

	@Column(name = "ex_var2")
	private String exVar2;

	@Column(name = "ex_var3")
	private String exVar3;

	@Column(name = "ex_var4")
	private String exVar4;

	@Column(name = "ex_var5")
	private String exVar5;

	@Column(name = "ex_float1")
	private float exFloat1;

	@Column(name = "ex_float2")
	private float exFloat2;

	@Column(name = "ex_float3")
	private float exFloat3;

	@Column(name = "ex_float4")
	private float exFloat4;

	@Column(name = "ex_float5")
	private float exFloat5;

	@Transient
	private boolean error;

	@Transient
	private String message;

	@Transient
	private String langName;
	
	
	
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Customer(int custId, String custName, String phoneNumber, String whatsappNo, String emailId,
			 int gender, String custDob, String ageGroup, int langId, int compId, int cityId,
			int frId, int isBuissHead, String companyName, String gstNo, String address, int isActive, int delStatus,
			int custAddPlatform, String custAddDatetime, int addedFormType, int userId, int isPremiumCust, int exInt1,
			int exInt2, int exInt3, int exInt4, int exInt5, String exVar1, String exVar2, String exVar3, String exVar4,
			String exVar5, float exFloat1, float exFloat2, float exFloat3, float exFloat4, float exFloat5) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.phoneNumber = phoneNumber;
		this.whatsappNo = whatsappNo;
		this.emailId = emailId;
		this.gender = gender;
		this.custDob = custDob;
		this.ageGroup = ageGroup;
		this.langId = langId;
		this.compId = compId;
		this.cityId = cityId;
		this.frId = frId;
		this.isBuissHead = isBuissHead;
		this.companyName = companyName;
		this.gstNo = gstNo;
		this.address = address;
		this.isActive = isActive;
		this.delStatus = delStatus;
		this.custAddPlatform = custAddPlatform;
		this.custAddDatetime = custAddDatetime;
		this.addedFormType = addedFormType;
		this.userId = userId;
		this.isPremiumCust = isPremiumCust;
		this.exInt1 = exInt1;
		this.exInt2 = exInt2;
		this.exInt3 = exInt3;
		this.exInt4 = exInt4;
		this.exInt5 = exInt5;
		this.exVar1 = exVar1;
		this.exVar2 = exVar2;
		this.exVar3 = exVar3;
		this.exVar4 = exVar4;
		this.exVar5 = exVar5;
		this.exFloat1 = exFloat1;
		this.exFloat2 = exFloat2;
		this.exFloat3 = exFloat3;
		this.exFloat4 = exFloat4;
		this.exFloat5 = exFloat5;
	}




	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getCustDob() {
		return custDob;
	}

	public void setCustDob(String custDob) {
		this.custDob = custDob;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getIsBuissHead() {
		return isBuissHead;
	}

	public void setIsBuissHead(int isBuissHead) {
		this.isBuissHead = isBuissHead;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getCustAddPlatform() {
		return custAddPlatform;
	}

	public void setCustAddPlatform(int custAddPlatform) {
		this.custAddPlatform = custAddPlatform;
	}

	public String getCustAddDatetime() {
		return custAddDatetime;
	}

	public void setCustAddDatetime(String custAddDatetime) {
		this.custAddDatetime = custAddDatetime;
	}

	public int getAddedFormType() {
		return addedFormType;
	}

	public void setAddedFormType(int addedFormType) {
		this.addedFormType = addedFormType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getIsPremiumCust() {
		return isPremiumCust;
	}

	public void setIsPremiumCust(int isPremiumCust) {
		this.isPremiumCust = isPremiumCust;
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

	public int getExInt4() {
		return exInt4;
	}

	public void setExInt4(int exInt4) {
		this.exInt4 = exInt4;
	}

	public int getExInt5() {
		return exInt5;
	}

	public void setExInt5(int exInt5) {
		this.exInt5 = exInt5;
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

	public String getExVar5() {
		return exVar5;
	}

	public void setExVar5(String exVar5) {
		this.exVar5 = exVar5;
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

	public float getExFloat4() {
		return exFloat4;
	}

	public void setExFloat4(float exFloat4) {
		this.exFloat4 = exFloat4;
	}

	public float getExFloat5() {
		return exFloat5;
	}

	public void setExFloat5(float exFloat5) {
		this.exFloat5 = exFloat5;
	}

	public String getWhatsappNo() {
		return whatsappNo;
	}

	public void setWhatsappNo(String whatsappNo) {
		this.whatsappNo = whatsappNo;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLangName() {
		return langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", phoneNumber=" + phoneNumber
				+ ", whatsappNo=" + whatsappNo + ", emailId=" + emailId + ", profilePic=" + profilePic + ", gender="
				+ gender + ", custDob=" + custDob + ", ageGroup=" + ageGroup + ", langId=" + langId + ", compId="
				+ compId + ", cityId=" + cityId + ", frId=" + frId + ", isBuissHead=" + isBuissHead + ", companyName="
				+ companyName + ", gstNo=" + gstNo + ", address=" + address + ", isActive=" + isActive + ", delStatus="
				+ delStatus + ", custAddPlatform=" + custAddPlatform + ", custAddDatetime=" + custAddDatetime
				+ ", addedFormType=" + addedFormType + ", userId=" + userId + ", isPremiumCust=" + isPremiumCust
				+ ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exInt3=" + exInt3 + ", exInt4=" + exInt4
				+ ", exInt5=" + exInt5 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3
				+ ", exVar4=" + exVar4 + ", exVar5=" + exVar5 + ", exFloat1=" + exFloat1 + ", exFloat2=" + exFloat2
				+ ", exFloat3=" + exFloat3 + ", exFloat4=" + exFloat4 + ", exFloat5=" + exFloat5 + ", error=" + error
				+ ", message=" + message + ", langName=" + langName + "]";
	}

}
