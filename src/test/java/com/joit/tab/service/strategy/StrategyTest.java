package com.joit.tab.service.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StrategyTest {

    @Test
    public void testAddStrategy() {
        AddOperation object = new AddOperation();
        Double b = 3.0;
        double result = object.calculate(1, b);
        Assertions.assertEquals(result, 4.0);
    }

    @Test
    public void testDivideStrategy() {
        DivideOperation object = new DivideOperation();
        Double b = 2.0;
        double result = object.calculate(4, b);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void testFailDivideStrategy() {
        DivideOperation obj = new DivideOperation();
        Double b = 0.0;

        ArithmeticException thrown = Assertions.assertThrows(
                ArithmeticException.class,
                () -> obj.calculate(9, b),
                "Division by zero"
        );
        Assertions.assertEquals("Division by zero", thrown.getMessage());
    }

    @Test
    public void testMultiplyStrategy() {
        MultiplyOperation object = new MultiplyOperation();
        Double b = 2.0;
        double result = object.calculate(4, b);
        Assertions.assertEquals(8, result);
    }

    @Test
    public void testSubstractStrategy() {
        SubtractOperation object = new SubtractOperation();
        Double b = 2.0;
        double result = object.calculate(4, b);
        Assertions.assertEquals(2, result);
    }
    @Test
    public void testSqrtStrategy() {
        SqrtOperation object = new SqrtOperation();
        double result = object.calculate(100, null);
        Assertions.assertEquals(10, result);
    }

    @Test
    public void testSqrtStrategyFail() {
        SqrtOperation object = new SqrtOperation();

        ArithmeticException thrown = Assertions.assertThrows(
                ArithmeticException.class,
                () -> object.calculate(-100, null),
                "Negative number"
        );
        Assertions.assertEquals("Negative number", thrown.getMessage());
    }

    @Test
    public void testPercentOperationSingleNumber() {
       PercentOperation object = new PercentOperation();
       double result = object.calculate(1000, null);
       Assertions.assertEquals(10, result);
    }

    @Test
    public void testPercentOperation() {
        PercentOperation object = new PercentOperation();
        Double b = 5.0;
        double result = object.calculate(1000, b);
        Assertions.assertEquals(50, result);
    }
}
