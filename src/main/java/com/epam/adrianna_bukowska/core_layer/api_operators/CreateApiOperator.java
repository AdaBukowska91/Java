package com.epam.adrianna_bukowska.core_layer.api_operators;

import com.epam.adrianna_bukowska.core_layer.calculator.Operation;
import com.epam.adrianna_bukowska.core_layer.calculator.Operator;

import java.util.function.Function;

public enum CreateApiOperator {

    ADD(Add::new),
    DIVIDE(Divide::new),
    MULTIPLY(Multiply::new),
    SUBTRACT(Subtract::new),
    ;

    private final Function<String, Operator> creator;

    CreateApiOperator(Function<String, Operator> creator) {
        this.creator = creator;
    }

    public static Operator createApiOperator(Operation operation, String endpoint) {
        try {
            return valueOf(operation.name()).creator.apply(endpoint);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unsupported operation: ".concat(operation.name()));
        }
    }
}
