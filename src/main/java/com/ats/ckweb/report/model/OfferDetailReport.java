package com.ats.ckweb.report.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OfferDetailReport {

	@Id
	private int sellBillNo;
	private String invoiceNo;
	private String billDate;
	private String custName;
	private String custPhone;
	private float grandTotal;
	private float discountAmt;
	private float deliveryAmt;
	private float walletAmt;
	private float payableAmt;

	public int getSellBillNo() {
		return sellBillNo;
	}

	public void setSellBillNo(int sellBillNo) {
		this.sellBillNo = sellBillNo;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public float getDiscountAmt() {
		return discountAmt;
	}

	public void setDiscountAmt(float discountAmt) {
		this.discountAmt = discountAmt;
	}

	public float getDeliveryAmt() {
		return deliveryAmt;
	}

	public void setDeliveryAmt(float deliveryAmt) {
		this.deliveryAmt = deliveryAmt;
	}

	public float getWalletAmt() {
		return walletAmt;
	}

	public void setWalletAmt(float walletAmt) {
		this.walletAmt = walletAmt;
	}

	public float getPayableAmt() {
		return payableAmt;
	}

	public void setPayableAmt(float payableAmt) {
		this.payableAmt = payableAmt;
	}

	@Override
	public String toString() {
		return "OfferDetailReport [sellBillNo=" + sellBillNo + ", invoiceNo=" + invoiceNo + ", billDate=" + billDate
				+ ", custName=" + custName + ", custPhone=" + custPhone + ", grandTotal=" + grandTotal
				+ ", discountAmt=" + discountAmt + ", deliveryAmt=" + deliveryAmt + ", walletAmt=" + walletAmt
				+ ", payableAmt=" + payableAmt + "]";
	}


}
