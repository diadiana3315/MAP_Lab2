package ui;

import controller.AirTrafficControlController;
import controller.AirlineController;
import controller.FlightController;
import domain.Airplane;
import domain.Flight;
import domain.Pilot;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminUI {
    private AirTrafficControlController airTrafficControlController;
    private FlightController flightController;
    private AirlineController airlineController;
    private Scanner scanner = new Scanner(System.in);

    public AdminUI(AirTrafficControlController airTrafficControlController, FlightController flightController, AirlineController airlineController) {
        this.airTrafficControlController = airTrafficControlController;
        this.flightController = flightController;
        this.airlineController = airlineController;
    }

    public void start() throws SQLException {
        boolean exit = false;

        while (!exit) {

            System.out.println("Select an option:");
            System.out.println("1. Use ATC system");
            System.out.println("2. Work on an entity");

            int optionChoice = scanner.nextInt();
            scanner.nextLine();

            switch (optionChoice){
                case 1:
                    System.out.println("Select an option:");
                    System.out.println("1. Assign pilot to flight");
                    System.out.println("2. Assign airplane to flight");
                    System.out.println("3. Get pilot for flight");
                    System.out.println("4. Get airplane for flight");

                    int optionChoice2 = scanner.nextInt();
                    scanner.nextLine();

                    switch (optionChoice2) {
                        case 1:
                            System.out.println("First name:");
                            String fn = scanner.nextLine();
                            System.out.println("Last name:");
                            String ln = scanner.nextLine();
                            System.out.println("Age:");
                            int age = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Gender:");
                            String gender = scanner.nextLine();
                            System.out.println("Pilot Id:");
                            int pilotId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Years of activity:");
                            int yoa = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Flight ID:");
                            int flightId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Airline:");
                            String airline = scanner.nextLine();
                            System.out.println("Departure Time:");
                            String departureTime = scanner.nextLine();
                            System.out.println("Arrival Time:");
                            String arrivalTime = scanner.nextLine();

                            Pilot pilot = new Pilot(fn, ln, age, gender, pilotId, yoa);
                            Flight flight = new Flight(flightId, airline, departureTime, arrivalTime);

                            airTrafficControlController.assignPilotToFlight(pilot, flight);
                            break;

                        case 2:

                            System.out.println("Flight ID:");
                            flightId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Airline:");
                            airline = scanner.nextLine();
                            System.out.println("Departure Time:");
                            departureTime = scanner.nextLine();
                            System.out.println("Arrival Time:");
                            arrivalTime = scanner.nextLine();

                            System.out.println("Airplane Id:");
                            int airplaneId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Manufacturer:");
                            String manufacturer = scanner.nextLine();
                            System.out.println("Model:");
                            String model = scanner.nextLine();

                            System.out.println("First name:");
                            fn = scanner.nextLine();
                            System.out.println("Last name:");
                            ln = scanner.nextLine();
                            System.out.println("Age:");
                            age = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Gender:");
                            gender = scanner.nextLine();
                            System.out.println("Pilot Id:");
                            pilotId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Years of activity:");
                            yoa = scanner.nextInt();
                            scanner.nextLine();

                            Pilot pilot2 = new Pilot(fn, ln, age, gender, pilotId, yoa);
                            Flight flight2 = new Flight(flightId, airline, departureTime, arrivalTime);
                            Airplane airplane = new Airplane(airplaneId, manufacturer, model, pilot2);

                            airTrafficControlController.assignAirPlaneToFlight(airplane, flight2);
                            break;

                        case 3:
                            System.out.println("Get pilot for flight\n");
                            System.out.println("Insert Id:");
                            flightId = scanner.nextInt();
                            scanner.nextLine();
                            airTrafficControlController.getPilotForFlightById(flightId);
                            break;

                        case 4:
                            System.out.println("Get plane for flight\n");
                            System.out.println("Insert Id:");
                            flightId = scanner.nextInt();
                            scanner.nextLine();
                            airTrafficControlController.getPlaneForFlightById(flightId);
                            break;
                    }

                case 2:
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
                    break;
            }

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

