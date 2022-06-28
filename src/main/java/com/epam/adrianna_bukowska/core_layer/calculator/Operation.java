package com.epam.adrianna_bukowska.core_layer.calculator;
import java.util.HashMap;
import java.util.Map;

public enum Operation {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;
    private static final Map<String, Operation> symbols = new HashMap<>(values().length, 1);

    static {
        for (Operation c : values()) symbols.put(c.symbol, c);
    }

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public static Operation of(String name) {
        Operation result = symbols.get(name);
        if (result == null) {
            throw new IllegalArgumentException(name + " doesn't match any operator.");
        }
        return result;
    }
}

