package com.epam.adrianna_bukowska.core_layer.api_operators;

public class Multiply extends AbstractApiOperator {

    public Multiply(String endpoint) {
        super(endpoint);
    }

    @Override
    protected String getSign() {
        return "*";
    }
}
