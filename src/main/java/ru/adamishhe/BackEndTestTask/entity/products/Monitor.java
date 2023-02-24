package ru.adamishhe.BackEndTestTask.entity.products;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import ru.adamishhe.BackEndTestTask.entity.Product;


@Entity
@Table(name = "MONITOR")
public class Monitor extends Product {

    @Column(name = "diagonal")
    private String diagonal;

    public Monitor() {

    }

    public Monitor(Long id, String type, String serial, String manufacturer, String cost, String amount, String diagonal) {
        super(id, type, serial, manufacturer, cost, amount);
        this.diagonal = diagonal;
    }

    public String getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(String diagonal) {
        this.diagonal = diagonal;
    }
}
