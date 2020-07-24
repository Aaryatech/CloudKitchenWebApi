package com.ats.ckweb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.ckweb.model.Company;
import com.ats.ckweb.model.FrConfig;
import com.ats.ckweb.model.GetFrConfigList;
@Service
public interface CompanyServices {

	List<Company> getAllCompany();

	Company getMnCompanyById(int compId);

	int deleteMnCompanyById(int compId);

	Company insertNewCompany(Company company);

	List<Company> getAllMnCompanyDetaisList();

	FrConfig insertFrConfiguration(FrConfig frConfig);

	FrConfig gerFrConfiguration(int configId);

	int deletConfiguratnById(int configId);

	List<GetFrConfigList> getAllFrConfigList();

}
