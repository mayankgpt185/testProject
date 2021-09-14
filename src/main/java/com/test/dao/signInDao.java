package com.test.dao;

import com.test.model.DimManager;

public interface signInDao {

	public DimManager signIn(String email, String pass);

	public DimManager loadUserByUsername(String email);
}
