package com.joit.tab.service.strategy;

import com.joit.tab.service.base.OperationStrategy;
import org.springframework.stereotype.Component;

@Component("add")
public class AddOperation implements OperationStrategy {

    @Override
    public double calculate (double a, Double b) {
        return a + b;
    }
}
