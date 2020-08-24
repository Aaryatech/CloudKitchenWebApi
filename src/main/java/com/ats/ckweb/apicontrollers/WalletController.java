package com.ats.ckweb.apicontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.model.CustWalletTotal;
import com.ats.ckweb.model.CustWalletTransaction;
import com.ats.ckweb.model.FrWiseGrievenceReportData;
import com.ats.ckweb.model.FrWiseOrderReportData;
import com.ats.ckweb.model.Wallet;
import com.ats.ckweb.model.WalletReportData;
import com.ats.ckweb.report.repo.WalletRepo;
import com.ats.ckweb.repository.CustWalletTotalRepo;
import com.ats.ckweb.repository.CustWalletTransactionRepo;
import com.ats.ckweb.repository.FrWiseGrievenceReportDataRepo;
import com.ats.ckweb.repository.FrWiseOrderReportDataRepo;
import com.ats.ckweb.repository.WalletReportDataRepo;

@RestController
public class WalletController {

	@Autowired
	WalletRepo walletRepo;

	@Autowired
	WalletReportDataRepo walletReportDataRepo;

	@Autowired
	CustWalletTotalRepo custWalletTotalRepo;

	@Autowired
	CustWalletTransactionRepo custWalletTransactionRepo;

	@Autowired
	FrWiseOrderReportDataRepo frWiseOrderReportDataRepo;
	
	@Autowired FrWiseGrievenceReportDataRepo frWiseGrievenceReportDataRepo;

	@RequestMapping(value = { "/saveWallet" }, method = RequestMethod.POST)
	public @ResponseBody Wallet saveWallet(@RequestBody Wallet wallet) {
		Wallet res = walletRepo.save(wallet);
		return res;
	}

	@RequestMapping(value = { "/getWalletReportByDateAndCust" }, method = RequestMethod.POST)
	public @ResponseBody List<WalletReportData> getOrderReportDateWise(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam List<Integer> transcType, @RequestParam int custId) {

		List<WalletReportData> res = new ArrayList<WalletReportData>();
		res = walletReportDataRepo.getWalletReportByDateAndCust(fromDate, toDate, transcType, custId);
		return res;
	}

	@RequestMapping(value = { "/getCustWalletTotalAmt" }, method = RequestMethod.POST)
	public @ResponseBody CustWalletTotal getCustWalletTotalAmt(@RequestParam int custId) {

		CustWalletTotal res = new CustWalletTotal();
		res = custWalletTotalRepo.getCustTotalWalletAmt(custId);
		return res;
	}

	@RequestMapping(value = { "/getCustWalletTransc" }, method = RequestMethod.POST)
	public @ResponseBody List<CustWalletTransaction> getCustWalletTransc(@RequestParam int custId) {

		List<CustWalletTransaction> res = new ArrayList<CustWalletTransaction>();
		res = custWalletTransactionRepo.getCustWalletTransc(custId);
		return res;
	}

	@RequestMapping(value = { "/getFrAndDateWiseOrderData" }, method = RequestMethod.POST)
	public @ResponseBody List<FrWiseOrderReportData> getFrAndDateWiseOrderData(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam List<Integer> frIds) {

		List<FrWiseOrderReportData> res = new ArrayList<FrWiseOrderReportData>();
		res = frWiseOrderReportDataRepo.getFrWiseOrderReport(fromDate, toDate, frIds);
		return res;
	}
	
	@RequestMapping(value = { "/getFrWiseGrieveReportData" }, method = RequestMethod.POST)
	public @ResponseBody List<FrWiseGrievenceReportData> getFrWiseGrieveReportData(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam List<Integer> frIds) {

		List<FrWiseGrievenceReportData> res = new ArrayList<FrWiseGrievenceReportData>();
		res = frWiseGrievenceReportDataRepo.getFrWiseGrievanceReport(fromDate, toDate, frIds);
		return res;
	}

}
