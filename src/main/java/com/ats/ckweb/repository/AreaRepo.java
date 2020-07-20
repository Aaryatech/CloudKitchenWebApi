package com.ats.ckweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.Area;
import java.lang.String;

public interface AreaRepo extends JpaRepository<Area, Integer> {

	List<Area> findBydelStatusOrderByAreaIdDesc(int del);
	
	Area findByAreaCodeIgnoreCase(String code);
	
	Area findByAreaCodeIgnoreCaseAndAreaIdNot(String code, int areaId);
	
	Area findByAreaIdAndDelStatus(int areaId, int del);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mn_area SET del_status=1 WHERE area_id=:areaId",nativeQuery=true)
	public int deleteArea(@Param("areaId") int areaId);
}
