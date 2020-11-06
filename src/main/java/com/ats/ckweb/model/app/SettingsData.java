package com.ats.ckweb.model.app;

import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.NewSetting;

public class SettingsData {

	private NewSetting newSetting;
	private Info info;

	public NewSetting getNewSetting() {
		return newSetting;
	}

	public void setNewSetting(NewSetting newSetting) {
		this.newSetting = newSetting;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "SettingsData [newSetting=" + newSetting + ", info=" + info + "]";
	}

}
