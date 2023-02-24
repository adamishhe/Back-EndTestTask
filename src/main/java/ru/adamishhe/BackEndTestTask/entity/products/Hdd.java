package ru.adamishhe.BackEndTestTask.entity.products;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import ru.adamishhe.BackEndTestTask.entity.Product;


@Entity
@Table(name = "HDD")
public class Hdd extends Product {


    @Column(name = "capacity")
    private String capacity;

    public Hdd() {

    }

    public Hdd(Long id, String type, String serial, String manufacturer, String cost, String amount, String capacity) {
        super(id, type, serial, manufacturer, cost, amount);
        this.capacity = capacity;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
