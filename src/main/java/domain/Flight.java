package domain;

import java.util.ArrayList;
import java.util.List;
public class Flight implements FlightSubject, Identifiable {
    private List<FlightObserver> observers = new ArrayList<>();
    private int flightId;
    private String airline;
    private String departureTime;
    private String arrivalTime;
    public Flight(int flightId, String airline, String departureTime, String arrivalTime) {
        this.flightId = flightId;
        this.airline = airline;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }
    public int getFlightId() {
        return flightId;
    }
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
    public String getAirline() {
        return airline;
    }
    public void setAirline(String airline) {
        this.airline = airline;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public String getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", airline='" + airline + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                '}';
    }

    @Override
    public void addObserver(FlightObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(FlightObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (FlightObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public int getId() {
        return flightId;
    }
}
