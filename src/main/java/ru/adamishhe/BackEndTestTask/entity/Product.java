package ru.adamishhe.BackEndTestTask.entity;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "PRODUCTS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "serial")
    private String serial;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "cost")
    private String cost;

    @Column(name = "amount")
    private String amount;

    public Product() {

    }

    public Product(Long id, String type, String serial, String manufacturer, String cost, String amount) {
        this.id = id;
        this.type = type;
        this.serial = serial;
        this.manufacturer = manufacturer;
        this.cost = cost;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}

