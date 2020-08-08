package com.ats.ckweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.Agent;

public interface AgentRepo extends JpaRepository<Agent, Integer> {

	List<Agent> findByCompanyIdAndDelStatusOrderByAgentIdDesc(int compId, int del);

	Agent findByAgentIdAndCompanyIdAndDelStatus(int agentId, int compId, int del);

	@Transactional
	@Modifying
	@Query(value = "UPDATE `mn_agent` SET del_status=1 WHERE agent_id=:agentId", nativeQuery = true)
	public int deleteAgent(@Param("agentId") int agentId);

	Agent findByMobileNoAndDelStatus(String mobile, int del);

	@Query(value = "select * from mn_agent where del_status=0 and is_active=0 and FIND_IN_SET(:cityId,mn_agent.area_ids) and FIND_IN_SET(:shopId,mn_agent.franchise_id)", nativeQuery = true)
	List<Agent> getAgetListByShopId(@Param("cityId")int cityId, @Param("shopId")int shopId);
}
