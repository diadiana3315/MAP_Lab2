package Domain;

public class FlightDelayLog {
    private int logID;
    private int flightNumber;
    private String delayReason;
    private int duration;
    private String status;

    public FlightDelayLog(int logID, int flightNumber, String delayReason, int duration, String status) {
        this.logID = logID;
        this.flightNumber = flightNumber;
        this.delayReason = delayReason;
        this.duration = duration;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
