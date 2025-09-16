package com.joit.tab.service.strategy;

import com.joit.tab.service.base.OperationStrategy;
import org.springframework.stereotype.Component;

@Component("divide")
public class DivideOperation implements OperationStrategy {

    @Override
    public double calculate(double a, Double b) {
        if (b == 0) throw  new ArithmeticException("Division by zero");
        return a / b;
    }
}
