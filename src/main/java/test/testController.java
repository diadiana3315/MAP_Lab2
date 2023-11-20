package test;

import controller.FlightController;
import domain.Flight;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.FlightRepository;
import repository.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testController {

    private FlightController flightController;
    private Repository<Flight> flightRepository;

    @BeforeEach
    void setUp() {
        flightRepository = new FlightRepository();
        flightController = new FlightController((FlightRepository) flightRepository);
    }

    @Test
    void saveFlightTest() {
        Flight flight = new Flight(1, "Airline", "Departure", "Arrival");

        flightController.saveFlight(flight);

        List<Flight> flights = flightRepository.getAll();

        assertEquals(1, flights.size());
        assertEquals(flight, flights.get(0));
    }

    @Test
    void saveMultipleFlightsTest() {
        Flight flight1 = new Flight(1, "Airline1", "Departure1", "Arrival1");
        Flight flight2 = new Flight(2, "Airline2", "Departure2", "Arrival2");

        flightController.saveFlight(flight1);
        flightController.saveFlight(flight2);

        List<Flight> flights = flightRepository.getAll();

        assertEquals(2, flights.size());
        assertEquals(List.of(flight1, flight2), flights);
    }

    @Test
    void removeFlightTest() {
        Flight flightToRemove = new Flight(1, "Airline", "Departure", "Arrival");

        flightRepository.save(flightToRemove);

        flightController.removeFlight(flightToRemove.getFlightId());

        List<Flight> flights = flightRepository.getAll();

        assertEquals(0, flights.size());
    }
}
