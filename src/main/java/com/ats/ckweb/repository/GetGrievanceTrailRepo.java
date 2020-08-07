package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.GetGrievanceTrail;

public interface GetGrievanceTrailRepo extends JpaRepository<GetGrievanceTrail, Integer> {
	
	
	//Sachin 2020-08-07
	//Desc- To Show Grievance Trail  List at Admin end by grieveId .
	
	@Query(value="SELECT t_grievences_trail.trail_id,t_grievences_trail.grievences_id,t_grievences_trail.remark,t_grievences_trail.status,\n" + 
			"t_grievences_trail.action_by_user_id,t_grievences_trail.action_date_time,t_grievences_trail.extra_var1,t_grievences_trail.extra_var2,t_grievences_trail.identified_root_cause,t_grievences_trail.grievence_res_type,t_grievences_trail.resolution_detail,t_grievences_trail.repay_amt,t_grievences_trail.repay_details,t_grievences_trail.griv_action_value,t_grievences_trail.griv_action_text,\n" + 
			"COALESCE((user_data.user_name ),'na' ) as action_by_user_name\n" + 
			"\n" + 
			"FROM t_grievences_trail \n" + 
			"LEFT JOIN  mn_user user_data on t_grievences_trail.action_by_user_id=user_data.user_id\n" + 
			"WHERE t_grievences_trail.grievences_id=:grieveId",nativeQuery=true)
	
	List<GetGrievanceTrail> getGrievanceTrailListByGrievencesId(@Param("grieveId") int grieveId );

}
