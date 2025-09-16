package com.joit.tab.service.strategy;

import com.joit.tab.service.base.OperationStrategy;
import org.springframework.stereotype.Component;

@Component("subtract")
public class SubtractOperation implements OperationStrategy {

    @Override
    public double calculate (double a, Double b) {
        return a - b;
    }
}
