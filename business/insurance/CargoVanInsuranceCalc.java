package business.insurance;

import business.rental.CargoVanRental;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CargoVanInsuranceCalc implements InsuranceDiscountCalculator {
    private static final BigDecimal CARGO_VAN_INSURANCE_COST = BigDecimal.valueOf(0.0003);
    private static final BigDecimal CARGO_VAN_INSURANCE_DISCOUNT_PERCENT = BigDecimal.valueOf(15);

    private final CargoVanRental cargoVan;

    public CargoVanInsuranceCalc(CargoVanRental vehicleRental) {
        this.cargoVan = vehicleRental;

    }

    @Override
    public BigDecimal calculateInitialCostPerDay() {
        return cargoVan.getVehicle().getValue().multiply(CARGO_VAN_INSURANCE_COST);
    }

    @Override
    public BigDecimal calculateDiscountPerDay() {
        return cargoVan.getVehicle().getValue()
                .multiply(CARGO_VAN_INSURANCE_COST)
                .multiply(CARGO_VAN_INSURANCE_DISCOUNT_PERCENT)
                .divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calculateTotalCostPerDay() {
        if (cargoVan.getClient().getDrivingExperience() > 5) {
            return calculateInitialCostPerDay().subtract(calculateDiscountPerDay());
        } else {
            return calculateInitialCostPerDay();
        }
    }
}
