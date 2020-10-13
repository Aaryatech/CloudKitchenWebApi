package com.ats.ckweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.ckweb.model.SettingsUpdateModel;

public interface SettingsUpdateModelRepo extends JpaRepository<SettingsUpdateModel, Integer> {

	@Query(value="SELECT\r\n" + 
			"    setting_id,\r\n" + 
			"    'Company Share Percent' AS title,\r\n" + 
			"    setting_key,\r\n" + 
			"    setting_value1\r\n" + 
			"FROM\r\n" + 
			"    t_setting_new\r\n" + 
			"WHERE\r\n" + 
			"    setting_id = 6\r\n" + 
			"UNION\r\n" + 
			"SELECT\r\n" + 
			"    setting_id,\r\n" + 
			"    'Franchisee Share Percent' AS title,\r\n" + 
			"    setting_key,\r\n" + 
			"    setting_value1\r\n" + 
			"FROM\r\n" + 
			"    t_setting_new\r\n" + 
			"WHERE\r\n" + 
			"    setting_id = 7\r\n" + 
			"UNION\r\n" + 
			"SELECT\r\n" + 
			"    setting_id,\r\n" + 
			"    'Wallet Apply On Amount Limit' AS title,\r\n" + 
			"    setting_key,\r\n" + 
			"    setting_value1\r\n" + 
			"FROM\r\n" + 
			"    t_setting_new\r\n" + 
			"WHERE\r\n" + 
			"    setting_id = 8\r\n" + 
			"UNION\r\n" + 
			"SELECT\r\n" + 
			"    setting_id,\r\n" + 
			"    'Wallet Apply Percent' AS title,\r\n" + 
			"    setting_key,\r\n" + 
			"    setting_value1\r\n" + 
			"FROM\r\n" + 
			"    t_setting_new\r\n" + 
			"WHERE\r\n" + 
			"    setting_id = 9\r\n" + 
			"UNION\r\n" + 
			"SELECT\r\n" + 
			"    setting_id,\r\n" + 
			"    'Wallet Apply Amount' AS title,\r\n" + 
			"    setting_key,\r\n" + 
			"    setting_value1\r\n" + 
			"FROM\r\n" + 
			"    t_setting_new\r\n" + 
			"WHERE\r\n" + 
			"    setting_id = 10\r\n" + 
			"UNION\r\n" + 
			"SELECT\r\n" + 
			"    setting_id,\r\n" + 
			"    'Cloud Kitchen Minimun Order Amount' AS title,\r\n" + 
			"    setting_key,\r\n" + 
			"    setting_value1\r\n" + 
			"FROM\r\n" + 
			"    t_setting_new\r\n" + 
			"WHERE\r\n" + 
			"    setting_id = 22\r\n" + 
			"UNION\r\n" + 
			"SELECT\r\n" + 
			"    setting_id,\r\n" + 
			"    'Cloud Kitchen Free Delivery Minimun Order Amount' AS title,\r\n" + 
			"    setting_key,\r\n" + 
			"    setting_value1\r\n" + 
			"FROM\r\n" + 
			"    t_setting_new\r\n" + 
			"WHERE\r\n" + 
			"    setting_id = 23\r\n"+
			"UNION\r\n" + 
			"SELECT\r\n" + 
			"    setting_id,\r\n" + 
			"    'Text on Bill Print' AS title,\r\n" + 
			"    setting_key,\r\n" + 
			"    setting_value1\r\n" + 
			"FROM\r\n" + 
			"    t_setting_new\r\n" + 
			"WHERE\r\n" + 
			"    setting_id = 28", nativeQuery=true)
	List<SettingsUpdateModel> settingsList();

}
