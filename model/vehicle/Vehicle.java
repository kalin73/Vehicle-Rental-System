package model.vehicle;

import java.math.BigDecimal;

public abstract class Vehicle {
    private String brand;
    private String model;
    private BigDecimal value;

    protected Vehicle() {
    }

    protected Vehicle(String brand, String model, BigDecimal value) {
        this.brand = brand;
        this.model = model;
        this.value = value;
    }

    public String getBrand() {
        return brand;
    }

    public Vehicle setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Vehicle setModel(String model) {
        this.model = model;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Vehicle setValue(BigDecimal value) {
        this.value = value;
        return this;
    }
}
