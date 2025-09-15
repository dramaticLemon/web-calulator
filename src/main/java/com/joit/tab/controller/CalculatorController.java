package com.joit.tab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculatorController {

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
