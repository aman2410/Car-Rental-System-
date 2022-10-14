package com.aman.carrental.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aman.carrental.pojo.Booking;
import com.aman.carrental.service.MyBookingService;

@RestController
@RequestMapping("/api")
public class MyBookingController {
	
	@Autowired
	private MyBookingService mybookingService;
	
	
	
	@GetMapping("/allBookings/{uid}")
	public ResponseEntity<Object> bookings(@PathVariable("uid") int uid) {
		List<Booking> bookings = mybookingService.getBookingsByUserId(uid);
		return new ResponseEntity<>(bookings,HttpStatus.OK);
		
	}
	
	@PostMapping("/saveBooking")
	public ResponseEntity<Object> saveBooking(@RequestBody Booking booking) {
		if(booking.getUser().isBlocked()) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		mybookingService.saveBooking(booking);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
