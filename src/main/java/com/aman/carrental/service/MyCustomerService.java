package com.aman.carrental.service;


import java.util.List;

import com.aman.carrental.pojo.User;

public interface MyCustomerService {

    public List < User > getCustomers();

    public void saveCustomer(User theCustomer);

    public User getCustomer(int theId);

    public void deleteCustomer(int theId);
    
    public User login(String email, String password);
    
    public boolean blockUser(int uid);
    
    public boolean unblockUser(int uid);
    
}
