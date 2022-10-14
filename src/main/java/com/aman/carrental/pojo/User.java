package com.aman.carrental.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "user")
public class User {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "uid")
	    private int uid;
	 	
	 	@Column(name = "name")
	 	private String name;
	 	
	 	@Column(name = "contact")
	 	private String contact;
	 	
	 	@Column(name = "address")
	 	private String address;
	 	
	 	@JsonIgnore
	 	@OneToMany(mappedBy="user")
		private Set<Booking> bookings;
	 	
	 	@JsonIgnore
	 	@OneToMany(mappedBy="user")
		private Set<Transaction> transactions;
	 	
	 	@Column(name = "email")
	 	private String email;
	 	
	 	@Column(name = "password")
	 	private String password;
	 	
	 	@Column(name = "role",columnDefinition = "int default 0")
	 	private int role;
	 	
	 	@Column(name = "is_blocked")
	 	private boolean isBlocked;

		public boolean isBlocked() {
			return isBlocked;
		}

		public void setBlocked(boolean isBlocked) {
			this.isBlocked = isBlocked;
		}

		public Set<Transaction> getTransactions() {
			return transactions;
		}

		public void setTransactions(Set<Transaction> transactions) {
			this.transactions = transactions;
		}

		public int getUid() {
			return uid;
		}

		public void setUid(int uid) {
			this.uid = uid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		
		public Set<Booking> getBookings() {
			return bookings;
		}

		public void setBookings(Set<Booking> bookings) {
			this.bookings = bookings;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		public int getRole() {
			return role;
		}

		public void setRole(int role) {
			this.role = role;
		}

		public User(int uid, String name, String contact, String address, Set<Booking> bookings,
				Set<Transaction> transactions, String email, String password, int role, boolean isBlocked) {
			super();
			this.uid = uid;
			this.name = name;
			this.contact = contact;
			this.address = address;
			this.bookings = bookings;
			this.transactions = transactions;
			this.email = email;
			this.password = password;
			this.role = role;
			this.isBlocked = isBlocked;
		}

		public User(String name, String contact, String address, Set<Booking> bookings, Set<Transaction> transactions,
				String email, String password, int role, boolean isBlocked) {
			super();
			this.name = name;
			this.contact = contact;
			this.address = address;
			this.bookings = bookings;
			this.transactions = transactions;
			this.email = email;
			this.password = password;
			this.role = role;
			this.isBlocked = isBlocked;
		}

		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "User [uid=" + uid + ", name=" + name + ", contact=" + contact + ", address=" + address
					+ ", bookings=" + bookings + ", transactions=" + transactions + ", email=" + email + ", password="
					+ password + ", role=" + role + ", isBlocked=" + isBlocked + "]";
		}

}
