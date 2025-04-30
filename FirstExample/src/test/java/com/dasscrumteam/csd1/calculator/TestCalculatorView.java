package com.dasscrumteam.csd1.calculator;

public class TestCalculatorView implements CalculatorView {
    private String input = "";
    private String output = "";

   public void setInput(String input) {
        this.input = input.trim();
    }

    @Override
    public String getInput() {
        return this.input;
    }

    @Override
    public void showResult(Double result) {
       this.output = new StringCalculatorFormatter().format(result);

    }

    public String getOutput() {
       return this.output;
    }
}
