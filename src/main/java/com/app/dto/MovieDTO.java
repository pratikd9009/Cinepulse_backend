package com.app.dto;

<<<<<<< HEAD
import java.time.LocalDate;
import java.util.Set;

import com.app.entities.Certificate;
import com.app.entities.Formats;
import com.app.entities.Genres;
import com.app.entities.Languages;
import com.app.entities.Type;

public class MovieDTO {
	private Long movieId;
	private String name; 
	private String thumbnail;
	private String backgroundImage;
	private String description;
	private LocalDate releaseDate;
	private Formats formats;
	private Languages languages;
	private Genres genres;
	private Certificate certificate;
	private Type type;
=======
<<<<<<< HEAD
import java.util.Set;
=======
import com.app.entities.Certificate;
import com.app.entities.MovieType;
>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5

public class MovieDTO {
    private Long movieId;
    private String name;
    private String description;
    private int rating;
    private String language;
    private String format;
<<<<<<< HEAD
    private Set<Long> showIds; // List of Show IDs related to the Movie
    private Set<Long> ratingIds; // List of Rating IDs related to the Movie

    // Default constructor
    public MovieDTO() {
    }

    // Parameterized constructor
    public MovieDTO(Long movieId, String name, String description, int rating, String language, String format,
            Set<Long> showIds, Set<Long> ratingIds) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.language = language;
        this.format = format;
        this.showIds = showIds;
        this.ratingIds = ratingIds;
    }

    // Getters and Setters
=======
    private Certificate certificate;
    private MovieType type;
>>>>>>> b854fc5e188cba5df25932dc753a0015f9a67bb7

	public MovieDTO() {
	}

	public MovieDTO(String name, String thumbnail, String backgroundImage, String description,
			LocalDate releaseDate, Formats formats, Languages languages, Genres genres,
			Certificate certificate, Type type) {
		this.name = name;
		this.thumbnail = thumbnail;
		this.backgroundImage = backgroundImage;
		this.description = description;
		this.releaseDate = releaseDate;
		this.formats = formats;
		this.languages = languages;
		this.genres = genres;
		this.certificate = certificate;
		this.type = type;
	}

<<<<<<< HEAD
	public Long getMovieId() {
		return movieId;
	}
=======
>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5
    public Long getMovieId() {
        return movieId;
    }
>>>>>>> b854fc5e188cba5df25932dc753a0015f9a67bb7

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String string) {
		this.thumbnail = string;
	}

	public String getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(String string) {
		this.backgroundImage = string;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

<<<<<<< HEAD
	public Formats getFormats() {
		return formats;
	}
=======
<<<<<<< HEAD
    public Set<Long> getShowIds() {
        return showIds;
    }

    public void setShowIds(Set<Long> showIds) {
        this.showIds = showIds;
    }

    public Set<Long> getRatingIds() {
        return ratingIds;
    }

    public void setRatingIds(Set<Long> ratingIds) {
        this.ratingIds = ratingIds;
    }

    @Override
    public String toString() {
        return "MovieDTO [movieId=" + movieId + ", name=" + name + ", description=" + description + ", rating=" + rating
                + ", language=" + language + ", format=" + format + ", showIds=" + showIds + ", ratingIds=" + ratingIds + "]";
=======
    public Certificate getCertificate() {
        return certificate;
    }
>>>>>>> b854fc5e188cba5df25932dc753a0015f9a67bb7

	public void setFormats(Formats formats) {
		this.formats = formats;
	}

	public Languages getLanguages() {
		return languages;
	}

	public void setLanguages(Languages languages) {
		this.languages = languages;
	}

	public Genres getGenres() {
		return genres;
	}

	public void setGenres(Genres genres) {
		this.genres = genres;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}


<<<<<<< HEAD
=======
    public void setBackgroundImage(byte[] backgroundImage) {
        this.backgroundImage = backgroundImage;
>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5
    }
>>>>>>> b854fc5e188cba5df25932dc753a0015f9a67bb7
}
