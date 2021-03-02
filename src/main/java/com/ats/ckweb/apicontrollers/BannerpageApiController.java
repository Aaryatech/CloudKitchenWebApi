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

import com.ats.ckweb.model.BannerPage;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.repository.BannerPageRepo;

@RestController
public class BannerpageApiController {

	@Autowired
	BannerPageRepo bannerPageRepo;

	/*--------------------------------------------------------------------------------*/
	// Created By :- Akhilesh Dani
	// Created On :- 2020-12-21
	// Modified By :- NAf
	// Modified On :- NA
	// Description :- saveBanner
	@RequestMapping(value = { "/saveBanner" }, method = RequestMethod.POST)
	public @ResponseBody BannerPage saveBanner(@RequestBody BannerPage subCat) {

		BannerPage addBanner = new BannerPage();
		try {
			addBanner = bannerPageRepo.save(subCat);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addBanner;

	}

	/*--------------------------------------------------------------------------------*/
	// Created By :- Akhilesh Dani
	// Created On :- 2020-12-21
	// Modified By :- NA
	// Modified On :- NA
	// Description :- Get Banner

	@RequestMapping(value = { "/getBannerById" }, method = RequestMethod.POST)
	public @ResponseBody BannerPage getBannerById(@RequestParam int bannerId) {

		BannerPage banner = new BannerPage();
		try {
			banner = bannerPageRepo.findByBannerId(bannerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return banner;

	}

	/*--------------------------------------------------------------------------------*/
	// Created By :- Akhilesh Dani
	// Created On :- 2020-12-21
	// Modified By :- NA
	// Modified On :- NA
	// Description :- getAllBannerByCompId
	@RequestMapping(value = { "/getAllBannerByCompId" }, method = RequestMethod.POST)
	public @ResponseBody List<BannerPage> getAllBannerByCompId(@RequestParam int compId) {

		List<BannerPage> list = new ArrayList<BannerPage>();
		try {
			list = bannerPageRepo.findByCompIdAndDelStatusOrderByBannerIdDesc(compId, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	/*--------------------------------------------------------------------------------*/
	// Created By :- Akhilesh Dani
	// Created On :- 2020-12-21
	// Modified By :- NA
	// Modified On :- NA
	// Description :- Delete Banner

	@RequestMapping(value = { "/deleteBannerById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteBannerById(@RequestParam int bannerId, @RequestParam int userId,
			@RequestParam String dateTime) {

		Info info = new Info();
		try {
			int res = bannerPageRepo.deleteBanner(bannerId, userId, dateTime);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Banner Deleted Successfully");
			} else {
				info.setError(true);
				info.setMessage("Failed to Delete Banner");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	// Created By :- Mahendra Singh
	// Created On :- 2020-12-22
	// Modified By :- NA
	// Modified On :- NA
	// Description :- getAllActiveBannerByCompId
	@RequestMapping(value = { "/getAllActiveBannerByCompId" }, method = RequestMethod.POST)
	public @ResponseBody List<BannerPage> getAllActiveBannerByCompId(@RequestParam int compId) {

		List<BannerPage> list = new ArrayList<BannerPage>();
		try {
			list = bannerPageRepo.findByIsActiveAndDelStatusAndCompIdOrderByBannerIdDesc(1, 0, compId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
