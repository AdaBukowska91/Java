package com.epam.adrianna_bukowska.core_layer.selenium_operators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebDriverManager {

    private final String browserName;
    private WebDriver driver = null;

    public WebDriverManager() {
        browserName = "CHROME";
    }

    public WebDriverManager(String browserName) {
        this.browserName = browserName;
    }

    public WebDriver getDriver(WebDriverListener listener) {
        if (driver == null) {
            BrowserHandler handler = new ChromeBrowserHandler(new FirefoxBrowserHandler(new EdgeBrowserHandler(null)));
            driver = handler.handleBrowser(browserName);
        }
        return driver = new EventFiringDecorator(listener).decorate(driver);
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
