package com.Audience.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class OfflineConference extends Conference {

    @Column(name = "venue_details")
    private String venueDetails;

    @Column(name = "seating_capacity")
    private Integer seatingCapacity;

    public String getVenueDetails() {
        return venueDetails;
    }

    public void setVenueDetails(String venueDetails) {
        this.venueDetails = venueDetails;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

}
