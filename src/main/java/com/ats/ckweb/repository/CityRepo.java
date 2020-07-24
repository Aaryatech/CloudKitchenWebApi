package com.ats.ckweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.City;
import java.lang.String;

public interface CityRepo extends JpaRepository<City, Integer> {

	List<City> findByDelStatusAndIsActiveOrderByCityIdDesc(int del, int i);
	
	City findByCityCodeIgnoreCase(String cityCode);
	
	City findByCityCodeIgnoreCaseAndCityIdNot(String cityCode, int cityId);
	
	City findByCityId(int cityId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mn_city SET del_status=1 WHERE city_id=:cityId",nativeQuery=true)
	public int deleteCity(@Param("cityId") int cityId);
}
