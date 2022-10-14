package com.aman.carrental.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aman.carrental.pojo.Transaction;
import com.aman.carrental.service.MyTransactionService;
import com.aman.carrental.util.Calculator;


@RestController
@RequestMapping("/api")
public class MyTransactionController {
	
	@Autowired
	private MyTransactionService mytransactionService;
	
	@PostMapping("/saveTransaction")
	public ResponseEntity<Object> saveTransaction(@RequestBody Transaction transaction) {
		Calculator cc=(int x,int y)->x*y;
		int total=cc.chargeCalc(transaction.getBooking().getCar().getChargePerKm(),transaction.getBooking().getTotalDistance());
		transaction.setTotalCharge(total);
		mytransactionService.saveTransaction(transaction);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/allTransactions/{uid}")
	public ResponseEntity<Object> listTransactions(@PathVariable("uid") int uid,Model theModel, HttpSession session) {
		List<Transaction> transaction = mytransactionService.getTransactionByUserId(uid);
		return new ResponseEntity<>(transaction, HttpStatus.OK);
	}
}
