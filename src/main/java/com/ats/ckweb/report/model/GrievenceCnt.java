package com.ats.ckweb.report.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GrievenceCnt {
	
	@Id
	private String id;
	
	private int totalCnt;
	private float totalAmt;
	
	private int pendingCnt;
	private float pendingAmt;
	
	private int resolvedCnt;
	private float resolvedAmt;
	
	private int damagedCnt;
	private float damagedAmt;
	
	private int settledCnt;
	private float settledAmt;
	
	private int unSettledCnt;
	private float unSettledAmt;	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public float getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}
	public int getPendingCnt() {
		return pendingCnt;
	}
	public void setPendingCnt(int pendingCnt) {
		this.pendingCnt = pendingCnt;
	}
	public float getPendingAmt() {
		return pendingAmt;
	}
	public void setPendingAmt(float pendingAmt) {
		this.pendingAmt = pendingAmt;
	}
	public int getResolvedCnt() {
		return resolvedCnt;
	}
	public void setResolvedCnt(int resolvedCnt) {
		this.resolvedCnt = resolvedCnt;
	}
	public float getResolvedAmt() {
		return resolvedAmt;
	}
	public void setResolvedAmt(float resolvedAmt) {
		this.resolvedAmt = resolvedAmt;
	}
	public int getDamagedCnt() {
		return damagedCnt;
	}
	public void setDamagedCnt(int damagedCnt) {
		this.damagedCnt = damagedCnt;
	}
	public float getDamagedAmt() {
		return damagedAmt;
	}
	public void setDamagedAmt(float damagedAmt) {
		this.damagedAmt = damagedAmt;
	}
	public int getSettledCnt() {
		return settledCnt;
	}
	public void setSettledCnt(int settledCnt) {
		this.settledCnt = settledCnt;
	}
	public float getSettledAmt() {
		return settledAmt;
	}
	public void setSettledAmt(float settledAmt) {
		this.settledAmt = settledAmt;
	}
	public int getUnSettledCnt() {
		return unSettledCnt;
	}
	public void setUnSettledCnt(int unSettledCnt) {
		this.unSettledCnt = unSettledCnt;
	}
	public float getUnSettledAmt() {
		return unSettledAmt;
	}
	public void setUnSettledAmt(float unSettledAmt) {
		this.unSettledAmt = unSettledAmt;
	}
	@Override
	public String toString() {
		return "GrievenceCnt [id=" + id + ", totalCnt=" + totalCnt + ", totalAmt=" + totalAmt + ", pendingCnt="
				+ pendingCnt + ", pendingAmt=" + pendingAmt + ", resolvedCnt=" + resolvedCnt + ", resolvedAmt="
				+ resolvedAmt + ", damagedCnt=" + damagedCnt + ", damagedAmt=" + damagedAmt + ", settledCnt="
				+ settledCnt + ", settledAmt=" + settledAmt + ", unSettledCnt=" + unSettledCnt + ", unSettledAmt="
				+ unSettledAmt + "]";
	}

}
