package com.ats.ckweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ckweb.model.Company;
import com.ats.ckweb.model.ConfigRelatedProduct;
import com.ats.ckweb.model.FrConfig;
import com.ats.ckweb.model.GetConfigureOfferList;
import com.ats.ckweb.model.GetFrConfigList;
import com.ats.ckweb.model.GetOfferFrConfiguredList;
import com.ats.ckweb.model.GetProductRelatedList;
import com.ats.ckweb.model.Item;
import com.ats.ckweb.model.OfferConfig;
import com.ats.ckweb.model.OfferHeader;
import com.ats.ckweb.repository.CompanyRepo;
import com.ats.ckweb.repository.ConfigRelatedProductRepo;
import com.ats.ckweb.repository.FrConfigRepo;
import com.ats.ckweb.repository.GetConfigureOfferListRepo;
import com.ats.ckweb.repository.GetFrConfigListRepo;
import com.ats.ckweb.repository.GetOfferFrConfiguredListRepo;
import com.ats.ckweb.repository.GetProductRelatedListRepo;
import com.ats.ckweb.repository.ItemRepository;
import com.ats.ckweb.repository.OfferConfigRepo;
import com.ats.ckweb.repository.OfferHeaderRepo;

@Service
public class CompanyServiceImpl implements CompanyServices{
	@Autowired CompanyRepo compRepo;
	
	@Autowired FrConfigRepo frConfigRepo;
	
	@Autowired GetFrConfigListRepo frConfigListRepo;
	
	@Autowired ItemRepository itemRepository;
	
	@Autowired OfferHeaderRepo offerHeadRepo;
	
	@Autowired GetConfigureOfferListRepo configureFrOfferList;
	
	@Autowired OfferConfigRepo frOfferConfig;
	
	@Autowired GetOfferFrConfiguredListRepo configFrOfferListRepo;
	
	@Autowired ItemRepository itemRepo;
	
	@Autowired ConfigRelatedProductRepo configProductRepo;
	
	@Autowired GetProductRelatedListRepo getRelatedProductListRepo;

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

	@Override
	public OfferConfig getConfigureFrOfferDetailById(int offerId) {
		OfferConfig frOffer = frOfferConfig.findByOfferIdAndDelStatus(offerId, 0);
		return frOffer;
	}

	@Override
	public OfferConfig insertFrOfferConfig(OfferConfig offer) {
		OfferConfig frOffer = frOfferConfig.save(offer);
		return frOffer;
	}

	@Override
	public List<GetOfferFrConfiguredList> getOfferFrConfiguredList() {
		List<GetOfferFrConfiguredList> list = configFrOfferListRepo.getConfiguredOfferFrList();
		return list;
	}

	@Override
	public int udateFrOfferConfig(String frIdStr, int offerId, String updtTime, int userId) {
		int res = frOfferConfig.updateFrOfferConfig(frIdStr, offerId, updtTime, userId);
		return res;
	}

	@Override
	public int deleteFrOfferConfig(int frOfferConfigId) {
		int res = frOfferConfig.deleteOfferConfigurationById(frOfferConfigId);
		return res;
	}

	@Override
	public List<Item> getAllProductItems() {
		List<Item> itemList = itemRepo.getAllItems();
		return itemList;
	}

	@Override
	public List<Item> getAllProductItemsById(int itemId) {
		List<Item> itemList = itemRepo.getAllItemsById(itemId);
		return itemList;
	}

	@Override
	public ConfigRelatedProduct getProductById(int itemId) {
		ConfigRelatedProduct item = configProductRepo.findByProductIdAndDelStatus(itemId, 0);
		return item;
	}

	@Override
	public ConfigRelatedProduct insertRelatedProductConfig(ConfigRelatedProduct product) {
		ConfigRelatedProduct res = configProductRepo.save(product);
		return res;
	}

	@Override
	public int udateRelatedProductConfig(String relatedItemIds, int productId, String updateDatTime, int userId) {
		int res = configProductRepo.updateConfigRelateProduct(productId, relatedItemIds, userId, updateDatTime);
		return res;
	}

	@Override
	public int deleteRelProductConfig(int relatedProductId) {
		int res = configProductRepo.deleteRelateProductById(relatedProductId);
		return res;
	}
	
	@Override
	public List<GetProductRelatedList> getAllRelatedProductsByCompId(int compId) {
		List<GetProductRelatedList> list = getRelatedProductListRepo.getAllConfigureRelatedProducts(compId);
		return list;
	}

	

}
