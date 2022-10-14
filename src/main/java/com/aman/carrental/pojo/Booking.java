package com.aman.carrental.pojo;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid")
    private int bid;
	 
	 @ManyToOne
	 @JoinColumn(name="uid", nullable=false)
	 private User user;
	 
	 @OneToOne
	 @JoinColumn(name = "cid", referencedColumnName = "cid")
	 private Car car;
	 
	 @Basic
	 @Temporal(TemporalType.DATE)
	 @Column(name = "booked_from")
	 private java.util.Date bookedFrom;
	 
	 @Basic
	 @Temporal(TemporalType.DATE)
	 @Column(name = "booked_till")
	 private java.util.Date bookedTill;
	 
	 @Column(name = "total_distance")
	 private int totalDistance;
	 
	 @Column(name = "payment_type")
	 private String paymentType;
	 
	 @Column(name = "booking_status")
	 private boolean bookingStatus;
	 
	 @JsonIgnore
	 @OneToOne(mappedBy = "booking")
	 private Transaction transaction;
	 
	 @Column(name = "booked_for")
	 private String bookedFor;
	 
	 

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public String getBookedFor() {
		return bookedFor;
	}

	public void setBookedFor(String bookedFor) {
		this.bookedFor = bookedFor;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public java.util.Date getBookedFrom() {
		return bookedFrom;
	}

	public void setBookedFrom(java.util.Date bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	public java.util.Date getBookedTill() {
		return bookedTill;
	}

	public void setBookedTill(java.util.Date bookedTill) {
		this.bookedTill = bookedTill;
	}

	public int getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(int totalDistance) {
		this.totalDistance = totalDistance;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public boolean isBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Booking(int bid, User user, Car car, Date bookedFrom, Date bookedTill, int totalDistance, String paymentType,
			boolean bookingStatus, Transaction transaction, String bookedFor) {
		super();
		this.bid = bid;
		this.user = user;
		this.car = car;
		this.bookedFrom = bookedFrom;
		this.bookedTill = bookedTill;
		this.totalDistance = totalDistance;
		this.paymentType = paymentType;
		this.bookingStatus = bookingStatus;
		this.transaction = transaction;
		this.bookedFor = bookedFor;
	}

	public Booking(User user, Car car, Date bookedFrom, Date bookedTill, int totalDistance, String paymentType,
			boolean bookingStatus, Transaction transaction, String bookedFor) {
		super();
		this.user = user;
		this.car = car;
		this.bookedFrom = bookedFrom;
		this.bookedTill = bookedTill;
		this.totalDistance = totalDistance;
		this.paymentType = paymentType;
		this.bookingStatus = bookingStatus;
		this.transaction = transaction;
		this.bookedFor = bookedFor;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	 
}
