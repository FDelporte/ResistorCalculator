# Resistor Calculator
Java library to calculate resistor values based on the color coding and their use in circuits.

## How to use

Example code:

```
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
```

Result

```
Value for resistor with 3 colors ORANGE-ORANGE-BROWN
330.0Ω
20.0%
-----------------------------------------------------------------
Value for resistor with 3 colors ORANGE-RED-BROWN-BROWN-BROWN-RED
39000.0Ω
1.0%
50ppm/K
```
## Read more
These are some of the sources used to write the functions in this library
* https://www.wikihow.com/Calculate-Total-Resistance-in-Circuits
* http://www.ohmslawcalculator.com/led-resistor-calculator
* http://www.resistorguide.com/resistor-color-code/
* https://learn.sparkfun.com/tutorials/resistors/decoding-resistor-markings