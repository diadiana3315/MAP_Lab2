package ui;
import controller.FlightController;
import controller.AirlineController;
import controller.TicketController;


import java.util.Scanner;

public class UI {
    private FlightController flightController;
    private AirlineController airlineController;
    private TicketController ticketController;
    private Scanner scanner = new Scanner(System.in);

    public UI(FlightController flightController, AirlineController airlineController, TicketController ticketController) {
        this.flightController = flightController;
        this.airlineController = airlineController;
        this.ticketController = ticketController;
    }

    public void start() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Select an entity to work on:");
            System.out.println("1. Flight");
            System.out.println("2. Airline Company");
            System.out.println("3. Ticket");
            System.out.println("4. Exit");

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
                    TicketUI ticketUI = new TicketUI(ticketController);
                    ticketUI.handleTicketOperations();
                    break;
                case 4:
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

