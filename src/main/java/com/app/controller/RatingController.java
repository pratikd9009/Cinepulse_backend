package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.RatingDTO;
import com.app.dto.UserDTO;
import com.app.service.RatingService;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<RatingDTO> addRating(@RequestBody RatingDTO ratingDTO) {
    	//ratingDTO.setUserId(userDTO.getUserId());
        RatingDTO createdRating = ratingService.addRating(ratingDTO);
        return new ResponseEntity<>(createdRating, HttpStatus.CREATED);
    }

    @PatchMapping("/{ratingId}")
    public ResponseEntity<RatingDTO> updateRating(
            @PathVariable Long ratingId,
            @RequestBody RatingDTO ratingDTO) {
        RatingDTO updatedRating = ratingService.updateRating(ratingId, ratingDTO);
        return new ResponseEntity<>(updatedRating, HttpStatus.OK);
    }

    @DeleteMapping("/{ratingId}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long ratingId) {
        ratingService.deleteRating(ratingId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<RatingDTO> getRatingById(@PathVariable Long ratingId) {
        RatingDTO ratingDTO = ratingService.getRatingById(ratingId);
        return new ResponseEntity<>(ratingDTO, HttpStatus.OK);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<RatingDTO>> getRatingsByMovieId(@PathVariable Long movieId) {
        List<RatingDTO> ratings = ratingService.getRatingsByMovieId(movieId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<RatingDTO>> getRatingsByUserId(@PathVariable("userId") Long userId) {
//        List<RatingDTO> ratings = ratingService.getRatingsByUserId(userId);
//        return new ResponseEntity<>(ratings, HttpStatus.OK);
//    }
}