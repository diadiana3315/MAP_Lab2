package domain;

public interface FlightSubject {
    void addObserver(FlightObserver observer);
    void removeObserver(FlightObserver observer);
    void notifyObservers();
}
