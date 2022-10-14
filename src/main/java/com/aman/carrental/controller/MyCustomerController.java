package com.aman.carrental.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aman.carrental.dao.CustomerRepository;
import com.aman.carrental.pojo.User;
import com.aman.carrental.service.MyCustomerService;

@RestController
@RequestMapping("/api")
public class MyCustomerController {

	@Autowired
	private MyCustomerService mycustomerService;
	
	@Autowired
	CustomerRepository customerDAO;

	@GetMapping("/showUser")
	public ResponseEntity<Object>  listCustomers(HttpSession session) {
		List<User> theCustomers = mycustomerService.getCustomers();
		return new ResponseEntity<>(theCustomers,HttpStatus.OK);
	}

	
	@PostMapping("/saveCustomer")
	public ResponseEntity<Object> saveCustomer(@RequestBody User theCustomer, HttpSession session) {
		System.out.println("theCustomer");
		System.out.println(theCustomer);
		mycustomerService.saveCustomer(theCustomer);
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/user/{uid}")
	public ResponseEntity<Object> getUser(@PathVariable("uid") int uid, HttpSession session) {
		
		User theCustomer = mycustomerService.getCustomer(uid);
		return new ResponseEntity<>(theCustomer,HttpStatus.OK);
	}

	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable("uid") int theId) {
		mycustomerService.deleteCustomer(theId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> loginIn(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {

		if (email.length() == 0 || password.length() == 0) 
			return new ResponseEntity<>(HttpStatus.PRECONDITION_REQUIRED);
			
		User user = mycustomerService.login(email, password);
		
		if (user != null) {
			user.setPassword(null);
			session.setAttribute("user", user);
			return new ResponseEntity<>(user,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping("/user/blockUser/{uid}")
	public ResponseEntity<Object> blockUser(@PathVariable("uid") int uid,HttpSession session) {
		mycustomerService.blockUser(uid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/user/unblockUser/{uid}")
	public ResponseEntity<Object> unblockUser(@PathVariable("uid") int uid,HttpSession session) {
		mycustomerService.unblockUser(uid);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	@GetMapping("/logout")
	public ResponseEntity<Object> logout(HttpSession session) {
		session.removeAttribute("user");
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

}
