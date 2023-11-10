package repository;
import domain.Flight;
import java.util.ArrayList;
import java.util.List;
public class FlightRepository implements Repository<Flight> {
    private List<Flight> flights = new ArrayList<>();

    public FlightRepository() {
        this.flights = new ArrayList<Flight>();
    }

    @Override
    public void save(Flight flight) {
        flights.add(flight);
    }

    @Override
    public void remove(Flight flight) {
        flights.remove(flight);
    }

    @Override
    public List<Flight> getAll() {
        return flights;
    }

    public Flight getById(int flightId) {
        for (Flight flight : flights) {
            if (flight.getFlightId() == flightId) {
                return flight;
            }
        }
        return null;
    }
}