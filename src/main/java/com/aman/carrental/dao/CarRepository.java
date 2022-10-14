package com.aman.carrental.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aman.carrental.pojo.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{

	@Query("FROM Car WHERE statusOfBooking = false")
    List<Car> getAvailableCars();
}
