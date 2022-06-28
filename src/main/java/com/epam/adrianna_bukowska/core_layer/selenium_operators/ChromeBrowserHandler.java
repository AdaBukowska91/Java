package com.epam.adrianna_bukowska.core_layer.selenium_operators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowserHandler implements BrowserHandler {

    private final BrowserHandler next;

    public ChromeBrowserHandler(BrowserHandler next) {
        this.next = next;
    }

    @Override
    public WebDriver handleBrowser(String browserName) {
        if (browserName.equals("CHROME")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            WebDriver driver = new ChromeDriver(options);
            return driver;
        }
        return next.handleBrowser(browserName);
    }
}

