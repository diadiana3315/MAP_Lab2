package controller;

import domain.AirlineCompany;
import repository.AirlineRepo;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class AirlineController {
    private Repository<AirlineCompany> airlineCompanyRepository;

    public AirlineController(Repository<AirlineCompany> airlineCompanyRepository) {
        this.airlineCompanyRepository = airlineCompanyRepository;
    }

    public void addAirline(AirlineCompany airlineCompany) {
        airlineCompanyRepository.save(airlineCompany);
    }

    public void removeAirline(int airlineId) {
        List<AirlineCompany> airline = airlineCompanyRepository.getAll();
        List<AirlineCompany> airlineToRemove = new ArrayList<>();
        for (AirlineCompany airlineCompany : airline) {
            if (airlineCompany.getAirlineID() == airlineId) {
                airlineToRemove.add(airlineCompany);
            }
        }
        for (AirlineCompany flight : airlineToRemove) {
            airlineCompanyRepository.remove(flight);
        }
    }

    public List<AirlineCompany> getAllAirlines() {
        return airlineCompanyRepository.getAll();
    }
}

