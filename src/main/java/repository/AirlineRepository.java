package repository;

import domain.AirlineCompany;
import java.sql.*;

public class AirlineRepository extends Repository<AirlineCompany>{

    private static Connection connection;
    public AirlineRepository(){
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

    public void viewAirlines() throws SQLException{
        String query = "SELECT * FROM AirlineCompany";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int airlineId = resultSet.getInt("airlineId");
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                int fleetSize = resultSet.getInt("fleetSize");
                int nrEmployees = resultSet.getInt("nrEmployees");


                AirlineCompany airlineCompany = new AirlineCompany(airlineId, name, country, fleetSize, nrEmployees);

                System.out.println("Airline ID: " + airlineCompany.getId() + ", Name: " + airlineCompany.getName() + ", Country: " + airlineCompany.getCountry() +
                        ", Fleet size: " + airlineCompany.getFleetSize() + ", Nr. employees: " + airlineCompany.getNrEmployees());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    public void addAirline(AirlineCompany airline) throws SQLException{
        String query = "INSERT INTO AirlineCompany (airlineId, name, country, fleetSize, nrEmployees) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, airline.getId());
            preparedStatement.setString(2, airline.getName());
            preparedStatement.setString(3, airline.getCountry());
            preparedStatement.setInt(4, airline.getFleetSize());
            preparedStatement.setInt(5, airline.getNrEmployees());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public void deleteAirline(int airlineId) throws SQLException {
        String query = "DELETE FROM AirlineCompany WHERE airlineId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, airlineId);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No airline with the specified airlineId found for deletion.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
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
