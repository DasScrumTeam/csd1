// test/java/com/dasscrumteam/csd1/calculator/StringCalculatorTest.java
package com.dasscrumteam.csd1.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    private StringCalculator calculator;

    // Add setup
    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void shouldReturnZeroForEmptyString() {

        assertEquals(0, calculator.calc(""));
    }

    @Test
    void shouldReturnOneForOne(){
        assertEquals(1, calculator.calc("1"));
    }

    @Test
    void shouldReturnTwoForOnePlusOne(){
        assertEquals(2, calculator.calc("1+1"));
    }

    @Test
    void shouldReturnZeroForInvalidCalculation(){
        assertEquals(0, calculator.calc("A+B+C"));
    }

    @Test
    void shouldReturnThreeForOneAndHalfPlusOneAndHalf() {
        assertEquals(3, calculator.calc("1.5+1.5"));
    }


}

