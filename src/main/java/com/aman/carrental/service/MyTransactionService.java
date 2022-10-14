package com.aman.carrental.service;

import java.util.List;

import com.aman.carrental.pojo.Transaction;


public interface MyTransactionService {

	public void saveTransaction(Transaction transaction);

	public List<Transaction> getTransactionByUserId(int uid);
}
