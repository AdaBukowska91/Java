package com.epam.adrianna_bukowska.core_layer.selenium_operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Test Add class, with Selenium")
class AddTest {

    private Add add;

    @DisplayName("Test operate method - add")
    @ParameterizedTest
    @ValueSource(strings = {"CHROME", "FIREFOX"})
    public void testOperateAdd(String browserName) {
        WebDriverManager driverManager = new WebDriverManager(browserName);
        add = new Add(driverManager, "https://instacalc.com/");
        assertEquals(5.0, add.operate(2, 3));
    }
}
