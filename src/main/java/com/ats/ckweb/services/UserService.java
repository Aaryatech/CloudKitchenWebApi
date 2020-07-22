package com.ats.ckweb.services;

import com.ats.ckweb.model.LoginResponse;

public interface UserService {

	public LoginResponse findUserByUsername(String username,String password, int type);

	
}
