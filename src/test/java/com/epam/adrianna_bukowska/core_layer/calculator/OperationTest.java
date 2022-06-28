package com.epam.adrianna_bukowska.core_layer.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test Operation class")
class OperationTest {

    @DisplayName("Test of method")
    @ParameterizedTest
    @CsvFileSource(resources = {"/operation.csv"})
    void testOf(String name, String symbol) {
        assertEquals(Operation.valueOf(name), Operation.of(symbol));
    }

    @DisplayName("Test of method using wrong values")
    @ParameterizedTest
    @ValueSource(strings = {" ", "@", "#", "$"})
    void testOfNotCorrect(String symbol) {
        assertThrows(IllegalArgumentException.class, () -> Operation.of(symbol));
    }
}