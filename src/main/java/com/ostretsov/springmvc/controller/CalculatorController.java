package com.ostretsov.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calc")
    public String calc(@RequestParam("a") int a,
                       @RequestParam("b") int b,
                       @RequestParam("action") String action,
                       Model model) {
        double result;
        switch (action) {
            case ("mul"):
                result = a * b;
                break;
            case ("sum"):
                result = a + b;
                break;
            case ("sub"):
                result = a - b;
                break;
            case ("div"):
                result = a / (double) b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);

        return "calc/calc";
    }
}
