package com.bank.services;

import java.util.List;

import com.bank.model.Transaction;

public interface TransactionService {

	public String fundTransfer(Transaction transaction);

	public List<Transaction> getTansactionDetails(long id);


}
