package com.ats.ckweb.apicontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.commons.Common;
import com.ats.ckweb.commons.EmailUtility;
import com.ats.ckweb.model.ErrorMessage;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.model.LoginResponse;
import com.ats.ckweb.model.MnUser;
import com.ats.ckweb.model.OTPVerification;
import com.ats.ckweb.services.UserService;

@RestController
public class FrontLoginApiController {

	@Autowired
	private UserService userService;

	
	String senderEmail = "atsinfosoft@gmail.com";
	String senderPassword = "atsinfosoft@123";
	static String mailsubject = "";
	String otp1 = null;
	
	@RequestMapping(value = { "/forgotPassword" }, method = RequestMethod.POST)
	@ResponseBody
	public LoginResponse forgotPassword(@RequestParam("username") String username, @RequestParam("type") int type) {
	
		OTPVerification.setConNumber(null);
		OTPVerification.setEmailId(null);
		OTPVerification.setOtp(null);
		OTPVerification.setPass(null);
		Info info = new Info();
		

		LoginResponse loginResponse = userService.forgotPassword(username, type);
		MnUser user = loginResponse.getUser();
		if(user!= null) {
			OTPVerification.setUserId(user.getUserId());
			
			String emailId = user.getUserEmail();
			String conNumber = user.getUserMobileNo();
			System.err.println("User conNumber CK----------"+conNumber);
			char[] otp = Common.OTP(6);
			otp1 = String.valueOf(otp);
			System.err.println("User otp is CK: " + otp1);
			
			Info inf = EmailUtility.sendOtp(otp1, conNumber);
			
			 mailsubject = " OTP  Verification ";
			 String text = "\n OTP for change your Password: ";
			Info emailRes = EmailUtility.sendEmail(senderEmail, senderPassword,emailId, mailsubject,
					text, otp1);

		
			OTPVerification.setConNumber(conNumber);
			OTPVerification.setEmailId(emailId);
			OTPVerification.setOtp(otp1);
			OTPVerification.setPass(user.getPassword());
		}else {
			System.err.println("In Else ");

			info.setError(true);
			info.setMessage("not Matched");
			System.err.println(" not Matched ");
		}

		return loginResponse;

	}
	
	@RequestMapping(value = { "/updatePassword" }, method = RequestMethod.POST)
	@ResponseBody
	public ErrorMessage updatePassword(@RequestParam("username") String username, @RequestParam("userId") int userId) {

		ErrorMessage loginResponse = userService.updatePassword(username, userId);

		return loginResponse;

	}

}
