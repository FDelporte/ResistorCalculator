package be.webtechie.resistorcalculator.util;

public class Convert {

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
