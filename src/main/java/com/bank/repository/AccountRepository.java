package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	@Query(value = "select * from onlinetransaction.account where user_user_id = ?1",nativeQuery = true)
	public Account displayUserDetails(long userId);
	
	@Query("select a from Account a where a.accountId=?1")
	public Account getUserAccount(long fromAccount);

}
