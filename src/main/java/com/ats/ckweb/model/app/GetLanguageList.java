package com.ats.ckweb.model.app;

import java.util.List;

import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.Language;

public class GetLanguageList {

	List<Language> langList;
	Info info;

	public List<Language> getLangList() {
		return langList;
	}

	public void setLangList(List<Language> langList) {
		this.langList = langList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetLanguageList [langList=" + langList + ", info=" + info + "]";
	}

}
