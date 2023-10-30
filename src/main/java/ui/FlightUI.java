package ui;

import controller.FlightController;
import domain.Flight;

import java.util.Scanner;

public class FlightUI {
    private FlightController flightController;
    private Scanner scanner = new Scanner(System.in);

    public FlightUI(FlightController flightController) {
        this.flightController = flightController;
    }

    public void handleFlightOperations() {

        int option;
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);
        while (exit) {
            System.out.println("Select an option:\n");
            System.out.println("1. Add an object\n");
            System.out.println("2. Remove an object\n");
            System.out.println("3. View all objects\n");
            option = scanner.nextInt();
            int flightId;
            switch (option) {
                case 1:
                    flightId = scanner.nextInt();
                    scanner.nextLine();
                    String airline = scanner.nextLine();
                    String departureTime = scanner.nextLine();
                    String arrivalTime = scanner.nextLine();
                    Flight newFlight = new Flight(flightId, airline, departureTime, arrivalTime);
                    System.out.println("ok");
                    flightController.saveFlight(newFlight);
                    System.out.println("ok");
                    break;
                case 2:
                    flightId = scanner.nextInt();
                    flightController.removeFlight(flightId);
                    break;
                case 3:
                    System.out.println(flightController.getAllFlights());
                    break;
                case 0:
                    exit = false;
            }
        }
    }
}
