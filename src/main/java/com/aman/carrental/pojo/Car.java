package com.aman.carrental.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "car")
public class Car {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "cid")
	    private int cid;
	 
	    @Column(name = "car_name")
	 	private String carName;
	 	
	    @Column(name = "brand")	
	 	private String brand;
	 	
	    @Column(name = "type")	
	 	private String type;
	 	
	 	@Column(name = "status_of_booking")	
	 	private boolean statusOfBooking=Boolean.FALSE;
	 	
		@Column(name = "charges_per_km")	
	 	private int chargePerKm;
	 	
		@Column(name = "car_number")
	 	private String carNumber;
		
		@JsonIgnore
		@OneToOne(mappedBy = "car")
	    private Booking booking;

		public Booking getBooking() {
			return booking;
		}

		public void setBooking(Booking booking) {
			this.booking = booking;
		}

		public int getCid() {
			return cid;
		}

		public void setCid(int cid) {
			this.cid = cid;
		}

		public String getCarName() {
			return carName;
		}

		public void setCarName(String carName) {
			this.carName = carName;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public boolean isStatusOfBooking() {
			return statusOfBooking;
		}

		public void setStatusOfBooking(boolean statusOfBooking) {
			this.statusOfBooking = statusOfBooking;
		}

		public int getChargePerKm() {
			return chargePerKm;
		}

		public void setChargePerKm(int chargePerKm) {
			this.chargePerKm = chargePerKm;
		}

		public String getCarNumber() {
			return carNumber;
		}

		public void setCarNumber(String carNumber) {
			this.carNumber = carNumber;
		}

		
		public Car(int cid, String carName, String brand, String type, boolean statusOfBooking, int chargePerKm,
				String carNumber, Booking booking) {
			super();
			this.cid = cid;
			this.carName = carName;
			this.brand = brand;
			this.type = type;
			this.statusOfBooking = statusOfBooking;
			this.chargePerKm = chargePerKm;
			this.carNumber = carNumber;
			this.booking = booking;
		}

		public Car(String carName, String brand, String type, boolean statusOfBooking, int chargePerKm,
				String carNumber, Booking booking) {
			super();
			this.carName = carName;
			this.brand = brand;
			this.type = type;
			this.statusOfBooking = statusOfBooking;
			this.chargePerKm = chargePerKm;
			this.carNumber = carNumber;
			this.booking = booking;
		}

		public Car() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
}
