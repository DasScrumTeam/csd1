// test/java/com/dasscrumteam/csd1/calculator/StringCalculatorTest.java
package com.dasscrumteam.csd1.calculator

public class StringCalculatorTest {
    @Test
    void shouldReturnZeroForEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }
}

