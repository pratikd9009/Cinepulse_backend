package com.app.service;

import com.app.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    MovieDTO addMovie(MovieDTO movieDTO);
    MovieDTO updateMovie(Long id, MovieDTO movieDTO);
    void deleteMovie(Long id);
    MovieDTO getMovieById(Long id);
    List<MovieDTO> getAllMovies();
}
