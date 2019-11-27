package be.webtechie.resistorcalculator.util;

/**
 * Result object used to return the value of a resistor.
 */
public class ResistorValue {

    final double ohm;
    final double tolerance;
    final Integer temperatureCoefficient;

    /**
     * Constructor for a resistor value with null temperatureCoefficient.
     *
     * @param ohm The Ohm value of the resistor in Ω
     * @param tolerance The tolerance value of the resistor in %
     */
    public ResistorValue(double ohm, double tolerance) {
        this(ohm, tolerance, null);
    }

    /**
     * Constructor for a resistor value.
     *
     * @param ohm The Ohm value of the resistor in Ω
     * @param tolerance The tolerance value of the resistor in %
     * @param temperatureCoefficient The temperature coefficient value in ppm/K
     */
    public ResistorValue(double ohm, double tolerance, Integer temperatureCoefficient) {
        this.ohm = ohm;
        this.tolerance = tolerance;
        this.temperatureCoefficient = temperatureCoefficient;
    }

    /**
     * @return The Ohm value of the resistor in Ω
     */
    public double getOhm() {
        return ohm;
    }

    /**
     * @return The tolerance value of the resistor in %
     */
    public double getTolerance() {
        return tolerance;
    }

    /**
     * @return The temperature coefficient value in ppm/K (or null)
     */
    public Integer getTemperatureCoefficient() {
        return temperatureCoefficient;
    }
}
