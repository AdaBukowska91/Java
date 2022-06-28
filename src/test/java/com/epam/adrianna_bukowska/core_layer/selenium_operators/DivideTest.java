package com.epam.adrianna_bukowska.core_layer.selenium_operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Divide class, with Selenium")
class DivideTest {

    private Divide divide;

    @DisplayName("Test operate method - divide")
    @ParameterizedTest
    @ValueSource(strings = {"CHROME", "FIREFOX"})
    public void testOperateDivide(String browserName) {
        WebDriverManager driverManager = new WebDriverManager(browserName);
        divide = new Divide(driverManager,"https://instacalc.com/");
        assertEquals(6.0, divide.operate(12, 2));
    }

    @DisplayName("Test operate method - divide by zero")
    @ParameterizedTest
    @ValueSource(strings = {"CHROME", "FIREFOX"})
    public void testOperateDivideByZero(String browserName) {
        WebDriverManager driverManager = new WebDriverManager(browserName);
        divide = new Divide(driverManager, "https://instacalc.com/");
        assertEquals(Double.POSITIVE_INFINITY, divide.operate(5, 0));
    }
}
