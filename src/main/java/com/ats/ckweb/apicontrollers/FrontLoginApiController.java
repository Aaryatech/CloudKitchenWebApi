package com.ats.ckweb.apicontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.model.ErrorMessage;
import com.ats.ckweb.model.LoginResponse;
import com.ats.ckweb.services.UserService;

@RestController
public class FrontLoginApiController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/forgotPassword" }, method = RequestMethod.POST)
	@ResponseBody
	public LoginResponse forgotPassword(@RequestParam("username") String username, @RequestParam("type") int type) {

		LoginResponse loginResponse = userService.forgotPassword(username, type);

		return loginResponse;

	}
	
	@RequestMapping(value = { "/updatePassword" }, method = RequestMethod.POST)
	@ResponseBody
	public ErrorMessage updatePassword(@RequestParam("username") String username, @RequestParam("userId") int userId) {

		ErrorMessage loginResponse = userService.updatePassword(username, userId);

		return loginResponse;

	}

}
