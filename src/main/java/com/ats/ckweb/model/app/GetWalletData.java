package com.ats.ckweb.model.app;

import java.util.List;

import com.ats.ckweb.model.CustWalletTransaction;
import com.ats.ckweb.model.Info;

public class GetWalletData {

	List<CustWalletTransaction> walletTransaction;
	Info info;

	public List<CustWalletTransaction> getWalletTransaction() {
		return walletTransaction;
	}

	public void setWalletTransaction(List<CustWalletTransaction> walletTransaction) {
		this.walletTransaction = walletTransaction;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetWalletData [walletTransaction=" + walletTransaction + ", info=" + info + "]";
	}

}
