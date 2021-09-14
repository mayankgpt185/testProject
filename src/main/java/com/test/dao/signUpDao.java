package com.test.dao;

import com.test.model.DimManager;

public interface signUpDao {

	int register(DimManager manager);

	String checkEmailDuplication(String emailId);
}
