package com.bank.services;

import org.springframework.stereotype.Service;

import com.bank.model.User;

@Service
public interface UserServices {

	public String createUser(User user);
	
	
	
}
