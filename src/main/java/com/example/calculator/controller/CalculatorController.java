package com.example.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    public final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculator")
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/calculator/plus")
    public String plus(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        if (a == null || b == null) {
            return "Не передан один из параметров";
        }
            return a + " + " + b + " = " + calculatorService.plus(a,b);
    }

    @GetMapping("/calculator/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        if (a == null || b == null) {
            return "Не передан один из параметров";
        }
            return a + " - " + b + " = "+ calculatorService.minus(a,b);
    }

    @GetMapping("/calculator/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        if (a == null || b == null) {
            return "Не передан один из параметров";
        }
            return a + " * " + b + " = " + calculatorService.miltiply(a,b);
    }

    @GetMapping("/calculator/divide")
    public String divide(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        if (a == null || b == null) {
            return "Не передан один из параметров";
        }
            if (b==0) {
                return "На  0 делить нельзя";
            }
            return a + " / " + b + " = " + calculatorService.divide(a,b);
    }
}
