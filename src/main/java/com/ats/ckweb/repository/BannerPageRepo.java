package com.ats.ckweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.BannerPage;

public interface BannerPageRepo extends JpaRepository<BannerPage, Integer> {
	
BannerPage findByBannerId(int bannerId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE\n" + 
			"        `banner_home_page` \n" + 
			"    SET\n" + 
			"        del_status=1,\n" + 
			"        update_date_time=:dateTime, \n" + 
			"        update_user_id=:userId\n" + 
			"    WHERE\n" + 
			"        banner_id=:bannerId \n" + 
			"       ",nativeQuery=true)
	int deleteBanner(@Param("bannerId") int bannerId,@Param("userId") int userId,@Param("dateTime") String dateTime);
//UPDATE `banner_home_page` SET del_status=0 WHERE banner_id=:bannerId AND update_date_time=:dateTime AND update_user_id=:userId
	
	
	List<BannerPage> findByCompIdAndDelStatusOrderByBannerIdDesc(int compId, int del);
	
	List<BannerPage> findByIsActiveAndDelStatusAndCompIdOrderByBannerIdDesc(int isActive, int del, int compId);
	
	
	@Query(value="SELECT b.* FROM banner_home_page b WHERE FIND_IN_SET(:frId,b.fr_ids) AND del_status=0 ",nativeQuery=true)
	List<BannerPage> getHomePageBannerList(@Param("frId") int frId);

	

}
