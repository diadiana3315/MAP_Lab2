package controller;

import domain.Airplane;
import domain.Flight;
import domain.Pilot;
import repository.AirTrafficControlRepository;

public class AirTrafficControlController {
    private AirTrafficControlRepository airTrafficControlRepository;

    public AirTrafficControlController(AirTrafficControlRepository repository) {
        this.airTrafficControlRepository = repository;
    }

    public void assignPilotToFlight(Pilot pilot, Flight flight) {
        airTrafficControlRepository.assignPilotToFlight(pilot, flight);
    }

    public void assignAirPlaneToFlight(Airplane plane, Flight flight) {
        airTrafficControlRepository.assignAirplaneToFlight(plane, flight);
    }

    public void getPilotForFlightById(int flightId) {
        airTrafficControlRepository.getPilotForFlightById(flightId);
    }

    public void getPlaneForFlightById(int flightId) {
        airTrafficControlRepository.getPlaneForFlightById(flightId);
    }
}
