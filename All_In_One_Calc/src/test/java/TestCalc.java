import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalc {

    Calculator calculator;
    Menus menus;

    @BeforeEach
    void setup()
    {
        calculator = new Calculator();
        menus = new Menus();
    }

    @Test
    @DisplayName("fact()=>follows path [1,2,3,5,6]")
    public void testFact1()
    {
        assertEquals(1,calculator.fact(1));
    }

    @Test
    @DisplayName("fact()=>follows path [1,2,3,4,3,5,6]")
    public void testFact2()
    {
        assertEquals(2,calculator.fact(2));
    }

    @Test
    @DisplayName("fact()=>follows path [1,2,3,4,3,4,3,5,6]")
    public void testFact3()
    {
        assertEquals(120,calculator.fact(5));
    }

    @Test
    @DisplayName("power()=>follows path [1,2,4,7,9]")
    public void testPower1()
    {
        assertEquals(1,calculator.power(2,0));
    }

    @Test
    @DisplayName("power()=>follows path [1,2,3,10,5,6,2,4,7,8]")
    public void testPower2()
    {
        assertEquals(0.5,calculator.power(2,-1));
    }

    @Test
    @DisplayName("power()=>follows path [1,2,3,10,5,6,2,4,7,9]")
    public void testPower3()
    {
        assertEquals(2,calculator.power(2,1));
    }

    @Test
    @DisplayName("power()=>follows path [1,2,3,10,5,6,2,3,10,5,6,2,4,7,8]")
    public void testPower4()
    {
        assertEquals(0.125,calculator.power(2,-3));
    }

    @Test
    @DisplayName("decimalToOctal()=>follows path [1,2,4]")
    public void testDecToOctal1()
    {
        assertEquals("7",calculator.decimalToOctal(7));
    }

    @Test
    @DisplayName("decimalToOctal()=>follows path [1,2,3,2,4]")
    public void testDecToOctal2()
    {
        assertEquals("12",calculator.decimalToOctal(10));
    }

    @Test
    @DisplayName("decimalToOctal()=>follows path [1,2,3,2,3,2,4]")
    public void testDecToOctal3()
    {
        assertEquals("244",calculator.decimalToOctal(164));
    }

    @Test
    @DisplayName("binaryToHexa()=>follows path [1,2,7]")
    public void testBinToHexa1()
    {
        assertEquals("",calculator.binaryToHexa(""));
    }

    @Test
    @DisplayName("binaryToHexa()=>follows path [1,2,3,4,5,4,6,2,7]")
    public void testBinToHexa2()
    {
        assertEquals("1",calculator.binaryToHexa("1"));
    }

    @Test
    @DisplayName("binaryToHexa()=>follows path [1,2,3,4,5,4,5,4,6,2,7]")
    public void testBinToHexa3()
    {
        assertEquals("2",calculator.binaryToHexa("10"));
    }

    @Test
    @DisplayName("decimalToBinary()=>follows path [1,2,4]")
    public void testDecToBin1()
    {
        assertEquals("1",calculator.decimalToBinary(1));
    }

    @Test
    @DisplayName("decimalToBinary()=>follows path [1,2,3,2,4]")
    public void testDecToBin2()
    {
        assertEquals("11",calculator.decimalToBinary(3));
    }

    @Test
    @DisplayName("decimalToBinary()=>follows path [1,2,3,2,3,2,4]")
    public void testDecToBin3()
    {
        assertEquals("101",calculator.decimalToBinary(5));
    }

    @Test
    @DisplayName("binaryToDecimal()=>follows path [1,2,3,6,2,4]")
    public void testBinToDec1()
    {
        assertEquals(0,calculator.binaryToDecimal("0"));
    }

    @Test
    @DisplayName("binaryToDecimal()=>follows path [1,2,3,5,6,2,4]")
    public void testBinToDec2()
    {
        assertEquals(1,calculator.binaryToDecimal("1"));
    }

    @Test
    @DisplayName("binaryToDecimal()=>follows path [1,2,4]")
    public void testBinToDec3()
    {
        assertEquals(0,calculator.binaryToDecimal(""));
    }

    @Test
    @DisplayName("binaryToDecimal()=>follows path [1,2,3,5,6,5,6,2,4]")
    public void testBinToDec4()
    {
        assertEquals(3,calculator.binaryToDecimal("11"));
    }





}
