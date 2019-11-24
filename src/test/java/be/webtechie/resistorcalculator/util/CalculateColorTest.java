package be.webtechie.resistorcalculator.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import be.webtechie.resistorcalculator.definition.ColorCode;
import be.webtechie.resistorcalculator.definition.ColorValue;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CalculateColorTest {

    @Test
    public void test3Band() {
        List<ColorCode> colors = Arrays.asList(ColorCode.ORANGE, ColorCode.ORANGE, ColorCode.BROWN);
        ColorValue expected = new ColorValue(330, 20);
        assertEquals(expected.getOhm(), CalculateColorValue.from(colors).getOhm());
        assertEquals(expected.getTolerance(), CalculateColorValue.from(colors).getTolerance());
        assertNull(CalculateColorValue.from(colors).getTemperatureCoefficient());
    }

    @Test
    public void test4Band() {
        List<ColorCode> colors = Arrays.asList(ColorCode.GREY, ColorCode.RED, ColorCode.ORANGE, ColorCode.GOLD);
        ColorValue expected = new ColorValue(82000, 5);
        assertEquals(expected.getOhm(), CalculateColorValue.from(colors).getOhm());
        assertEquals(expected.getTolerance(), CalculateColorValue.from(colors).getTolerance());
        assertNull(CalculateColorValue.from(colors).getTemperatureCoefficient());
    }

    @Test
    public void test5Band() {
        List<ColorCode> colors = Arrays.asList(ColorCode.GREEN, ColorCode.RED, ColorCode.BROWN, ColorCode.BLACK, ColorCode.BROWN);
        ColorValue expected = new ColorValue(521, 1);
        assertEquals(expected.getOhm(), CalculateColorValue.from(colors).getOhm());
        assertEquals(expected.getTolerance(), CalculateColorValue.from(colors).getTolerance());
        assertNull(CalculateColorValue.from(colors).getTemperatureCoefficient());
    }

    @Test
    public void test6Band() {
        List<ColorCode> colors = Arrays.asList(ColorCode.ORANGE, ColorCode.RED, ColorCode.BROWN, ColorCode.BROWN, ColorCode.BROWN, ColorCode.RED);
        ColorValue expected = new ColorValue(3210, 1, 50);
        assertEquals(expected.getOhm(), CalculateColorValue.from(colors).getOhm());
        assertEquals(expected.getTolerance(), CalculateColorValue.from(colors).getTolerance());
        assertEquals(expected.getTemperatureCoefficient(), CalculateColorValue.from(colors).getTemperatureCoefficient());
    }
}
