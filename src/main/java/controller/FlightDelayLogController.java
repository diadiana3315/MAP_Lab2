package controller;

import domain.FlightDelayLog;
import repository.FlightDelayLogRepository;

import java.sql.SQLException;

public class FlightDelayLogController {

   private FlightDelayLogRepository flightDelayLogList;

    public FlightDelayLogController(FlightDelayLogRepository flightDelayLogList) {
        this.flightDelayLogList = flightDelayLogList;
    }


    public void addFlightDelayLog(FlightDelayLog flightDelayLog) throws SQLException {
        flightDelayLogList.addFlightDelay(flightDelayLog);
    }

    public void removeFlightDelayLog(int logID) throws SQLException {
        flightDelayLogList.deleteFlightDelay(logID);
    }

    public void getAllFlightDelayLogs() throws SQLException {
        flightDelayLogList.viewFlightDelay();
    }
}
