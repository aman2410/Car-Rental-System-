package com.aman.carrental.controller;

import java.util.List;
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

import com.aman.carrental.pojo.Car;
import com.aman.carrental.service.MyCarService;

@RestController
@RequestMapping("/api")
public class MyCarController {
	
	@Autowired
	private MyCarService mycarService;
	
		
	@GetMapping("/updateThisCar")
	public ResponseEntity<Object> showFormForUpdateCar(@RequestBody Car car) {
		mycarService.saveCar(car);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/car/saveCar")
	public ResponseEntity<Object> saveCarTemp(@RequestBody Car car) {
		mycarService.saveCar(car);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@GetMapping("/findCars")
	public ResponseEntity<Object> findCars(@RequestParam("booked_from") String bookedFrom, @RequestParam("booked_till") String bookedTill) {
		List<Car> cars = mycarService.getAvailableCars();
		if (cars == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(cars, HttpStatus.OK);
	}

	@DeleteMapping("/deleteThisCar/{cid}")
	public ResponseEntity<Object> deleteCar(@PathVariable("cid") int theId) {
		mycarService.deleteCar(theId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/car/showCars")
	public ResponseEntity<Object> allCars() {
		return new ResponseEntity<>(mycarService.getAllCars(),HttpStatus.OK);
	}


}
