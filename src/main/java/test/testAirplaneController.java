package test;

import domain.Airplane;
import domain.Pilot;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repository.AirplaneRepository;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class testAirplaneController {

    private static AirplaneRepository airplaneRepository;
    private static Connection connection;

    @BeforeAll
    public static void setUp() throws SQLException {
        String url = "jdbc:sqlserver://DESKTOP-S0UCO99\\SQLEXPRESS:1433;databaseName=Airport;encrypt=true;trustServerCertificate=true";
        String user = "JavaProject";
        String password = "java123";

        connection = DriverManager.getConnection(url, user, password);
        airplaneRepository = new AirplaneRepository();
    }

    @Test
    public void testAddAirplane() throws SQLException {
        Airplane airplane = new Airplane(1, "Boeing", "747");

        airplaneRepository.addAirplane(airplane);

        Airplane addedAirplane = getAirplaneById(1);

        assertEquals(airplane.getAirplaneId(), addedAirplane.getAirplaneId());
        assertEquals(airplane.getManufacturer(), addedAirplane.getManufacturer());
        assertEquals(airplane.getModel(), addedAirplane.getModel());
    }

    @Test
    public void testRemoveAirplane() throws SQLException {
        int airplaneId = 1;

        airplaneRepository.deleteAirplane(airplaneId);

        Airplane removedAirplane = getAirplaneById(1);

        assertNull(removedAirplane);
    }

    private Airplane getAirplaneById(int airplaneId) throws SQLException {
        String query = "SELECT * FROM Airplane WHERE airplaneId = ?";
        Airplane airplane = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, airplaneId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("airplaneId");
                    String manufacturer = resultSet.getString("manufacturer");
                    String model = resultSet.getString("model");

                    airplane = new Airplane(id, manufacturer, model);
                }
            }
        }

        return airplane;
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

}
