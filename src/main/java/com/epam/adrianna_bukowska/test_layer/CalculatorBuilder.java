package com.epam.adrianna_bukowska.test_layer;

import com.epam.adrianna_bukowska.application_layer.Calculator;
import com.epam.adrianna_bukowska.application_layer.CalculatorApplication;
import com.epam.adrianna_bukowska.core_layer.api_operators.CreateApiOperator;
import com.epam.adrianna_bukowska.core_layer.calculator.Operation;
import com.epam.adrianna_bukowska.core_layer.calculator.Operator;
import com.epam.adrianna_bukowska.core_layer.selenium_operators.CreateSeleniumOperator;
import com.epam.adrianna_bukowska.core_layer.selenium_operators.WebDriverManager;
import org.apache.logging.log4j.Logger;

public class CalculatorBuilder {
    private String testType;
    private String browser;
    private String url;
    private Logger logger;
    private Operation operation;
    private Operator operator;

    public CalculatorBuilder setTestType(String testType) {
        this.testType = testType;
        return this;
    }

    public CalculatorBuilder setBrowser(String browser) {
        this.browser = browser;
        return this;
    }

    public CalculatorBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public CalculatorBuilder setLogger(Logger logger) {
        this.logger = logger;
        return this;
    }

    public CalculatorBuilder setOperation(Operation operation) {
        this.operation = operation;
        return this;
    }

    public Calculator build() {
        CalculatorApplication.init(logger);
        Calculator calculator = CalculatorApplication.getInstance();
        if (testType.equalsIgnoreCase("API")) {
            operator = CreateApiOperator.createApiOperator(operation, url);
            calculator.addOperator(operation, operator);
        } else if (testType.equalsIgnoreCase("UI")) {
            operator = CreateSeleniumOperator.createSeleniumOperator(operation, new WebDriverManager(browser), url);
            calculator.addOperator(operation, operator);
        }
        return calculator;
    }
}