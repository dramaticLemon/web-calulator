package com.joit.tab.controller;

import com.joit.tab.dtos.CalculationRequest;
import com.joit.tab.dtos.CalculationResponse;
import com.joit.tab.dtos.ExpressionRequest;
import com.joit.tab.service.CalculationService;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/app")
public class CalculationLogicController {

    private final CalculationService service;

    public CalculationLogicController (CalculationService service) {
        this.service = service;
    }

    @PostMapping("/{operator}")
    public CalculationResponse calculate (
            @PathVariable String operator,
            @RequestBody CalculationRequest request
    ) {
        double result = service.calculate(operator, request.getFirstOperand(), request.getSecondOperand());
        return new CalculationResponse(result);
    }

    @PostMapping("/evaluate")
    public CalculationResponse evaluateExpression(@RequestBody ExpressionRequest request) {
        double result;
        try {

            Expression expression = new ExpressionBuilder(request.getExpression()).build();
            result = expression.evaluate();
        } catch (IllegalArgumentException | ArithmeticException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid expression: " + e.getMessage()
            );
        }
        return new CalculationResponse(result);
    }
}
