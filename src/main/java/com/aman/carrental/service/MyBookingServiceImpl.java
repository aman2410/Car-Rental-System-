package com.aman.carrental.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aman.carrental.dao.BookingRepository;
import com.aman.carrental.pojo.Booking;


@Service
public class MyBookingServiceImpl implements MyBookingService{
	
	@Autowired
	BookingRepository bookingRepo;
	
	@Override
	public void saveBooking(Booking booking) {
		// TODO Auto-generated method stub
		bookingRepo.save(booking);
	}

	@Override
	public Booking getBookingById(int bid) {
		// TODO Auto-generated method stub
		return bookingRepo.getById(bid);
	}

	@Override
	public List<Booking> getBookingsByUserId(int uid) {
		// TODO Auto-generated method stub
		return bookingRepo.getBookingsByUserId(uid);
	}

}
