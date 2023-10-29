package domain;

public class AirlineCompany {
    private int airlineID;
    private String name;
    private String country;
    private int fleetSize;
    private int nrEmployees;

    public AirlineCompany(int airlineID, String name, String country, int fleetSize, int nrEmployees) {
        this.airlineID = airlineID;
        this.name = name;
        this.country = country;
        this.fleetSize = fleetSize;
        this.nrEmployees = nrEmployees;
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

    @Override
    public String toString() {
        return "AirlineCompany{" +
                "airlineID=" + airlineID +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", fleetSize=" + fleetSize +
                ", nrEmployees=" + nrEmployees +
                '}';
    }
}
