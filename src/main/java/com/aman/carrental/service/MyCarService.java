package com.aman.carrental.service;

import java.util.List;

import com.aman.carrental.pojo.Car;


public interface MyCarService {
	
	public List<Car> getAvailableCars();
	
	public void saveCar(Car car);

	public Car getCarById(int cid);
	
	public List<Car> getAllCars();
	
	public void deleteCar(int theId);

}
