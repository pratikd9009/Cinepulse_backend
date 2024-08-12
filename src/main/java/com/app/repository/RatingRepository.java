package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
//    List<Rating> findByMovieId(Long movieId);
//    List<Rating> findByUserId(Long userId);
	List<Rating> findByMovie_MovieId(Long movieId);

}
