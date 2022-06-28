package com.epam.adrianna_bukowska.core_layer.selenium_operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Subtract class, with Selenium")
class SubtractTest {

    private Subtract subtract;

    @DisplayName("Test operate method - subtract")
    @ParameterizedTest
    @ValueSource(strings = {"CHROME", "FIREFOX"})
    public void testOperateSubtract(String browserName) {
        WebDriverManager driverManager = new WebDriverManager(browserName);
        subtract = new Subtract(driverManager, "https://instacalc.com/");
        assertEquals(8.0, subtract.operate(10, 2));
    }
}
