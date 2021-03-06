package be.webtechie.resistorcalculator.definition;

import be.webtechie.resistorcalculator.util.Convert;

/**
 * Color coding used on resistors.
 */
public enum ColorCode {
    BLACK(0, 0x000000, 1D, null, 250),
    BROWN(1, 0x761d1d, 10D, 1D, 100),
    RED(2, 0xcc0000, 100D, 2D, 50),
    ORANGE(3, 0xFFA500, 1000D, null, 15),
    YELLOW(4, 0xFFFF00, 10 * 1000D, 0D, 25),
    GREEN(5, 0x008000, 100 * 1000D, 0.5, 20),
    BLUE(6, 0x0000cc, 1000 * 1000D, 0.25, 10),
    VIOLET(7, 0xEE82EE, 10 * 1000 * 1000D, 0.1, 5),
    GREY(8, 0x808080, 100 * 1000 * 1000D, 0.25, 1),
    WHITE(9, 0xFFFFFF, 1000 * 1000 * 1000D, 0D, null),
    GOLD(null, 0xFFD700, 0.1, 5D, null),
    SILVER(null, 0xC0C0C0, 0.01, 10D, null),
    NONE(null, null, null, 20D, null);

    final Integer value;
    final Integer color;
    final Double multiplier;
    final Double tolerance;
    final Integer temperatureCoefficient;

    /**
     * Constructor for a color code.
     *
     * @param value The value in the range 0-9 or null
     * @param color The HEX color code
     * @param multiplier The multiplier
     * @param tolerance The tolerance value in %
     * @param temperatureCoefficient The temperature coefficient in ppm/K
     */
    ColorCode(Integer value, Integer color, Double multiplier, Double tolerance, Integer temperatureCoefficient) {
        this.value = value;
        this.color = color;
        this.multiplier = multiplier;
        this.tolerance = tolerance;
        this.temperatureCoefficient = temperatureCoefficient;
    }

    /**
     * @return The value in the range 0-9 or null if not applicable
     */
    public Integer getValue() {
        return value;
    }

    /**
     * @return The HEX color code or null if not applicable
     */
    public Integer getColor() {
        return color;
    }

    /**
     * @return The multiplier or null if not applicable
     */
    public Double getMultiplier() {
        return multiplier;
    }

    /**
     * @return The tolerance value in % or null if not applicable
     */
    public Double getTolerance() {
        return tolerance;
    }

    /**
     * @return The temperature coefficient in ppm/K or null if not applicable
     */
    public Integer getTemperatureCoefficient() {
        return temperatureCoefficient;
    }

    /**
     * @return All the color codes in markdown table format
     */
    public static String toMarkdown() {
        StringBuilder rt = new StringBuilder();
        rt.append("| ColorCode | HEX color | Value | Multiplier | Tolerance (%) | Temp. coeff. (ppm/K) |");
        rt.append(System.lineSeparator());
        rt.append("| :---: | :---: | :---: | :---: | :---: | :---: |");
        rt.append(System.lineSeparator());

        for (ColorCode colorCode : ColorCode.values()) {
            rt.append("| ").append(colorCode.name())
                    .append(" | ").append(Convert.toHexColorString(colorCode.getColor()))
                    .append(" | ").append(colorCode.getValue() == null ? "" : colorCode.getValue())
                    .append(" | ").append(Convert.toOhmString(colorCode.getMultiplier()))
                    .append(" | ").append(colorCode.getTolerance() == null ? "" : colorCode.getTolerance())
                    .append(" | ").append(colorCode.getTemperatureCoefficient() == null ? "" : colorCode.getTemperatureCoefficient())
                    .append(" |")
                    .append(System.lineSeparator());

        }

        return rt.toString();
    }
}
