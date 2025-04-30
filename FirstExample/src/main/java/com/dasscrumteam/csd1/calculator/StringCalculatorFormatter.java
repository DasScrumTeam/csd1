package com.dasscrumteam.csd1.calculator;

public class StringCalculatorFormatter {

    public StringCalculatorFormatter() {

    }

    public String format(Double v) {
        return v.toString()
                .replaceAll("()\\.0+$|(\\..+?)0+$", "$2");
    }
}
