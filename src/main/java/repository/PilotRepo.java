package repository;
import domain.Pilot;

import java.util.ArrayList;
import java.util.List;

public class PilotRepo implements Repository<Pilot>{
    private List<Pilot> pilotList = new ArrayList<>();

    @Override
    public void save(Pilot entity) {
        pilotList.add(entity);
    }

    @Override
    public void remove(Pilot entity) {
        pilotList.remove(entity);
    }

    @Override
    public List<Pilot> getAll() {
        return pilotList;
    }
}
