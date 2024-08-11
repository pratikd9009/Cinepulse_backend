package com.app.dto;

public class RatingDTO {
    private Long ratingId;
    private int rating;
    private String review;
    private Long userId; // To reference the User entity
    private Long movieId; // To reference the Movie entity

    // Default constructor
    public RatingDTO() {
    }

    // Parameterized constructor
    public RatingDTO(Long ratingId, int rating, String review, Long userId, Long movieId) {
        this.ratingId = ratingId;
        this.rating = rating;
        this.review = review;
        this.userId = userId;
        this.movieId = movieId;
    }

    // Getters and Setters
    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "RatingDTO [ratingId=" + ratingId + ", rating=" + rating + ", review=" + review + ", userId=" + userId
                + ", movieId=" + movieId + "]";
    }
}
