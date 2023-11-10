package repository;

import domain.Passenger;

import java.util.ArrayList;
import java.util.List;

public class PassengerRepository implements Repository<Passenger> {

    List<Passenger> passengers = new ArrayList<>();

    @Override
    public void save(Passenger passenger) {
        passengers.add(passenger);
    }

    @Override
    public void remove(Passenger passenger) {
        passengers.remove(passenger);
    }

    @Override
    public List<Passenger> getAll() {
        return passengers;
    }

    @Override
    public Passenger getById(int id) {
        return null;
    }
}

