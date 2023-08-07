package Gers_Garage.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_role;
    private String name_role;

    public Role() {
    }

    public Role(Integer id_role, String id_name) {
        this.id_role = id_role;
        this.name_role = id_name;
    }

    public Integer getId_role() {
        return id_role;
    }

    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }

    public String getId_name() {
        return name_role;
    }

    public void setId_name(String id_name) {
        this.name_role = id_name;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id_role=" + id_role +
                ", id_name='" + name_role + '\'' +
                '}';
    }
}
