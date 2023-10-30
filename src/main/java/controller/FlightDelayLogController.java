package controller;

import domain.Flight;
import domain.FlightDelayLog;
import repository.Repository;

import java.util.List;

public class FlightDelayLogController {

   private Repository<FlightDelayLog> flightDelayLogList;

    public FlightDelayLogController(Repository<FlightDelayLog> flightDelayLogList) {
        this.flightDelayLogList = flightDelayLogList;
    }


    public void addFlightDelayLog(FlightDelayLog flightDelayLog) {
        flightDelayLogList.save(flightDelayLog);
    }

    public void removeFlightDelayLog(int logID) {
        List<FlightDelayLog> flightDelayLogs = flightDelayLogList.getAll();
        for (FlightDelayLog log : flightDelayLogs) {
            if (log.getLogID() == logID) {
                flightDelayLogList.remove(log);
                return;
            }
        }
        System.out.println("Flight delay log not found.");
    }

    public List<FlightDelayLog> getAllFlightDelayLogs() {
        return flightDelayLogList.getAll();
    }
}
