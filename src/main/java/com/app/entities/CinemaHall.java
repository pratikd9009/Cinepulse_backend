package com.app.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CinemaHall {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cinemaHallId;

	private String name;

	private String location;

	@OneToMany(mappedBy = "cinemaHall")
	private Set<Show> shows;

	public CinemaHall() {
		super();
	}

	public CinemaHall(String name, String location, Set<Show> shows) {
		super();
		this.name = name;
		this.location = location;
		this.shows = shows;
	}

	public Long getCinemaHallId() {
		return cinemaHallId;
	}

	public void setCinemaHallId(Long cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Show> getShows() {
		return shows;
	}

	public void setShows(Set<Show> shows) {
		this.shows = shows;
	}

	@Override
	public String toString() {
		return "CinemaHall [cinemaHallId=" + cinemaHallId + ", name=" + name + ", location=" + location + ", shows="
				+ shows + "]";
	}

}