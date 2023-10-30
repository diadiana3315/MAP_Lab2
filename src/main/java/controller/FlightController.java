package controller;
import domain.Flight;
import repository.Repository;
import java.util.ArrayList;
import java.util.List;
public class FlightController {
    private Repository<Flight> flightRepository;
    public FlightController(Repository<Flight> flightRepository) {
        this.flightRepository = flightRepository;
    }
    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }
    public void removeFlight(int flightId) {
        List<Flight> flights = flightRepository.getAll();
        List<Flight> flightsToRemove = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getFlightId() == flightId) {
                flightsToRemove.add(flight);
            }
        }
        for (Flight flight : flightsToRemove) {
            flightRepository.remove(flight);
        }
    }
    public List<Flight> getAllFlights() {
        return flightRepository.getAll();
    }
}