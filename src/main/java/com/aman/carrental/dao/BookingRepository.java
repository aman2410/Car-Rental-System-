package com.aman.carrental.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aman.carrental.pojo.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
	@Query("FROM Booking WHERE uid = ?1")
    List<Booking> getBookingsByUserId(int uid);

}
