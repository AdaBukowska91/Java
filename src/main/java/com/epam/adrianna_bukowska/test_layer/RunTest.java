package com.epam.adrianna_bukowska.test_layer;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/com/epam/adrianna_bukowska/test_layer/features",
        glue = "com/epam/adrianna_bukowska/test_layer/stepdefinitions",
        plugin = {"pretty", "html:target/system-test-reports/report.html",
                "json:target/system-test-reports/report.json"})

public class RunTest {
}

