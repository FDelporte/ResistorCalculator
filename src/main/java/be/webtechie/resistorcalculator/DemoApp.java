package be.webtechie.resistorcalculator;

import be.webtechie.resistorcalculator.definition.ColorCode;
import be.webtechie.resistorcalculator.definition.ResistorValue;
import be.webtechie.resistorcalculator.util.Calculate;
import be.webtechie.resistorcalculator.util.Convert;
import java.util.Arrays;

public class DemoApp {
    public static void main(String[] args) {
        ResistorValue value3band = Calculate.resistorValue(
                Arrays.asList(ColorCode.ORANGE, ColorCode.ORANGE, ColorCode.BROWN)
        );
        System.out.println(Convert.toOhmString(value3band.getOhm()));
        System.out.println(value3band.getTolerance() + "%");

        System.out.println("-----------------------------------------------------------------");

        ResistorValue value6band = Calculate.resistorValue(
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