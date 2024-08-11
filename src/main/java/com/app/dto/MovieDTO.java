package com.app.dto;

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

//    private byte[] image;
//    private byte[] backgroundImage;
    
    @JsonSerialize(using = ByteArraySerializer.class)
    @JsonDeserialize(using = ByteArrayDeserializer.class)
    private byte[] image; // Store as byte array

    // Getters and Setters

>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5
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
>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5
    }
}
