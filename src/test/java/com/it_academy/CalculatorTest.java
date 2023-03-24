package com.it_academy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    @Test
    @DisplayName("Test addition with valid input")
    void testAddition() {
        Calculator calculator = new Calculator();
        double result = calculator.calculate(9.0, 3.0, "+");
        Assertions.assertEquals(12.0, result);
    }

    @Test
    @DisplayName("Test subtraction with valid input")
    void testSubtraction() {
        Calculator calculator = new Calculator();
        double result = calculator.calculate(7.0, 6.0, "-");
        Assertions.assertEquals(1.0, result);
    }

    @Test
    @DisplayName("Test multiplication with valid input")
    void testMultiplication() {
        Calculator calculator = new Calculator();
        double result = calculator.calculate(4.0, 5.0, "*");
        Assertions.assertEquals(20.0, result);
    }

    @Test
    @DisplayName("Test division with valid input")
    void testDivision() {
        Calculator calculator = new Calculator();
        double result = calculator.calculate(10.0, 5.0, "/");
        Assertions.assertEquals(2.0, result);
    }

    @Test
    @DisplayName("Test invalid operation with valid input")
    void testInvalidOperation() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate(2, 3, ";");
            Assertions.fail("IllegalArgumentException should have been thrown.");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Operation not recognized!", e.getMessage());
        }
    }

    @ParameterizedTest
    @DisplayName("Test operations with negative numbers")
    @CsvSource({"-2, 2, +, 0", "-4, -2, /, 2", "10, -5, *, -50", "-3, -6, -, 3"})
    public void testNegativeNumbers(double num1, double num2, String operation, double expected) {
        double result = Calculator.calculate(num1, num2, operation);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @DisplayName("Test operations with decimal numbers")
    @CsvSource({"8.0, 5.0, +, 13.0", "-9, -5, /, 1.8", "10.5, 2.5, *, 26.25", "12.6, 3.8, -, 8.8"})
    public void testDecimalNumbers(double num1, double num2, String operation, double expected) {
        double result = Calculator.calculate(num1, num2, operation);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test division by zero with valid input")
    void testDivisionByZero() throws ArithmeticException {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate(4, 0, "/");
            Assertions.fail("ArithmeticException should have been thrown.");
        } catch (ArithmeticException e) {
            Assertions.assertEquals("Division on null is impossible!", e.getMessage());
        }
    }
}

