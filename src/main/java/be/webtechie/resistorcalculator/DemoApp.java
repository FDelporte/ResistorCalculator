package be.webtechie.resistorcalculator;

import be.webtechie.resistorcalculator.definition.ColorCode;
import be.webtechie.resistorcalculator.definition.ColorValue;
import be.webtechie.resistorcalculator.util.CalculateColorValue;
import java.util.Arrays;

public class DemoApp {
    public static void main(String[] args) {
        System.out.println("Value for resistor with 3 colors ORANGE-ORANGE-BROWN");
        ColorValue value3band = CalculateColorValue.from(
                Arrays.asList(ColorCode.ORANGE, ColorCode.ORANGE, ColorCode.BROWN)
        );
        System.out.println(value3band.getOhm() + "Ω");
        System.out.println(value3band.getTolerance() + "%");

        System.out.println("-----------------------------------------------------------------");

        System.out.println("Value for resistor with 3 colors ORANGE-RED-BROWN-BROWN-BROWN-RED");
        ColorValue value6band = CalculateColorValue.from(
                Arrays.asList(
                        ColorCode.ORANGE, ColorCode.WHITE, ColorCode.BLACK,
                        ColorCode.RED, ColorCode.BROWN, ColorCode.RED
                )
        );

        System.out.println(value6band.getOhm() + "Ω");
        System.out.println(value6band.getTolerance() + "%");
        System.out.println(value6band.getTemperatureCoefficient() + "ppm/K");
    }
}