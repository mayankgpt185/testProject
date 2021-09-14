package com.test.service;

import com.test.model.DimManager;

public interface signUpService {

	int register(DimManager manager);

	String checkEmailDuplication(String emailId);
}
