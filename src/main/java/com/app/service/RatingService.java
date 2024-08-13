package com.app.service;

import com.app.dto.RatingDTO;
import java.util.List;

public interface RatingService {
    RatingDTO addRating(RatingDTO ratingDTO);
    RatingDTO updateRating(Long ratingId, RatingDTO ratingDTO);
    void deleteRating(Long ratingId);
    RatingDTO getRatingById(Long ratingId);
    List<RatingDTO> getRatingsByMovieId(Long movieId);
//    List<RatingDTO> getRatingsByUserId(Long userId);
}