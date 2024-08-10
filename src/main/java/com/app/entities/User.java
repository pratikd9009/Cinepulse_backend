package com.app.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String name;
	private String lname;
	private String username;
	private String password;
	private String email;

	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(mappedBy = "user")
	private Set<Booking> bookings;

	@OneToMany(mappedBy = "user")
	private Set<Rating> ratings;

	public User() {
		super();
	}

	public User(String name, String lname, String username, String password, String email, Role role,
			Set<Booking> bookings, Set<Rating> ratings) {
		super();
		this.name = name;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.bookings = bookings;
		this.ratings = ratings;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", lname=" + lname + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", role=" + role + ", bookings=" + bookings
				+ ", ratings=" + ratings + "]";
	}

}
