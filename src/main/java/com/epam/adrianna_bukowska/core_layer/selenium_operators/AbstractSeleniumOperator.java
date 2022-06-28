package com.epam.adrianna_bukowska.core_layer.selenium_operators;

import com.epam.adrianna_bukowska.core_layer.calculator.Operator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;


public abstract class AbstractSeleniumOperator implements Operator {

    private static Logger logger = LogManager.getLogger("logger");
    private final WebDriverManager driverManager;
    private String url;

    public AbstractSeleniumOperator(WebDriverManager driverManager, String url) {
        this.driverManager = driverManager;
        this.url = url;
    }

    @Override
    public Number operate(Number x, Number y) {
        Number calculationResult = null;
        try {
            WebDriverListener listener = new CalculatorWebDriverListener();
            WebDriver driver = driverManager.getDriver(listener);
            driver.get(url);
            CalculatorPage page = new CalculatorPage(driver);
            page.clearInputField();
            page.inputFormula(x.toString(), getSign(), y.toString());
            calculationResult = Double.parseDouble(page.getResult());
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        }
        driverManager.quitDriver();
        return calculationResult;
    }

    protected abstract String getSign();

    public class CalculatorWebDriverListener implements WebDriverListener {

        @Override
        public void afterGet(WebDriver driver, String url) {
            logger.info("Open InstaCalc Online Calculator. " + driver);
        }

        @Override
        public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
            if (keysToSend.length == 2) {
                logger.info("Clear input field.");
            } else if (keysToSend.length == 3) {
                logger.info("Enter formula to calculate: " + keysToSend[0] + keysToSend[1] + keysToSend[2]);
            }
        }

        @Override
        public void afterGetText(WebElement element, String result) {
            logger.info("Get calculation results: " + result);
        }
    }
}

