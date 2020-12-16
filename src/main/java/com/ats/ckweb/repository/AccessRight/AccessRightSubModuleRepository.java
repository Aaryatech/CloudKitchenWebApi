package com.ats.ckweb.repository.AccessRight;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.AccessRightSubModule;

public interface AccessRightSubModuleRepository extends JpaRepository<AccessRightSubModule, String>{

	
	
	//List<AccessRightSubModule> findByIsDeleteAndModuleId(int isDelete, int moduleId);

	
	@Query(value=" SELECT * FROM mn_module_sub_ckadmin WHERE "
			+ "is_delete =0 AND module_id=:moduleId ORDER BY order_by ASC;"
			+ "",nativeQuery=true)
	List<AccessRightSubModule> getSubModule(@Param("moduleId")int moduleId);
	
	

}
