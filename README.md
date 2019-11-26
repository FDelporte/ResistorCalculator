# Resistor Calculator
Java library to calculate resistor values based on the color coding and their use in circuits.

## How to use

Example code:

```
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
```

Result:

```
Value for resistor with 3 colors ORANGE-ORANGE-BROWN
330Ω
20.0%
-----------------------------------------------------------------
Value for resistor with 6 colors ORANGE-RED-BROWN-SILVER-BROWN-RED
3.9Ω
1.0%
50ppm/K
```

### ColorCode definition

| Color | HEX color | Value | Multiplier | Tolerance (%) | Temp. coeff. (ppm/K) |
| :---: | :---: | :---: | :---: | :---: | :---: |
| BLACK | #000000 | 0 | 1Ω |  | 250 |
| BROWN | #6f370f | 1 | 10Ω | 1.0 | 100 |
| RED | #800000 | 2 | 100Ω | 2.0 | 50 |
| ORANGE | #ffa500 | 3 | 1KΩ |  | 15 |
| YELLOW | #ffff00 | 4 | 10KΩ | 0.0 | 25 |
| GREEN | #008000 | 5 | 100KΩ | 0.5 | 20 |
| BLUE | #000080 | 6 | 1MΩ | 0.25 | 10 |
| VIOLET | #ee82ee | 7 | 10MΩ | 0.1 | 5 |
| GREY | #808080 | 8 | 100MΩ | 0.25 | 1 |
| WHITE | #ffffff | 9 | 1GΩ | 0.0 |  |
| GOLD | #ffd700 |  | 0.1Ω | 5.0 |  |
| SILVER | #c0c0c0 |  | 0.01Ω | 10.0 |  |
| NONE |  |  |  | 20.0 |  |

## Read more
These are some of the sources used to write the functions in this library
* https://www.wikihow.com/Calculate-Total-Resistance-in-Circuits
* http://www.ohmslawcalculator.com/led-resistor-calculator
* http://www.resistorguide.com/resistor-color-code/
* https://learn.sparkfun.com/tutorials/resistors/decoding-resistor-markings
* https://learn.sparkfun.com/tutorials/light-emitting-diodes-leds/all