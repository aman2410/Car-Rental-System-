package com.aman.carrental.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aman.carrental.dao.CustomerRepository;
import com.aman.carrental.pojo.User;
@Service
public class MyCustomerServiceImpl implements MyCustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	@Transactional
	public List<User> getCustomers() {
		return customerRepo.findAll();
	}

	@Override
	@Transactional
	public void saveCustomer(User theCustomer) {
		customerRepo.save(theCustomer);
	}

	@Override
	@Transactional
	public User getCustomer(int theId) {
		return customerRepo.getById(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerRepo.deleteById(theId);
	}

	@Override
	public User login(String email, String password) {
		// TODO Auto-generated method stub
		User user=customerRepo.findByEmail(email);
		
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				return user;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}

	@Override
	public boolean blockUser(int id) {
		// TODO Auto-generated method stub
		User u=getCustomer(id);
		u.setBlocked(true);
		customerRepo.save(u);
		return true;
	}

	@Override
	public boolean unblockUser(int uid) {
		User u=getCustomer(uid);
		u.setBlocked(false);
		customerRepo.save(u);
		return true;
	}
}
