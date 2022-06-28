//package com.epam.adrianna_bukowska.application_layer;
//
//import com.epam.adrianna_bukowska.core_layer.calculator.Formula;
//import com.epam.adrianna_bukowska.core_layer.calculator.Operator;
//import com.epam.adrianna_bukowska.core_layer.exceptions.InvalidOperatorTypeException;
//import com.epam.adrianna_bukowska.core_layer.selenium_operators.CreateSeleniumOperator;
//import com.epam.adrianna_bukowska.core_layer.selenium_operators.WebDriverManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static com.epam.adrianna_bukowska.core_layer.calculator.Operation.ADD;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.mock;
//
//@DisplayName("Test CalculatorApplication class")
//public class CalculatorApplicationCalculateTest {
//
//    private CalculatorApplication calculator;
//
//    @DisplayName("Test calculate method")
//    @Test
//    public void testCalculate() {
//        Logger loggerMock = mock(Logger.class);
//        calculator = new CalculatorApplication(loggerMock);
//        Operator operator = CreateSeleniumOperator.createSeleniumOperator(ADD, new WebDriverManager(), "https://instacalc.com/");
//        calculator.addOperator(ADD, operator);
//        Formula formula = new Formula(2, 3, ADD);
//        assertEquals(5.0, calculator.calculate(formula));
//    }
//
//    @DisplayName("Test calculate method - operator not added")
//    @Test
//    public void testCalculateOperatorNotAdded() {
//        Logger loggerMock = mock(Logger.class);
//        calculator = new CalculatorApplication(loggerMock);
//        Formula formula = new Formula(2, 3, ADD);
//        assertThrows(InvalidOperatorTypeException.class, () -> calculator.calculate(formula));
//    }
//}
//
