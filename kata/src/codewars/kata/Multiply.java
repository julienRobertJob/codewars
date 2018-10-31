package codewars.kata;
import java.math.BigDecimal;

public class Multiply {
    public static Double multiply(Double a, Double b) {
        if (a == null || b == null)
          return Double.NaN;
        else
          return ((new BigDecimal(a)).multiply(new BigDecimal(b))).doubleValue();
    }
}