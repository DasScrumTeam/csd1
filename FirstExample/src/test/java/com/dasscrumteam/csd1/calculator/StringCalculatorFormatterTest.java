package com.dasscrumteam.csd1.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StringCalculatorFormatterTest {
    private StringCalculatorFormatter formatter;

    @BeforeEach
    public void setup() {
        this.formatter = new StringCalculatorFormatter();
    }

    @Test
    public void testFormatIntegerResult() {
        assertEquals("2", this.formatter.format(2.0));

    }

    @Test
    public void testFormatDoubleResult() {
        assertEquals("2.5", this.formatter.format(2.5));

    }

}
