package com.joit.tab.service.strategy;

import com.joit.tab.service.base.OperationStrategy;
import org.springframework.stereotype.Component;

@Component("percent")
public class PercentOperation implements OperationStrategy {

    @Override
    public double calculate(double a, Double b) {
        if (b == null) return  a / 100.0;
        return a * b / 100.0;
    }
}
