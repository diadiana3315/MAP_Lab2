package controller;

import domain.Flight;
import repository.FlightRepository;
import repository.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightController {
    private FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void saveFlight(Flight flight) throws SQLException {
        flightRepository.addFlight(flight);
    }

    public void removeFlight(int flightId) throws SQLException {
        flightRepository.deleteFlight(flightId);
    }

    public void getAllFlights() throws SQLException {
        flightRepository.viewFlights();
    }

//    public void updateFlight(int flightId, Flight updatedFlight) {
//        Flight existingFlight = flightRepository.getById(flightId);
//
//        if (existingFlight != null) {
//            flightRepository.remove(existingFlight);
//            flightRepository.save(updatedFlight);
//        } else {
//            System.out.println("Flight not found.");
//        }
//    }
//
//    public Flight getFlightById(int flightId) {
//        Flight flight = flightRepository.getById(flightId);
//        return flight;
//    }
}
