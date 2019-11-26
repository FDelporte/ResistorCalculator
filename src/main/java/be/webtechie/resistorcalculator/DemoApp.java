package be.webtechie.resistorcalculator;

import be.webtechie.resistorcalculator.definition.ColorCode;
import be.webtechie.resistorcalculator.definition.ColorValue;
import be.webtechie.resistorcalculator.util.CalculateColorValue;
import be.webtechie.resistorcalculator.util.Convert;
import java.util.Arrays;

public class DemoApp {
    public static void main(String[] args) {
        System.out.println("Value for resistor with 3 colors ORANGE-ORANGE-BROWN");
        ColorValue value3band = CalculateColorValue.from(
                Arrays.asList(ColorCode.ORANGE, ColorCode.ORANGE, ColorCode.BROWN)
        );
        System.out.println(Convert.toOhmString(value3band.getOhm()));
        System.out.println(value3band.getTolerance() + "%");

        System.out.println("-----------------------------------------------------------------");

        System.out.println("Value for resistor with 6 colors ORANGE-RED-BROWN-SILVER-BROWN-RED");
        ColorValue value6band = CalculateColorValue.from(
                Arrays.asList(
                        ColorCode.ORANGE, ColorCode.WHITE, ColorCode.BLACK,
                        ColorCode.SILVER, ColorCode.BROWN, ColorCode.RED
                )
        );

        System.out.println(Convert.toOhmString(value6band.getOhm()));
        System.out.println(value6band.getTolerance() + "%");
        System.out.println(value6band.getTemperatureCoefficient() + "ppm/K");

        System.out.println("-----------------------------------------------------------------");

        System.out.print(ColorCode.toMarkdown());
    }
}