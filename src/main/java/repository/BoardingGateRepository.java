package repository;

import domain.AirlineCompany;
import domain.BoardingGate;

import java.sql.*;

public class BoardingGateRepository extends Repository<BoardingGate> {

    private static Connection connection;
    public BoardingGateRepository(){
        try {
            connect();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void connect() throws SQLException {
        String url = "jdbc:sqlserver://DESKTOP-S0UCO99\\SQLEXPRESS:1433;databaseName=Airport;encrypt=true;trustServerCertificate=true";
        String user = "JavaProject";
        String password = "java123";
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public void viewBoradingGates() throws SQLException{
        String query = "SELECT * FROM BoardingGates";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int gateNumber = resultSet.getInt("gateNumber");
                int aircraftId = resultSet.getInt("aircraftId");
                int airlineId = resultSet.getInt("airlineId");
                int flightNumber = resultSet.getInt("flightNumber");
                int departureTime = resultSet.getInt("departureTime");

                AirlineCompany airline = getAirlineById(airlineId);

                BoardingGate boardingGate = new BoardingGate(gateNumber, aircraftId, airline, flightNumber, departureTime);

                System.out.println("Gate number: " + boardingGate.getGateNumber() + ", Aircraft: " + boardingGate.getAircraftID() + ", Airline: " + boardingGate.getAirline() +
                        ", Flight number: " + boardingGate.getFlightNumber() + ", Departure time: " + boardingGate.getDepartureTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    public void addBoardingGate(BoardingGate boardingGate) throws SQLException{
        String query = "INSERT INTO BoardingGates (gateNumber, aircraftId, airline, flightNumber, departureTime) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, boardingGate.getGateNumber());
            preparedStatement.setInt(2, boardingGate.getAircraftID());
            preparedStatement.setInt(3, boardingGate.getAirline().getId());
            preparedStatement.setInt(4, boardingGate.getFlightNumber());
            preparedStatement.setInt(5, boardingGate.getDepartureTime());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void deleteBoardingGate(int gateNumber) throws SQLException {
        String query = "DELETE FROM BoardingGates WHERE gateNumber = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, gateNumber);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No boarding gate with the specified gate number found for deletion.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private AirlineCompany getAirlineById(int airlineId){
        try {
            String query = "SELECT * FROM AirlineCompany WHERE airlineId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, airlineId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String name = resultSet.getString("name");
                        String country = resultSet.getString("country");
                        int fleetSize = resultSet.getInt("fleetSize");
                        int nrEmployees = resultSet.getInt("nrEmployees");

                        return new AirlineCompany(airlineId, name, country, fleetSize, nrEmployees);
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
