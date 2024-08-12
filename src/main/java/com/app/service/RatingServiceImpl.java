package com.app.service;

import com.app.dto.RatingDTO;
import com.app.entities.Rating;
import com.app.entities.Movie;
import com.app.entities.User;
import com.app.repository.RatingRepository;
import com.app.repository.MovieRepository;
import com.app.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RatingDTO addRating(RatingDTO ratingDTO) {
        Rating rating = modelMapper.map(ratingDTO, Rating.class);

        // Set User and Movie entities
        User user = userRepository.findById(ratingDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + ratingDTO.getUserId()));
        Movie movie = movieRepository.findById(ratingDTO.getMovieId())
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with id " + ratingDTO.getMovieId()));
        
        rating.setUser(user);
        rating.setMovie(movie);

        Rating savedRating = ratingRepository.save(rating);
        return modelMapper.map(savedRating, RatingDTO.class);
    }

    @Override
    public RatingDTO updateRating(Long ratingId, RatingDTO ratingDTO) {
        Rating rating = ratingRepository.findById(ratingId)
                .orElseThrow(() -> new EntityNotFoundException("Rating not found with id " + ratingId));

        // Map fields from DTO to entity
        modelMapper.map(ratingDTO, rating);

        // Update User and Movie entities
        if (ratingDTO.getUserId() != null) {
            User user = userRepository.findById(ratingDTO.getUserId())
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id " + ratingDTO.getUserId()));
            rating.setUser(user);
        }

        if (ratingDTO.getMovieId() != null) {
            Movie movie = movieRepository.findById(ratingDTO.getMovieId())
                    .orElseThrow(() -> new EntityNotFoundException("Movie not found with id " + ratingDTO.getMovieId()));
            rating.setMovie(movie);
        }

        Rating updatedRating = ratingRepository.save(rating);
        return modelMapper.map(updatedRating, RatingDTO.class);
    }

    @Override
    public void deleteRating(Long ratingId) {
        if (!ratingRepository.existsById(ratingId)) {
            throw new EntityNotFoundException("Rating not found with id " + ratingId);
        }
        ratingRepository.deleteById(ratingId);
    }

    @Override
    public RatingDTO getRatingById(Long ratingId) {
        Rating rating = ratingRepository.findById(ratingId)
                .orElseThrow(() -> new EntityNotFoundException("Rating not found with id " + ratingId));
        return modelMapper.map(rating, RatingDTO.class);
    }

    @Override
    public List<RatingDTO> getRatingsByMovieId(Long movieId) {
        return ratingRepository.findByMovie_MovieId(movieId)
                .stream()
                .map(rating -> modelMapper.map(rating, RatingDTO.class))
                .collect(Collectors.toList());
    }

//    @Override
//    public List<RatingDTO> getRatingsByUserId(Long userId) {
//        return ratingRepository.findByUserId(userId)
//                .stream()
//                .map(rating -> modelMapper.map(rating, RatingDTO.class))
//                .collect(Collectors.toList());
//    }
}
