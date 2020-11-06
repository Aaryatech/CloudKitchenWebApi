package com.ats.ckweb.model.app;

import java.util.List;

import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.NotificationApp;

public class NotificationResponse {

	private List<NotificationApp> notification;
	private Info info;

	public List<NotificationApp> getNotification() {
		return notification;
	}

	public void setNotification(List<NotificationApp> notification) {
		this.notification = notification;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "NotificationResponse [notification=" + notification + ", info=" + info + "]";
	}

}
