package domain;

public class FlightDelayLog implements FlightObserver {
    private int logID;
    private int flightNumber;
    private String delayReason;
    private int duration;
    private Flight flight;

    public FlightDelayLog(int logID, int flightNumber, String delayReason, int duration, Flight flight) {
        this.logID = logID;
        this.flightNumber = flightNumber;
        this.delayReason = delayReason;
        this.duration = duration;
        this.flight = flight;
    }

    public int getLogID() {
        return logID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDelayReason() {
        return delayReason;
    }

    public void setDelayReason(String delayReason) {
        this.delayReason = delayReason;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public void update() {
        System.out.println("Flight delay log has been notified about a flight update.");

    }
}
