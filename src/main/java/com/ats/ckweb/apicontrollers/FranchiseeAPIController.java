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

import com.ats.ckweb.model.FrConfig;
import com.ats.ckweb.model.GetFrConfigList;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.services.CompanyServices;

@RestController
public class FranchiseeAPIController {
	
	@Autowired CompanyServices companyService;
	
	 @RequestMapping(value = { "/saveFrConfig" }, method = RequestMethod.POST)
		public @ResponseBody FrConfig saveFrConfig(@RequestBody FrConfig frConfig){
			
		 FrConfig config = new FrConfig();
			try {
				config = companyService.insertFrConfiguration(frConfig);
			}catch (Exception e) {
				e.printStackTrace();
			}
			return config;
		}
	 
	 
	 @RequestMapping(value = { "/getFrConfigById" }, method = RequestMethod.POST)
		public @ResponseBody FrConfig getFrConfigById(@RequestParam int configId){
			
		 FrConfig config = new FrConfig();
			try {
				config = companyService.gerFrConfiguration(configId);
			}catch (Exception e) {
				e.printStackTrace();
			}
			return config;
		}
	 
	 @RequestMapping(value = { "/deleteFrConfigurationById" }, method = RequestMethod.POST)
		public @ResponseBody Info deleteFrConfigurationById(@RequestParam int configId){
			
			Info info = new Info();
			try {
				int res = companyService.deletConfiguratnById(configId);
				if(res>0) {
					info.setError(false);
					info.setMessage("Franchise Configuration Deleted Successfully");
				}else {
					info.setError(true);
					info.setMessage("Failed to Delete Franchise Configuration");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return info;		
		}
	 
	 @RequestMapping(value = { "/getAllFrConfigList" }, method = RequestMethod.GET)
		public @ResponseBody List<GetFrConfigList> getFrConfigList(){
			
			List<GetFrConfigList> list = new ArrayList<GetFrConfigList>();
			
			try {
				list = companyService.getAllFrConfigList();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
}
