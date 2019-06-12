package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.model.User;
import com.bank.services.AccountService;
import com.bank.services.TransactionService;
import com.bank.services.UserServices;

@RestController
public class BankController {

	@Autowired
	UserServices userService;

	@Autowired
	AccountService accountService;

	@Autowired
	TransactionService transactionService;

	@PostMapping(value = "/createUser")
	public String createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@GetMapping("/getUserAccDetails/{id}")
	public Account getUserAccDetails(@PathVariable("id") long id) {

		return accountService.displayAccountDetails(id);

	}

	@PostMapping("/transfer")
	public String fundTransfer(@RequestBody Transaction transaction) {

		return transactionService.fundTransfer(transaction);

	}
	 
	@GetMapping("/transactionDetails/{id}")
	public List<Transaction> getTransactionDetailsById(@PathVariable("id") long id) {
		
		return transactionService.getTansactionDetails(id);
		
		
	}

}
