package com.ats.ckweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.MnUser;

public interface MnUserRepo extends JpaRepository<MnUser, Integer> {

	@Query(value="SELECT\n" + 
			"    user.user_id,\n" + 
			"    user.user_name,\n" + 
			"    user.user_mobile_no,\n" + 
			"    user.user_address,\n" + 
			"    user.user_email,\n" + 
			"    user.reg_date,\n" + 
			"    user.profile_pic,\n" + 
			"    user.password,\n" + 
			"    user.company_Id,\n" + 
			"    user.designation_id,\n" + 
			"    user.user_type,\n" + 
			"    user.del_status,\n" + 
			"    user.is_active,\n" + 
			"    user.ex_int1,\n" + 
			"    user.ex_int2,\n" + 
			"    user.ex_int3,\n" + 
			"    user.ex_int4,\n" + 
			"    user.ex_float1,\n" + 
			"    user.ex_float2,\n" + 
			"    user.ex_float3,\n" + 
			"    user.ex_var1,\n" + 
			"    user.ex_var2,\n" + 
			"    type.user_type_name AS ex_var3,\n" + 
			"    desig.designation AS ex_var4\n" + 
			"FROM\n" + 
			"     mn_user user,\n" + 
			"     mn_user_type type,\n" + 
			"     mn_designation desig\n" + 
			"WHERE\n" + 
			"	user.company_Id=:compId AND\n" + 
			"    user.del_status=0 AND\n" + 
			"    type.del_status=0 AND\n" + 
			"    desig.del_status=0 AND\n" + 
			"    user.user_type=type.user_type_id AND\n" + 
			"    user.designation_id=desig.designation_id\n" + 
			"    ORDER BY user.user_id DESC",nativeQuery=true)
	List<MnUser> findByAllCompanyId(@Param("compId") int compId);
	
	MnUser findByUserIdAndDelStatusAndCompanyId(int userId, int del, int compId);
	
	MnUser findByUserMobileNoAndDelStatus(String mobNo, int del);
	
	MnUser findByUserMobileNoAndDelStatusAndUserIdNot(String mobNo, int del, int userId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mn_user SET del_status=1 WHERE user_id=:userId",nativeQuery=true)
	public int deleteUserById(@Param("userId") int userId);
	
	@Query(value="SELECT\n" + 
			"        * \n" + 
			"    FROM\n" + 
			"        mn_user \n" + 
			"    WHERE\n" + 
			"        user_mobile_no = :username\n" + 
			"        AND PASSWORD = :password\n" + 
			"        AND del_status = 0 \n" + 
			"        AND is_active = 0 \n" + 
			"        AND user_type IN(\n" + 
			"            SELECT\n" + 
			"                user_type_id     \n" + 
			"            FROM\n" + 
			"                mn_user_type     \n" + 
			"            WHERE\n" + 
			"                ex_int1 IN (0,2))", nativeQuery=true)
	public MnUser getUserCradentials(@Param("username") String username, @Param("password") String password);
}
