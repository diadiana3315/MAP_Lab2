package repository;

import domain.Flight;

import java.sql.*;

public class FlightRepository {

    private static Connection connection;

    public FlightRepository() {
        try {
            connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void connect() throws SQLException {
        String url = "jdbc:sqlserver://DESKTOP-S0UCO99\\SQLEXPRESS:1433;databaseName=Airport;encrypt=true;trustServerCertificate=true";
        String user = "JavaProject";
        String password = "java123";

        this.connection = DriverManager.getConnection(url, user, password);
    }

    public void viewFlights() throws SQLException {
        String query = "SELECT * FROM Flights";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int flightId = resultSet.getInt("flightId");
                String airline = resultSet.getString("airline");
                String departureTime = resultSet.getString("departureTime");
                String arrivalTime = resultSet.getString("arrivalTime");

                System.out.println("ID: " + flightId + ", Airline: " + airline + ", departureTime: " + departureTime + ", arrivalTime: " + arrivalTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addFlight(Flight flight) throws SQLException {
        String query = "INSERT INTO Flights (flightId, airline, departureTime, arrivalTime) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, flight.getFlightId());
            preparedStatement.setString(2, flight.getAirline());
            preparedStatement.setString(3, flight.getDepartureTime());
            preparedStatement.setString(4, flight.getArrivalTime());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFlight(int flightId) throws SQLException {
        String query = "DELETE FROM Flights WHERE flightId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, flightId);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No flight with the specified flightId found for deletion.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
