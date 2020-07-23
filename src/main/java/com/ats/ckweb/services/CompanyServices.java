package com.ats.ckweb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.ckweb.model.Company;
@Service
public interface CompanyServices {

	List<Company> getAllCompany();

	Company getMnCompanyById(int compId);

	int deleteMnCompanyById(int compId);

	Company insertNewCompany(Company company);

	List<Company> getAllMnCompanyDetaisList();

}
