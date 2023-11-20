package controller;

import domain.AirlineCompany;
import repository.AirlineRepository;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class AirlineController {
    private Repository<AirlineCompany> airlineCompanyRepository;

    public AirlineController(AirlineRepository airlineCompanyRepository) {
        this.airlineCompanyRepository = airlineCompanyRepository;
    }

    public void addAirline(AirlineCompany airlineCompany) {
        airlineCompanyRepository.save(airlineCompany);
    }

    public void removeAirline(int airlineId) {
        airlineCompanyRepository.removeById(airlineId);
    }

    public List<AirlineCompany> getAllAirlines() {
        return airlineCompanyRepository.getAll();
    }
}

