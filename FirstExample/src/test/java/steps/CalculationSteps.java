package steps;

import com.dasscrumteam.csd1.calculator.CalculatorController;
import com.dasscrumteam.csd1.calculator.StringCalculator;
import com.dasscrumteam.csd1.calculator.TestCalculatorView;
import io.cucumber.java.en.*;


import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class CalculationSteps {
    private CalculatorController calculatorController;
    private StringCalculator calculator;
    private TestCalculatorView testCalculatorView;
    private String input;

    @Given("the calculator is started")
    public void theCalculatorIsStarted() {
        calculator = new StringCalculator();
        testCalculatorView = new TestCalculatorView();
        calculatorController = new CalculatorController(calculator, testCalculatorView);
    }

    @When("the user enters {string}")
    public void theUserEntersString(String input) {
        testCalculatorView.setInput(input);
        calculatorController.run();
    }

    @Then("the calculator should display {string}")
    public void theCalculatorShouldDisplay(String output) {
        String result = testCalculatorView.getOutput();
        assertEquals(output, result,
                "The calculator should display "
                        + output + " as the result of the calculation.\n"
                        + "But it displayed " + "result");
    }


}

