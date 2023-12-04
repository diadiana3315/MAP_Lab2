package controller;

import domain.Staff;
import repository.Repository;
import repository.StaffRepository;

import java.sql.SQLException;
import java.util.List;

public class StaffController {
    private StaffRepository staffList;

    public StaffController(StaffRepository staffList) {
        this.staffList = staffList;
    }

    public void addStaff(Staff staff) throws SQLException {
        staffList.addStaffMember(staff);
    }

    public void removeStaff(int staffId) throws SQLException {
        staffList.deleteStaffMember(staffId);
    }

    public void getAllStaff() throws SQLException {
        staffList.viewStaffMembers();
    }


}
