package com.epam.adrianna_bukowska.core_layer.api_operators;

import com.epam.adrianna_bukowska.core_layer.calculator.Operator;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.io.IoBuilder;

import java.io.PrintStream;

import static io.restassured.RestAssured.given;

public abstract class AbstractApiOperator implements Operator {

    private String endpoint;
    private static Logger logger = LogManager.getLogger("logger");

    public AbstractApiOperator(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public Number operate(Number x, Number y) {
        PrintStream logStream = IoBuilder.forLogger(logger).setLevel(Level.INFO).buildPrintStream();
        RestAssured.config = RestAssured.config().logConfig(LogConfig.logConfig().defaultStream(logStream));
        String expression = String.join(getSign(), x.toString(), y.toString());
        return given().log().method().log().uri().queryParam("expr", expression).when().get(endpoint).then()
                .log().body().extract().htmlPath().getDouble("html.body");
    }

    protected abstract String getSign();
}

