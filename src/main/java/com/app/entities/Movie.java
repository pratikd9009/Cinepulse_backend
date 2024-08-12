package com.app.entities;

<<<<<<< HEAD
import java.time.LocalDate;
=======
<<<<<<< HEAD
import java.util.Set;

=======
import java.sql.Blob;
import java.util.Arrays;
>>>>>>> b854fc5e188cba5df25932dc753a0015f9a67bb7
import java.util.Set;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
<<<<<<< HEAD
import javax.persistence.ElementCollection;
=======
>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5
>>>>>>> b854fc5e188cba5df25932dc753a0015f9a67bb7
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.Index;
=======
<<<<<<< HEAD
=======
>>>>>>> b854fc5e188cba5df25932dc753a0015f9a67bb7
import javax.persistence.Lob;
>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "movie", indexes = {
	    @Index(name = "idx_movie_id", columnList = "id")
	})
public class Movie {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long movieId;

<<<<<<< HEAD
    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    private String name;


    @Column(name = "thumbnail")
    @NotNull(message = "Thumbnail is mandatory")
    private String thumbnail;

  
    @Column(name = "background_image")
    @NotNull(message = "Background image is mandatory")
    private String backgroundImage;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Release date is mandatory")
    private LocalDate releaseDate;

//    @ElementCollection(targetClass = Formats.class)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Formats are mandatory")
    private Formats formats;

//    @ElementCollection(targetClass = Languages.class)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Languages are mandatory")
    private Languages languages;

//    @ElementCollection(targetClass = Genres.class)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Genres are mandatory")
    private Genres genres;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Certificate is mandatory")
    private Certificate certificate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Type is mandatory")
    private Type type;



    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Rating> ratings;
    
    @OneToMany(mappedBy = "movie")
    private List<CinemaHall> cinemaHalls;

    public Movie() {
        super();
    }

    public Movie(Long movieId, String name, String thumbnail,String backgroundImage, String description,
                 LocalDate releaseDate, Formats formats, Languages languages, Genres genres,
                 Certificate certificate, Type type,Set<Rating> ratings) {
        super();
        this.movieId = movieId;
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
 
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String bs) {
        this.thumbnail = bs;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String bs) {
        this.backgroundImage = bs;
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

    public Formats getFormats() {
        return formats;
    }

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


    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

   
=======
	private String name;
	private String description;
	private int rating;
	private String language;
	private String format;
<<<<<<< HEAD
=======
	private Certificate certificate;
	private MovieType type=MovieType.MOVIE;
    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private byte[] image;

    @Lob
    @Column(name = "background_image", columnDefinition = "BLOB")
    private byte[] backgroundImage;
>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5

	@OneToMany(mappedBy = "movie")
	private Set<Show> shows;

	@OneToMany(mappedBy = "movie")
	private Set<Rating> ratings;

	public Movie() {
		super();
	}

<<<<<<< HEAD
	public Movie(String name, String description, int rating, String language, String format,
			Set<Show> shows, Set<Rating> ratings) {
=======
	public Movie(String name, String description, int rating, String language, String format, Certificate certificate,
			MovieType type, byte[] image, byte[] backgroundImage, Set<Show> shows, Set<Rating> ratings) {
>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5
		super();
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.language = language;
		this.format = format;
<<<<<<< HEAD
=======
		this.certificate = certificate;
		this.type = type;
		this.image = image;
		this.backgroundImage = backgroundImage;
>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5
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

<<<<<<< HEAD
=======
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

>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5
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
<<<<<<< HEAD
				+ ", language=" + language + ", format=" + format + ", shows=" + shows + ", ratings=" + ratings + "]";
	}

=======
				+ ", language=" + language + ", format=" + format + ", certificate=" + certificate + ", type=" + type
				+ ", image=" + Arrays.toString(image) + ", backgroundImage=" + Arrays.toString(backgroundImage)
				+ ", shows=" + shows + ", ratings=" + ratings + "]";
	}

	


>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5
>>>>>>> b854fc5e188cba5df25932dc753a0015f9a67bb7
}
