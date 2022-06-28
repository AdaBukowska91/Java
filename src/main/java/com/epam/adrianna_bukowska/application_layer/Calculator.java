package com.epam.adrianna_bukowska.application_layer;

import com.epam.adrianna_bukowska.core_layer.calculator.Formula;
import com.epam.adrianna_bukowska.core_layer.calculator.Operation;
import com.epam.adrianna_bukowska.core_layer.calculator.Operator;

public interface Calculator {

    Number calculate (Formula formula);

    void addOperator (Operation operation, Operator operator);
}
