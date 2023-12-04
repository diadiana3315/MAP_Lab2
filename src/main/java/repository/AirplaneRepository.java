package repository;

import domain.Airplane;
import domain.Pilot;

import java.sql.*;

public class AirplaneRepository extends Repository<Airplane> {

    private static Connection connection;
    public AirplaneRepository(){
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

    public void viewAirplanes() throws SQLException{
        String query = "SELECT * FROM Airplane";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int airplaneId = resultSet.getInt("airplaneId");
                String manufacturer = resultSet.getString("manufacturer");
                String model = resultSet.getString("model");
                int pilotId = resultSet.getInt("pilotId");

                Pilot pilot = getPilotById(pilotId);


                Airplane airplane = new Airplane(airplaneId, manufacturer, model, pilot);

                System.out.println("Airplane ID: " + airplane.getAirplaneId() + ", Manufacturer: " + airplane.getManufacturer() + ", Model: " + airplane.getModel() +
                        ", Pilot: " + pilot.getPilotId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    public void addAirplane(Airplane airplane) throws SQLException{
        String query = "INSERT INTO Airplane (airplaneId, manufacturer, model, pilotId) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, airplane.getAirplaneId());
            preparedStatement.setString(2, airplane.getManufacturer());
            preparedStatement.setString(3, airplane.getModel());
            preparedStatement.setInt(4, airplane.getPilotId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void deleteAirplane(int airplaneId) throws SQLException {
        String query = "DELETE FROM AirlineCompany WHERE airlineId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, airplaneId);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No airplane with the specified airplaneId found for deletion.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private Pilot getPilotById(int pilotId){
        try {
            String query = "SELECT * FROM Pilots WHERE pilotId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, pilotId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String firstName = resultSet.getString("firstName");
                        String lastName = resultSet.getString("lastName");
                        int age = resultSet.getInt("age");
                        String gender = resultSet.getString("gender");
                        int yearsOfActivity = resultSet.getInt("yearsOfActivity");

                        return new Pilot(firstName, lastName, age, gender, pilotId, yearsOfActivity);
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
