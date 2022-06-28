package com.epam.adrianna_bukowska.core_layer.api_operators;

public class Add extends AbstractApiOperator {

    public Add(String endpoint) {
        super(endpoint);
    }

    @Override
    protected String getSign() {
        return "+";
    }
}


