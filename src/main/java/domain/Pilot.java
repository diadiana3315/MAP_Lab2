package domain;

public class Pilot extends Person implements Identifiable{

    private int pilotId;
    private int yearsOfActivity;

    public Pilot(String firstName, String lastName, int age, String gender, int pilotId, int yearsOfActivity) {
        super(firstName, lastName, age, gender);
        this.pilotId = pilotId;
        this.yearsOfActivity = yearsOfActivity;
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }

    public int getYearsOfActivity() {
        return yearsOfActivity;
    }

    public void setYearsOfActivity(int yearsOfActivity) {
        this.yearsOfActivity = yearsOfActivity;
    }


    @Override
    public int getId() {
        return pilotId;
    }
}
