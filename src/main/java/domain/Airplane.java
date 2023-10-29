package domain;

public class Airplane {
    private int airplaneId;
    private String manufacturer;
    private String model;
    private Pilot pilot;
    public Airplane(int airplaneId, String manufacturer, String model, Pilot pilot) {
        this.airplaneId = airplaneId;
        this.manufacturer = manufacturer;
        this.model = model;
        this.pilot = pilot;
    }
    public int getAirplaneId() {
        return airplaneId;
    }
    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Pilot getPilot() {
        return pilot;
    }
    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }
}