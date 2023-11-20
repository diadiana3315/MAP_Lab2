package ui;

import controller.AirTrafficControlController;
import controller.AirlineController;
import controller.FlightController;
import controller.TicketController;

import java.util.Scanner;

public class UI {
    private AirTrafficControlController airTrafficControlController;
    private FlightController flightController;
    private AirlineController airlineController;
    private TicketController ticketController;

    private Scanner scanner = new Scanner(System.in);

    public UI(AirTrafficControlController airTrafficControlController, FlightController flightController, AirlineController airlineController, TicketController ticketController) {
        this.airTrafficControlController = airTrafficControlController;
        this.flightController = flightController;
        this.airlineController = airlineController;
        this.ticketController = ticketController;
    }

    public void start() {
        boolean exit = false;

        while (!exit) {

            System.out.println("Select a menu:");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");

            int menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (menuChoice) {
                case 1:
                    AdminUI adminUI = new AdminUI(airTrafficControlController, flightController, airlineController);
                    adminUI.start();
                    break;

                case 2:
                    UserUI userUI = new UserUI(ticketController);
                    userUI.handleTicketOperations();
                    break;

                case 3:
                    exit = true;
                    break;
            }
        }
    }
}
