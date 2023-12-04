package controller;

import domain.AirlineCompany;
import repository.AirlineRepository;

import java.sql.SQLException;

public class AirlineController {
    private AirlineRepository airlineCompanyRepository;

    public AirlineController(AirlineRepository airlineCompanyRepository) {
        this.airlineCompanyRepository = airlineCompanyRepository;
    }

    public void addAirline(AirlineCompany airlineCompany) throws SQLException {
        airlineCompanyRepository.addAirline(airlineCompany);
    }

    public void removeAirline(int airlineId) throws SQLException {
        airlineCompanyRepository.deleteAirline(airlineId);
    }

    public void getAllAirlines() throws SQLException {
        airlineCompanyRepository.viewAirlines();
    }

}

