package Domain;

public class BoardingGate {
    private int gateNumber;
    private int aircraftID;
    private String airline;
    private int flightNumber;
    private Status status;
    private int staffID;
    private int departureTime;

    public BoardingGate(int gateNumber, int aircraftID, String airline, int flightNumber, Status status, int staffID, int departureTime) {
        this.gateNumber = gateNumber;
        this.aircraftID = aircraftID;
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.status = status;
        this.staffID = staffID;
        this.departureTime = departureTime;
    }


    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public int getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(int aircraftID) {
        this.aircraftID = aircraftID;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }


}