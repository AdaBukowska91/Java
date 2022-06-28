package com.epam.adrianna_bukowska.core_layer.selenium_operators;

import com.epam.adrianna_bukowska.core_layer.calculator.Operation;
import com.epam.adrianna_bukowska.core_layer.calculator.Operator;

import java.util.function.BiFunction;

public enum CreateSeleniumOperator {

    ADD(Add::new),
    SUBTRACT(Subtract::new),
    MULTIPLY(Multiply::new),
    DIVIDE(Divide::new),
    ;

    private final BiFunction<WebDriverManager, String, Operator> creator;

    CreateSeleniumOperator(BiFunction<WebDriverManager, String, Operator> creator) {
        this.creator = creator;
    }

    public static Operator createSeleniumOperator(Operation operation, WebDriverManager driverManager, String url) {
        try {
            return valueOf(operation.name()).creator.apply(driverManager, url);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unsupported operation: ".concat(operation.name()));
        }
    }
}

