package com.test.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.dao.signInDao;
import com.test.model.DimManager;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	signInDao signInDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		DimManager user = signInDao.loadUserByUsername(username);
		if (user.getEmail().equals(username)) {
			return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

	}

}
