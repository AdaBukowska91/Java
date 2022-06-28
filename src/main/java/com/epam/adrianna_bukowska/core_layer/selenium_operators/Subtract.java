package com.epam.adrianna_bukowska.core_layer.selenium_operators;

public class Subtract extends AbstractSeleniumOperator {

    public Subtract(WebDriverManager driverManager, String url) {
        super(driverManager, url);
    }

    @Override
    protected String getSign() {
        return "-";
    }
}
