package be.webtechie.resistorcalculator.util;

public class CalculateLedResistor {

    /**
     * Calculate the required resistor value for a LED.
     *
     * @param sourceVoltage The source voltage in Volt
     * @param ledVoltage The LED voltage in Volt
     * @param ledAmpere The LED current in Ampere
     * @return The resister value in Ohm
     */
    public static long from(double sourceVoltage, double ledVoltage, double ledAmpere) {
        return Math.round((sourceVoltage - ledVoltage) / ledAmpere);
    }
}
