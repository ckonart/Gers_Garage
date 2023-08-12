//package Gers_Garage.dto;
//
//import Gers_Garage.enumerates.Gender;
//import Gers_Garage.models.Booking;
//import Gers_Garage.models.Role;
//import Gers_Garage.models.Vehicle;
//import java.io.Serializable;
//import java.time.LocalDate;
//import java.util.Date;
//import java.util.List;
//
//public class ClientDTO implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    private String first_name;
//
//    private String last_name;
//
//    private Integer id_client;
//
//    private String email;
//
//    private String password;
//
//    private Gender gender;
//
//    private String phone_number;
//
//    private LocalDate dob;
//
//    private Date create_time;
//
//    private Date update_time;
//
//    private Role role;
//
//    private List<Vehicle> vehicleList;
//
//    private List<Booking> bookingList;
//
//    private String confirmPassword;
//
//    private boolean enabled;
//
//    public ClientDTO(){
//    }
//
//    public ClientDTO(String first_name, String last_name, Integer id_client, String email, String password, Gender gender, String phone_number, LocalDate dob) {
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.id_client = id_client;
//        this.email = email;
//        this.password = password;
//        this.gender = gender;
//        this.phone_number = phone_number;
//        this.dob = dob;
//    }
//
//    public String getFirst_name() {
//        return first_name;
//    }
//
//    public void setFirst_name(String first_name) {
//        this.first_name = first_name;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }
//
//    public Integer getId_client() {
//        return id_client;
//    }
//
//    public void setId_client(Integer id_client) {
//        this.id_client = id_client;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Gender getGender() {
//        return gender;
//    }
//
//    public void setGender(Gender gender) {
//        this.gender = gender;
//    }
//
//    public String getPhone_number() {
//        return phone_number;
//    }
//
//    public void setPhone_number(String phone_number) {
//        this.phone_number = phone_number;
//    }
//
//    public LocalDate getDob() {
//        return dob;
//    }
//
//    public void setDob(LocalDate dob) {
//        this.dob = dob;
//    }
//
//    public Date getCreate_time() {
//        return create_time;
//    }
//
//    public void setCreate_time(Date create_time) {
//        this.create_time = create_time;
//    }
//
//    public Date getUpdate_time() {
//        return update_time;
//    }
//
//    public void setUpdate_time(Date update_time) {
//        this.update_time = update_time;
//    }
//
//    public Role getRoles(){
//        return role;
//    }
//
//    public void setRoles(Role role) {
//        this.role = role;
//    }
//
//    public List<Vehicle> getVehicleList() {
//        return vehicleList;
//    }
//
//    public void setVehiclesList(List<Vehicle> vehicleList) {
//        this.vehicleList = vehicleList;
//    }
//
//    public boolean getEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
//
//
//    public String getConfirmPassword() {
//        return confirmPassword;
//    }
//
//    public void setConfirmPassword(String confirmPassword) {
//        this.confirmPassword = confirmPassword;
//    }
//}
