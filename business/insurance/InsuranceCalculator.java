package business.insurance;

import java.math.BigDecimal;

public interface InsuranceCalculator {
    BigDecimal calculateInitialCostPerDay();

    BigDecimal calculateTotalCostPerDay();

    default BigDecimal calculateAdditionPerDay() {
        return null;
    }

    default BigDecimal calculateDiscountPerDay() {
        return null;
    }

}
