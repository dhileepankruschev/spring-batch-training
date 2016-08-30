package com.tkhts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tkhts.dao.AccountDao;

@Service
public class PaymentService {

	@Autowired
	AccountDao accountDao;
	@Transactional
	public void fundsTransfer(Integer fromAccountId, Integer toAccountId, Double amount) throws Exception{
		
		accountDao.debitAccount(fromAccountId, amount);
		accountDao.creditAccount(toAccountId, amount);
	}
}
