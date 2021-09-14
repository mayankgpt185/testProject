package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.signUpDao;
import com.test.model.DimManager;

@Service
public class signUpServiceImpl implements signUpService {

	@Autowired
	signUpDao signUpDao;

	@Override
	public int register(DimManager manager) {

		int regSuccess = signUpDao.register(manager);
		if (regSuccess == 1) {
			return 1;
		} else {
			return 0;
		}

	}

	@Override
	public String checkEmailDuplication(String emailId) {
		// TODO Auto-generated method stub
		return signUpDao.checkEmailDuplication(emailId);
	}

}
