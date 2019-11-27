package be.webtechie.resistorcalculator.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculateLedResistorTest {

    @Test
    public void testCalculation1() {
        assertEquals(55, Calculate.resistorForLed(3.3, 2.2, 0.02));
    }

    @Test
    public void testCalculation2() {
        assertEquals(140, Calculate.resistorForLed(5, 2.2, 0.02));
    }

    @Test
    public void testCalculation3() {
        assertEquals(17, Calculate.resistorForLed(9, 2.9, 0.35));
    }
}
