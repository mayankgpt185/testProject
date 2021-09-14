package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.signInDao;

@Service
public class signInServiceImpl implements signInService {

	@Autowired
	signInDao signInDao;

	@Override
	public int signIn(String email, String pass) {
		// System.out.println("service");
		return signInDao.signIn(email, pass);
	}
}