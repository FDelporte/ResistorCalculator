package be.webtechie.resistorcalculator.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CalculateSerialParallelTest {

    @Test
    public void testSerial() {
        assertEquals(14, Calculate.serial(Arrays.asList(2D, 5D, 7D)));
    }

    @Test
    public void testParallel() {
        assertEquals(0.625, Calculate.parallel(Arrays.asList(10D, 2D, 1D)));
    }
}
