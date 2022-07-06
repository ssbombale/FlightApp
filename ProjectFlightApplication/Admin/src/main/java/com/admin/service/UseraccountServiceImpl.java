package com.admin.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.admin.entity.Useraccount;

@Service
public class UseraccountServiceImpl implements UserDetailsService {

	@Autowired
	private IUseraccountRepostiory useraccountRepostiory;

	@Override
	public UserDetails loadUserByUsername(String username) {
		Useraccount user = useraccountRepostiory.findByUserName(username);
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				new ArrayList<>());
	}
	
	
	public Useraccount getUseraccountByUsername(String username) {
		return useraccountRepostiory.findByUserName(username);
		
	}

}
