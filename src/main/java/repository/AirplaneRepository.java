package repository;

import domain.Airplane;

import java.util.ArrayList;
import java.util.List;

public class AirplaneRepository implements Repository<Airplane> {

    private List<Airplane> airplanes = new ArrayList<>();

    @Override
    public void save(Airplane airplane) {
        airplanes.add(airplane);
    }

    @Override
    public void remove(Airplane airplane) {
        airplanes.remove(airplane);
    }

    @Override
    public List<Airplane> getAll() {
        return airplanes;
    }
}
