package com.app.service;

import com.app.dto.RatingDTO;
import com.app.entities.Rating;
import com.app.entities.Movie;
import com.app.entities.User;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.RatingRepository;
import com.app.repository.MovieRepository;
import com.app.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
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
		
		updateMovieTotalRating(ratingDTO.getMovieId());
		return modelMapper.map(savedRating, RatingDTO.class);
	}

	@Override
    public RatingDTO updateRating(Long ratingId, RatingDTO ratingDTO) {
        // Check if the rating exists
        Rating existingRating = ratingRepository.findById(ratingId)
            .orElseThrow(() -> new ResourceNotFoundException("Rating not found with id " + ratingId));

        // Update only the provided fields
        if (ratingDTO.getRating() != null) {
            existingRating.setRating(ratingDTO.getRating());
        }
        if (ratingDTO.getReview() != null) {
            existingRating.setReview(ratingDTO.getReview());
        }
        // Handle other fields if necessary

        // Save the updated rating
        Rating updatedRating = ratingRepository.save(existingRating);
        
        updateMovieTotalRating(ratingDTO.getMovieId());

        // Convert to DTO and return
        return new RatingDTO(updatedRating.getRatingId(), updatedRating.getRating(), updatedRating.getReview());    }

	@Override
	public void deleteRating(Long ratingId) {
		if (ratingRepository.existsById(ratingId)) {
			ratingRepository.deleteById(ratingId);
		} else {
			throw new ResourceNotFoundException("Rating not found with id " + ratingId);
		}
	}


	@Override
	public RatingDTO getRatingById(Long ratingId) {
		Rating rating = ratingRepository.findById(ratingId)
				.orElseThrow(() -> new EntityNotFoundException("Rating not found with id " + ratingId));
		return modelMapper.map(rating, RatingDTO.class);
	}

	@Override
	public List<RatingDTO> getRatingsByMovieId(Long movieId) {
		return ratingRepository.findByMovie_MovieId(movieId).stream()
				.map(rating -> modelMapper.map(rating, RatingDTO.class)).collect(Collectors.toList());
	}
	
    private void updateMovieTotalRating(Long movieId) {
        Double averageRating = ratingRepository.findAverageRatingByMovieId(movieId);
        Movie movie = movieRepository.findById(movieId)
            .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id " + movieId));
        movie.setRating(averageRating);
        movieRepository.save(movie);
    }

//    @Override
//    public List<RatingDTO> getRatingsByUserId(Long userId) {
//        return ratingRepository.findByUserId(userId)
//                .stream()
//                .map(rating -> modelMapper.map(rating, RatingDTO.class))
//                .collect(Collectors.toList());
//    }
}