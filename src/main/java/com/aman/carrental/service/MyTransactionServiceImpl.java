package com.aman.carrental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aman.carrental.dao.TransactionRepository;
import com.aman.carrental.pojo.Transaction;

@Service
public class MyTransactionServiceImpl implements MyTransactionService{

	@Autowired
	private TransactionRepository transactionRepo;
	
	@Override
	public void saveTransaction(Transaction transaction) {
		transactionRepo.save(transaction);

	}

	@Override
	public List<Transaction> getTransactionByUserId(int uid) {
		// TODO Auto-generated method stub
		return transactionRepo.getTransactionByUserId(uid);
	}
}
