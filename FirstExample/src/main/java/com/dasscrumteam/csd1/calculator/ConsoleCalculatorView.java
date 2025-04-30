package com.dasscrumteam.csd1.calculator;

import java.util.Scanner;

public class ConsoleCalculatorView implements CalculatorView {
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleCalculatorView() {
    }

    @Override
    public void showResult(Double result) {
        // Format so .0 is not shown if integer
        if (result == Math.floor(result)) {
            System.out.println(result.longValue());
        } else {
            System.out.println(result);
        }
    }

    @Override
    public String getInput() {
        System.out.print("Enter numbers separated by '+': ");
        return scanner.nextLine();
    }
}
