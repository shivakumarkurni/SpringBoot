package com.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.User;
import com.bank.repository.UserRepository;


//@Transactional
@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public String createUser(User user) {
		userRepo.save(user);
		return "user created successfully";
	}
}
