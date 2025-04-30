package com.dasscrumteam.csd1.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommandLineTest {
    @Test
    public void testItHasACommandLineProcessor() {
        CalculatorApp processor = new CalculatorApp();
        assertNotNull(processor);
    }

    @Test
    public void testItCanProcessSomething() {
        CalculatorApp processor = new CalculatorApp();

    }
}
