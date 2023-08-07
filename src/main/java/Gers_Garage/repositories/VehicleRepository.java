package Gers_Garage.repositories;

import Gers_Garage.models.Client;
import Gers_Garage.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("SELECT v FROM Vehicle v")
    List<Vehicle> findAllVehicles();

    @Query("SELECT c FROM Client c WHERE v.id_vehicle = :vehicleId")
    Vehicle findVehicleById(@Param("vehicleId") Integer vehicleId);

    @Query("SELECT v FROM Vehicle v WHERE v.model = :model")
    List<Vehicle> findVehicleByModel(@Param("model") String model);

    @Query("SELECT v FROM Vehicle v WHERE v.brand = :brand")
    List<Vehicle> findVehicleByBrand(@Param("brand") String brand);

    //@Query("SELECT v FROM Vehicle v " +
      //      "WHERE v.client = :user")
    //List<Vehicle> findVehiclesByUser(@Param("user") Client client);

    @Modifying
    @Query("DELETE v FROM Vehicle v WHERE v.id_vehicle = :vehicleId")
    void deleteVehicleById(@Param("vehicleId") Integer vehicleId);

    @Modifying
    @Query("UPDATE Vehicle v " +
            "SET v.model = :#{#updatedVehicle.model}, " +
            "v.brand = :#{#updatedVehicle.brand}, " +
            "v.year = :#{#updatedVehicle.year}, " +
            "v.license_number = :#{#updatedVehicle.license_number}, " +
            "v.mileage = :#{#updatedVehicle.mileage}, " +
            "v.details = :#{#updatedVehicle.details}, " +
            "WHERE c.id_vehicle = :vehicleId")
    void updateVehicleById(@Param("vehicleId") Integer vehicleId, @Param("updatedVehicle") Vehicle updatedVehicle);

}
