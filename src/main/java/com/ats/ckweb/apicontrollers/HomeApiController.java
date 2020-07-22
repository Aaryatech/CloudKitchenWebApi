package com.ats.ckweb.apicontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.model.LoginResponse;
import com.ats.ckweb.services.UserService;

@RestController
public class HomeApiController {
	
	@Autowired private UserService userService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	@ResponseBody
	public LoginResponse loginUser(@RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("type") int type) {

		LoginResponse loginResponse = userService.findUserByUsername(username, password, type);

		return loginResponse;

	}
}
