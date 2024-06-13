package business.insurance;

import business.rental.CarRental;
import model.vehicle.Car;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CarInsuranceCalc implements InsuranceCalculator {
    private static final BigDecimal CAR_INSURANCE_COST = BigDecimal.valueOf(0.0001);
    private static final BigDecimal CAR_INSURANCE_DISCOUNT_PERCENT = BigDecimal.valueOf(10);

    private final Car car;

    public CarInsuranceCalc(CarRental rentalCar) {
        this.car = (Car) rentalCar.getVehicle();

    }

    @Override
    public BigDecimal calculateInitialCostPerDay() {
        return car.getValue().multiply(CAR_INSURANCE_COST);
    }

    @Override
    public BigDecimal calculateDiscountPerDay() {
        return car.getValue()
                .multiply(CAR_INSURANCE_COST)
                .multiply(CAR_INSURANCE_DISCOUNT_PERCENT)
                .divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calculateTotalCostPerDay() {
        if (car.getSafetyRating() > 3 && car.getSafetyRating() <= 5) {
            return calculateInitialCostPerDay().subtract(calculateDiscountPerDay());
        } else {
            return calculateInitialCostPerDay();
        }
    }
}
