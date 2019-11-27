package be.webtechie.resistorcalculator.util;

/**
 * Helper methods to format to readable values.
 */
public class Convert {

    /**
     * Convert integer color value to HEX string.
     *
     * @param value Color value
     * @return HEX color in format #RRGGBB
     */
    public static String toHexColorString(Integer value) {
        if (value == null) {
            return "";
        }

        String hex = Integer.toHexString(value);

        if (hex.length() < 6) {
            hex = ("000000").substring(0, (6 - hex.length())) + hex;
        }

        return "#" + hex;
    }

    /**
     * Convert double Ohm value to Ω, KΩ, MΩ or GΩ value.
     *
     * @param value Ohm value
     * @return Ohm value as Ω, KΩ, MΩ or GΩ
     */
    public static String toOhmString(Double value) {
        if (value == null) {
            return "";
        } else if (value >= 1000000000) {
            return roundIfPossible(value / 1000000000) + "GΩ";
        } else if (value >= 1000000) {
            return roundIfPossible(value / 1000000) + "MΩ";
        } else if (value >= 1000) {
            return roundIfPossible(value / 1000) + "KΩ";
        } else {
            return roundIfPossible(value) + "Ω";
        }
    }

    /**
     * Convert double to rounded value if there are no decimals.
     *
     * @param value Double value
     * @return String value, eg. "3" for input "3.3", or "3.3" for input "3.3"
     */
    public static String roundIfPossible(Double value) {
        if (value == null) {
            return "";
        } else if (value - (int) (double) value == 0) {
            return String.valueOf(Math.round(value));
        } else {
            return String.valueOf(value);
        }
    }
}
