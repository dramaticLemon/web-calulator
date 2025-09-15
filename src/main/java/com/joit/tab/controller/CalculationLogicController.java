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

    @PostMapping("/add")
    public CalculationResponse add(@RequestBody CalculationRequest request) {
        return new CalculationResponse(service.add(request.getFirstOperand(), request.getSecondOperand()));
    }

    @PostMapping("/subtract")
    public CalculationResponse subtract(@RequestBody CalculationRequest request) {
        return new CalculationResponse(service.subtract(request.getFirstOperand(), request.getSecondOperand()));
    }

    @PostMapping("/multiply")
    public CalculationResponse multiply(@RequestBody CalculationRequest request) {
        return new CalculationResponse(service.multiply(request.getFirstOperand(), request.getSecondOperand()));
    }

    @PostMapping("/divide")
    public CalculationResponse divide(@RequestBody CalculationRequest request) {
        return new CalculationResponse(service.divide(request.getFirstOperand(), request.getSecondOperand()));
    }

    @PostMapping("/sqrt")
    public CalculationResponse sqrt(@RequestBody CalculationRequest request) {
        return new CalculationResponse(service.sqrt(request.getFirstOperand()));
    }

    @PostMapping("/percent")
    public CalculationResponse percent(@RequestBody CalculationRequest request) {
        return new CalculationResponse(service.percent(request.getFirstOperand()));
    }
}
