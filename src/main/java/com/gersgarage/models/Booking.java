package Gers_Garage.models;

import Gers_Garage.enumerates.BookingStatus;
import Gers_Garage.enumerates.ServiceType;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "booking_service")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_booking;

   @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private ServiceType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private BookingStatus status;
    @Column
    private String details;
    @Column
    private BigDecimal cost;

    @Embedded
    //@NotNull
    private BookingDate bookingDate;

    @ManyToOne
    @JoinColumn(name = "id_client_fk", nullable = true)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_vehicle_fk", nullable = true)
    private Vehicle vehicle;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_staff_fk", nullable = true)
    private Staff staff;

    @OneToMany(mappedBy = "booking")
    private List<Product> productList;

    public Booking() {
    }

    public Booking(Integer id_booking, ServiceType type, BookingStatus status, String details, BigDecimal cost, BookingDate bookingDate, Client client, Vehicle vehicle, Staff staff, List<Product> productList) {
        this.id_booking = id_booking;
        this.type = type;
        this.status = status;
        this.details = details;
        this.cost = cost;
        this.bookingDate = bookingDate;
        this.client = client;
        this.vehicle = vehicle;
        this.staff = staff;
        this.productList = productList;
    }

    public Integer getId_booking() {
        return id_booking;
    }

    public void setId_booking(Integer id_booking) {
        this.id_booking = id_booking;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BookingDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(BookingDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Client getClients() {
        return client;
    }

    public void setClients(Client client) {
        this.client = client;
    }

    public Vehicle getVehicles() {
        return vehicle;
    }

    public void setVehicles(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<Product> getProductsList() {
        return productList;
    }

    public void setProductsList(List<Product> productList) {
        this.productList = productList;
    }

    public LocalDate getDate(){
        return getBookingDate().getDate();
    }
    public LocalTime getTime(){
        return getBookingDate().getTime();
    }
}

