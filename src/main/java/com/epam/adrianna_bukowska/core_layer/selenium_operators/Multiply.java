package com.epam.adrianna_bukowska.core_layer.selenium_operators;

public class Multiply extends AbstractSeleniumOperator {

    public Multiply(WebDriverManager driverManager, String url) {
        super(driverManager, url);
    }

    @Override
    protected String getSign() {
        return "*";
    }
}
