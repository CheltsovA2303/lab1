package com.example.lab1.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/math")
public class MathController {

    @GetMapping("/add")
    public String add(@RequestParam double a, @RequestParam double b) {
        double result = a + b;
        return String.format("%.2f + %.2f = %.2f", a, b, result);
    }

    @GetMapping("/subtract")
    public String subtract(@RequestParam double a, @RequestParam double b) {
        double result = a - b;
        return String.format("%.2f - %.2f = %.2f", a, b, result);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam double a, @RequestParam double b) {
        double result = a * b;
        return String.format("%.2f * %.2f = %.2f", a, b, result);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            return "Ошибка: деление на ноль!";
        }
        double result = a / b;
        return String.format("%.2f / %.2f = %.2f", a, b, result);
    }

    @GetMapping("/power/{number}")
    public String power(@PathVariable double number, @RequestParam(defaultValue = "2") int exponent) {
        double result = Math.pow(number, exponent);
        return String.format("%.2f^%d = %.2f", number, exponent, result);
    }

    @GetMapping("/sqrt/{number}")
    public String squareRoot(@PathVariable double number) {
        if (number < 0) {
            return "Ошибка: нельзя извлечь корень из отрицательного числа";
        }
        double result = Math.sqrt(number);
        return String.format("√%.2f = %.2f", number, result);
    }
}