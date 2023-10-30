package ui;
import controller.FlightController;
import domain.Flight;
import repository.FlightRepository;
import controller.AirlineController;
import domain.AirlineCompany;

import java.util.Scanner;

public class UI {
    private FlightController flightController;
    private AirlineController airlineController;
    private Scanner scanner = new Scanner(System.in);

    public UI(FlightController flightController, AirlineController airlineController) {
        this.flightController = flightController;
        this.airlineController = airlineController;
    }

    public void start() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Select an entity to work on:");
            System.out.println("1. Flight");
            System.out.println("2. Airline Company");
            System.out.println("3. Exit");

            int entityChoice = scanner.nextInt();
            scanner.nextLine();

            switch (entityChoice) {
                case 1:
                    FlightUI flightUI = new FlightUI(flightController);
                    flightUI.handleFlightOperations();
                    break;
                case 2:
                    AirlineUI airlineUI = new AirlineUI(airlineController);
                    airlineUI.handleAirlineOperations();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("Exiting the program.");
        scanner.close();
    }
}

