package com.joit.tab.service.strategy;

import com.joit.tab.service.base.OperationStrategy;
import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Component;

@Component("sqrt")
public class SqrtOperation implements OperationStrategy {

    @Observed
    public double calculate (double a, Double b) {
        if (a < 0) throw new ArithmeticException("Negative number");
        return Math.sqrt(a);
    }
}
