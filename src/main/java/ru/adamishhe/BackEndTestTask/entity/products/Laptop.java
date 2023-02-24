package ru.adamishhe.BackEndTestTask.entity.products;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import ru.adamishhe.BackEndTestTask.entity.Product;


@Entity
@Table(name = "LAPTOP")
public class Laptop extends Product {


    @Column(name = "screenSize")
    private String screenSize;

    public Laptop() {

    }

    public Laptop(Long id, String type, String serial, String manufacturer, String cost, String amount, String diagonal) {
        super(id, type, serial, manufacturer, cost, amount);
        this.screenSize = diagonal;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }
}