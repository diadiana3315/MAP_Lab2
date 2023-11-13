package org.example;

import controller.AirlineController;
import controller.FlightController;
import controller.TicketController;
import domain.Ticket;
import repository.AirlineRepository;
import repository.FlightRepository;
import repository.TicketRepository;
import ui.UI;

public class Main {
    public static void main(String[] args) {
        FlightRepository flightRepository = new FlightRepository();
        AirlineRepository airlineRepository = new AirlineRepository();
        TicketRepository ticketRepository = new TicketRepository();

        FlightController flightController = new FlightController(flightRepository);
        AirlineController airlineController = new AirlineController(airlineRepository);
        TicketController ticketController = new TicketController(ticketRepository);

        UI ui = new UI(flightController, airlineController, ticketController);
        ui.start();
    }
}
