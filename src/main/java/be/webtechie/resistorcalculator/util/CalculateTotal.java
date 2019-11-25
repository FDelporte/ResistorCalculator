package be.webtechie.resistorcalculator.util;

import java.util.List;

/**
 * Calculates the total value for a list of resistor values.
 */
public class CalculateTotal {

    /**
     * Calculate the total for a list of serial resistors.
     *
     * @param values {@link List} of {@link Double} values
     * @return The calculate total value
     */
    public static double serial(List<Double> values) {
        return values.stream().reduce(0D, (a, b) -> a + b);
    }

    /**
     * Calculate the total for a list of parallel resistors.
     *
     * @param values {@link List} of {@link Double} values
     * @return The calculate total value
     */
    public static double parallel(List<Double> values) {
        return 1 / values.stream().reduce(0D, (a, b) -> a + (1/b));
    }
}
