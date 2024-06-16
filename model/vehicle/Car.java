package model.vehicle;


import java.math.BigDecimal;

public class Car extends Vehicle {
    private int safetyRating;

    public Car() {
    }

    public Car(String brand, String model, BigDecimal value, int safetyRating) {
        super(brand, model, value);
        setSafetyRating(safetyRating);
    }

    public int getSafetyRating() {
        return safetyRating;
    }

    public void setSafetyRating(int safetyRating) {
        if(safetyRating < 1 || safetyRating > 5){
            throw new IllegalArgumentException("Safety Rating must be between 1 and 5");
        }
        this.safetyRating = safetyRating;
    }
}
