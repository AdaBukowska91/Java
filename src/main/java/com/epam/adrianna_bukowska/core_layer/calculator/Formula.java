package com.epam.adrianna_bukowska.core_layer.calculator;

public record Formula(Number x, Number y, Operation operator) {

    @Override
    public String toString() {
        return "x = " + x +
                ", y = " + y +
                ", operator = " + operator;
    }
}
