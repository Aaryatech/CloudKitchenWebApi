package com.ats.ckweb.apicontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.model.Franchisee;
import com.ats.ckweb.repository.FranchiseeRepository;

@RestController
public class ReportApiController {
	@Autowired FranchiseeRepository frRepo;
	
	/*
	 * @RequestMapping(value = { "/getAllFranchise" }, method = RequestMethod.GET)
	 * public @ResponseBody List<Franchisee> getAllFranchise() {
	 * 
	 * List<Franchisee> franchisee = null;
	 * 
	 * franchisee = frRepo.findAllFranchisee();
	 * 
	 * if (franchisee == null) { franchisee = new ArrayList<Franchisee>(); } return
	 * franchisee; }
	 */
}
