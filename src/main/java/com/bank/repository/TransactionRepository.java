package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query(value="select * from onlinetransaction.transaction where user_user_id = ?1",nativeQuery = true)
	public List<Transaction> getTransactionDetails(long id);

}
