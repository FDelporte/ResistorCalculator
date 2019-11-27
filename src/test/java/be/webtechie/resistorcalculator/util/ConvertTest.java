package be.webtechie.resistorcalculator.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ConvertTest {

    @Test
    public void hex() {
        assertEquals("", Convert.toHexColorString(null));
        assertEquals("#0000ff", Convert.toHexColorString(255));
        assertEquals("#00ff00", Convert.toHexColorString(255 << 8));
        assertEquals("#ff0000", Convert.toHexColorString(255 << 16));
        assertEquals("#ff0f05", Convert.toHexColorString((255 << 16) + (15 << 8) + 5));
    }

    @Test
    public void ohm() {
        assertEquals("", Convert.toOhmString(null));
        assertEquals("0.01Ω",   Convert.toOhmString(0.01D));
        assertEquals("0.1Ω",    Convert.toOhmString(0.1D));
        assertEquals("1Ω",      Convert.toOhmString(1D));
        assertEquals("10Ω",     Convert.toOhmString(10D));
        assertEquals("100Ω",    Convert.toOhmString(100D));
        assertEquals("1KΩ",     Convert.toOhmString(1000D));
        assertEquals("10KΩ",    Convert.toOhmString(10000D));
        assertEquals("100KΩ",   Convert.toOhmString(100000D));
        assertEquals("1MΩ",     Convert.toOhmString(1000000D));
        assertEquals("10MΩ",    Convert.toOhmString(10000000D));
        assertEquals("100MΩ",   Convert.toOhmString(100000000D));
        assertEquals("1GΩ",     Convert.toOhmString(1000000000D));
        assertEquals("10GΩ",    Convert.toOhmString(10000000000D));
        assertEquals("100GΩ",   Convert.toOhmString(100000000000D));
    }

    @Test
    public void round() {
        assertEquals("", Convert.roundIfPossible(null));
        assertEquals("3", Convert.roundIfPossible(3D));
        assertEquals("3", Convert.roundIfPossible(3.0D));
        assertEquals("3.3", Convert.roundIfPossible(3.3D));
        assertEquals("3.3", Convert.roundIfPossible(3.30D));
    }
}
