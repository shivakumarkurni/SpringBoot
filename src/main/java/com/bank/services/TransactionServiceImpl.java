package com.bank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountRepository accountRepo;

	@Autowired
	AccountService accountService;


	@Override
	public String fundTransfer(Transaction transaction) {

		Account fromAccount = accountService.getUserAccount(transaction.getFromAccount());
		Account toAccount= accountService.getUserAccount(transaction.getToAccount());
		if(fromAccount.getBalance()>=transaction.getTransactionAmount()) {
		double debAmt = fromAccount.getBalance() - transaction.getTransactionAmount();
		double creditAmt = toAccount.getBalance() + transaction.getTransactionAmount();
		
		fromAccount.setBalance(debAmt);
		toAccount.setBalance(creditAmt);
		if(accountRepo.save(fromAccount)!=null &&
				accountRepo.save(toAccount)!=null) {

			Transaction updateDebitTransaction = new Transaction();

			updateDebitTransaction.setDescription(transaction.getDescription());
			updateDebitTransaction.setFromAccount(transaction.getFromAccount());
			updateDebitTransaction.setTransactionAmount(transaction.getTransactionAmount());
			updateDebitTransaction.setTransactionType("Debit");
			updateDebitTransaction.setUser(fromAccount.getUser());
			updateDebitTransaction.setToAccount(transaction.getToAccount());

			//credit
			Transaction updateCreditTransaction = new Transaction();
			updateCreditTransaction.setDescription(transaction.getDescription());
			updateCreditTransaction.setFromAccount(transaction.getFromAccount());
			updateCreditTransaction.setTransactionAmount(transaction.getTransactionAmount());
			updateCreditTransaction.setTransactionType("Credit");
			updateCreditTransaction.setUser(toAccount.getUser());
			updateCreditTransaction.setToAccount(transaction.getToAccount());


			//Account account = accountRepo.findById(fromAccount.getAccountId()).get();
			fromAccount.getUser().getUserId();
			if(transactionRepository.save(updateDebitTransaction) != null &&
					transactionRepository.save(updateCreditTransaction) != null)
				return "Transaction successful";
			else
				return "Transaction failed";

		}
	
	else {
		return "transaction failed";
	}
	}
		else {
			return "Insufficient balance";
		}

}


	@Override
	public List<Transaction> getTansactionDetails(long id) {
		
		return (List<Transaction>) transactionRepository.getTransactionDetails(id);
	}
}
