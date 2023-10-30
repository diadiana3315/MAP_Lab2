package repository;

import domain.FlightDelayLog;

import java.util.ArrayList;
import java.util.List;

public class FlightDelayLogRepo implements Repository<FlightDelayLog> {
    private List<FlightDelayLog> flightDelayLogList = new ArrayList<>();

    @Override
    public void save(FlightDelayLog entity) {
        flightDelayLogList.add(entity);
    }

    @Override
    public void remove(FlightDelayLog entity) {
        flightDelayLogList.remove(entity);
    }

    @Override
    public List<FlightDelayLog> getAll() {
        return flightDelayLogList;
    }
}
