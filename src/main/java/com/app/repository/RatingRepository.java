package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
//    List<Rating> findByMovieId(Long movieId);
//    List<Rating> findByUserId(Long userId);
	List<Rating> findByMovie_MovieId(Long movieId);
	
    @Query("SELECT AVG(r.rating) FROM Rating r WHERE r.movie.id = :movieId")
    Double findAverageRatingByMovieId(@Param("movieId") Long movieId);
	
	

}