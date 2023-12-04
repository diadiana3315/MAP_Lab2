package ui;

import controller.FlightController;
import domain.Flight;
import domain.Passenger;

import java.sql.SQLException;
import java.util.Scanner;

public class FlightUI {
    private FlightController flightController;

    public FlightUI(FlightController flightController) {
        this.flightController = flightController;
    }

    public void handleFlightOperations() throws SQLException {
        int option;
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);

        while (exit) {
            System.out.println("Select an option:");
            System.out.println("1. Add a new flight");
            System.out.println("2. Remove a flight");
            System.out.println("3. View all flights");
            System.out.println("4. Update a flight");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Adding a new flight:");
                    System.out.print("Enter Flight ID: ");
                    int flightId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Airline: ");
                    String airline = scanner.nextLine();

                    System.out.print("Enter Departure Time: ");
                    String departureTime = scanner.nextLine();

                    System.out.print("Enter Arrival Time: ");
                    String arrivalTime = scanner.nextLine();

                    Flight newFlight = new Flight(flightId, airline, departureTime, arrivalTime);
                    flightController.saveFlight(newFlight);
                    System.out.println("Flight added successfully!");
                    break;

                case 2:
                    System.out.println("Removing a flight:");
                    System.out.print("Enter Flight ID to remove: ");
                    int flightIdToRemove = scanner.nextInt();
                    flightController.removeFlight(flightIdToRemove);
                    System.out.println("Flight removed successfully!");
                    break;

                case 3:
                    System.out.println("Viewing all flights:");
                    flightController.getAllFlights();
                    break;
//                case 4:
//                    System.out.println("Updating a flight:");
//                    System.out.print("Enter Flight ID to update: ");
//                    int flightIdToUpdate = scanner.nextInt();
//                    scanner.nextLine();
//
//                    Flight existingFlight = flightController.getFlightById(flightIdToUpdate);
//
//                    if (existingFlight != null) {
//                        System.out.println("Existing Flight Details: " + existingFlight);
//
//                        System.out.print("Enter new Airline: ");
//                        String newAirline = scanner.nextLine();
//                        System.out.print("Enter new Departure Time: ");
//                        String newDepartureTime = scanner.nextLine();
//                        System.out.print("Enter new Arrival Time: ");
//                        String newArrivalTime = scanner.nextLine();
//
//                        Flight updatedFlight = new Flight(flightIdToUpdate, newAirline, newDepartureTime, newArrivalTime);
//
//                        flightController.updateFlight(flightIdToUpdate, updatedFlight);
//
//                        System.out.println("Enter passenger details:");
//                        System.out.print("First Name: ");
//                        String firstName = scanner.nextLine();
//                        System.out.print("Last Name: ");
//                        String lastName = scanner.next();
//                        System.out.print("Age: ");
//                        int age = scanner.nextInt();
//                        scanner.nextLine();
//                        System.out.print("Gender: ");
//                        String gender = scanner.nextLine();
//                        System.out.print("Passenger ID: ");
//                        int passengerId = scanner.nextInt();
//                        scanner.nextLine();
//                        System.out.print("Passport Number: ");
//                        int passportNumber = scanner.nextInt();
//                        scanner.nextLine();
//
//                        Passenger passenger = new Passenger(firstName, lastName, age, gender, passengerId, passportNumber);
//                        existingFlight.addObserver(passenger);
//                        existingFlight.notifyObservers();
//
//                    } else {
//                        System.out.println("Flight not found.");
//                    }
//                    break;

                case 0:
                    exit = false;
                    System.out.println("Exiting the Flight Operations menu.");
                    break;

                default:
                    System.out.println("Invalid option. Please enter a valid option.");
                    break;
            }
        }
    }
}
