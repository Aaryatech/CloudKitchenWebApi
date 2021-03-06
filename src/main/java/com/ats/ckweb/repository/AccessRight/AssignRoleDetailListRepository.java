package com.ats.ckweb.repository.AccessRight;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.AssignRoleDetailList;

public interface AssignRoleDetailListRepository extends JpaRepository<AssignRoleDetailList, Integer>{

	List<AssignRoleDetailList> findByDelStatus(int delStatus);

	
	@Query(value=" SELECT r.* from mn_assign_role_ckadmin r, mn_user u where u.user_id=:usrId AND r.role_id=u.ex_int1",nativeQuery=true)
	AssignRoleDetailList getRoleJson(@Param("usrId")int usrId);

	@Modifying
	@Transactional
	@Query("Update AssignRoleDetailList  SET del_status=1 WHERE role_id=:roleId")
	int deleteRole(@Param("roleId")int roleId);

	AssignRoleDetailList findByRoleIdAndDelStatus(int roleId,int delStatus);
	
}
