package controller;

import domain.Airplane;
import repository.Repository;

import java.util.List;

public class AirplaneController {
    private Repository<Airplane> airplaneRepository;

    public AirplaneController(Repository<Airplane> airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    public void saveAirplane(Airplane airplane) {
        airplaneRepository.save(airplane);
    }

    public void removeAirplane(Airplane airplane) {
        airplaneRepository.remove(airplane);
    }

    public List<Airplane> getAllAirplanes() {
        return airplaneRepository.getAll();
    }
}
