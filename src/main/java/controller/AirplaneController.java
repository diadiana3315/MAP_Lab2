package controller;

import domain.Airplane;
import repository.AirplaneRepository;

import java.sql.SQLException;

public class AirplaneController {
    private AirplaneRepository airplaneRepository;

    public AirplaneController(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    public void saveAirplane(Airplane airplane) throws SQLException {
        airplaneRepository.addAirplane(airplane);
    }

    public void removeAirplane(int airplaneId) throws SQLException {
        airplaneRepository.deleteAirplane(airplaneId);
    }

    public void getAllAirplanes() throws SQLException {
        airplaneRepository.viewAirplanes();
    }
}
