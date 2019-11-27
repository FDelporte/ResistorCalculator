package be.webtechie.resistorcalculator.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import be.webtechie.resistorcalculator.definition.ColorCode;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CalculateColorTest {

    @Test
    public void test3Band() {
        List<ColorCode> colors = Arrays.asList(ColorCode.ORANGE, ColorCode.ORANGE, ColorCode.BROWN);
        ResistorValue expected = new ResistorValue(330, 20);
        assertEquals(expected.getOhm(), Calculate.resistorValue(colors).getOhm());
        assertEquals(expected.getTolerance(), Calculate.resistorValue(colors).getTolerance());
        assertNull(Calculate.resistorValue(colors).getTemperatureCoefficient());
    }

    @Test
    public void test4Band() {
        List<ColorCode> colors = Arrays.asList(ColorCode.GREY, ColorCode.RED, ColorCode.ORANGE, ColorCode.GOLD);
        ResistorValue expected = new ResistorValue(82000, 5);
        assertEquals(expected.getOhm(), Calculate.resistorValue(colors).getOhm());
        assertEquals(expected.getTolerance(), Calculate.resistorValue(colors).getTolerance());
        assertNull(Calculate.resistorValue(colors).getTemperatureCoefficient());
    }

    @Test
    public void test5Band() {
        List<ColorCode> colors = Arrays.asList(ColorCode.GREEN, ColorCode.RED, ColorCode.BROWN, ColorCode.BLACK, ColorCode.BROWN);
        ResistorValue expected = new ResistorValue(521, 1);
        assertEquals(expected.getOhm(), Calculate.resistorValue(colors).getOhm());
        assertEquals(expected.getTolerance(), Calculate.resistorValue(colors).getTolerance());
        assertNull(Calculate.resistorValue(colors).getTemperatureCoefficient());
    }

    @Test
    public void test6Band() {
        List<ColorCode> colors = Arrays.asList(ColorCode.ORANGE, ColorCode.RED, ColorCode.BROWN, ColorCode.BROWN, ColorCode.BROWN, ColorCode.RED);
        ResistorValue expected = new ResistorValue(3210, 1, 50);
        assertEquals(expected.getOhm(), Calculate.resistorValue(colors).getOhm());
        assertEquals(expected.getTolerance(), Calculate.resistorValue(colors).getTolerance());
        assertEquals(expected.getTemperatureCoefficient(), Calculate.resistorValue(colors).getTemperatureCoefficient());
    }
}
