package com.ats.ckweb.apicontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.model.Wallet;
import com.ats.ckweb.report.repo.WalletRepo;

@RestController
public class WalletController {

	@Autowired WalletRepo walletRepo;
	
	@RequestMapping(value = { "/saveWallet" }, method = RequestMethod.POST)
	public @ResponseBody Wallet saveWallet(@RequestBody Wallet wallet) {
		Wallet res = walletRepo.save(wallet);
		return res;
	}
	
	
}
