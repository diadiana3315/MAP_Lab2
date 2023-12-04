package controller;

import domain.Passenger;
import repository.PassengerRepository;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class PassengerController {
    private PassengerRepository passengerRepository;

    public PassengerController(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public void savePassenger(Passenger passenger) throws SQLException {
        passengerRepository.addPassenger(passenger);
    }

    public void removePassenger(int passengerId) throws SQLException {
        passengerRepository.deletePassenger(passengerId);
    }

    public void getAllPassengers() throws SQLException {
        passengerRepository.viewPassengers();
    }
}
