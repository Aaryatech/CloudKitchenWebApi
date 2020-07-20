package com.ats.ckweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.ckweb.model.Language;

public interface LanguageRepo extends JpaRepository<Language, Integer> {

	List<Language> findByDelStatusOrderByLangIdDesc(int del);

	Language findByLangCode(String langCode);
	
	Language findByLangCodeAndLangIdNot(String langCode, int langId);
	
	Language findByLangIdAndDelStatus(int langId, int del);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mn_language SET del_status = 1 WHERE lang_id=:langId",nativeQuery=true)
	public int deleteLanguage(@Param("langId") int langId);
}
