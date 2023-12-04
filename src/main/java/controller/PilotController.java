package controller;

import domain.Pilot;
import repository.PilotRepository;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class PilotController {
    private PilotRepository pilotList;

    public PilotController(PilotRepository pilotList) {
        this.pilotList = pilotList;
    }

    public void addPilot(Pilot pilot) throws SQLException {
        pilotList.addPilot(pilot);
    }

    public void removePilot(int pilotId) throws SQLException {
        pilotList.deletePilot(pilotId);
    }

    public void getAllPilots() throws SQLException { pilotList.viewPilots();
    }

}
