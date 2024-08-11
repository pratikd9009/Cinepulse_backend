package com.app.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movieId;

	private String name;
	private String description;
	private int rating;
	private String language;
	private String format;

	@OneToMany(mappedBy = "movie")
	private Set<Show> shows;

	@OneToMany(mappedBy = "movie")
	private Set<Rating> ratings;

	public Movie() {
		super();
	}

	public Movie(String name, String description, int rating, String language, String format,
			Set<Show> shows, Set<Rating> ratings) {
		super();
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.language = language;
		this.format = format;
		this.shows = shows;
		this.ratings = ratings;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Set<Show> getShows() {
		return shows;
	}

	public void setShows(Set<Show> shows) {
		this.shows = shows;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", name=" + name + ", description=" + description + ", rating=" + rating
				+ ", language=" + language + ", format=" + format + ", shows=" + shows + ", ratings=" + ratings + "]";
	}

}
