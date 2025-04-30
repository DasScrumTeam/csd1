package com.dasscrumteam.csd1.calculator;

public class CalculatorController {
    private final Calculator calculator;
    private final CalculatorView view;

    public CalculatorController(Calculator calculator, CalculatorView view) {
        this.calculator = calculator;
        this.view = view;
    }

    public void run() {
        String input = view.getInput();
        Double result = calculator.calc(input);
        view.showResult(result);
    }
}