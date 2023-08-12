package com.gersgarage.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = true, length = 30)
    private String first_name;

    @Column(nullable = true, length = 30)
    private String last_name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_client;

    @Column(nullable = true, length = 40)
    private String email;

    @Column(nullable = true)
    private String password;

    @Column
    //@Enumerated(EnumType.STRING)
    private String gender;

    @Column(nullable = true, length = 20)
    private String phone_number;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotNull
    private LocalDate dob;

    @CreationTimestamp
    private Date create_time;
    @UpdateTimestamp
    private Date update_time;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_role_fk", nullable = true)
    private Role role;

    @OneToMany(mappedBy = "client")
    private List<Vehicle> vehicleList;

    @OneToMany(mappedBy = "client")
    private List<Booking> bookingList;


    @Transient
    private String confirmPassword;

    private boolean enabled;

    public Client(){
    }

    public Client(String first_name, String last_name, Integer id_client, String email, String password, String gender, String phone_number, LocalDate dob) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.id_client = id_client;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.phone_number = phone_number;
        this.dob = dob;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getId_client() {
        return id_client;
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Role getRoles(){
        return role;
    }

    public void setRoles(Role role) {
        this.role = role;
    }

    public List<Vehicle> getVehiclesList() {
        return vehicleList;
    }

    public void setVehiclesList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
