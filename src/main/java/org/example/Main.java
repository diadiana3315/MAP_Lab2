package org.example;

import controller.AirTrafficControlController;
import controller.AirlineController;
import controller.FlightController;
import controller.TicketController;
import repository.AirTrafficControlRepository;
import repository.AirlineRepository;
import repository.FlightRepository;
import repository.TicketRepository;
import ui.UI;

public class Main {
    public static void main(String[] args) {
        FlightRepository flightRepository = new FlightRepository();
        AirlineRepository airlineRepository = new AirlineRepository();
        TicketRepository ticketRepository = new TicketRepository();
        AirTrafficControlRepository airTrafficControlRepository = new AirTrafficControlRepository();

        FlightController flightController = new FlightController(flightRepository);
        AirlineController airlineController = new AirlineController(airlineRepository);
        TicketController ticketController = new TicketController(ticketRepository);
        AirTrafficControlController airTrafficControlController = new AirTrafficControlController(airTrafficControlRepository);


        UI ui = new UI(airTrafficControlController, flightController, airlineController, ticketController);
        ui.start();
    }
}
