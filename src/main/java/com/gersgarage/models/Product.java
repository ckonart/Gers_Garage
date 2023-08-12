package Gers_Garage.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_item;
    private String item_name;
    private BigDecimal item_cost;

    @ManyToOne
    @JoinColumn(name = "id_booking_fk", nullable = true)
    private Booking booking;

    public Product() {
    }

    public Product(Integer id_item, String item_name, BigDecimal item_cost) {
        this.id_item = id_item;
        this.item_name = item_name;
        this.item_cost = item_cost;
    }

    public Integer getId_item() {
        return id_item;
    }

    public void setId_item(Integer id_item) {
        this.id_item = id_item;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public BigDecimal getItem_cost() {
        return item_cost;
    }

    public void setItem_cost(BigDecimal item_cost) {
        this.item_cost = item_cost;
    }
}
