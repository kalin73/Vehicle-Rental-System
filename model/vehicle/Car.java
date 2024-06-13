package model.vehicle;


import java.math.BigDecimal;

public class Car extends Vehicle {
    private int safetyRating;

    public Car() {
    }

    public Car(String brand, String model, BigDecimal value, int safetyRating) {
        super(brand, model, value);
        this.safetyRating = safetyRating;
    }

    public int getSafetyRating() {
        return safetyRating;
    }

    public Car setSafetyRating(int safetyRating) {
        this.safetyRating = safetyRating;
        return this;
    }
}
