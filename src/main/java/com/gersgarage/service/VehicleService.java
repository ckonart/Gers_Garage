package com.gersgarage.service;

import com.gersgarage.models.Product;
import com.gersgarage.models.Vehicle;
import com.gersgarage.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> findAllVehicles() {return vehicleRepository.findAllVehicles(); }

    public List<Vehicle> findVehicleById(Integer vehicleId) {
        return vehicleRepository.findVehicleById(vehicleId); }
    public List<Vehicle> findVehicleByModel(String model) {
        return vehicleRepository.findVehicleByModel(model); }

    public List<Vehicle> findVehicleByBrand(String brand) {
        return vehicleRepository.findVehicleByBrand(brand); }

    public void deleteVehicleById(Integer vehicleId) {
        vehicleRepository.deleteVehicleById(vehicleId); }

    @Transactional
    public boolean updateVehicle(Integer vehicleId, Vehicle updatedVehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(vehicleId).orElse(null);

        if (existingVehicle != null) {
            existingVehicle.setModel(updatedVehicle.getModel());
            existingVehicle.setBrand(updatedVehicle.getBrand());
            existingVehicle.setYear(updatedVehicle.getYear());
            existingVehicle.setLicence_number(updatedVehicle.getLicence_number());
            existingVehicle.setMileage(updatedVehicle.getMileage());
            existingVehicle.setDetails(updatedVehicle.getDetails());

            vehicleRepository.save(existingVehicle);
            return true;
        } else {
            return false;
        }
    }

}
