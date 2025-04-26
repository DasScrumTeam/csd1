// src/main/java/com/dasscrumteam/csd1/calculator/StringCalculator.java
package com.dasscrumteam.csd1.calculator;

import java.util.Arrays;


public class StringCalculator {
    public Double calc(String numbers) {
        // TDD exercise: Implement string calculator kata
        try {
            // parse String to find + and add the numbers
            String[] numberArray = numbers.split("\\+");
            // iterate through array
            Double sum = 0.0;
            for (int i = 0; i < numberArray.length; i++) {
                sum += Double.parseDouble(numberArray[i]);
            }
            return sum;
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
