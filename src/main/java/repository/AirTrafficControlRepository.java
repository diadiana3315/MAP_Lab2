package repository;

import domain.Airplane;
import domain.Flight;
import domain.Pilot;

import java.util.HashMap;
import java.util.Map;

public class AirTrafficControlRepository {
    private Map<Flight, Pilot> flightToPilotMap;
    private Map<Flight, Airplane> flightToPlaneMap;

    public AirTrafficControlRepository() {
        flightToPilotMap = new HashMap<>();
        flightToPlaneMap = new HashMap<>();
    }

    public void assignPilotToFlight(Pilot pilot, Flight flight) {
        flightToPilotMap.put(flight, pilot);
    }

    public void assignAirplaneToFlight(Airplane plane, Flight flight) {
        flightToPlaneMap.put(flight, plane);
    }

    public Pilot getPilotForFlightById(int flightId) {
        for (Map.Entry<Flight, Pilot> entry : flightToPilotMap.entrySet()) {
            Flight flight = entry.getKey();
            if (flight.getId() == flightId) {
                return entry.getValue();
            }
        }
        return null;
    }

    public Airplane getPlaneForFlightById(int flightId) {
        for (Map.Entry<Flight, Airplane> entry : flightToPlaneMap.entrySet()) {
            Flight flight = entry.getKey();
            if (flight.getId() == flightId) {
                return entry.getValue();
            }
        }
        return null;
    }

}

