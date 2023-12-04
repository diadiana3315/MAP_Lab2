package repository;
import domain.Pilot;

import java.sql.*;

public class PilotRepository extends Repository<Pilot> {

    private static Connection connection;

    public PilotRepository() {
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

    public void viewPilots() throws SQLException {
        String query = "SELECT * FROM Pilots";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int pilotId = resultSet.getInt("pilotId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                int yearsOfActivity = resultSet.getInt("yearsOfActivity");

                Pilot pilot = new Pilot(firstName, lastName, age, gender, pilotId, yearsOfActivity);

                System.out.println("Pilot ID: " + pilot.getPilotId() + ", Name: " + pilot.getFirstName() +
                        ", Age: " + pilot.getAge() + ", Gender: " + pilot.getGender() + ", Years of Activity: " + pilot.getYearsOfActivity());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void addPilot(Pilot pilot) throws SQLException {
        String query = "INSERT INTO Pilots (pilotId, firstName, lastName, age, gender, yearsOfActivity) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, pilot.getPilotId());
            preparedStatement.setString(2, pilot.getFirstName());
            preparedStatement.setString(3, pilot.getLastName());
            preparedStatement.setInt(4, pilot.getAge());
            preparedStatement.setString(5, pilot.getGender());
            preparedStatement.setInt(6, pilot.getYearsOfActivity());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void deletePilot(int pilotId) throws SQLException {
        String query = "DELETE FROM Pilots WHERE pilotId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, pilotId);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No pilot with the specified pilotId found for deletion.");
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
