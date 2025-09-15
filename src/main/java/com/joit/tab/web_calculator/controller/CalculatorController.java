package com.joit.tab.web_calculator.controller;

import com.joit.tab.web_calculator.model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    private final Calculator calculator = new Calculator();

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam double firstOperand,
            @RequestParam(required = false) Double secondOperand,
            @RequestParam String operator,
            Model model
    ) {
        double result;

        switch (operator) {
            case "sqrt":
                result = Math.sqrt(firstOperand);
                break;
            case "percent":
                result = firstOperand / 100.0;
                break;
            default:
                result = calculator.calculate(firstOperand,
                        secondOperand != null ? secondOperand : 0,
                        operator);
        }

        String displayResult;
        if (result == (long) result) {
            displayResult = String.valueOf((long) result);
        } else {
            displayResult = String.valueOf(result);
        }

        model.addAttribute("result", displayResult);
        model.addAttribute("firstOperand", firstOperand);
        model.addAttribute("secondOperand", secondOperand);
        model.addAttribute("operator", operator);

        return "index"; // calculator page
    }
    /**
     * Get calculator page
     * @return html page representation
     */
    @GetMapping("/app")
    public String getHomePage(Model model) {
        model.addAttribute("result", "0");
        return "index"; // calculator page
    }

}
