package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class CustWalletTotal {

	@Id
	private int custId;
	private float total;
	
	@Transient
	private float walletLimitRs;
	@Transient
	private float walletPercent;
	@Transient
	private float walletMinAmt;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getWalletLimitRs() {
		return walletLimitRs;
	}

	public void setWalletLimitRs(float walletLimitRs) {
		this.walletLimitRs = walletLimitRs;
	}

	public float getWalletPercent() {
		return walletPercent;
	}

	public void setWalletPercent(float walletPercent) {
		this.walletPercent = walletPercent;
	}

	public float getWalletMinAmt() {
		return walletMinAmt;
	}

	public void setWalletMinAmt(float walletMinAmt) {
		this.walletMinAmt = walletMinAmt;
	}

	@Override
	public String toString() {
		return "CustWalletTotal [custId=" + custId + ", total=" + total + ", walletLimitRs=" + walletLimitRs
				+ ", walletPercent=" + walletPercent + ", walletMinAmt=" + walletMinAmt + "]";
	}

}
