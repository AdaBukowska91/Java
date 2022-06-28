//package com.epam.adrianna_bukowska.application_layer;
//
//import com.epam.adrianna_bukowska.core_layer.calculator.Operator;
//import com.epam.adrianna_bukowska.core_layer.selenium_operators.CreateSeleniumOperator;
//import com.epam.adrianna_bukowska.core_layer.selenium_operators.WebDriverManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//
//import static com.epam.adrianna_bukowska.core_layer.calculator.Operation.ADD;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
//@DisplayName("Test CalculatorApplication class")
//public class CalculatorApplicationAddOperatorTest {
//
//    private CalculatorApplication calculator;
//    private Operator operator;
//    private Logger loggerMock;
//
//    @BeforeEach
//    public void testPrep() {
//        loggerMock = mock(Logger.class);
//        calculator = new CalculatorApplication(loggerMock);
//        operator = CreateSeleniumOperator.createSeleniumOperator(ADD, new WebDriverManager(), "https://instacalc.com/");
//    }
//
//    @DisplayName("Test addOperator method")
//    @Test
//    public void testAddOperator() {
//        calculator.addOperator(ADD, operator);
//        assertTrue(calculator.getOperators().containsKey(ADD));
//    }
//
//    @DisplayName("Test when operator already exist")
//    @Nested
//    class WhenOperatorAlreadyExist {
//
//        @BeforeEach
//        public void testPrep() {
//            calculator.addOperator(ADD, operator);
//        }
//
//        @DisplayName("Test addOperator method - operator already exist")
//        @Test
//        public void testAddOperatorAlreadyExist() {
//            calculator.addOperator(ADD, operator);
//            verify(loggerMock).info("Operator has already been added.");
//        }
//    }
//}
//
