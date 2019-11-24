package be.webtechie.resistorcalculator.util;

import java.util.List;

public class CalculateTotal {

    public static double serial(List<Double> values) {
        return values.stream().reduce(0D, (a, b) -> a + b);
    }

    public static double parallel(List<Double> values) {
        return 1 / values.stream().reduce(0D, (a, b) -> a + (1/b));
    }
}
