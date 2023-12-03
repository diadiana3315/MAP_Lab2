package repository;

import domain.Flight;
import domain.Passenger;
import domain.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketRepository extends Repository<Ticket> {

    private static Connection connection;

    public TicketRepository() {
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

    public void viewTickets() throws SQLException {
        String query = "SELECT * FROM Tickets";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int ticketId = resultSet.getInt("ticketId");
                int passengerId = resultSet.getInt("passengerId");
                int flightId = resultSet.getInt("flightId");
                double price = resultSet.getDouble("price");

                Passenger passenger = getPassengerById(passengerId);
                Flight flight = getFlightById(flightId);

                Ticket ticket = new Ticket(ticketId, passenger, flight, price);

                System.out.println("Ticket ID: " + ticket.getTicketId() + ", Passenger: " + passenger.getPassengerId() + ", Flight: " + flight.getFlightId() +
                        ", Price: " + ticket.getPrice());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void addTicket(Ticket ticket) throws SQLException {
        String query = "INSERT INTO Tickets (ticketId, passengerId, flightId, price) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, ticket.getTicketId());
            preparedStatement.setInt(2, ticket.getPassengerId());
            preparedStatement.setInt(3, ticket.getFlightId());
            preparedStatement.setDouble(4, ticket.getPrice());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void deleteTicket(int ticketId) throws SQLException {
        String query = "DELETE FROM Tickets WHERE ticketId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, ticketId);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No ticket with the specified ticketId found for deletion.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private Passenger getPassengerById(int passengerId) {
        try {
            String query = "SELECT * FROM Passengers WHERE passengerId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, passengerId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String firstName = resultSet.getString("firstName");
                        String lastName = resultSet.getString("lastName");
                        int age = resultSet.getInt("age");
                        String gender = resultSet.getString("gender");
                        int passportNumber = resultSet.getInt("passportNumber");

                        return new Passenger(firstName, lastName, age, gender, passengerId, passportNumber);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    private Flight getFlightById(int flightId) {
        try {
            String query = "SELECT * FROM Flights WHERE flightId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, flightId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String airline = resultSet.getString("airline");
                        String departureTime = resultSet.getString("departureTime");
                        String arrivalTime = resultSet.getString("arrivalTime");

                        return new Flight(flightId, airline, departureTime, arrivalTime);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }


    private void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
