package com.gersgarage.service;

import com.gersgarage.models.Staff;
import com.gersgarage.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> findAllStaff() {
        return staffRepository.findAllStaff();
    }

    public List<Staff> findStaffById(Integer staffId) {
        return staffRepository.findStaffById(staffId);
    }

    public List<Staff> findStaffByFirstName(String firstName) {
        return staffRepository.findStaffByFirstName(firstName); }

    public List<Staff> findStaffByLastName(String lastName) {
        return staffRepository.findStaffByLastName(lastName); }

    public void deleteStaffById(Integer staffId) {
        staffRepository.deleteStaffById(staffId); }

    public boolean updateStaff(Integer staffId, Staff updatedStaff) {
        Staff existingStaff = staffRepository.findById(staffId).orElse(null);

        if (existingStaff != null) {
            existingStaff.setStaff_fname(updatedStaff.getStaff_fname());
            existingStaff.setStaff_lname(updatedStaff.getStaff_lname());

            staffRepository.save(existingStaff);
            return true;
        } else {
            return false;
        }
    }
}
