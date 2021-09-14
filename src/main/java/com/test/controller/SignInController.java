package com.test.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.jwt.JwtTokenUtil;
import com.test.jwt.JwtUserDetailsService;
import com.test.model.DimManager;
import com.test.model.JwtResponse;
import com.test.service.signInService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping(value = "/signIn")
public class SignInController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;
	@Autowired
	signInService loginService;

	public static final String SALT = "mayank";

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody DimManager userDetails) throws Exception {
		String pass = generateHash(SALT + userDetails.getPassword());
		int cust = loginService.signIn(userDetails.getEmail().toLowerCase(), pass);
		if (cust == 1) {
			final String token = jwtTokenUtil.generateToken(userDetails);
//		cust.setTokenNo(token);
			return ResponseEntity.ok(cust);
		} else {
			return ResponseEntity.ok(new JwtResponse("Invalid"));
		}
	}

//	@RequestMapping(value = "/signin")
//	public int signIn(@RequestBody DimManager manager) {
//		String pass = generateHash(SALT + manager.getPassword());
//		int cust = loginService.signIn(manager.getEmail(), pass);
//		if (cust == 1) {
//			return 1;
//		} else {
//			return 0;
//		}
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
