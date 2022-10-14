package com.aman.carrental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aman.carrental.dao.CarRepository;
import com.aman.carrental.pojo.Car;


@Service
public class MyCarServiceImpl implements MyCarService{

	@Autowired
	private CarRepository carRepo;
	
	@Override
	public List<Car> getAvailableCars() {
		// TODO Auto-generated method stub
		return carRepo.getAvailableCars();
	}
	@Override
	public void saveCar(Car car) {
		carRepo.save(car);
	}

	@Override
	public Car getCarById(int cid) {
		// TODO Auto-generated method stub
		return carRepo.getById(cid);
	}

	@Override
	public List<Car> getAllCars() {
		// TODO Auto-generated method stub
		return carRepo.findAll();
	}

	@Override
	public void deleteCar(int theId) {
		// TODO Auto-generated method stub
		carRepo.deleteById(theId);
	}
	
}
