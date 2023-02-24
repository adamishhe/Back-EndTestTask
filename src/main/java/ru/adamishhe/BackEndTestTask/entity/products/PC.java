package ru.adamishhe.BackEndTestTask.entity.products;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import ru.adamishhe.BackEndTestTask.entity.Product;


@Entity
@Table(name = "PC")
public class PC extends Product {


    @Column(name = "pcType")
    private String pcType;

    public PC() {

    }

    public PC(Long id, String type, String serial, String manufacturer, String cost, String amount, String pcType) {
        super(id, type, serial, manufacturer, cost, amount);
        this.pcType = pcType;
    }

    public String getPcType() {
        return pcType;
    }

    public void setPcType(String pcType) {
        this.pcType = pcType;
    }
}
