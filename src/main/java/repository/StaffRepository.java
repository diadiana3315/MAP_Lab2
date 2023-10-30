package repository;

import domain.Staff;

import java.util.ArrayList;
import java.util.List;

public class StaffRepository implements Repository<Staff> {
    private List<Staff> staffList = new ArrayList<>();

    @Override
    public void save(Staff entity) {
        staffList.add(entity);
    }

    @Override
    public void remove(Staff entity) {
        staffList.remove(entity);
    }

    @Override
    public List<Staff> getAll() {
        return staffList;
    }
}
