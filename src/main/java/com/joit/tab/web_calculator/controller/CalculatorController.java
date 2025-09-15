package com.joit.tab.web_calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculatorController {

    /**
     * Get calculator page
     * @return html page representation
     */
    @GetMapping("/app")
    public String getHomePage() {
        return "index";
    }
}
