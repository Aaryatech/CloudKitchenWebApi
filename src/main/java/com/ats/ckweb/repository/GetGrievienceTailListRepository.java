package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.GetGrievienceTailList;

public interface GetGrievienceTailListRepository extends JpaRepository<GetGrievienceTailList, Integer>{

	@Query(value = "select gt.*,\n" + 
			"case \n" + 
			"            when(gt.action_by_user_id!=0) then (select\n" + 
			"                concat(u.user_name,\n" + 
			"                ' (',\n" + 
			"                ut.user_type_name,\n" + 
			"                ')') \n" + 
			"            from\n" + 
			"                mn_user u,\n" + 
			"                mn_user_type ut \n" + 
			"            where\n" + 
			"                u.user_id=gt.action_by_user_id \n" + 
			"                and ut.user_type_id=u.user_type) \n" + 
			"             \n" + 
			"            else (select\n" + 
			"                concat(c.cust_name,\n" + 
			"                ' (Customer)') \n" + 
			"            from\n" + 
			"                m_customer c  \n" + 
			"            where\n" + 
			"                c.cust_id=gt.action_by_user_id )  \n" + 
			"        end as action_user_name \n" + 
			"        from t_grievences_trail gt ,t_grievences gr where gr.grieve_id=gt.grievences_id and gr.grieve_id=:grvId", nativeQuery = true)
	List<GetGrievienceTailList> getGriviencevDetailByGrvId(@Param("grvId")  int grvId);

}
