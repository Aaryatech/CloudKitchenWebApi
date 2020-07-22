package com.ats.ckweb.services;

import com.ats.ckweb.model.ErrorMessage;
import com.ats.ckweb.model.LoginResponse;

public interface UserService {

	public LoginResponse findUserByUsername(String username, String password, int type);

	public LoginResponse forgotPassword(String username, int type);

	public ErrorMessage updatePassword(String username, int userId);

}
