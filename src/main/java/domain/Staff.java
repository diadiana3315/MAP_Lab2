package domain;

public class Staff extends Person implements Identifiable{
    private int staffId;
    private String role;

    public Staff(String firstName, String lastName, int age, String gender, int staffId, String role) {
        super(firstName, lastName, age, gender);
        this.staffId = staffId;
        this.role = role;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int getId() {
        return staffId;
    }
}
