package com.gersgarage.controllers;

/*import Gers_Garage.models.Client;
import Gers_Garage.models.Product;
import Gers_Garage.models.Staff;
import Gers_Garage.service.ClientService;
import Gers_Garage.service.StaffService;*/
import com.gersgarage.models.Staff;
import com.gersgarage.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.findAllStaff();
    }

    @GetMapping("/id/{staffId}")
    public List<Staff> getStaffById(@PathVariable Integer staffId) {
        return staffService.findStaffById(staffId);
    }

    @GetMapping("/first-name/{firstName}")
    public ResponseEntity<List<Staff>> getStaffByFirstName(@PathVariable String firstName) {
        List<Staff> staff = staffService.findStaffByFirstName(firstName);

        if (staff.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        } else {
            return ResponseEntity.ok(staff); // 200 OK with the list of clients
        }
    }

    @GetMapping("last-name/{lastName}")
    public List<Staff> getStaffByLastName(@PathVariable String lastName) {
        return staffService.findStaffByLastName(lastName); }

    @DeleteMapping("/{staffId}")
    public ResponseEntity<String> deleteStaff(@PathVariable Integer staffId) {
        staffService.deleteStaffById(staffId);
        return ResponseEntity.ok("Staff deleted successfully");
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<String> updatedStaff(@PathVariable Integer staffId, @RequestBody Staff updatedStaff) {
        boolean updated = staffService.updateStaff(staffId, updatedStaff);

        if (updated) {
            return ResponseEntity.ok("Product updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
