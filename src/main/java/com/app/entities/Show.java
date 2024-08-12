package com.app.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movie_show")
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long showId;

	private LocalDateTime showTime;
	
	private int availableSeats;


	@ManyToOne
	@JoinColumn(name = "cinema_hall_id", nullable = false)
	private CinemaHall cinemaHall;

	@OneToMany(mappedBy = "show")
	private Set<Booking> bookings;

	public Show() {
		super();
	}

	public Show(LocalDateTime showTime, int availableSeats, CinemaHall cinemaHall,
			Set<Booking> bookings) {
		super();
		this.showTime = showTime;
		this.availableSeats = availableSeats;
		this.cinemaHall = cinemaHall;
		this.bookings = bookings;
	}

	public Long getShowId() {
		return showId;
	}

	public void setShowId(Long showId) {
		this.showId = showId;
	}

	public LocalDateTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}



	public CinemaHall getCinemaHall() {
		return cinemaHall;
	}

	public void setCinemaHall(CinemaHall cinemaHall) {
		this.cinemaHall = cinemaHall;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", showTime=" + showTime + ", availableSeats=" + availableSeats + ", movie="
				+   ", cinemaHall=" + cinemaHall + ", bookings=" + bookings + "]";
	}

	
}
