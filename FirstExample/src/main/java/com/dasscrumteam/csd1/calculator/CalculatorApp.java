package com.dasscrumteam.csd1.calculator;
public class CalculatorApp {
    public CalculatorApp() {


    }

    public static void main(String[] args) {

        StringCalculator calculator = new StringCalculator();
        ConsoleCalculatorView view = new ConsoleCalculatorView();
        CalculatorController controller = new CalculatorController(calculator, view);
        controller.run();


    }


}
