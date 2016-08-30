package com.tkhts.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tkhts.entity.Account;

@Repository
public class AccountDao {
	@PersistenceContext
	private EntityManager em;

	public void creditAccount(Integer accountId, Double amount) throws Exception {
		Account account = em.find(Account.class,accountId);
		System.out.println(account);
		Double currentBalance = account.getBalance();
		Double changedBalance = currentBalance + amount;
		account.setBalance(changedBalance);
		
		if(amount < 100){
			throw new RuntimeException("Required minimum 100");
		}
		
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void debitAccount(Integer accountId, Double amount) {
		Account account = em.find(Account.class,accountId);
		System.out.println(account);
		Double currentBalance = account.getBalance();
		Double changedBalance = currentBalance - amount;
		account.setBalance(changedBalance);
	}
	@Transactional
	public void createAccount(Account account){
		em.persist(account);
	}

}
