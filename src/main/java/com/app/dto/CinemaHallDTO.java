//package com.app.dto;
//
//import java.util.Set;
//
//public class CinemaHallDTO {
//    private Long cinemaHallId;
//    private String name;
//    private String location;
//    private Set<Long> showIds; // List of Show IDs related to the CinemaHall
//
//    // Default constructor
//    public CinemaHallDTO() {
//    }
//
//    // Parameterized constructor
//    public CinemaHallDTO(Long cinemaHallId, String name, String location, Set<Long> showIds) {
//        this.cinemaHallId = cinemaHallId;
//        this.name = name;
//        this.location = location;
//        this.showIds = showIds;
//    }
//
//    // Getters and Setters
//    public Long getCinemaHallId() {
//        return cinemaHallId;
//    }
//
//    public void setCinemaHallId(Long cinemaHallId) {
//        this.cinemaHallId = cinemaHallId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public Set<Long> getShowIds() {
//        return showIds;
//    }
//
//    public void setShowIds(Set<Long> showIds) {
//        this.showIds = showIds;
//    }
//
//    @Override
//    public String toString() {
//        return "CinemaHallDTO [cinemaHallId=" + cinemaHallId + ", name=" + name + ", location=" + location + ", showIds=" + showIds + "]";
//    }
//}

package com.app.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CinemaHallDTO {
	
	
    private Long cinemaHallId;
    
    @NotBlank(message = "Name is Madanatory")
    private String name;
    
    @NotNull(message = "Location is madanatory")
    private String location;
    
    private Set<Long> showIds; // List of Show IDs related to the CinemaHall

    // Default constructor
    public CinemaHallDTO() {
    }

    // Parameterized constructor
    public CinemaHallDTO(Long cinemaHallId, String name, String location, Set<Long> showIds) {
        this.cinemaHallId = cinemaHallId;
        this.name = name;
        this.location = location;
        this.showIds = showIds;
    }
    

    // Getters and Setters
    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Long> getShowIds() {
        return showIds;
    }

    public void setShowIds(Set<Long> showIds) {
        this.showIds = showIds;
    }

    @Override
    public String toString() {
        return "CinemaHallDTO [cinemaHallId=" + cinemaHallId + ", name=" + name + ", location=" + location + ", showIds=" + showIds + "]";
    }
}