package test;

import domain.Flight;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repository.FlightRepository;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class testFlight {
    private static FlightRepository flightRepository;
    private static Connection connection;

    @BeforeAll
    public static void setUp() throws SQLException {
        String url = "jdbc:sqlserver://DESKTOP-S0UCO99\\SQLEXPRESS:1433;databaseName=Airport;encrypt=true;trustServerCertificate=true";
        String user = "JavaProject";
        String password = "java123";
        flightRepository = new FlightRepository();
        connection = DriverManager.getConnection(url, user, password);
    }

    @Test
    public void testAddFlight() throws SQLException {
        Flight flight = new Flight(1, "Test Airline", "12:00:00", "14:00:00");
        flightRepository.addFlight(flight);
        Flight addedFlight = getFlightById(1);
        assertNotNull(addedFlight);
        assertEquals(flight.getFlightId(), addedFlight.getFlightId());
        assertEquals(flight.getAirline(), addedFlight.getAirline());
        assertEquals(flight.getDepartureTime(), addedFlight.getDepartureTime());
        assertEquals(flight.getArrivalTime(), addedFlight.getArrivalTime());
    }

    @Test
    public void testDeleteFlight() throws SQLException {
        int flightId = 1;
        flightRepository.deleteFlight(flightId);
        Flight deletedFlight = getFlightById(1);
        assertNull(deletedFlight);
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        flightRepository.closeConnection();
    }

    public Flight getFlightById(int flightId) throws SQLException {
        String query = "SELECT * FROM Flights WHERE flightId = ?";
        Flight flight = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, flightId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("flightId");
                    String airline = resultSet.getString("airline");
                    String departureTime = resultSet.getString("departureTime");
                    String arrivalTime = resultSet.getString("arrivalTime");

                    flight = new Flight(id, airline, departureTime, arrivalTime);
                }
            }
        }

        return flight;
    }
}
 