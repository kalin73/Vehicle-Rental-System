package utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Utils {
    public static String getFormatedValue(BigDecimal value) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(value);
    }
}
