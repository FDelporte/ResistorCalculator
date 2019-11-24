package be.webtechie.resistorcalculator.definition;

public class ColorValue {

    final double ohm;
    final double tolerance;
    final Integer temperatureCoefficient;

    public ColorValue(double ohm, double tolerance) {
        this(ohm, tolerance, null);
    }

    public ColorValue(double ohm, double tolerance, Integer temperatureCoefficient) {
        this.ohm = ohm;
        this.tolerance = tolerance;
        this.temperatureCoefficient = temperatureCoefficient;
    }

    public double getOhm() {
        return ohm;
    }

    public double getTolerance() {
        return tolerance;
    }

    public Integer getTemperatureCoefficient() {
        return temperatureCoefficient;
    }
}
