package com.ats.ckweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ckweb.model.Company;
import com.ats.ckweb.repository.CompanyRepo;

@Service
public class CompanyServiceImpl implements CompanyServices{
	@Autowired CompanyRepo compRepo;
	
	

	@Override
	public Company getMnCompanyById(int compId) {
		Company comp = compRepo.findByCompanyIdAndDelStatus(compId, 0);
		return comp;
	}

	@Override
	public int deleteMnCompanyById(int compId) {
		int comp = compRepo.deleteCompanyById(compId);
		return comp;
	}

	@Override
	public Company insertNewCompany(Company company) {
		Company addComp = compRepo.save(company);
		return addComp;
	}

	@Override
	public List<Company> getAllCompany() {
		List<Company> comp = compRepo.findByDelStatus(0);
		return comp;
	}

	@Override
	public List<Company> getAllMnCompanyDetaisList() {		
		List<Company> comp = compRepo.getAllCompaniesDetails();
		return comp;
	}

}
