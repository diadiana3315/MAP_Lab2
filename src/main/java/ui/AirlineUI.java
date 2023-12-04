package ui;

import controller.AirlineController;
import domain.AirlineCompany;

import java.sql.SQLException;
import java.util.Scanner;

public class AirlineUI {
    private AirlineController airlineController;

    public AirlineUI(AirlineController airlineController) {
        this.airlineController = airlineController;
    }

    public void handleAirlineOperations() throws SQLException {
        int option;
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);

        while (exit) {
            System.out.println("Select an option:");
            System.out.println("1. Add a new airline");
            System.out.println("2. Remove an airline");
            System.out.println("3. View all airlines");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Adding a new airline:");
                    System.out.print("Enter Airline ID: ");
                    int airlineId = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character left by nextInt()

                    System.out.print("Enter Airline Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Country: ");
                    String country = scanner.nextLine();

                    System.out.print("Enter Fleet Size: ");
                    int fleetSize = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Number of Employees: ");
                    int nrEmployees = scanner.nextInt();
                    scanner.nextLine();

                    AirlineCompany newAirline = new AirlineCompany(airlineId, name, country, fleetSize, nrEmployees);
                    airlineController.addAirline(newAirline);
                    System.out.println("Airline added successfully!");
                    break;

                case 2:
                    System.out.println("Removing an airline:");
                    System.out.print("Enter Airline ID to remove: ");
                    int airlineIdToRemove = scanner.nextInt();
                    airlineController.removeAirline(airlineIdToRemove);
                    System.out.println("Airline removed successfully!");
                    break;

                case 3:
                    System.out.println("Viewing all airlines:");
                    airlineController.getAllAirlines();
                    break;

                case 0:
                    exit = false;
                    System.out.println("Exiting the Airline Operations menu.");
                    break;

                default:
                    System.out.println("Invalid option. Please enter a valid option.");
                    break;
            }
        }
    }
}
