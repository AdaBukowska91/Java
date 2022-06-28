package com.epam.adrianna_bukowska.application_layer;

import com.epam.adrianna_bukowska.core_layer.calculator.Formula;
import com.epam.adrianna_bukowska.core_layer.calculator.Operation;
import com.epam.adrianna_bukowska.core_layer.calculator.Operator;
import com.epam.adrianna_bukowska.core_layer.exceptions.InvalidOperatorTypeException;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CalculatorApplication implements Calculator {

    private static CalculatorApplication calculatorApplication = null;
    private final Map<Operation, Operator> operators = new HashMap();
    private final Logger logger;
    private Number result;
    private Operation operator;

    private CalculatorApplication(Logger logger) {
        this.logger = logger;
    }

    public static CalculatorApplication getInstance() {
        if (calculatorApplication == null) {
            throw new AssertionError("CalculatorApplication needs to be initialized first.");
        }
        return calculatorApplication;
    }

    public synchronized static CalculatorApplication init(Logger logger) {
        if (calculatorApplication != null) {
            throw new AssertionError("CalculatorApplication has already been initialized.");
        }
        calculatorApplication = new CalculatorApplication(logger);
        return calculatorApplication;
    }

    public void setResult(Number result) {
        this.result = result;
    }

    public Map<Operation, Operator> getOperators() {
        return operators;
    }

    @Override
    public Number calculate(Formula formula) {
        operator = formula.operator();
        if (operators.containsKey(operator)) {
            setResult(operators.get(operator).operate(formula.x(), formula.y()));
            return result;
        } else {
            throw new InvalidOperatorTypeException("Operator " + formula.operator() +
                    " is not supported.");
        }
    }

    @Override
    public void addOperator(Operation operation, Operator operator) {
        if (operators.containsKey(operation)) {
            logger.info("Operator has already been added.");
        } else {
            operators.putIfAbsent(operation, operator);
            logger.info("New operator has been added successfully.");
        }
    }
}