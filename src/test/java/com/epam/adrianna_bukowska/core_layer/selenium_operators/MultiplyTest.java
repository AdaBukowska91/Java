package com.epam.adrianna_bukowska.core_layer.selenium_operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Multiply class, with Selenium")
class MultiplyTest {

    private Multiply multiply;

    @DisplayName("Test operate method - multiply")
    @ParameterizedTest
    @ValueSource(strings = {"CHROME", "FIREFOX"})
    public void testOperateMultiply(String browserName) {
        WebDriverManager driverManager = new WebDriverManager(browserName);
        multiply = new Multiply(driverManager, "https://instacalc.com/");
        assertEquals(8.0, multiply.operate(2, 4));
    }
}