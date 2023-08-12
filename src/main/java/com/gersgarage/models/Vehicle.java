package com.gersgarage.models;

import com.gersgarage.enumerates.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vehicle")

public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_vehicle;

    @Column(nullable = true)
    private String model;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private CarMaker brand;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Color color;

    @Column(nullable = true)
    private Integer year;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private TypeVehicle type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private EngineSize engine_size;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Fuel fuel;

    @Column(nullable = true)
    private String licence_number;

    @Column(nullable = true)
    private Integer mileage;

    @Column(nullable = true)
    private String details;

    @ManyToOne
    @JoinColumn(name = "id_client_fk", nullable = true)
    private Client client;

    @OneToMany(mappedBy = "vehicle")
    private List<Booking> bookingList;

    public Vehicle() {
    }

    public Vehicle(Integer id_vehicle, String model, CarMaker brand, Color color, Integer year, TypeVehicle type, EngineSize engine_size, Fuel fuel, String licence_number, Integer mileage, String details, Client client) {
        this.id_vehicle = id_vehicle;
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.year = year;
        this.type = type;
        this.engine_size = engine_size;
        this.fuel = fuel;
        this.licence_number = licence_number;
        this.mileage = mileage;
        this.details = details;
        this.client = client;
    }

    public Integer getId_vehicles() {
        return id_vehicle;
    }

    public void setId_vehicles(Integer id_vehicles) {
        this.id_vehicle = id_vehicles;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CarMaker getBrand() {
        return brand;
    }

    public void setBrand(CarMaker brand) {
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public TypeVehicle getType() {
        return type;
    }

    public void setType(TypeVehicle type) {
        this.type = type;
    }

    public EngineSize getEngine_size() {
        return engine_size;
    }

    public void setEngine_size(EngineSize engine_size) {
        this.engine_size = engine_size;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public String getLicence_number() {
        return licence_number;
    }

    public void setLicence_number(String licence_number) {
        this.licence_number = licence_number;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Client getClients() {
        return client;
    }

    public void setClients(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "id_vehicles=" + id_vehicle +
                ", model='" + model + '\'' +
                ", brand=" + brand +
                ", color=" + color +
                ", year=" + year +
                ", type=" + type +
                ", engine_size=" + engine_size +
                ", fuel=" + fuel +
                ", licence_number='" + licence_number + '\'' +
                ", details='" + details + '\'' +
                ", clients=" + client +
                '}';
    }
}
