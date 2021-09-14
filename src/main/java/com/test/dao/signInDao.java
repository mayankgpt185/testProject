package com.test.dao;

import com.test.model.DimManager;

public interface signInDao {

	public int signIn(String email, String pass);

	public DimManager loadUserByUsername(String email);
}
