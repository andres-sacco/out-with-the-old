package com.twa.reservations.util;

import com.twa.reservations.dto.*;
import com.twa.reservations.model.*;
import net.datafaker.Faker;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ReservationUtil {

    private static final Faker faker = new Faker();

    public static ReservationDTO getReservationDTO(Long id, String origin, String destination) {
        // Passenger
        PassengerDTO passenger = new PassengerDTO();
        passenger.setFirstName(faker.name().firstName());
        passenger.setLastName(faker.name().lastName());
        passenger.setDocumentType(faker.options().option("DNI", "Passport", "ID Card"));
        passenger.setDocumentNumber(faker.number().digits(8));
        passenger.setBirthday(faker.date().birthday().toLocalDateTime().toLocalDate());

        // Price
        PriceDTO price = new PriceDTO();
        price.setBasePrice(BigDecimal.valueOf(faker.number().randomDouble(2, 100, 1000)));
        price.setTotalTax(BigDecimal.valueOf(faker.number().randomDouble(2, 10, 200)));
        price.setTotalPrice(price.getBasePrice().add(price.getTotalTax()));

        // Segment
        SegmentDTO segment = new SegmentDTO();
        segment.setArrival(
                faker.date().future(10, java.util.concurrent.TimeUnit.DAYS).toLocalDateTime().toLocalDate().toString());
        segment.setDeparture(
                faker.date().past(10, java.util.concurrent.TimeUnit.DAYS).toLocalDateTime().toLocalDate().toString());
        segment.setOrigin(origin != null ? origin : faker.aviation().airport());
        segment.setDestination(destination != null ? destination : faker.regexify("[A-Z]{3}"));
        segment.setCarrier(faker.aviation().airline());

        // Itinerary
        ItineraryDTO itinerary = new ItineraryDTO();
        itinerary.setPrice(price);
        itinerary.setSegment(List.of(segment));

        // Reservation
        ReservationDTO reservation = new ReservationDTO();
        reservation.setId(id);
        reservation.setPassengers(List.of(passenger));
        reservation.setItinerary(itinerary);

        return reservation;
    }

    public static Reservation getReservation(Long id, String origin, String destination) {
        Passenger passenger = new Passenger();
        passenger.setFirstName(faker.name().firstName());
        passenger.setLastName(faker.name().lastName());
        passenger.setId(faker.number().randomNumber());
        passenger.setDocumentType(faker.options().option("DNI", "Passport", "ID Card"));
        passenger.setDocumentNumber(faker.number().digits(8));
        passenger.setBirthday(faker.date().birthday().toLocalDateTime().toLocalDate());

        Price price = new Price();
        price.setBasePrice(BigDecimal.valueOf(faker.number().randomDouble(2, 100, 1000)));
        price.setTotalTax(BigDecimal.valueOf(faker.number().randomDouble(2, 10, 200)));
        price.setTotalPrice(price.getBasePrice().add(price.getTotalTax()));

        Segment segment = new Segment();
        segment.setArrival(
                faker.date().future(10, java.util.concurrent.TimeUnit.DAYS).toLocalDateTime().toLocalDate().toString());
        segment.setDeparture(
                faker.date().past(10, java.util.concurrent.TimeUnit.DAYS).toLocalDateTime().toLocalDate().toString());
        segment.setOrigin(origin != null ? origin : faker.aviation().airport());
        segment.setDestination(destination != null ? destination : faker.regexify("[A-Z]{3}"));
        segment.setCarrier(faker.aviation().airline());
        segment.setId(faker.number().randomNumber());

        Itinerary itinerary = new Itinerary();
        itinerary.setId(faker.number().randomNumber());
        itinerary.setPrice(price);
        itinerary.setSegment(List.of(segment));

        Reservation reservation = new Reservation();
        reservation.setId(id);
        reservation.setPassengers(List.of(passenger));
        reservation.setItinerary(itinerary);

        return reservation;
    }

    public static ReservationDTO getOldReservationDTO(Long id, String origin, String destination) {
        PassengerDTO passenger = new PassengerDTO();
        passenger.setFirstName("Andres");
        passenger.setLastName("Sacco");
        passenger.setDocumentType("DNI");
        passenger.setDocumentNumber("12345678");
        passenger.setBirthday(LocalDate.of(1985, 1, 1));

        PriceDTO price = new PriceDTO();
        price.setBasePrice(BigDecimal.ONE);
        price.setTotalTax(BigDecimal.ZERO);
        price.setTotalPrice(BigDecimal.ONE);

        SegmentDTO segment = new SegmentDTO();
        segment.setArrival("2025-01-01");
        segment.setDeparture("2024-12-31");
        segment.setOrigin(origin);
        segment.setDestination(destination);
        segment.setCarrier("AA");

        ItineraryDTO itinerary = new ItineraryDTO();
        itinerary.setPrice(price);
        itinerary.setSegment(List.of(segment));

        ReservationDTO reservation = new ReservationDTO();
        reservation.setId(id);
        reservation.setPassengers(List.of(passenger));
        reservation.setItinerary(itinerary);

        return reservation;
    }

    public static Reservation getOldReservation(Long id, String origin, String destination) {
        Passenger passenger = new Passenger();
        passenger.setFirstName("Andres");
        passenger.setLastName("Sacco");
        passenger.setId(1L);
        passenger.setDocumentType("DNI");
        passenger.setDocumentNumber("12345678");
        passenger.setBirthday(LocalDate.of(1985, 1, 1));

        Price price = new Price();
        price.setBasePrice(BigDecimal.ONE);
        price.setTotalTax(BigDecimal.ZERO);
        price.setTotalPrice(BigDecimal.ONE);

        Segment segment = new Segment();
        segment.setArrival("2025-01-01");
        segment.setDeparture("2024-12-31");
        segment.setOrigin(origin);
        segment.setDestination(destination);
        segment.setCarrier("AA");
        segment.setId(1L);

        Itinerary itinerary = new Itinerary();
        itinerary.setId(1L);
        itinerary.setPrice(price);
        itinerary.setSegment(List.of(segment));

        Reservation reservation = new Reservation();
        reservation.setId(id);
        reservation.setPassengers(List.of(passenger));
        reservation.setItinerary(itinerary);

        return reservation;
    }
}