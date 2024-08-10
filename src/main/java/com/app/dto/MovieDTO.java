package com.app.dto;

import java.util.Set;

public class MovieDTO {
    private Long movieId;
    private String name;
    private String description;
    private int rating;
    private String language;
    private String format;
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
    }
}
