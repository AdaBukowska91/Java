package com.epam.adrianna_bukowska.core_layer.api_operators;

public class Subtract extends AbstractApiOperator {

    public Subtract(String endpoint) {
        super(endpoint);
    }

    @Override
    protected String getSign() {
        return "-";
    }
}
