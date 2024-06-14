package business.insurance;

import business.rental.MotorcycleRental;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MotorcycleInsuranceCalc implements InsuranceAdditionCalculator {
    private static final BigDecimal MOTORCYCLE_INSURANCE_COST = BigDecimal.valueOf(0.0002);
    private static final BigDecimal MOTORCYCLE_INSURANCE_ADDITION_PERCENT = BigDecimal.valueOf(20);

    private final MotorcycleRental motorcycle;

    public MotorcycleInsuranceCalc(MotorcycleRental vehicleRental) {
        this.motorcycle = vehicleRental;

    }

    @Override
    public BigDecimal calculateInitialCostPerDay() {
        return this.motorcycle.getVehicle().getValue().multiply(MOTORCYCLE_INSURANCE_COST);
    }

    @Override
    public BigDecimal calculateAdditionPerDay() {
        return motorcycle.getVehicle().getValue()
                .multiply(MOTORCYCLE_INSURANCE_COST)
                .multiply(MOTORCYCLE_INSURANCE_ADDITION_PERCENT)
                .divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calculateTotalCostPerDay() {
        if (motorcycle.getClient().getAge() < 25) {
            return calculateInitialCostPerDay().add(calculateAdditionPerDay());
        } else {
            return calculateInitialCostPerDay();
        }
    }
}
