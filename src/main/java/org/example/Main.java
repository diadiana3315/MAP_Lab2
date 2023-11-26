package org.example;

import java.sql.*;

import controller.AirTrafficControlController;
import controller.AirlineController;
import controller.FlightController;
import controller.TicketController;
import repository.AirTrafficControlRepository;
import repository.AirlineRepository;
import repository.FlightRepository;
import repository.TicketRepository;
import ui.UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//        FlightRepository flightRepository = new FlightRepository();
//        AirlineRepository airlineRepository = new AirlineRepository();
//        TicketRepository ticketRepository = new TicketRepository();
//        AirTrafficControlRepository airTrafficControlRepository = new AirTrafficControlRepository();
//
//        FlightController flightController = new FlightController(flightRepository);
//        AirlineController airlineController = new AirlineController(airlineRepository);
//        TicketController ticketController = new TicketController(ticketRepository);
//        AirTrafficControlController airTrafficControlController = new AirTrafficControlController(airTrafficControlRepository);
//
//
//        UI ui = new UI(airTrafficControlController, flightController, airlineController, ticketController);
//        ui.start();

        String url = "jdbc:sqlserver://DESKTOP-S0UCO99\\SQLEXPRESS:1433;databaseName=Airport;encrypt=true;trustServerCertificate=true";
        String user = "JavaProject";
        String password = "java123";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            System.out.println("Connected to server");

            String query = "SELECT * FROM Pilots"; // Replace YourTableName with an actual table name

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    // Retrieve data from the result set
                    int id = resultSet.getInt("id"); // Replace "id" with an actual column name
                    String name = resultSet.getString("name"); // Replace "name" with an actual column name

                    // Process the retrieved data (e.g., print it)
                    System.out.println("ID: " + id + ", Name: " + name);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
