package business.insurance;

import java.math.BigDecimal;

public interface InsuranceAdditionCalculator extends InsuranceCalculator {
    BigDecimal calculateAdditionPerDay();
}
