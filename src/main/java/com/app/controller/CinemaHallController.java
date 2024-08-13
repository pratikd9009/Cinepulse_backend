package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CinemaHallDTO;
import com.app.dto.CinemaHallSearchRequest;
import com.app.entities.CinemaHall;
import com.app.service.CinemaHallService;

@RestController
@RequestMapping("/cinemaHall")
public class CinemaHallController {

	private final CinemaHallService cinemaHallService;
	private final ModelMapper modelMapper;

	@Autowired
	public CinemaHallController(CinemaHallService cinemaHallService, ModelMapper modelMapper) {
		this.cinemaHallService = cinemaHallService;
		this.modelMapper = modelMapper;
	}

	@Secured("ROLE_MANAGER")
	@PreAuthorize("hasRole('MANAGER')")
	@PostMapping("/add")
	public ResponseEntity<CinemaHallDTO> addCinemaHall(@Valid @RequestBody CinemaHallDTO cinemaHallDTO) {
		CinemaHallDTO savedCinemaHallDTO = cinemaHallService.addCinemaHall(cinemaHallDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCinemaHallDTO);
	}

	@GetMapping("/all")
	public ResponseEntity<List<CinemaHallDTO>> showAllCinemaHalls() {
		List<CinemaHallDTO> cinemaHalls = cinemaHallService.getAllCinemaHalls();
		return ResponseEntity.ok(cinemaHalls);
	}

	@Secured("ROLE_MANAGER")
	@PreAuthorize("hasRole('MANAGER')")
	@GetMapping("/{id}")
	public ResponseEntity<CinemaHallDTO> findCinemaHallById(@Valid @PathVariable Long id) {
		CinemaHallDTO cinemaHallDTO = cinemaHallService.findCinemaHallById(id);
		if (cinemaHallDTO != null) {
			return ResponseEntity.ok(cinemaHallDTO);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<CinemaHallDTO> findCinemaHallByName(@Valid @PathVariable String name) {
		CinemaHallDTO cinemaHalls = cinemaHallService.getCinemaHallByName(name);

		if (cinemaHalls != null) {
			return ResponseEntity.ok(cinemaHalls);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@Secured("ROLE_MANAGER")
	@PreAuthorize("hasRole('MANAGER')")
	@PatchMapping("/update/{id}")
	public ResponseEntity<?> updateCinemaHall(@Valid @PathVariable Long id, @Valid @RequestBody CinemaHallDTO cinemaHallDTO) {
		// Call the service method to update the cinema hall
		CinemaHallDTO updatedCinemaHall = cinemaHallService.updateCinemaHall(id, cinemaHallDTO);

		if (updatedCinemaHall != null) {
			return ResponseEntity.ok(updatedCinemaHall);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cinema Hall not found");
		}
	}

	@Secured("ROLE_MANAGER")
	@PreAuthorize("hasRole('MANAGER')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCinemaHall(@Valid @PathVariable Long id) {
		cinemaHallService.deleteCinemaHall(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/search")
	public ResponseEntity<List<CinemaHallDTO>> searchCinemaHalls(@Valid @RequestParam String name) {
		List<CinemaHallDTO> cinemaHalls = cinemaHallService.searchCinemaHallsByName(name);
		return ResponseEntity.ok(cinemaHalls);
	}
	
    @PutMapping("/{cinemaHallId}/associateMovie/{movieId}")
    public ResponseEntity<CinemaHall> associateMovieWithCinemaHall(
            @PathVariable Long cinemaHallId,
            @PathVariable Long movieId) {
        CinemaHall cinemaHall = cinemaHallService.associateMovieWithCinemaHall(cinemaHallId, movieId);
        return new ResponseEntity<>(cinemaHall, HttpStatus.OK);
    }
	
    @PostMapping("/search2")
    public ResponseEntity<List<CinemaHall>> searchCinemaHalls(@RequestBody CinemaHallSearchRequest searchRequest) {
        List<CinemaHall> cinemaHalls = cinemaHallService.findCinemaHallsByMovieAndLocation(searchRequest.getMovieId(), searchRequest.getLocation());
        return ResponseEntity.ok(cinemaHalls);
    }
//	@GetMapping("/byMovieAndLocation")
//	public ResponseEntity<List<CinemaHallDTO>> findCinemaHallByMovieAndLocation(@Valid @RequestBody CinemaHallSearchRequest request ){
//        List<CinemaHall> cinemaHalls = cinemaHallService.findCinemaHallsByMovieAndLocation(request.getMovieName(), request.getLocation());
//        
//        List<CinemaHallDTO> cinemaHallDTOs = cinemaHalls.stream()
//                .map(this::convertToDTO) // Assuming you have a method to convert entity to DTO
//                .collect(Collectors.toList());
//        
//        return ResponseEntity.ok(cinemaHallDTOs);
//	}
//	
//	private CinemaHallDTO convertToDTO(CinemaHall cinemaHall) {
//	    return new CinemaHallDTO(
//	            cinemaHall.getCinemaHallId(),
//	            cinemaHall.getName(),
//	            cinemaHall.getLocation(),
//	            null   ///nantar taku shows 
//	    );
//	}



}