package repository;

import domain.Airplane;
import domain.Flight;
import domain.FlightDelayLog;
import domain.Pilot;

import java.sql.*;

public class FlightDelayLogRepository extends Repository<FlightDelayLog> {

    private static Connection connection;
    public FlightDelayLogRepository(){
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

    public void viewFlightDelay() throws SQLException{
        String query = "SELECT * FROM FlightDelayLog";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int logId = resultSet.getInt("logId");
                int flightNumber = resultSet.getInt("flightNumber");
                String delayReason = resultSet.getString("delayReason");
                int duration = resultSet.getInt("duration");
                int flightId = resultSet.getInt("flightId");

                Flight flight = getFlightById(flightId);


                FlightDelayLog flightDelayLog = new FlightDelayLog(logId, flightNumber, delayReason, duration, flight);

                System.out.println("Log ID: " + flightDelayLog.getID() + ", Flight Number: " + flightDelayLog.getFlightNumber() + ", Delay reason: " + flightDelayLog.getDelayReason() +
                        ", Duration: " + flightDelayLog.getDuration() + ", Flight: " + flightDelayLog.getFlight());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
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

    public void addFlightDelay(FlightDelayLog flightDelayLog) throws SQLException{
        String query = "INSERT INTO FlightDelayLog (airplaneId, manufacturer, model, pilotId) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, flightDelayLog.getID());
            preparedStatement.setInt(2, flightDelayLog.getFlightNumber());
            preparedStatement.setString(3, flightDelayLog.getDelayReason());
            preparedStatement.setInt(4, flightDelayLog.getDuration());
            preparedStatement.setInt(5, flightDelayLog.getFlight().getFlightId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void deleteFlightDelay(int logId) throws SQLException {
        String query = "DELETE FROM FlightDelayLog WHERE logId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, logId);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No flight delays with the specified logId found for deletion.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
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
