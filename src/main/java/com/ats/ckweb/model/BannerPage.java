package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banner_home_page")
public class BannerPage {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bannerId;
	private String bannerEventName;
	private String bannerImage;
	private int sortNo;
	private String frIds;
	private String tagIds;
	private int compId;
	private int insertUserId;
	private int updateUserId;

	private String insertDateTime;
	private String updateDateTime;;
	private String captionOnproductPage;

	private int isActive;
	private int delStatus;
 
	private int exInt1;
	private int exInt2;
	private int exInt3;
	private String exVar1;
	private String exVar2;
	private String exVar3;
	public int getBannerId() {
		return bannerId;
	}
	public String getBannerEventName() {
		return bannerEventName;
	}
	public String getBannerImage() {
		return bannerImage;
	}
	public int getSortNo() {
		return sortNo;
	}
	public String getFrIds() {
		return frIds;
	}
	public String getTagIds() {
		return tagIds;
	}
	public int getCompId() {
		return compId;
	}
	public int getInsertUserId() {
		return insertUserId;
	}
	public int getUpdateUserId() {
		return updateUserId;
	}
	public String getInsertDateTime() {
		return insertDateTime;
	}
	public String getUpdateDateTime() {
		return updateDateTime;
	}
	public String getCaptionOnproductPage() {
		return captionOnproductPage;
	}
	public int getIsActive() {
		return isActive;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public int getExInt1() {
		return exInt1;
	}
	public int getExInt2() {
		return exInt2;
	}
	public int getExInt3() {
		return exInt3;
	}
	public String getExVar1() {
		return exVar1;
	}
	public String getExVar2() {
		return exVar2;
	}
	public String getExVar3() {
		return exVar3;
	}
	public void setBannerId(int bannerId) {
		this.bannerId = bannerId;
	}
	public void setBannerEventName(String bannerEventName) {
		this.bannerEventName = bannerEventName;
	}
	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}
	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}
	public void setFrIds(String frIds) {
		this.frIds = frIds;
	}
	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}
	public void setCompId(int compId) {
		this.compId = compId;
	}
	public void setInsertUserId(int insertUserId) {
		this.insertUserId = insertUserId;
	}
	public void setUpdateUserId(int updateUserId) {
		this.updateUserId = updateUserId;
	}
	public void setInsertDateTime(String insertDateTime) {
		this.insertDateTime = insertDateTime;
	}
	public void setUpdateDateTime(String updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	public void setCaptionOnproductPage(String captionOnproductPage) {
		this.captionOnproductPage = captionOnproductPage;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}
	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}
	public void setExInt3(int exInt3) {
		this.exInt3 = exInt3;
	}
	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}
	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}
	public void setExVar3(String exVar3) {
		this.exVar3 = exVar3;
	}
	@Override
	public String toString() {
		return "BannerPage [bannerId=" + bannerId + ", bannerEventName=" + bannerEventName + ", bannerImage="
				+ bannerImage + ", sortNo=" + sortNo + ", frIds=" + frIds + ", tagIds=" + tagIds + ", compId=" + compId
				+ ", insertUserId=" + insertUserId + ", updateUserId=" + updateUserId + ", insertDateTime="
				+ insertDateTime + ", updateDateTime=" + updateDateTime + ", captionOnproductPage="
				+ captionOnproductPage + ", isActive=" + isActive + ", delStatus=" + delStatus + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exInt3=" + exInt3 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2
				+ ", exVar3=" + exVar3 + "]";
	}
	
	
	
	
	
	
	
	
	

}
