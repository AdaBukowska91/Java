package com.epam.adrianna_bukowska.core_layer.selenium_operators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {

    private WebDriverWait wait;
    private WebDriver driver;

    By inputFieldLocator = By.cssSelector("input[type=text]");
    By resultLocator = By.cssSelector("span.c2");


    public CalculatorPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver = driver;
    }

    public void clearInputField() {
        WebElement calculator = wait.until(ExpectedConditions
                .visibilityOfElementLocated(inputFieldLocator));
        calculator.sendKeys(Keys.CONTROL,"a");
    }

    public void inputFormula(String x, String sign, String y) {
        WebElement calculator = wait.until(ExpectedConditions
                .visibilityOfElementLocated(inputFieldLocator));
        calculator.sendKeys(x, sign, y);
    }

    public String getResult() {
        return driver.findElement(resultLocator).getText().replaceAll(",", "");
    }
}


