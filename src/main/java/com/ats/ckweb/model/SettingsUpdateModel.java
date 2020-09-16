package com.ats.ckweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SettingsUpdateModel {

	@Id
	private int settingId;
	private String title;
	private String settingKey;
	private String settingValue1;

	public int getSettingId() {
		return settingId;
	}

	public void setSettingId(int settingId) {
		this.settingId = settingId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSettingKey() {
		return settingKey;
	}

	public void setSettingKey(String settingKey) {
		this.settingKey = settingKey;
	}

	public String getSettingValue1() {
		return settingValue1;
	}

	public void setSettingValue1(String settingValue1) {
		this.settingValue1 = settingValue1;
	}

	@Override
	public String toString() {
		return "SettingsUpdateModel [settingId=" + settingId + ", title=" + title + ", settingKey=" + settingKey
				+ ", settingValue1=" + settingValue1 + "]";
	}

}
