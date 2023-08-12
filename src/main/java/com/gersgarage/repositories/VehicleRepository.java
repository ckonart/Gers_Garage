package com.gersgarage.repositories;

import com.gersgarage.models.Client;
import com.gersgarage.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("SELECT v FROM Vehicle v")
    List<Vehicle> findAllVehicles();

    @Query("SELECT v FROM Vehicle v WHERE v.id_vehicle = :vehicleId")
    List<Vehicle> findVehicleById(@Param("vehicleId") Integer vehicleId);

    @Query("SELECT v FROM Vehicle v WHERE v.model = :model")
    List<Vehicle> findVehicleByModel(@Param("model") String model);

    @Query("SELECT v FROM Vehicle v WHERE v.brand = :brand")
    List<Vehicle> findVehicleByBrand(@Param("brand") String brand);

    @Query("SELECT v FROM Vehicle v WHERE v.client = :user")
    List<Vehicle> findVehiclesByUser(@Param("user") Client client);

    @Modifying
    @Query("DELETE FROM Vehicle v WHERE v.id_vehicle = :vehicleId")
    void deleteVehicleById(@Param("vehicleId") Integer vehicleId);


}