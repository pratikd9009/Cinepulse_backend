package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.CinemaHall;

public interface CinemaHallRepository extends JpaRepository<CinemaHall, Long> {
	List<CinemaHall> findByName(String name);

	Optional<CinemaHall> findByCinemaHallId(Long id);

	List<CinemaHall> findByNameContainingIgnoreCase(String name);
	
	List<CinemaHall> findByMovie_MovieIdAndLocation(Long movieId, String location);	
//    @Query("SELECT ch FROM CinemaHall ch JOIN ch.shows s JOIN s.movie m WHERE m.name = :movieName")
//    List<CinemaHall> findCinemaHallsByMovieName(@Param("movieName") String movieName);

}