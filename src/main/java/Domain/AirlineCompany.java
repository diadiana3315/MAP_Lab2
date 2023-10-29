package Domain;

import java.util.ArrayList;

public class AirlineCompany {
    private int airlineID;
    private String name;
    private String country;
    private int fleetSize;
    private int nrEmployees;
    private ArrayList destinations;

    public AirlineCompany(int airlineID, String name, String country, int fleetSize, int nrEmployees, ArrayList destinations) {
        this.airlineID = airlineID;
        this.name = name;
        this.country = country;
        this.fleetSize = fleetSize;
        this.nrEmployees = nrEmployees;
        this.destinations = destinations;
    }
    public int getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(int airlineID) {
        this.airlineID = airlineID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getFleetSize() {
        return fleetSize;
    }

    public void setFleetSize(int fleetSize) {
        this.fleetSize = fleetSize;
    }

    public int getNrEmployees() {
        return nrEmployees;
    }

    public void setNrEmployees(int nrEmployees) {
        this.nrEmployees = nrEmployees;
    }

    public ArrayList getDestinations() {
        return destinations;
    }

    public void setDestinations(ArrayList destinations) {
        this.destinations = destinations;
    }



}
