package be.webtechie.resistorcalculator.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CalculateTotalTest {

    @Test
    public void testSerial() {
        assertEquals(14, CalculateTotal.serial(Arrays.asList(2D, 5D, 7D)));
    }

    @Test
    public void testParallell() {
        assertEquals(0.625, CalculateTotal.parallel(Arrays.asList(10D, 2D, 1D)));
    }
}
