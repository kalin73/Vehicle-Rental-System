package business.insurance;

import java.math.BigDecimal;

public interface InsuranceDiscountCalculator extends InsuranceCalculator {
    BigDecimal calculateDiscountPerDay();
}
