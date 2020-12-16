package com.ats.ckweb.repository.AccessRight;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ats.ckweb.model.GetUser;



public interface GetUserRepo extends CrudRepository<GetUser, Integer>{
	
	@Query(value = " SELECT\n" + 
			"    b.*,\n" + 
			"    IFNULL(c.role_name, 'NA') AS role_name\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        mn_user.user_id,\n" + 
			"        mn_user.user_name,\n" + 
			"        mn_user.user_mobile_no,\n" + 
			"        mn_user.user_email,\n" + 
			"        mn_user.ex_int1 as role_id\n" + 
			"    FROM\n" + 
			"        mn_user\n" + 
			"    WHERE\n" + 
			"        mn_user.del_status = 0\n" + 
			") b\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT mn_assign_role_ckadmin.role_id,\n" + 
			"        mn_assign_role_ckadmin.role_name\n" + 
			"    FROM\n" + 
			"        mn_assign_role_ckadmin\n" + 
			") c\n" + 
			"ON\n" + 
			"    b.role_id = c.role_id\n" + 
			"ORDER BY\n" + 
			"    b.role_id,\n" + 
			"    b.user_name ASC", nativeQuery = true)
	List<GetUser> getUserListForAssignRole();

}
