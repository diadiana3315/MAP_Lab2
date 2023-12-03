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

            String query = "SELECT * FROM Pilots"; 

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id"); 
                    String name = resultSet.getString("name"); 

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
