package com.epam.adrianna_bukowska.test_layer.stepdefinitions;

import com.epam.adrianna_bukowska.application_layer.Calculator;
import com.epam.adrianna_bukowska.core_layer.calculator.ConfigProperties;
import com.epam.adrianna_bukowska.core_layer.calculator.Formula;
import com.epam.adrianna_bukowska.core_layer.calculator.Operation;
import com.epam.adrianna_bukowska.test_layer.CalculatorBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorApplicationSteps {

    private Formula formula;
    private Calculator calculator;

    @Given("I have a formula to calculate with operator {}")
    public void i_have_a_formula_to_calculate(Operation operation) throws IOException {
        ConfigProperties.initializePropertyFile();
        Logger logger = LogManager.getLogger();
        calculator = new CalculatorBuilder().setTestType(ConfigProperties.property.getProperty("TestType")).
                setBrowser(ConfigProperties.property.getProperty("Browser")).setUrl(ConfigProperties.property.getProperty("Url")).
                setLogger(logger).setOperation(operation).build();
    }

    @When("enter {double}, {double} and operator {} to calculate")
    public void enter_and_add_to_calculate(double numberX, double numberY, Operation operation) {
        formula = new Formula(numberX, numberY, operation);
    }

    @Then("final calculation result is {double}")
    public void final_calculation_result_is(double result) {
        assertEquals(result, calculator.calculate(formula));
    }

    @Then("final calculation result is positive infinity")
    public void final_calculation_result_is_positive_infinity() {
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(formula));
    }
}

