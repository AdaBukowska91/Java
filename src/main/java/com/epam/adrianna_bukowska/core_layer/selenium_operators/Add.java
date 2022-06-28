package com.epam.adrianna_bukowska.core_layer.selenium_operators;

public class Add extends AbstractSeleniumOperator {

    public Add(WebDriverManager driverManager, String url) {
        super(driverManager, url);
    }

    @Override
    protected String getSign() {
        return "+";
    }
}
