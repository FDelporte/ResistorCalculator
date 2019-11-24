# Resistor Calculator
Java library to calculate resistor values based on the color coding and their use in circuits.

## How to use

Example code:

```
ColorValue value = CalculateColorValue.from(Arrays.asList(ColorCode.ORANGE, ColorCode.ORANGE, ColorCode.BROWN));

System.out.println(value.getOhm()); // Will print 330 for 330Ω
System.out.println(value.getTolerance()); // Will print 20 for 20%
```

## Read more
These are some of the sources used to write the functions in this library
* https://www.wikihow.com/Calculate-Total-Resistance-in-Circuits
* http://www.ohmslawcalculator.com/led-resistor-calculator
* http://www.resistorguide.com/resistor-color-code/