package org.example;

import controller.AirlineController;
import controller.FlightController;
import repository.AirlineRepository;
import repository.FlightRepository;
import ui.UI;

public class Main {
    public static void main(String[] args) {
        FlightRepository flightRepository = new FlightRepository();
        AirlineRepository airlineRepository = new AirlineRepository();

        FlightController flightController = new FlightController(flightRepository);
        AirlineController airlineController = new AirlineController(airlineRepository);

        UI ui = new UI(flightController, airlineController);
        ui.start();

    }
}
