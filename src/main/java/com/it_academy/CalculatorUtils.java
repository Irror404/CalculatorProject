package com.it_academy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorUtils {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.start();
    }
}

class Calculator {
    private Scanner scanner;

    public Calculator() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        double num1;
        double num2;
        double result;
        String operation;
        while (true) {
            try {
                System.out.print("Input first number: ");
                while (!scanner.hasNextDouble()){
                    System.out.println("Error! You can only enter numbers here!");
                    scanner.next();
                    System.out.println("Input first number: ");
                }
                num1 = scanner.nextDouble();

                System.out.print("Input second number: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Error! You can only enter numbers here!");
                    scanner.next();
                    System.out.print("Input second number: ");
                }
                num2 = scanner.nextDouble();

                System.out.print("Select operation (+,-,*,/), or enter 'q' for quit: ");
                operation = scanner.next();
                if (operation.equals("q")) {
                    break;
                }
                result = Calculator.calculate(num1, num2, operation);
                System.out.println("Result: " + result);
            } catch (InputMismatchException e) {
                System.out.println("Error! You can only enter numbers here!");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (ArithmeticException e) {
                e.printStackTrace();
            }

        }
        scanner.close();
    }

    public static double calculate(double num1, double num2, String operation) {
        double result;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Division on null is impossible!");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Operation not recognized!");
        }
        return result;
    }
}
