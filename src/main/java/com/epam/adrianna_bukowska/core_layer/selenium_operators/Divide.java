package com.epam.adrianna_bukowska.core_layer.selenium_operators;

public class Divide extends AbstractSeleniumOperator {

    public Divide(WebDriverManager driverManager, String url) {
        super(driverManager, url);
    }

    @Override
    protected String getSign() {
        return "/";
    }
}
