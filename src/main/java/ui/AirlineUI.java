package ui;

import controller.AirlineController;
import domain.AirlineCompany;

import java.util.Scanner;

public class AirlineUI {
    private AirlineController airlineController;
    private Scanner scanner = new Scanner(System.in);

    public AirlineUI(AirlineController airlineController) {
        this.airlineController = airlineController;
    }

    public void handleAirlineOperations() {

        int option;
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);
        while (exit) {
            System.out.println("Select an option:\n");
            System.out.println("1. Add an object\n");
            System.out.println("2. Remove an object\n");
            System.out.println("3. View all objects\n");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    int airlineId = scanner.nextInt();
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    String country = scanner.nextLine();
                    int fleetSize = scanner.nextInt();
                    scanner.nextLine();
                    int nrEmployees = scanner.nextInt();
                    scanner.nextLine();
                    AirlineCompany newAirline = new AirlineCompany(airlineId, name, country, fleetSize, nrEmployees);
                    airlineController.addAirline(newAirline);
                    break;
                case 2:
                    airlineId = scanner.nextInt();
                    airlineController.removeAirline(airlineId);
                    break;
                case 3:
                    System.out.println(airlineController.getAllAirlines());
                    break;
                case 0:
                    exit = false;
            }
        }
    }
}

