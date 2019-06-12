package com.bank.services;

import org.springframework.stereotype.Service;

import com.bank.model.Account;

@Service
public interface AccountService {
	
	public Account getUserAccount(long fromAccount);
	
	public Account displayAccountDetails(long userId);

}
