package com.epam.adrianna_bukowska.core_layer.api_operators;

public class Divide extends AbstractApiOperator {

    public Divide(String endpoint) {
        super(endpoint);
    }

    @Override
    protected String getSign() {
        return "/";
    }
}

