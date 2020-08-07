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
	@Query(value="UPDATE `mn_agent` SET del_status=1 WHERE agent_id=:agentId",nativeQuery=true)
	public int deleteAgent(@Param("agentId") int agentId);
	
	Agent findByMobileNoAndDelStatus(String mobile, int del);
}
