package com.aman.carrental.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aman.carrental.pojo.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	@Query("FROM Transaction WHERE uid = ?1")
    List<Transaction> getTransactionByUserId(int uid);
}
