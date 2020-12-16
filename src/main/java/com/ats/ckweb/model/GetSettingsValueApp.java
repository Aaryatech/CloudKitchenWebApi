package com.ats.ckweb.model;

public class GetSettingsValueApp {

	NewSetting newSetting;
	Info info;

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
		return "GetSettingsValueApp [newSetting=" + newSetting + ", info=" + info + "]";
	}

}
