package com.ats.ckweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ckweb.model.ErrorMessage;
import com.ats.ckweb.model.LoginResponse;
import com.ats.ckweb.model.MnUser;
import com.ats.ckweb.repository.MnUserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private MnUserRepo userRepository;
	
	String jsonUser = "{}";
	MnUser user = null;
	com.ats.ckweb.model.ErrorMessage errorMessage;

	@Override
	public LoginResponse findUserByUsername(String username, String password) {

		String dbUsername = null;
		String dbPassword = null;
        LoginResponse loginResponse=null;
		try {
			user = userRepository.getUserCradentials(username, password);
			dbUsername = user.getUserMobileNo();
			dbPassword = user.getPassword();
		} catch (Exception e) {
			loginResponse=new LoginResponse();
            errorMessage=new ErrorMessage();
			errorMessage.setError(true);
			errorMessage.setMessage("User is not registered");
			
			loginResponse.setErrorMessage(errorMessage);
			loginResponse.setUser(user);
			
		
		}
		try {
			if (user == null || username == null||username.equalsIgnoreCase("")) {
				
				loginResponse=new LoginResponse();

				errorMessage=new ErrorMessage();
				errorMessage.setError(true);
				errorMessage.setMessage("User is not registered");
				
				loginResponse.setErrorMessage(errorMessage);
				loginResponse.setUser(user);
				
			} else if (password == null||password.equalsIgnoreCase("")) {
				
				loginResponse=new LoginResponse();
	            errorMessage=new ErrorMessage();

				errorMessage.setError(true);
				errorMessage.setMessage("Please enter Password");
				loginResponse.setErrorMessage(errorMessage);
				loginResponse.setUser(user);

			} else if (dbUsername.equals(username) && dbPassword.equals(password)) {
				
				loginResponse=new LoginResponse();
	            errorMessage=new ErrorMessage();

				errorMessage.setError(false);
				errorMessage.setMessage("User Logged in Successfully");
				loginResponse.setErrorMessage(errorMessage);
				loginResponse.setUser(user);

			} else if (dbUsername.equals(username) && dbPassword != password) {
				
				loginResponse=new LoginResponse();
	            errorMessage=new ErrorMessage();

				errorMessage.setError(true);
				errorMessage.setMessage("Invalid Password");
				loginResponse.setErrorMessage(errorMessage);
				loginResponse.setUser(user);

			}
		} catch (Exception e) {

			loginResponse=new LoginResponse();
            errorMessage=new ErrorMessage();

			errorMessage.setError(true);
			errorMessage.setMessage("User is not registered");
			loginResponse.setErrorMessage(errorMessage);
			loginResponse.setUser(user);

		}
		return loginResponse;

	}
	
	
	/********************************************************************************/
	

	
	
}
