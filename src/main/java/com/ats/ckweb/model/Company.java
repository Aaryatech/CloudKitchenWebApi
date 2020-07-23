package com.ats.ckweb.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "mn_company")
public class Company {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "company_id")
	private int companyId;
	
	@Column(name = "company_name")
	private String companyName;

	@Column(name = "company_address")
	private String companyAddress;

	@Column(name = "company_contact_no")
	private String companyContactNo;

	@Column(name = "contact_person_name")
	private String contactPersonName;

	@Column(name = "contact_person_mobile")
	private String contactPersonMobile;

	@Column(name = "contact_person_name1")
	private String contactPersonName1;

	@Column(name = "contact_person_mobile1")
	private String contactPersonMobile1;

	@Column(name = "company_gst_no")
	private String companyGstNo;

	@Column(name = "company_website")
	private String companyWebsite;

	@Column(name = "company_email")
	private String companyEmail;

	@Column(name = "cin_no")
	private String cinNo;

	@Column(name = "reg_date")
	private Date regDate;

	@Column(name = "starting_date")
	private Date startingDate;

	@Column(name = "company_logo")
	private String companyLogo;

	@Column(name = "pan_card")
	private String panCard;

	@Column(name = "city")
	private int city;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "is_used")
	private int isUsed;

	@Column(name = "ex_var1")
	private String exVar1;

	@Column(name = "ex_var2")
	private String exVar2;

	@Column(name = "ex_var3")
	private String exVar3;

	@Column(name = "ex_int1")
	private int exInt1;

	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "ex_int3")
	private int exInt3;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyContactNo() {
		return companyContactNo;
	}

	public void setCompanyContactNo(String companyContactNo) {
		this.companyContactNo = companyContactNo;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPersonMobile() {
		return contactPersonMobile;
	}

	public void setContactPersonMobile(String contactPersonMobile) {
		this.contactPersonMobile = contactPersonMobile;
	}

	public String getContactPersonName1() {
		return contactPersonName1;
	}

	public void setContactPersonName1(String contactPersonName1) {
		this.contactPersonName1 = contactPersonName1;
	}

	public String getContactPersonMobile1() {
		return contactPersonMobile1;
	}

	public void setContactPersonMobile1(String contactPersonMobile1) {
		this.contactPersonMobile1 = contactPersonMobile1;
	}

	public String getCompanyGstNo() {
		return companyGstNo;
	}

	public void setCompanyGstNo(String companyGstNo) {
		this.companyGstNo = companyGstNo;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	
	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public String getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
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

	@Override
	public String toString() {
		return "Comapny [companyId=" + companyId + ", companyName=" + companyName + ", companyAddress=" + companyAddress
				+ ", companyContactNo=" + companyContactNo + ", contactPersonName=" + contactPersonName
				+ ", contactPersonMobile=" + contactPersonMobile + ", contactPersonName1=" + contactPersonName1
				+ ", contactPersonMobile1=" + contactPersonMobile1 + ", companyGstNo=" + companyGstNo
				+ ", companyWebsite=" + companyWebsite + ", companyEmail=" + companyEmail + ", cinNo=" + cinNo
				+ ", regDate=" + regDate + ", startingDate=" + startingDate + ", companyLogo=" + companyLogo
				+ ", panCard=" + panCard + ", city=" + city + ", delStatus=" + delStatus + ", isUsed=" + isUsed
				+ ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3 + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exInt3=" + exInt3 + "]";
	}
	
	
}
