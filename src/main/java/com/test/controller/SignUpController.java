package com.test.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.DimManager;
import com.test.service.signUpService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping(value = "/signUp/**")
public class SignUpController {

	@Autowired
	signUpService signUpService;

	public static final String SALT = "mayank";

	@GetMapping(value = "/checkEmailDuplication/{emailid}")
	public String checkEmailDuplication(@PathVariable(value = "emailid") String emailid) {
		return signUpService.checkEmailDuplication(emailid.toLowerCase());
	}

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public int register(@RequestBody DimManager manager) {

		manager.setEmail(manager.getEmail().toLowerCase());
		if (manager.getPassword() != null && manager.getPassword() != "") {
			String saltedPassword = SALT + manager.getPassword();
			String hashedPassword = generateHash(saltedPassword);
			manager.setPassword(hashedPassword);
		}
		int status = signUpService.register(manager);
		if (status == 1) {
			return 1;
		} else {
			return 0;
		}

	}

//	@ResponseBody
//	@RequestMapping(value = "/savePasswordAndSignIn", method = RequestMethod.POST)
//	public int savePasswordAndSignIn(@RequestBody ConfirmPassword confirmPassword) {
//
//		if (confirmPassword.getUserName() != null) {
//			confirmPassword.setUserName(confirmPassword.getUserName().toLowerCase());
//		}
//		return signUpService.savePasswordAndSignIn(confirmPassword);
//
//	}

//	@ResponseBody
//	@RequestMapping(value = "/confirmCustomerDetail", method = RequestMethod.POST)
//	public long confirmCustomerDetail(@RequestBody UserDetails userDetails) {
//		if (userDetails.getUserName() != null) {
//			userDetails.setUserName(userDetails.getUserName().toLowerCase());
//		}
//		return signUpService.confirmCustomerDetail(userDetails);
//	}

	public static String generateHash(String input) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("MD5");
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			// handle error here.
		}

		return hash.toString();
	}

}
