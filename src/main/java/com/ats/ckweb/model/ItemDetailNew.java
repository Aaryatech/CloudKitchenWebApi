package com.ats.ckweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mn_detail")
public class ItemDetailNew {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_d_id")
	private int itemDId;

	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_desc")
	private String itemDesc;

	@Column(name = "product_type")
	private int productType;

	@Column(name = "product_status")
	private String productStatus;

	@Column(name = "product_category")
	private int productCategory;

	@Column(name = "product_show_in")
	private int productShowIn;

	@Column(name = "preperation_time")
	private String preperationTime;

	@Column(name = "taste_type_ids")
	private String tasteTypeIds;

	@Column(name = "is_tag_applicable")
	private int isTagApplicable;

	@Column(name = "tag_ids")
	private String tagIds;

	@Column(name = "show_in_order")
	private int showInOrder;

	@Column(name = "is_used")
	private int isUsed;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "ex_int1")
	private int exInt1;

	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "ex_int3")
	private int exInt3;

	@Column(name = "ex_int4")
	private int exInt4;

	@Column(name = "ex_var1")
	private String exVar1;

	@Column(name = "ex_var2")
	private String exVar2;

	@Column(name = "ex_var3")
	private String exVar3;

	@Column(name = "ex_var4")
	private String exVar4;

	@Column(name = "ex_float1")
	private float exFloat1;

	@Column(name = "ex_float2")
	private float exFloat2;

	@Column(name = "ex_float3")
	private float exFloat3;

	@Column(name = "ex_float4")
	private float exFloat4;

	public int getItemDId() {
		return itemDId;
	}

	public void setItemDId(int itemDId) {
		this.itemDId = itemDId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public int getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}

	public int getProductShowIn() {
		return productShowIn;
	}

	public void setProductShowIn(int productShowIn) {
		this.productShowIn = productShowIn;
	}

	public String getPreperationTime() {
		return preperationTime;
	}

	public void setPreperationTime(String preperationTime) {
		this.preperationTime = preperationTime;
	}

	public String getTasteTypeIds() {
		return tasteTypeIds;
	}

	public void setTasteTypeIds(String tasteTypeIds) {
		this.tasteTypeIds = tasteTypeIds;
	}

	public int getIsTagApplicable() {
		return isTagApplicable;
	}

	public void setIsTagApplicable(int isTagApplicable) {
		this.isTagApplicable = isTagApplicable;
	}

	public String getTagIds() {
		return tagIds;
	}

	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}

	public int getShowInOrder() {
		return showInOrder;
	}

	public void setShowInOrder(int showInOrder) {
		this.showInOrder = showInOrder;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
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

	@Override
	public String toString() {
		return "ItemDetailNew [itemDId=" + itemDId + ", itemId=" + itemId + ", itemDesc=" + itemDesc + ", productType="
				+ productType + ", productStatus=" + productStatus + ", productCategory=" + productCategory
				+ ", productShowIn=" + productShowIn + ", preperationTime=" + preperationTime + ", tasteTypeIds="
				+ tasteTypeIds + ", isTagApplicable=" + isTagApplicable + ", tagIds=" + tagIds + ", showInOrder="
				+ showInOrder + ", isUsed=" + isUsed + ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2="
				+ exInt2 + ", exInt3=" + exInt3 + ", exInt4=" + exInt4 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2
				+ ", exVar3=" + exVar3 + ", exVar4=" + exVar4 + ", exFloat1=" + exFloat1 + ", exFloat2=" + exFloat2
				+ ", exFloat3=" + exFloat3 + ", exFloat4=" + exFloat4 + "]";
	}

}
