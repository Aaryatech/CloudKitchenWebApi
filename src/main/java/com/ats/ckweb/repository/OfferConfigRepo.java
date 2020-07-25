package com.ats.ckweb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.OfferConfig;

public interface OfferConfigRepo extends JpaRepository<OfferConfig, Integer> {

	OfferConfig findByDelStatusAndOfferConfigId(int del, int configId);
	
	OfferConfig findByOfferIdAndDelStatus(int frOffer, int del);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mn_offer_config SET del_status=1 WHERE offer_config_id=:frOfferConfigId",nativeQuery=true)
	public int deleteOfferConfigurationById(@Param("frOfferConfigId")  int frOfferConfigId);

	@Transactional
	@Modifying
	@Query(value="UPDATE mn_offer_config SET fr_id=:frIdStr, maker_user_id=:userId, updated_date_time=:updtTime WHERE offer_id=:frOffer",nativeQuery=true)
	int updateFrOfferConfig(String frIdStr, int frOffer, String updtTime, int userId);
}
