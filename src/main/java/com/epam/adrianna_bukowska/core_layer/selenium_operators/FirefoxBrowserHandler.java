package com.epam.adrianna_bukowska.core_layer.selenium_operators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowserHandler implements BrowserHandler {

    private final BrowserHandler next;

    public FirefoxBrowserHandler(BrowserHandler next) {
        this.next = next;
    }

    public WebDriver handleBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("FIREFOX")) {
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            WebDriver driver = new FirefoxDriver(options);
            return driver;
        }
        return next.handleBrowser(browserName);
    }
}


