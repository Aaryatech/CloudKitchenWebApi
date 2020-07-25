package com.ats.ckweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ckweb.model.Company;
import com.ats.ckweb.model.FrConfig;
import com.ats.ckweb.model.GetConfigureOfferList;
import com.ats.ckweb.model.GetFrConfigList;
import com.ats.ckweb.model.OfferHeader;
import com.ats.ckweb.repository.CompanyRepo;
import com.ats.ckweb.repository.FrConfigRepo;
import com.ats.ckweb.repository.GetConfigureOfferListRepo;
import com.ats.ckweb.repository.GetFrConfigListRepo;
import com.ats.ckweb.repository.ItemRepository;
import com.ats.ckweb.repository.OfferHeaderRepo;

@Service
public class CompanyServiceImpl implements CompanyServices{
	@Autowired CompanyRepo compRepo;
	
	@Autowired FrConfigRepo frConfigRepo;
	
	@Autowired GetFrConfigListRepo frConfigListRepo;
	
	@Autowired ItemRepository itemRepository;
	
	@Autowired OfferHeaderRepo offerHeadRepo;
	
	@Autowired GetConfigureOfferListRepo configureFrOfferList;

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

	@Override
	public FrConfig insertFrConfiguration(FrConfig frConfig) {
		FrConfig config = frConfigRepo.save(frConfig);
		return config;
	}

	@Override
	public FrConfig gerFrConfiguration(int configId) {
		FrConfig config = frConfigRepo.findBydelStatusAndFrConfigId(0, configId);
		return config;
	}

	@Override
	public int deletConfiguratnById(int configId) {
		int config = frConfigRepo.deleteConfigurationById(configId);
		return config;
	}

	@Override
	public List<GetFrConfigList> getAllFrConfigList() {
		List<GetFrConfigList> list = frConfigListRepo.getAllFrConfigList();
		return list;
	}

	@Override
	public List<Company> getAllActiveCompanyList() {
		List<Company> list = compRepo.findByDelStatusAndIsUsed(0, 0);
		return list;
	}

	@Override
	public List<OfferHeader> getFrOfferConfigList(int compId) {
		List<OfferHeader> offerList = offerHeadRepo.findByCompIdAndDelStatusOrderByOfferIdDesc(compId, 0);
		return offerList;
	}

	@Override
	public List<GetConfigureOfferList> getConfigureOfferListById(int offerId) {
		List<GetConfigureOfferList> list = configureFrOfferList.getConfigureOferList(offerId);
		return list;
	}

}
