package com.ats.ckweb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.ckweb.model.Company;
import com.ats.ckweb.model.FrConfig;
import com.ats.ckweb.model.GetConfigureOfferList;
import com.ats.ckweb.model.GetFrConfigList;
import com.ats.ckweb.model.GetOfferFrConfiguredList;
import com.ats.ckweb.model.Item;
import com.ats.ckweb.model.OfferConfig;
import com.ats.ckweb.model.OfferHeader;
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

	List<Company> getAllActiveCompanyList();

	List<OfferHeader> getFrOfferConfigList(int compId);

	List<GetConfigureOfferList> getConfigureOfferListById(int offerId);

	OfferConfig getConfigureFrOfferDetailById(int offerId);

	OfferConfig insertFrOfferConfig(OfferConfig offer);

	List<GetOfferFrConfiguredList> getOfferFrConfiguredList();

	int udateFrOfferConfig(String frIdStr, int offerId, String updtTime, int userId);

	int deleteFrOfferConfig(int frOfferConfigId);

	List<Item> getAllProductItems();

	List<Item> getAllProductItemsById(int itemId);

}
