package model.vehicle;

import java.math.BigDecimal;

public abstract class Vehicle {
    private String brand;
    private String model;
    private BigDecimal value;

    protected Vehicle() {
    }

    protected Vehicle(String brand, String model, BigDecimal value) {
        setBrand(brand);
        setModel(model);
        setValue(value);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("Brand cannot be null or blank");
        }
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Model cannot be null or blank");
        }
        this.model = model;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }
        this.value = value;
    }
}
