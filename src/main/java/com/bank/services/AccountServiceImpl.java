package com.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepo;
	@Override
	public Account displayAccountDetails(long userId) {

		return accountRepo.displayUserDetails(userId);
	}
	public Account getUserAccount(long account) {

		return accountRepo.getUserAccount(account);
	}
}
