package business.insurance;

import java.math.BigDecimal;

public interface InsuranceCalculator {
    BigDecimal calculateInitialCostPerDay();

    BigDecimal calculateTotalCostPerDay();

}
