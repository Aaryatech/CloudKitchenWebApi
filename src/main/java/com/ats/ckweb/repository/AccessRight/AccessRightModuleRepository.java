package com.ats.ckweb.repository.AccessRight;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.ckweb.model.AccessRightModule;

public interface AccessRightModuleRepository extends JpaRepository<AccessRightModule,String>{

	
	
	//List<AccessRightModule> findByDelStatus(int delStatus);

	
	@Query(value=" SELECT * FROM mn_module_ckadmin WHERE "
			+ "del_status =0 ORDER BY order_by ASC;"
			+ "",nativeQuery=true)
	List<AccessRightModule> getModule();
	/*List<AccessRightModule> findAllByDelStatus(int delStatus);
	OrderByLevelDesc()*/
	
}
