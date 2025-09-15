package com.joit.tab.controller;

import com.joit.tab.dtos.CalculationRequest;
import com.joit.tab.dtos.CalculationResponse;
import com.joit.tab.service.CalculationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CalculationLogicController {

    private final CalculationService service;

    public CalculationLogicController(CalculationService service) {
        this.service = service;
    }

    @PostMapping("/{operator}")
    public CalculationResponse calculate(
            @PathVariable String operator,
            @RequestBody CalculationRequest request
    ) {
        double result = service.calculate(operator, request.getFirstOperand(), request.getSecondOperand());
        return new CalculationResponse(result);
    }
}
