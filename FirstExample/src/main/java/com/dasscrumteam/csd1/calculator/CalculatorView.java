package com.dasscrumteam.csd1.calculator;

public interface CalculatorView {

    /**
     *
     * @return input of user
     */
    String getInput();

    /**
     *
     * Show result to user
     * @param result any number
     */
    void showResult(Double result);
}
