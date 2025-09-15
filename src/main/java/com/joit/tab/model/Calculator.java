package com.joit.tab.model;

public class Calculator {

    private double firstOperand;
    private double secondOperand;
    private String operator;
    private double result;


    public double calculate(double firstOperand, double secondOperand, String operator) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;

        switch (operator) {
            case "add":
                result = firstOperand + secondOperand;
                break;
            case "subtract":
                result = firstOperand - secondOperand;
                break;
            case "multiply":
                result = firstOperand * secondOperand;
                break;
            case "divide":
                result = firstOperand / secondOperand;
                break;
            default:
                result = secondOperand;
        }switch (operator) {
            case "add":
                result = firstOperand + secondOperand;
                break;
            case "subtract":
                result = firstOperand - secondOperand;
                break;
            case "multiply":
                result = firstOperand * secondOperand;
                break;
            case "divide":
                result = firstOperand / secondOperand;
                break;
            default:
                result = secondOperand;
        }

        return result;
    }

    public double getResult() {
        return result;
    }

}
