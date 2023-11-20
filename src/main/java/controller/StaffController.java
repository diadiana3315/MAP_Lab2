package controller;

import domain.Staff;
import repository.Repository;

import java.util.List;

public class StaffController {
    private Repository<Staff> staffList;

    public StaffController(Repository<Staff> staffList) {
        this.staffList = staffList;
    }

    public void addStaff(Staff staff) {
        staffList.save(staff);
    }

    public void removeStaff(int staffId) {
        List<Staff> staffPerson = staffList.getAll();
        for (Staff staff : staffPerson) {
            if (staff.getStaffId() == staffId) {
                staffList.remove(staff);
                return;
            }
        }
        System.out.println("Staff member not found.");
    }

    public List<Staff> getAllStaff() {
        return staffList.getAll();
    }


}
