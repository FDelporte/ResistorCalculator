# Resistor Calculator
Java library to calculate resistor values based on the color coding and their use in electronic circuits.

## How to use

### Resistor color coding

Available as ColorCode.BLACK, ColorCode.BROWN... and includes all values listed in this table:

| ColorCode | HEX color | Value | Multiplier | Tolerance (%) | Temp. coeff. (ppm/K) |
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

### Calculate value of a resistor based on 3, 4, 5 or 6 ColorCodes

#### Example with 3 ColorCodes

```
ColorValue value3band = Calculate.resistorValue(
        Arrays.asList(ColorCode.ORANGE, ColorCode.ORANGE, ColorCode.BROWN)
);
System.out.println(Convert.toOhmString(value3band.getOhm()));           // Result: 330Ω
System.out.println(value3band.getTolerance() + "%");                    // Result: 20.0%
```

#### Example with 6 ColorCodes

```
ColorValue value6band = Calculate.resistorValue(
        Arrays.asList(
                ColorCode.ORANGE, ColorCode.WHITE, ColorCode.BLACK,
                ColorCode.SILVER, ColorCode.BROWN, ColorCode.RED
        )
);

System.out.println(Convert.toOhmString(value6band.getOhm()));           // Result: 3.9Ω
System.out.println(value6band.getTolerance() + "%");                    // Result: 1.0%
System.out.println(value6band.getTemperatureCoefficient() + "ppm/K");   // Result: 50ppm/K
```

### Calculate required resistor value for a LED

```
// Calculate.resistorForLed(double sourceVoltage, double ledVoltage, double ledCurrent)
System.out.println(Calculate.resistorForLed(3.3, 2.2, 0.02));           // Result: 55
```

### Calculate total value for resistors in serial or parallel

```
// Calculate.serial(List<Double> values) {
System.out.println(Calculate.serial(Arrays.asList(2D, 5D, 7D)));        // Result: 14
    
// Calculate.parallel(List<Double> values)
System.out.println(Calculate.parallel(Arrays.asList(10D, 2D, 1D)));     // Result: 0.625
```

## Read more
These are some of the sources used to write the functions in this library
* https://www.wikihow.com/Calculate-Total-Resistance-in-Circuits
* http://www.ohmslawcalculator.com/led-resistor-calculator
* http://www.resistorguide.com/resistor-color-code/
* https://learn.sparkfun.com/tutorials/resistors/decoding-resistor-markings
* https://learn.sparkfun.com/tutorials/light-emitting-diodes-leds/all