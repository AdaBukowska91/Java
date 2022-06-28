package com.epam.adrianna_bukowska.core_layer.selenium_operators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeBrowserHandler implements BrowserHandler {

    private final BrowserHandler next;

    public EdgeBrowserHandler(BrowserHandler next) {
        this.next = next;
    }

    public WebDriver handleBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("EDGE")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("headless");
            WebDriver driver = new EdgeDriver(options);
            return driver;
        }
        return next.handleBrowser(browserName);
    }
}



