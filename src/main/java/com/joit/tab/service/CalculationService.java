package com.joit.tab.service;

import com.joit.tab.service.base.OperationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CalculationService {

    private final Map<String, OperationStrategy> strategies;

    @Autowired
    public CalculationService(Map<String, OperationStrategy> strategies) {
        this.strategies = strategies;
    }

    public double calculate(String operator, double a, Double b) {
        OperationStrategy strategy = strategies.get(operator);
        if (strategy == null) throw new IllegalArgumentException("Unknown operator: " + operator);
        return strategy.calculate(a, b);
    }

}
