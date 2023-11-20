package test;

import controller.AirTrafficControlController;
import domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.AirTrafficControlRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPattern {
    AirTrafficControlRepository airTrafficControlRepository = new AirTrafficControlRepository();
    AirTrafficControlController airTrafficControlController = new AirTrafficControlController(airTrafficControlRepository);

    void saveTest() {
        Pilot pilot = new Pilot("dudu", "ffff", 30, "edss", 23, 3);
        Flight flight = new Flight(1, "fesef", "dwad", "dwad");

        airTrafficControlRepository.assignPilotToFlight(pilot, flight);
        Pilot pilot1 = airTrafficControlRepository.getPilotForFlightById(1);
        assert (pilot1.getPilotId() == 1);
    }

    void factoryTest() {
        String ticketType = "First-class";
        TicketType ticket = TicketFactory.createTicket(ticketType);
        assert(ticket.getClass() ==  FirstClassTicket.class);
    }
}
