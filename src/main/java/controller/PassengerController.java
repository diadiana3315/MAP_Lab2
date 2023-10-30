package controller;

import domain.Passenger;
import repository.Repository;

import java.util.List;

public class PassengerController {
    private Repository<Passenger> passengerRepository;

    public PassengerController(Repository<Passenger> passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public void savePassenger(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    public void removePassenger(Passenger passenger) {
        passengerRepository.remove(passenger);
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.getAll();
    }
}
