package be.webtechie.resistorcalculator.util;

import be.webtechie.resistorcalculator.definition.ColorCode;
import java.util.List;

/**
 * Different resistor calculation methods.
 */
public class Calculate {

    /**
     * Calculates the {@link ResistorValue} based on the {@link List} of {@link ColorCode}.
     * This function can calculate for 3, 4, 5 and 6 colors.
     *
     * @param colors {@link List} of {@link ColorCode} with 3 to 6 items
     * @return {@link ResistorValue} or {@link IllegalArgumentException} when a {@link ColorCode} is given 
     * which can not be used at a given position.
     */
    public static ResistorValue resistorValue(List<ColorCode> colors) throws IllegalArgumentException {
        if (colors.get(0).getValue() == null) {
            throw new IllegalArgumentException("Color 1 can not be " + colors.get(0).name());
        }
        if (colors.get(1).getValue() == null) {
            throw new IllegalArgumentException("Color 2 can not be " + colors.get(1).name());
        }

        double value;
        double tolerance;

        switch (colors.size()) {
            case 3:
            case 4:
                value = (colors.get(0).getValue() * 10) + colors.get(1).getValue();

                if (colors.get(2).getMultiplier() == null) {
                    throw new IllegalArgumentException("Color 3 can not be " + colors.get(2).name());
                }
                value = value * colors.get(2).getMultiplier();

                if (colors.size() == 4 && colors.get(3).getTolerance() == null) {
                    throw new IllegalArgumentException("Color 4 can not be " + colors.get(3).name());
                }
                tolerance = colors.size() == 3 ? ColorCode.NONE.getTolerance()
                        : colors.get(3).getTolerance();

                return new ResistorValue(value, tolerance);

            case 5:
            case 6:
                if (colors.get(2).getValue() == null) {
                    throw new IllegalArgumentException("Color 3 can not be " + colors.get(2).name());
                }
                value = (colors.get(0).getValue() * 100)
                        + (colors.get(1).getValue() * 10)
                        + colors.get(2).getValue();

                if (colors.get(3).getMultiplier() == null) {
                    throw new IllegalArgumentException("Color 4 can not be " + colors.get(3).name());
                }
                value = value * colors.get(3).getMultiplier();

                if (colors.get(4).getTolerance() == null) {
                    throw new IllegalArgumentException("Color 5 can not be " + colors.get(4).name());
                }
                tolerance = colors.get(4).getTolerance();

                if (colors.size() == 5) {
                    return new ResistorValue(value, tolerance);
                } else {
                    if (colors.get(5).getTemperatureCoefficient() == null) {
                        throw new IllegalArgumentException("Color 6 can not be " + colors.get(5).name());
                    }

                    return new ResistorValue(value, tolerance, colors.get(5).getTemperatureCoefficient());
                }
            default:
                throw new IllegalArgumentException("Number of colors should be 3, 4, 5 or 6");
        }
    }

    /**
     * Calculate the total Ohm value for a list of serial resistors.
     *
     * @param values {@link List} of {@link Double} Ohm values
     * @return The calculate total Ohm value
     */
    public static double serial(List<Double> values) {
        return values.stream().reduce(0D, (a, b) -> a + b);
    }

    /**
     * Calculate the total Ohm value for a list of parallel resistors.
     *
     * @param values {@link List} of {@link Double} Ohm values
     * @return The calculate total Ohm value
     */
    public static double parallel(List<Double> values) {
        return 1 / values.stream().reduce(0D, (a, b) -> a + (1/b));
    }

    /**
     * Calculate the required resistor Ohm value for a LED.
     *
     * @param sourceVoltage The source voltage in Volt
     * @param ledVoltage The LED voltage in Volt
     * @param ledAmpere The LED current in Ampere
     * @return The resister value in Ohm
     */
    public static long resistorForLed(double sourceVoltage, double ledVoltage, double ledAmpere) {
        return Math.round((sourceVoltage - ledVoltage) / ledAmpere);
    }
}
