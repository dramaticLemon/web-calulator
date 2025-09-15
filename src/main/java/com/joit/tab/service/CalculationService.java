package com.joit.tab.service;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
       return  a / b;
    }

    public double sqrt(double a) {
        if (a < 0) throw  new ArithmeticException("Negative nubmer");
        return Math.sqrt(a);
    }

    public double percent(double a) {
        return a / 100.0;
    }

}
