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

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid")
    private int tid;
	
	 @ManyToOne
	 @JoinColumn(name="uid", nullable=false)
	 private User user;
	 
	 @Basic
	 @CreationTimestamp
	 @Temporal(TemporalType.DATE)
	 @Column(name = "transact_at")
	 private java.util.Date transactAt;
	 
	 @Column(name = "total_charge")
	 private int totalCharge;
	 
	 @OneToOne
	 @JoinColumn(name = "bid", referencedColumnName = "bid")
	 private Booking booking;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public java.util.Date getTransactAt() {
		return transactAt;
	}

	public void setTransactAt(java.util.Date transactAt) {
		this.transactAt = transactAt;
	}

	public int getTotalCharge() {
		return totalCharge;
	}

	public void setTotalCharge(int totalCharge) {
		this.totalCharge = totalCharge;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Transaction(int tid, User user, Date transactAt, int totalCharge, Booking booking) {
		super();
		this.tid = tid;
		this.user = user;
		this.transactAt = transactAt;
		this.totalCharge = totalCharge;
		this.booking = booking;
	}

	public Transaction(User user, Date transactAt, int totalCharge, Booking booking) {
		super();
		this.user = user;
		this.transactAt = transactAt;
		this.totalCharge = totalCharge;
		this.booking = booking;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	 
}
