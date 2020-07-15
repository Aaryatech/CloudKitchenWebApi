package com.ats.ckweb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mn_tags")
public class Tags implements Serializable {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		
		@Column(name="tag_id")
		private int  tagId;
		
		@Column(name="tag_name")
		private String  tagName;
		
		@Column(name="tag_desc")
		private String  tagDesc;
		
		@Column(name="tag_is_active")
		private int  tagIsActive;
		
		@Column(name="tag_delete_status	")
		private int  tagDeleteStatus;
		
		@Column(name="tag_sort_number")
		private float  tagSortNumber;
		
		@Column(name="ex_int1")
		private int  exInt1;
		
		@Column(name="ex_int2")
		private int  exInt2;
		
		@Column(name="ex_var1")
		private String  exVar1;
		
		@Column(name="ex_var2")
		private String  exVar2;

		public int getTagId() {
			return tagId;
		}

		public void setTagId(int tagId) {
			this.tagId = tagId;
		}

		public String getTagName() {
			return tagName;
		}

		public void setTagName(String tagName) {
			this.tagName = tagName;
		}

		public String getTagDesc() {
			return tagDesc;
		}

		public void setTagDesc(String tagDesc) {
			this.tagDesc = tagDesc;
		}

		public int getTagIsActive() {
			return tagIsActive;
		}

		public void setTagIsActive(int tagIsActive) {
			this.tagIsActive = tagIsActive;
		}

		public int getTagDeleteStatus() {
			return tagDeleteStatus;
		}

		public void setTagDeleteStatus(int tagDeleteStatus) {
			this.tagDeleteStatus = tagDeleteStatus;
		}

		public float getTagSortNumber() {
			return tagSortNumber;
		}

		public void setTagSortNumber(float tagSortNumber) {
			this.tagSortNumber = tagSortNumber;
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
			return "Tags [tagId=" + tagId + ", tagName=" + tagName + ", tagDesc=" + tagDesc + ", tagIsActive="
					+ tagIsActive + ", tagDeleteStatus=" + tagDeleteStatus + ", tagSortNumber=" + tagSortNumber
					+ ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
		}

}
