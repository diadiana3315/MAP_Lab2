package repository;

import domain.AirlineCompany;

import java.util.ArrayList;
import java.util.List;

public class AirlineRepo implements Repository<AirlineCompany> {
    private List<AirlineCompany> airlineCompany = new ArrayList<>();


    @Override
    public void save(AirlineCompany entity) {
        airlineCompany.add(entity);
    }

    @Override
    public void remove(AirlineCompany entity) {
        airlineCompany.remove(entity);
    }

    @Override
    public List<AirlineCompany> getAll() {
        return airlineCompany;
    }
}
