package com.aman.carrental.service;

import java.util.List;

import com.aman.carrental.pojo.Booking;


public interface MyBookingService {

	public void saveBooking(Booking booking);

	public Booking getBookingById(int bid);
	
	public List<Booking> getBookingsByUserId(int uid);
}
