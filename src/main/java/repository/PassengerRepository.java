package repository;
import domain.Passenger;

import java.sql.*;

public class PassengerRepository {

    private static Connection connection;

    public PassengerRepository() {
        try {
            connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void connect() throws SQLException {
        String url = "jdbc:sqlserver://DESKTOP-S0UCO99\\SQLEXPRESS:1433;databaseName=YourDatabaseName;encrypt=true;trustServerCertificate=true";
        String user = "JavaProject";
        String password = "java123";

        this.connection = DriverManager.getConnection(url, user, password);
    }

    public void viewPassengers() throws SQLException {
        String query = "SELECT * FROM Passengers";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int passengerId = resultSet.getInt("passengerId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                int passportNumber = resultSet.getInt("passportNumber");

                Passenger passenger = new Passenger(firstName, lastName, age, gender, passengerId, passportNumber);

                System.out.println("Passenger ID: " + passenger.getPassengerId() + ", Name: " + passenger.getFirstName() +
                        ", Age: " + passenger.getAge() + ", Gender: " + passenger.getGender() + ", Passport Number: " + passenger.getPassportNumber());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void addPassenger(Passenger passenger) throws SQLException {
        String query = "INSERT INTO Passengers (passengerId, firstName, lastName, age, gender, passportNumber) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, passenger.getPassengerId());
            preparedStatement.setString(2, passenger.getFirstName());
            preparedStatement.setString(3, passenger.getLastName());
            preparedStatement.setInt(4, passenger.getAge());
            preparedStatement.setString(5, passenger.getGender());
            preparedStatement.setInt(6, passenger.getPassportNumber());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void deletePassenger(int passengerId) throws SQLException {
        String query = "DELETE FROM Passengers WHERE passengerId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, passengerId);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No passenger with the specified passengerId found for deletion.");
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
