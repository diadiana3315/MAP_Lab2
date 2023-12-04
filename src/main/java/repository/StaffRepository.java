package repository;
import domain.Staff;

import java.sql.*;

public class StaffRepository {

    private static Connection connection;

    public StaffRepository() {
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

    public void viewStaffMembers() throws SQLException {
        String query = "SELECT * FROM StaffMembers";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int staffId = resultSet.getInt("staffId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String role = resultSet.getString("role");

                Staff staff = new Staff(firstName, lastName, age, gender, staffId, role);

                System.out.println("Staff ID: " + staff.getStaffId() + ", Name: " + staff.getFirstName() +
                        ", Age: " + staff.getAge() + ", Gender: " + staff.getGender() + ", Role: " + staff.getRole());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void addStaffMember(Staff staff) throws SQLException {
        String query = "INSERT INTO StaffMembers (staffId, firstName, lastName, age, gender, role) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, staff.getStaffId());
            preparedStatement.setString(2, staff.getFirstName());
            preparedStatement.setString(3, staff.getLastName());
            preparedStatement.setInt(4, staff.getAge());
            preparedStatement.setString(5, staff.getGender());
            preparedStatement.setString(6, staff.getRole());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void deleteStaffMember(int staffId) throws SQLException {
        String query = "DELETE FROM StaffMembers WHERE staffId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, staffId);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No staff member with the specified staffId found for deletion.");
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
