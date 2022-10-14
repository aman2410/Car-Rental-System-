package com.aman.carrental.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aman.carrental.pojo.User;

@Repository
public interface CustomerRepository extends JpaRepository<User, Integer>{
	
	@Query("FROM User WHERE email = ?1")
    User findByEmail(String email);

}
