package com.twa.reservations.model;

import java.util.List;
import java.util.Objects;

public class Reservation {

    private Long id;
    private List<Passenger> passengers;

    private Itinerary itinerary;

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id) && Objects.equals(passengers, that.passengers)
                && Objects.equals(itinerary, that.itinerary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passengers, itinerary);
    }
}
