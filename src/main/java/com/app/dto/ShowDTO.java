package com.app.dto;

import java.time.LocalDateTime;

public class ShowDTO {
    private Long showId;
    private LocalDateTime showTime;
    private int availableSeats;
    private Long movieId;
    private Long cinemaHallId;

    public ShowDTO() {
    }

    public ShowDTO(Long showId, LocalDateTime showTime, int availableSeats, Long movieId, Long cinemaHallId) {
        this.showId = showId;
        this.showTime = showTime;
        this.availableSeats = availableSeats;
        this.movieId = movieId;
        this.cinemaHallId = cinemaHallId;
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

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    @Override
    public String toString() {
        return "ShowDTO [showId=" + showId + ", showTime=" + showTime + ", availableSeats=" + availableSeats
                + ", movieId=" + movieId + ", cinemaHallId=" + cinemaHallId + "]";
    }
}
