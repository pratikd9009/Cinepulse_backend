package com.app.entities;

import java.sql.Blob;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
	private Certificate certificate;
	private MovieType type=MovieType.MOVIE;
    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private byte[] image;

    @Lob
    @Column(name = "background_image", columnDefinition = "BLOB")
    private byte[] backgroundImage;

	@OneToMany(mappedBy = "movie")
	private Set<Show> shows;

	@OneToMany(mappedBy = "movie")
	private Set<Rating> ratings;

	public Movie() {
		super();
	}

	public Movie(String name, String description, int rating, String language, String format, Certificate certificate,
			MovieType type, byte[] image, byte[] backgroundImage, Set<Show> shows, Set<Rating> ratings) {
		super();
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.language = language;
		this.format = format;
		this.certificate = certificate;
		this.type = type;
		this.image = image;
		this.backgroundImage = backgroundImage;
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

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public MovieType getType() {
		return type;
	}

	public void setType(MovieType type) {
		this.type = type;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public byte[] getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(byte[] backgroundImage) {
		this.backgroundImage = backgroundImage;
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
				+ ", language=" + language + ", format=" + format + ", certificate=" + certificate + ", type=" + type
				+ ", image=" + Arrays.toString(image) + ", backgroundImage=" + Arrays.toString(backgroundImage)
				+ ", shows=" + shows + ", ratings=" + ratings + "]";
	}

	


}
