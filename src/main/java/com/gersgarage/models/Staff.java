package com.gersgarage.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "staff")
public class Staff  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_staff;
    private String staff_fname;
    private String staff_lname;

    @OneToMany(mappedBy = "staff")
    private List<Booking> bookings = new ArrayList<>();

    public Staff() {
    }

    public Staff(Integer id_staff, String staff_fname, String staff_lname) {
        this.id_staff = id_staff;
        this.staff_fname = staff_fname;
        this.staff_lname = staff_lname;
    }

    public Integer getId(){
        return id_staff;
    }
    public void setId(Integer id){
        this.id_staff = id;
    }
    public String getStaff_fname(){
        return staff_fname;
    }
    public void setStaff_fname(String staff_fname){
        this.staff_fname = staff_fname;
    }
    public String getStaff_lname(){
        return staff_lname;
    }
    public void setStaff_lname(String staff_lname){
        this.staff_lname = staff_lname;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id_staff=" + id_staff +
                ", staff_fname='" + staff_fname + '\'' +
                ", staff_lname='" + staff_lname + '\'' +
                '}';
    }

}
