package com.ats.ckweb.model;

public class LoginResponse {
	MnUser user;
	ErrorMessage errorMessage;
	public MnUser getUser() {
		return user;
	}
	public void setUser(MnUser user) {
		this.user = user;
	}
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "LoginResponse [user=" + user + ", errorMessage=" + errorMessage + "]";
	}

}
