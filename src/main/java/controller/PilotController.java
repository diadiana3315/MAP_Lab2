package controller;

import domain.Pilot;
import repository.Repository;

import java.util.List;

public class PilotController {
    private Repository<Pilot> pilotList;

    public PilotController(Repository<Pilot> pilotList) {
        this.pilotList = pilotList;
    }

    public void addPilot(Pilot pilot) {
        pilotList.save(pilot);
    }

    public void removePilot(int pilotId) {
        List<Pilot> pilots = pilotList.getAll();
        for (Pilot pilot : pilots) {
            if (pilot.getPilotId() == pilotId) {
                pilotList.remove(pilot);
                return;
            }
        }
        System.out.println("Pilot not found.");
    }

    public List<Pilot> getAllPilots() {
        return pilotList.getAll();
    }

}
