package domain;

public class Passenger extends Person {
    private int passengerId;
    private int passportNumber;
    public Passenger(String firstName, String lastName, int age, String gender, int passengerId, int passportNumber) {
        super(firstName, lastName, age, gender);
        this.passengerId = passengerId;
        this.passportNumber = passportNumber;
    }
    public int getPassengerId() {
        return passengerId;
    }
    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }
    public int getPassportNumber() {
        return passportNumber;
    }
    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }
    @Override
    public String toString() {
        return super.toString() + "Passenger{" +
                "passengerId=" + passengerId +
                ", passportNumber=" + passportNumber +
                '}';
    }
}